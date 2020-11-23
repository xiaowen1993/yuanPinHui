package com.yph.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yph.modules.system.entity.NoticeEntity;
import com.yph.util.P;
import com.yph.util.R;

/**
 * <p>
 * 广告表 服务类
 * </p>
 *
 * @author 
 * @since 2020-11-23
 */
public interface NoticeService extends IService<NoticeEntity> {

    public R noticePage(P p);

    public R noticeAdd(P p) throws Exception;

    public R noticeEdit(P p) throws Exception;

    public R editStateById(P p) throws Exception;
}
