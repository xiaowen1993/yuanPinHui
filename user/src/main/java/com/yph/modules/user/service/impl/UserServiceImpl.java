package com.yph.modules.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yph.modules.china.entity.ChinaEntity;
import com.yph.modules.china.service.IChinaService;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.mapper.UserMapper;
import com.yph.modules.user.service.IUserService;
import com.yph.modules.user.template.SmsTemplate;
import com.yph.util.P;
import com.yph.util.R;
import com.yph.util.utli.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.Consumer;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmsTemplate smsTemplate;

    @Autowired
    private IChinaService chinaService;


    //用户等级升级  降级
    @Override
    public void userUpgrade(List<UserEntity> userEntities){
        if(userEntities==null){
            QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.ge("sum_team_energy_source",20000000);
            userEntities = userMapper.selectList(queryWrapper);
        }
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        List<Integer> list4=new ArrayList<>();
        List<Integer> list5=new ArrayList<>();
        List<Integer> list6=new ArrayList<>();

        List<UserEntity> userEntities3=new ArrayList<>();
        List<UserEntity> userEntities4=new ArrayList<>();
        List<UserEntity> userEntities5=new ArrayList<>();
        List<UserEntity> userEntities6=new ArrayList<>();

        List<UserEntity> demotion1=new ArrayList<>();


        //判断升级的用户
        for (UserEntity userEntity : userEntities) {
            if(userEntity.getUserLevel()==0&&userEntity.getSumTeamEnergySource()>=20000000){
                list1.add(userEntity.getUserId());
            }else if(userEntity.getUserLevel()==1&&userEntity.getSumTeamEnergySource()>=50000000){
                list2.add(userEntity.getUserId());
            }else if(userEntity.getUserLevel()==2&&userEntity.getSumTeamEnergySource()>=200000000){
                list3.add(userEntity.getUserId());
                userEntities3.add(userEntity);
            }else if(userEntity.getUserLevel()==3&&userEntity.getSumTeamEnergySource()>=500000000){
                list4.add(userEntity.getUserId());
                userEntities4.add(userEntity);
            }else if(userEntity.getUserLevel()==4&&userEntity.getSumTeamEnergySource()>=1500000000){
                list5.add(userEntity.getUserId());
                userEntities5.add(userEntity);
            }else if(userEntity.getUserLevel()==5&&userEntity.getSumTeamEnergySource()>=5000000000L){
                list6.add(userEntity.getUserId());
                userEntities6.add(userEntity);
            }else{
                demotion1.add(userEntity);   //业绩降级的
            }
        }


        List<UserEntity> demotion2=new ArrayList<>();
        List<UserEntity> demotion3=new ArrayList<>();
        List<UserEntity> demotion4=new ArrayList<>();
        List<UserEntity> demotion5=new ArrayList<>();

        //判断降级的用户
        if(demotion1.size()>0){
            for (UserEntity userEntity : demotion1) {
                if(userEntity.getSumTeamEnergySource()>=20000000&&userEntity.getSumTeamEnergySource()<50000000){
                    list1.add(userEntity.getUserId());
                }else if(userEntity.getSumTeamEnergySource()>=50000000&&userEntity.getSumTeamEnergySource()<200000000&&userEntity.getUserLevel()==3){
                    list2.add(userEntity.getUserId());
                    demotion2.add(userEntity);
                }else if(userEntity.getSumTeamEnergySource()>=200000000&&userEntity.getSumTeamEnergySource()<500000000&&userEntity.getUserLevel()==4){
                    demotion3.add(userEntity);
                }else if(userEntity.getSumTeamEnergySource()>=500000000&&userEntity.getSumTeamEnergySource()<1500000000&&userEntity.getUserLevel()==5){
                    demotion4.add(userEntity);
                }else if(userEntity.getSumTeamEnergySource()>=1500000000&&userEntity.getSumTeamEnergySource()<5000000000L&&userEntity.getUserLevel()==6){
                    demotion5.add(userEntity);
                }
            }
        }

        //将<20000000业绩的  改为普通用户
        UpdateWrapper<UserEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("user_level",0);
        updateWrapper.le("sum_team_energy_source",20000000);
        this.update(updateWrapper);

        if(list1.size()>0){
            UpdateWrapper<UserEntity> updateWrapper1=new UpdateWrapper<>();
            updateWrapper1.set("user_level",1);
            updateWrapper1.in("user_id",list1);
            this.update(updateWrapper1);
        }


        if(list2.size()>0){
            UpdateWrapper<UserEntity> updateWrapper2=new UpdateWrapper<>();
            updateWrapper2.set("user_level",2);
            updateWrapper2.in("user_id",list2);
            this.update(updateWrapper2);
        }

        if(list3.size()>0){
            UpdateWrapper<UserEntity> updateWrapper3=new UpdateWrapper<>();
            updateWrapper3.set("user_level",3);
            updateWrapper3.in("user_id",list3);
            this.update(updateWrapper3);
        }

        //升级了3星的用户，往上查找，看上面是否有人可以升级了
        List<String> upgrade4Ids=new ArrayList<>();  //业绩达到可以升级为4星的用户
        for (UserEntity userEntity : userEntities3) {
            String relation = userEntity.getRelation();
            String[] split = relation.split(",");
            for (String s : split) {
                if (list4.contains(s))   //看可以升级4星的用户集合里面包含了此用户没有，没有包含的话 说明他业绩不够
                    upgrade4Ids.add(s);
            }
        }

        for (String upgrade4Id : upgrade4Ids) {
            List<UserEntity> entityList=userMapper.selectUserByReferrer(upgrade4Id);
            int count=0;
            if(entityList!=null&&entityList.size()>=2){
                for (UserEntity userEntity : entityList) {
                    Boolean aBoolean = selectBottomUser(userEntity,3);
                    if(aBoolean){
                        count++;
                    }
                }
            }
            if(count>=2){
                updateUserRank(upgrade4Id,4);
                //升了4星  看上面的人  能不能升级
                UserEntity userEntity1 = userMapper.selectById(upgrade4Id);
                //现在是4星的用户  可能会升为5星的用户（业绩达到了  现在下面有用户升了4星用户）
                List<String> upgrade5Ids=new ArrayList<>();
                String relation = userEntity1.getRelation();
                String[] split = relation.split(",");
                for (String s : split) {
                    if (list5.contains(s))
                        upgrade5Ids.add(s);
                }
                for (String upgrade5Id : upgrade5Ids) {
                    List<UserEntity> entityList2=userMapper.selectUserByReferrer(upgrade5Id);
                    int count2=0;
                    if(entityList2!=null&&entityList2.size()>=2){
                        for (UserEntity userEntity : entityList2) {
                            Boolean aBoolean = selectBottomUser(userEntity,4);
                            if(aBoolean){
                                count2++;
                            }
                        }
                    }
                    if(count2>=2){
                        //升级5星，看上面的人  能否升6星
                        updateUserRank(upgrade5Id,5);
                        //升了4星  看上面的人  能不能升级
                        UserEntity userEntity3 = userMapper.selectById(upgrade5Id);
                        //现在是4星的用户  可能会升为5星的用户（业绩达到了  现在下面有用户升了4星用户）
                        List<String> upgrade6Ids=new ArrayList<>();
                        String relation3 = userEntity3.getRelation();
                        String[] split3 = relation3.split(",");
                        for (String s : split3) {
                            if (list6.contains(s))
                                upgrade6Ids.add(s);
                        }
                        for (String upgrade6Id : upgrade6Ids) {
                            List<UserEntity> entityList3=userMapper.selectUserByReferrer(upgrade6Id);
                            int count3=0;
                            if(entityList3!=null&&entityList3.size()>=3){
                                for (UserEntity userEntity : entityList3) {
                                    Boolean aBoolean = selectBottomUser(userEntity,5);
                                    if(aBoolean){
                                        count2++;
                                    }
                                }
                            }
                            if(count3>=3){
                                updateUserRank(upgrade5Id,6);
                            }
                        }
                    }
                }
            }
        }

        //从3星降级成2星
        List<String> demotion2Ids=new ArrayList<>();
        for (UserEntity userEntity : demotion2) {
            String relation = userEntity.getRelation();
            String[] split = relation.split(",");
            QueryWrapper<UserEntity> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("user_level",4);
            queryWrapper1.in("user_id", Arrays.asList(split));
            List<UserEntity> userEntities1 = userMapper.selectList(queryWrapper1);
            for (UserEntity entity : userEntities1) {
                demotion2Ids.add(entity.getUserId()+"");
            }
        }
        for (String demotion2Id : demotion2Ids) {
            List<UserEntity> entityList=userMapper.selectUserByReferrer(demotion2Id);
            int count=0;
            for (UserEntity userEntity : entityList) {
                Boolean aBoolean = selectBottomUser(userEntity,3);
                if(aBoolean){
                    count++;
                }
            }
            if(count<2){
                updateUserRank(demotion2Id,3);
                //4星降成了3级
                UserEntity userEntity1 = userMapper.selectById(demotion2Id);

                List<String> upgrade5Ids=new ArrayList<>();
                String relation = userEntity1.getRelation();
                String[] split = relation.split(",");
                QueryWrapper<UserEntity> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("user_level",5);
                queryWrapper1.in("user_id", Arrays.asList(split));
                List<UserEntity> userEntities1 = userMapper.selectList(queryWrapper1);
                for (UserEntity entity : userEntities1) {
                    upgrade5Ids.add(entity.getUserId()+"");
                }

                for (String upgrade5Id : upgrade5Ids) {
                    List<UserEntity> entityList2=userMapper.selectUserByReferrer(upgrade5Id);
                    int count2=0;
                    for (UserEntity userEntity : entityList2) {
                        Boolean aBoolean = selectBottomUser(userEntity,4);
                        if(aBoolean){
                            count2++;
                        }
                    }
                    if(count2<2){
                        updateUserRank(upgrade5Id,4);
                        UserEntity userEntity3 = userMapper.selectById(upgrade5Id);
                        List<String> upgrade6Ids=new ArrayList<>();
                        String relation3 = userEntity3.getRelation();
                        String[] split3 = relation3.split(",");
                        QueryWrapper<UserEntity> queryWrapper4=new QueryWrapper<>();
                        queryWrapper4.eq("user_level",6);
                        queryWrapper4.in("user_id", Arrays.asList(split3));
                        List<UserEntity> userEntities2 = userMapper.selectList(queryWrapper4);
                        for (UserEntity entity : userEntities2) {
                            upgrade6Ids.add(entity.getUserId()+"");
                        }
                        for (String upgrade6Id : upgrade6Ids) {
                            List<UserEntity> entityList3=userMapper.selectUserByReferrer(upgrade6Id);
                            int count3=0;
                            for (UserEntity userEntity : entityList3) {
                                Boolean aBoolean = selectBottomUser(userEntity,5);
                                if(aBoolean){
                                    count2++;
                                }
                            }
                            if(count3<3){
                                updateUserRank(upgrade5Id,5);
                            }
                        }
                    }
                }
            }
        }



        //从4星降成了3星
        List<String> demotion3Ids=new ArrayList<>();
        for (UserEntity userEntity : demotion3) {
            String relation = userEntity.getRelation();
            String[] split = relation.split(",");
            QueryWrapper<UserEntity> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("user_level",5);
            queryWrapper1.in("user_id", Arrays.asList(split));
            List<UserEntity> userEntities1 = userMapper.selectList(queryWrapper1);
            for (UserEntity entity : userEntities1) {
                demotion3Ids.add(entity.getUserId()+"");
            }
        }
        for (String demotion2Id : demotion3Ids) {
            List<UserEntity> entityList=userMapper.selectUserByReferrer(demotion2Id);
            int count=0;
            for (UserEntity userEntity : entityList) {
                Boolean aBoolean = selectBottomUser(userEntity,4);
                if(aBoolean){
                    count++;
                }
            }
            if(count<2){
                updateUserRank(demotion2Id,4);
                //5星降成了4级
                UserEntity userEntity1 = userMapper.selectById(demotion2Id);

                List<String> upgrade5Ids=new ArrayList<>();
                String relation = userEntity1.getRelation();
                String[] split = relation.split(",");
                QueryWrapper<UserEntity> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("user_level",6);
                queryWrapper1.in("user_id", Arrays.asList(split));
                List<UserEntity> userEntities1 = userMapper.selectList(queryWrapper1);
                for (UserEntity entity : userEntities1) {
                    upgrade5Ids.add(entity.getUserId()+"");
                }
                for (String upgrade5Id : upgrade5Ids) {
                    List<UserEntity> entityList2=userMapper.selectUserByReferrer(upgrade5Id);
                    int count2=0;
                    for (UserEntity userEntity : entityList2) {
                        Boolean aBoolean = selectBottomUser(userEntity,5);
                        if(aBoolean){
                            count2++;
                        }
                    }
                    if(count2<3){
                        updateUserRank(upgrade5Id,5);
                    }
                }
            }
        }


        //从5星降成了4星
        List<String> demotion4Ids=new ArrayList<>();
        for (UserEntity userEntity : demotion4) {
            String relation = userEntity.getRelation();
            String[] split = relation.split(",");
            QueryWrapper<UserEntity> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("user_level",6);
            queryWrapper1.in("user_id", Arrays.asList(split));
            List<UserEntity> userEntities1 = userMapper.selectList(queryWrapper1);
            for (UserEntity entity : userEntities1) {
                demotion4Ids.add(entity.getUserId()+"");
            }
        }
        for (String demotion2Id : demotion4Ids) {
            List<UserEntity> entityList=userMapper.selectUserByReferrer(demotion2Id);
            int count=0;
            for (UserEntity userEntity : entityList) {
                Boolean aBoolean = selectBottomUser(userEntity,5);
                if(aBoolean){
                    count++;
                }
            }
            if(count<3) {
                updateUserRank(demotion2Id, 5);
            }
        }
    }



    //修改用户等级
    private Boolean updateUserRank(String userId,Integer rank){
        UpdateWrapper<UserEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("user_level",rank);
        updateWrapper.eq("user_id",userId);
        return update(updateWrapper);
    }


    //根据会员ID  查询下面是否有 xx 星以上的用户
    private Boolean selectBottomUser(UserEntity userEntity,Integer userLevel){
        List<UserEntity> list=new ArrayList<>();
        recursionSelectUser(userEntity,list,userLevel);
        return list.size()>0 ? true : false;
    }


    private void recursionSelectUser(UserEntity userEntity,List<UserEntity> list,Integer userLevel){
        List<UserEntity> userEntities = userMapper.selectUserByReferrer(userEntity.getUserId() + "");
        boolean temp=false;
        for (UserEntity entity : userEntities) {
            if(entity.getUserLevel()>=userLevel){
                list.add(entity);
                temp=true;
                break;
            }
        }
        if(temp){
            for (UserEntity entity : userEntities) {
                recursionSelectUser(entity,list,userLevel);
            }
        }
    }



    //累加团队业绩
    @Override
    public Boolean updateSumTeamEnergySource(List<String> userId, String performance) {
        UpdateWrapper<UserEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.setSql("sum_team_energy_source=sum_team_energy_source"+performance);
        updateWrapper.in("user_id",userId);
        return this.update(updateWrapper);
    }

    @Override
    public String selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public R selectUserBySuperior(P p) {
        Map<String,List<UserEntity>> map=new HashMap<>();
        Integer userId = p.getInt("userId");
        Integer userRank = p.getInt("userRank");
        UserEntity userEntity = userMapper.selectById(userId);
        String relation = userEntity.getRelation();
        List<UserEntity> lists=new ArrayList<>();
        List<UserEntity> zones=new ArrayList<>();
        if(!StringUtils.isBlank(relation)){
            String[] split = relation.split(",");
            QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<>();
            queryWrapper.in("user_id",Arrays.asList(split));
            queryWrapper.orderByDesc("user_id");
            List<UserEntity> userEntities = userMapper.selectList(queryWrapper);
            for (UserEntity entity : userEntities) {
                if(entity.getIsAdmin()!=null&&entity.getIsAdmin()!=0){
                    zones.add(entity);
                }
                if(entity.getUserLevel()!=0){
                    if(userRank!=null&&entity.getUserLevel()>=userRank){
                        lists.add(entity);
                    }else if(userRank==null){
                        lists.add(entity);
                    }
                }
            }
        }
        map.put("userLevel",lists);
        map.put("zones",zones);
        return R.success().data(map);
    }

    @Override
    public R selectUserReferrerTo(P p) {
        return selectUserReferrerTo(p.getInt("userId"));
    }

    @Override
    public R selectUserReferrerTo(Integer userId) {
        UserEntity userEntity = userMapper.selectById(userId);
        String relation = userEntity.getRelation();
        return R.success().data(userIdSubstring(relation));
    }

    @Transactional
    @Override
    public R addZoneCode(P p) {
        Integer userId = p.getInt("userId");
        Integer rank = p.getInt("rank");
        UserEntity userEntity = userMapper.selectById(userId);
        if(userEntity.getIsAdmin()!=null&&userEntity.getIsAdmin()!=0){
            return R.error("已经成为代理，不能再更改");
        }
        String relation = userEntity.getRelation();
        String[] split = relation.split(",");
        QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("user_id",Arrays.asList(split));
        queryWrapper.orderByDesc("user_id");
        List<UserEntity> userEntities = userMapper.selectList(queryWrapper);
        UserEntity userEntity1=null;
        for (UserEntity entity : userEntities) {
            if(entity.getIsAdmin()==1){
                userEntity1=entity;
                break;
            }
        }
        Integer zoneCode = p.getInt("zoneCode");
        ChinaEntity chinaEntity = chinaService.getById(zoneCode);
        if(chinaEntity==null){
            return R.error("传入地区编码有误");
        }
        if(userEntity1==null){
            if(rank==1){
                //直接添加
                UpdateWrapper<UserEntity> updateWrapper=new UpdateWrapper<>();
                updateWrapper.set("is_admin",1);
                updateWrapper.set("rank",rank);
                updateWrapper.set("zone_code",chinaEntity.getId());
                updateWrapper.set("zone_name",chinaEntity.getName());
                update(updateWrapper);
                return R.success();
            }else{
                return R.error("上级无省代理，不可直接添加市区代理");
            }
        }else{
            //查询到了  有代理
            Integer zoneCode1 = userEntity1.getZoneCode();
            QueryWrapper<ChinaEntity> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("Pid",zoneCode1);
            List<ChinaEntity> list = chinaService.list(queryWrapper1);
            boolean temp=false;
            for (ChinaEntity entity : list) {
                if(entity.getId()==zoneCode){
                    temp=true;
                    break;
                }
            }
            if(!temp){
                return R.error("您的最近上级为"+userEntity1.getZoneName()+"代理,您只能选择此地域以下的代理");
            }
            UpdateWrapper<UserEntity> updateWrapper=new UpdateWrapper<>();
            updateWrapper.set("is_admin",1);
            updateWrapper.set("rank",rank);
            updateWrapper.set("zone_code",chinaEntity.getId());
            updateWrapper.set("zone_name",chinaEntity.getName());
            update(updateWrapper);
            return R.success();
        }
    }

    @Override
    public R sendNote(P p) throws UnsupportedEncodingException {
        return R.success(smsTemplate.sendNote(p.getString("templateCode"),p.getString("phone")));
    }



    public  Map<String,String> userIdSubstring(String relation){
        Map<String,String> map=new HashMap<>();
        if(StringUtils.isBlank(relation))
            return map;
        int i = relation.lastIndexOf(",");
        if(i==-1){
            map.put("zhiTui",relation);
            return map;
        }
        String zhiTui = relation.substring(i+1);
        map.put("zhiTui",zhiTui);
        String temp = relation.substring(0,i);
        i = temp.lastIndexOf(",");
        if(i==-1){
            map.put("jianTui",temp);
            return map;
        }
        String jianTui = temp.substring(i+1);
        map.put("jianTui",jianTui);
        return map;
    }


    @Override
    public R userRegister(P p) throws Exception {
        String phone = p.getString("phone");
        String password = p.getString("password");
        String code = p.getString("code");
        Integer inviterId = p.getInt("inviterId");
        UserEntity userEntityNew=new UserEntity();
        String verify = smsTemplate.verify(phone, code);
        if(!verify.equals("OK")){
            return R.error(verify);
        }
        if(inviterId!=null){
            UserEntity userEntity = userMapper.selectById(inviterId);
            if(userEntity==null)
                return R.error("邀请人无效");
            userEntityNew.setUserReferrer(inviterId);
            Integer topRefereeId = userEntity.getTopRefereeId();
            if(topRefereeId!=null)
                userEntityNew.setTopRefereeId(topRefereeId);
            String relation = userEntity.getRelation();
            if(!StringUtils.isBlank(relation))
                userEntityNew.setRelation(relation+","+inviterId);
            else
                userEntityNew.setRelation(inviterId+"");
        }
        Date date = new Date();
        userEntityNew.setAddTime(date);
        userEntityNew.setUpdateTime(date);
        userEntityNew.setUserPassword(password);
        userEntityNew.setUserLastLoginTime(date);
        userEntityNew.setUserLevel(0);
        userEntityNew.setUserMobile(phone);
        userEntityNew.setFreezeLifeSource(0L);
        userEntityNew.setFreezeEnergySource(0L);
        userEntityNew.setFreezeBean(0L);
        userEntityNew.setLifeSource(0L);
        userEntityNew.setEnergySource(0L);
        userEntityNew.setBean(0L);
        userEntityNew.setGoupSize(0);
        userEntityNew.setUnderlingSize(0);
        userEntityNew.setIndirectSize(0);
        try {
            userMapper.insert(userEntityNew);
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                //手机号冲突，已经注册
                return userWithoutLogin(phone);
            }
        }
