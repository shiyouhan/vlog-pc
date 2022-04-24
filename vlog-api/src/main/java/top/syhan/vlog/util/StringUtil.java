package top.syhan.vlog.util;

import java.util.Random;

/**
 * @program: vlog-api
 * @description: 字符串工具类
 * @author: SYH
 * @create: 2022-04-23 20:31
 **/
public class StringUtil {
    private final static int LENGTH = 6;

    /**
     * 获取六位随机数短信验证码
     *
     * @return String
     */
    public static String getVerifyCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}

