package com.yph.modules.system.service;

import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.SysDeptEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yph.util.P;
import com.yph.util.R;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    /**
     * 获取部门树形结构
     * @param p
     * @return
     */
    R sysDeptTree(@Pmap P p);

}
