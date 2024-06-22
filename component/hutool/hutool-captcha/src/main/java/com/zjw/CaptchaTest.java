package com.zjw;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

/**
 * <p>
 * 验证码生成工具类
 * </p>
 *
 * @author 朱俊伟
 * @since 2024/06/15 10:24
 */
public class CaptchaTest {
    public static void main(String[] args) {
        // 参考 https://doc.hutool.cn/pages/captcha/#%E5%AE%9E%E7%8E%B0%E7%B1%BB
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100);
        System.out.println(captcha.getCode());
        System.out.println("captcha.getImageBase64() = " + captcha.getImageBase64());
        System.out.println("captcha.getImageBase64Data() = " + captcha.getImageBase64Data());
    }
}
