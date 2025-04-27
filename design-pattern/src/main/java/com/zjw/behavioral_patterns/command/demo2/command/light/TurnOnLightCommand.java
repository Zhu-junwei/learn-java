package com.zjw.behavioral_patterns.command.demo2.command.light;

import com.zjw.behavioral_patterns.command.demo2.command.Command;
import com.zjw.behavioral_patterns.command.demo2.receiver.Light;

/**
 * ConcreteCommand：实现Command接口，定义执行与请求相关的操作。
 */
public class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}