package top.syhan.vlog.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: vlog-api
 * @description: 短信工具类
 * @author: SYH
 * @create: 2022-04-23 20:30
 **/
@Component
public class SmsUtil {
    @Resource
    public AliyunResource aliyunResource;

    public boolean sendSms(String mobile, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliyunResource.getAccessKeyId(), aliyunResource.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "陶然然");
        request.putQueryParameter("TemplateCode", "SMS_135275229");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            String resData = response.getData();
            //将返回的JSON字符串转成JSON对象
            JSONObject jsonObject = JSON.parseObject(resData);
            // 发送成功
            if ("OK".equals(jsonObject.get("Code"))) {
                return true;
            }
        } catch (ClientException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}

