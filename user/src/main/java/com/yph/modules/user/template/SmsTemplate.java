package com.yph.modules.user.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.yph.constant.UserConstant;
import com.yph.modules.user.entity.SmsProperties;
import com.yph.redis.service.RedisService;
import com.yph.util.utli.RandomStringGeneratorId;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SmsTemplate {

    @Autowired
    private SmsProperties smsProperties;

    @Autowired
    private RedisService redisService;

    /**
     * 验证码 发送
     * @param templateCode
     * @param phone
     * @return
     * @throws UnsupportedEncodingException
     */
    public String sendNote(String templateCode,String phone) throws UnsupportedEncodingException{
        DefaultProfile profile = DefaultProfile.getProfile(smsProperties.getRegionId(), smsProperties.getAccessKeyId(), smsProperties.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(smsProperties.getDomain());
        request.setSysVersion(smsProperties.getVersion());
        request.setSysAction(smsProperties.getAction());
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", smsProperties.getSignName());
        request.putQueryParameter("TemplateCode", templateCode);
        Map<String,Object> map=new HashMap<>();
        String code= RandomStringGeneratorId.getRandomNumberByLength(6);
        map.put("code",code);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject jsonObject = JSONObject.parseObject(response.getData());
            if(jsonObject.getString("Code").equals("OK")){
                redisService.getValueOperations().set(UserConstant.SYSTEM_SMS+":"+phone,code, 5,TimeUnit.MINUTES);
                return "验证码已经发送成功";
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "服务器繁忙";
    }


    /**
     * 验证码 验证
     * @param phone
     * @return
     * @throws UnsupportedEncodingException
     */
    public String verify(String phone,String code) throws UnsupportedEncodingException{
        String s = redisService.getValueOperations().get(UserConstant.SYSTEM_SMS + ":" + phone);
        if(StringUtils.isBlank(s)){
            return "验证码无效或已过期";
        }
        if(!s.equals(code.trim())){
            return "验证码错误";
        }
        return "OK";
    }


}