//        if(inviterId!=null)
//            redisService.getListOperations().leftPush(UserConstant.USER_REGISTER_QUEUE,userEntityNew.getRelation());
        return returnUserData(userEntityNew);
    }

    @Override
    public R userLogin(P p) throws Exception {
        String phone = p.getString("phone");
        String password = p.getString("password");
        String code = p.getString("code");
        if(!StringUtils.isBlank(code)){  //验证码登陆
            //验证 验证码
            String verify = smsTemplate.verify(phone, code);
            if(!verify.equals("OK")){
                return R.error(verify);
            }
            //通过查询用户
            UserEntity userEntity = selectPhone(phone);
            return returnUserData(userEntity);
        }else if(!StringUtils.isBlank(password)){  //密码登陆
            UserEntity userEntity = selectPhoneAndPassWord(phone,password);
            if(userEntity==null){
                return R.error("密码错误");
            }else{
                return returnUserData(userEntity);
            }
        }
        return R.error("密码或验证码错误");
    }


    //用户免密登录（用户已经注册的用户，点击注册流程）
    public R userWithoutLogin(String phone) throws Exception {
        UserEntity userEntity = selectPhone(phone);
        return returnUserData(userEntity);
    }

    //根据手机号查询用户
    private UserEntity selectPhone(String phone){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_mobile",phone);
        return userMapper.selectOne(queryWrapper);
    }


    //根据手机号和密码查询用户
    private UserEntity selectPhoneAndPassWord(String phone,String password){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_mobile",phone);
        queryWrapper.and(new Consumer<QueryWrapper<UserEntity>>() {
            @Override
            public void accept(QueryWrapper<UserEntity> userEntityQueryWrapper) {
                userEntityQueryWrapper.eq("user_password",password);
            }
        });
        return userMapper.selectOne(queryWrapper);
    }

    //返回用户信息
    private R returnUserData(UserEntity userEntity) throws Exception {
        String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(userEntity.getUserId()));
        userEntity.setUserId(null);
        return R.success().data(userEntity).set("token",jwt);
    }

}
