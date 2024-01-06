package com.zjw._05._01_timer;

import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.TimerTask;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MyTimerTask extends TimerTask {

    private String taskName;

    /**
     * 打印当前task名字和当前时间
     */
    @Override
    public void run() {
        System.out.println(taskName + ":\t" + DateUtil.now());
    }
}