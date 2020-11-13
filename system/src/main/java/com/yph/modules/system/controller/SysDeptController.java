package com.yph.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.AdminEntity;
import com.yph.modules.system.entity.SysDeptEntity;
import com.yph.modules.system.service.AdminService;
import com.yph.modules.system.service.SysDeptService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 增加
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptAdd",method = RequestMethod.POST)
    public R sysDeptAdd(@Pmap P p) throws Exception {
        SysDeptEntity sysDeptEntity = p.thisToEntity(SysDeptEntity.class);
        if(sysDeptEntity!=null){
            sysDeptService.save(sysDeptEntity);
        }
        return R.success();
    }

    /**
     * 查询集合
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptPage",method = RequestMethod.GET)
    public R sysDeptPage(@Pmap P p) throws Exception {
        p.initPageArg();
        Page<SysDeptEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<SysDeptEntity> pageObject = sysDeptService.page(objectPage,new QueryWrapper<SysDeptEntity>()
                .eq("simple_name", p.getString("simpleName"))
                .eq("full_name", p.getString("fullName"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }


    /**
     * 修改
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptEdit",method = RequestMethod.POST)
    public R sysDeptEdit(@Pmap P p) throws Exception {
        SysDeptEntity sysDeptEntity = p.thisToEntity(SysDeptEntity.class);
        sysDeptService.update(sysDeptEntity,new UpdateWrapper<SysDeptEntity>().eq("dept_id",sysDeptEntity.getDeptId()));
        return R.success();
    }

    /**
     * 删除
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptRemove",method = RequestMethod.POST)
    public R sysDeptRemove(@Pmap P p) throws Exception {
        sysDeptService.removeById(p.getInt("dept_id"));
        return R.success();
    }

}