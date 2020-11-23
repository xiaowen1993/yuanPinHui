package com.yph.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.yph.modules.system.entity.SysDeptEntity;
import com.yph.modules.system.mapper.SysDeptMapper;
import com.yph.modules.system.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity> implements SysDeptService {

    private List<SysDeptEntity> toTree(List<SysDeptEntity> depts) {
        List<SysDeptEntity> treeDepts = new ArrayList<>();
        for (SysDeptEntity dept : depts) {
            if (dept.getPid() != null && dept.getPid().equals(0)) {
                dept.setChildren(new ArrayList<>());
                treeDepts.add(dept);
            }

        }
        for (SysDeptEntity rootDept : treeDepts) {
            for (SysDeptEntity dept : depts) {
                if (rootDept.getDeptId().equals(dept.getPid())) {
                    rootDept.getChildren().add(dept);
                }
            }
        }
        return treeDepts;
    }

    @Override
    public R sysDeptTree(P p) {
        p.initPageArg();
        Page<SysDeptEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<SysDeptEntity> pageObject = baseMapper.selectPage(objectPage,new QueryWrapper<SysDeptEntity>()
                .eq(!StringUtils.isNullOrEmpty(p.getString("simpleName")),"simple_name", p.getString("simpleName"))
                .eq(!StringUtils.isNullOrEmpty(p.getString("fullName")),"full_name", p.getString("fullName"))
        );
        List<SysDeptEntity> sysDeptList = this.toTree(pageObject.getRecords());
        return R.success("success",sysDeptList).set("count",pageObject.getTotal());
    }
}
