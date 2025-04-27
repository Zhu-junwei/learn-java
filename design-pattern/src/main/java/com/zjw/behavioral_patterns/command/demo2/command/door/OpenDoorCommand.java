package com.zjw.behavioral_patterns.command.demo2.command.door;

import com.zjw.behavioral_patterns.command.demo2.command.Command;
import com.zjw.behavioral_patterns.command.demo2.receiver.Door;

/**
 * ConcreteCommand：实现Command接口，定义执行与请求相关的操作。
 */
public class OpenDoorCommand implements Command {
    private Door door;

    public OpenDoorCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }
}