package com.yph.serviceClient;

import com.yph.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("SERVER-SYSTEM")
public interface AdminServiceClient {

    @RequestMapping("/system/admin/login")
    public R login (@RequestParam("adminName") String name,@RequestParam("adminPassword") String password);


}
