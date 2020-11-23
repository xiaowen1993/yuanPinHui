package com.yph.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.yph.modules.system.entity.AdminEntity;
import com.yph.modules.system.entity.NoticeEntity;
import com.yph.modules.system.entity.SysDeptEntity;
import com.yph.modules.system.mapper.NoticeMapper;
import com.yph.modules.system.service.NoticeService;
import com.yph.param.RedisParamenter;
import com.yph.redis.service.RedisService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-11-23
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, NoticeEntity> implements NoticeService {
    @Autowired
    private RedisService redisService;

    @Override
    public R noticePage(P p) {
        p.initPageArg();
        Page<NoticeEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<NoticeEntity> pageObject = baseMapper.selectPage(objectPage,new QueryWrapper<NoticeEntity>()
                .eq(!StringUtils.isNullOrEmpty(p.getString("title")),"title", p.getString("title"))
                .eq(!StringUtils.isNullOrEmpty(p.getString("state")),"state", p.getString("state"))
                .eq(!StringUtils.isNullOrEmpty(p.getString("format")),"format", p.getString("format"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }

    @Override
    public R noticeAdd(P p) throws Exception {
        NoticeEntity noticeEntity = p.thisToEntity(NoticeEntity.class);
        if(noticeEntity!=null){
            AdminEntity adminEntity = redisService.get(p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY), AdminEntity.class);
            noticeEntity.setCreateUser(adminEntity.getAdminName());
            baseMapper.insert(noticeEntity);
        }
        return R.success();
    }

    @Override
    public R noticeEdit(P p) throws Exception {
        NoticeEntity noticeEntity = p.thisToEntity(NoticeEntity.class);
        AdminEntity adminEntity = redisService.get(p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY), AdminEntity.class);
        noticeEntity.setUpdateUser(adminEntity.getAdminName());
        baseMapper.update(noticeEntity,new UpdateWrapper<NoticeEntity>().eq("id",noticeEntity.getId()));
        return R.success();
    }

    @Override
    public R editStateById(P p) throws Exception {
        baseMapper.editStateById(p);
        return R.success();
    }
}
