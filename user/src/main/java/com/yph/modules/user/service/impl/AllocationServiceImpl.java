package com.yph.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yph.entity.AllocationDto;
import com.yph.enun.AllocationRate;
import com.yph.enun.SystemParameter;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.service.AllocationService;
import com.yph.modules.user.service.IUserService;
import com.yph.util.BigDecimalUtil;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Agu
 */
@Service
public class AllocationServiceImpl implements AllocationService {


    @Autowired
    IUserService userService;


    @Autowired
    SystemParameter systemParameter;

    /**
     * 伞下分红  共6级
     *
     * @param allocationDto
     */
    @Override
    public void allocation(AllocationDto allocationDto) {
        //当前业绩创造者的ID
        Integer userId = allocationDto.getUserId();
        //当前业绩创造者的级别
        Integer userLevel = allocationDto.getUserLevel();
        //创造者的业绩量
        Long energySource = allocationDto.getEnergySource();
        //直推and 间推
        directPush(userId, energySource);

        //伞下
//        down(userId, userLevel, energySource);


    }


    private void directPush(Integer userId, Long energySource) {
        R r = userService.selectUserReferrerTo(userId);
        Object data = r.get("data");
        Map<String, Object> map = data == null ? null : (Map) data;
        if (map != null) {
            String zhiTui = map.get("zhiTui") == null ? null : (String) map.get("zhiTui");
            String jianTui = map.get("jianTui") == null ? null : (String) map.get("jianTui");
            if (zhiTui != null) {
                BigDecimal multiply = BigDecimalUtil.multiply(new BigDecimal(energySource.toString()), systemParameter.getDirectPush());
                if (multiply.doubleValue() > 0) {
                    //直推分红
                    updateMoney(Integer.parseInt(zhiTui),multiply);
                }
            }

            if (jianTui != null) {
                BigDecimal multiply = BigDecimalUtil.multiply(new BigDecimal(energySource.toString()), systemParameter.getIndirectPush());
                if (multiply.doubleValue() > 0) {
                    //间推分红
                    updateMoney(Integer.parseInt(jianTui),multiply);
                }
            }
        }

    }

    private void  updateMoney(Integer userId,BigDecimal money){
        UpdateWrapper<UserEntity> userEntityUpdateWrapper =
                new UpdateWrapper<UserEntity>().setSql("energy_source=energy_source+" + money.longValue()).eq("user_id", userId);
        userService.update(userEntityUpdateWrapper);
    }


    private static void down(Integer userId, Integer userLevel, Long energySource,List<UserEntity> listUser) {
        List<UserEntity>[] upMan = getUpMan(userId, userLevel,listUser);
        BigDecimal sumRate = new BigDecimal("0.00");
        for (int i = 0; i < upMan.length; i++) {
            List<UserEntity> list = upMan[i];
            if (list == null) {
                continue;
            }
            boolean isPin = false;
            for (UserEntity userEntity : list) {
                //同级
                if (list.size() == 1 && userEntity.getUserLevel() == userLevel) {
                    isPin = true;
                }
                AllocationRate aCase = AllocationRate.getCase(i+1);
               if (aCase!=null){
                   BigDecimal currency;
                   if (!isPin) {
                       //上级
                       currency = aCase.getCurrency(energySource, sumRate);
                       isPin = true;
                   } else {
                       //平级
                       currency = aCase.getPeers(energySource);
                   }
                   sumRate = aCase.getRate();
                   if (currency.doubleValue()>0){
//                       updateMoney(userEntity.getUserId(),currency);
                       System.out.println("id:"+userEntity.getUserId()+"级别"+userEntity.getUserLevel()+"比率"+currency.doubleValue());
                   }
               }
            }
        }
    }


    private static List<UserEntity>[] getUpMan(Integer userId, Integer userLevel, List<UserEntity> listUser) {
        //
        P p = new P();
        p.put("userId", userId);
        p.put("userRank", userLevel);
//        Object data = userService.selectUserBySuperior(p).get("data");
//        List<UserEntity> listUser = data == null ? null : (List<UserEntity>) data;
        List<UserEntity>[] lists = new ArrayList[6];
        int level;
        int preLevel = -1;
        int nowLevel;
        for (UserEntity userEntity : listUser) {
            List<UserEntity> temp;
            //当前的级别
            nowLevel = userEntity.getUserLevel() >= userLevel ? userEntity.getUserLevel() : userLevel;
            //级别对应数组的下标
            level = nowLevel - 1;
            if (preLevel != -1) {
                if (nowLevel < preLevel) {
                    continue;
                }
            }
            if (lists[level] == null) {
                lists[level] = new ArrayList();
            }
            temp = lists[level];
            if (temp.size() < (userEntity.getUserLevel() == userLevel ? 1 : 2)) {
                if (userEntity.getUserLevel() >= userLevel) {
                    temp.add(userEntity);
                }
            }
            preLevel = nowLevel;
        }
        return lists;
    }


    public static void main(String[] args) {
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity(1,1));
        userEntities.add(new UserEntity(2,1));
        userEntities.add(new UserEntity(3,1));
        userEntities.add(new UserEntity(4,2));
        userEntities.add(new UserEntity(5,3));
        userEntities.add(new UserEntity(6,3));
        userEntities.add(new UserEntity(7,4));
        userEntities.add(new UserEntity(8,4));
        userEntities.add(new UserEntity(9,5));
        userEntities.add(new UserEntity(7,6));
        userEntities.add(new UserEntity(7,5));
        userEntities.add(new UserEntity(7,5));
        userEntities.add(new UserEntity(10,6));
        down(1,3,1000L,userEntities);
    }

}
