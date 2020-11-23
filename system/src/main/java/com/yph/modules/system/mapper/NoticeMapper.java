package com.yph.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yph.modules.system.entity.NoticeEntity;
import com.yph.util.P;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 广告表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-11-23
 */
public interface NoticeMapper extends BaseMapper<NoticeEntity> {

    void editStateById(@Param("p") P p);
}
