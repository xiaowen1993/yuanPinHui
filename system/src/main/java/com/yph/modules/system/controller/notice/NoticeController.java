package com.yph.modules.system.controller.notice;


import com.yph.annotation.Pmap;
import com.yph.modules.system.service.NoticeService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 广告表 前端控制器
 * </p>
 *
 * @author 
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/system/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/noticePage")
    public R noticePage(@Pmap P p){
        return noticeService.noticePage(p);
    }

    @PostMapping("/noticeAdd")
    public R noticeAdd(@Pmap P p) throws Exception {
        return noticeService.noticeAdd(p);
    }

    @PostMapping("/noticeEdit")
    public R noticeEdit(@Pmap P p) throws Exception {
        return noticeService.noticeEdit(p);
    }

    @PostMapping("/editStateById")
    public R editStateById(@Pmap P p) throws Exception {
        return noticeService.editStateById(p);
    }

    @DeleteMapping("/noticeRemove")
    public R noticeRemove(@Pmap P p){
        noticeService.removeById(p.getInt("id"));
        return R.success();
    }

}
