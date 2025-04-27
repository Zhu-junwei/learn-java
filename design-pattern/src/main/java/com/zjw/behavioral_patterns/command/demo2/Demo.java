package com.zjw.behavioral_patterns.command.demo2;

import com.zjw.behavioral_patterns.command.demo2.command.Command;
import com.zjw.behavioral_patterns.command.demo2.command.door.CloseDoorCommand;
import com.zjw.behavioral_patterns.command.demo2.command.light.TurnOffLightCommand;
import com.zjw.behavioral_patterns.command.demo2.command.light.TurnOnLightCommand;
import com.zjw.behavioral_patterns.command.demo2.invoker.RemoteControl;
import com.zjw.behavioral_patterns.command.demo2.receiver.Door;
import com.zjw.behavioral_patterns.command.demo2.receiver.Light;

/**
 * 命令模式测试类
 */
public class Demo {
    public static void main(String[] args) {
        Light light = new Light();
        Door door = new Door();

        // 命令对象 将请求转换为一个包含与请求相关的所有信息的独立对象
        Command turnOnLight = new TurnOnLightCommand(light);
        Command turnOffLight = new TurnOffLightCommand(light);
        Command closeDoor = new CloseDoorCommand(door);
        // 命令的发送者
        RemoteControl remote = new RemoteControl();
        
        // 开灯
        remote.sendCommand(turnOnLight);
        // 关灯
        remote.sendCommand(turnOffLight);
        // 关门
        remote.sendCommand(closeDoor);
    }
}