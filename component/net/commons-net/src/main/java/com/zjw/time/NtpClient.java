package com.zjw.time;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取NTP服务器的时间
 * ntp服务器 ：
 *  ntp.ntsc.ac.cn 国家授时中心NTP服务器
 *  cn.ntp.org.cn 中国NTP快速授时服务
 *  cn.pool.ntp.org 国际NTP快速授时服务
 *  0.centos.pool.ntp.org
 *
 * @author 朱俊伟
 */
public class NtpClient {

    public static void main(String[] args) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        Date nowDate = getNtpTime("cn.pool.ntp.org");
        System.out.println(dateFormat.format(nowDate));

    }

    /**
     * 根据ntp服务器地址返回ntp服务器时间
     * @param timeServerUrl ntp服务器地址 IPV4/IPV6/IP
     * @return ntp服务器时间
     * @throws IOException 异常
     */
    public static Date getNtpTime(String timeServerUrl) throws IOException {
        NTPUDPClient ntpClient = new NTPUDPClient();
        ntpClient.setVersion(NtpV3Packet.VERSION_4);
        ntpClient.setDefaultTimeout(20000);
        InetAddress inetAddress = InetAddress.getByName(timeServerUrl);
        TimeInfo timeInfo = ntpClient.getTime(inetAddress);
        TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
        return timeStamp.getDate();
    }
}
