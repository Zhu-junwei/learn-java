package com.zjw.behavioral_patterns.command.demo2.invoker;

import com.zjw.behavioral_patterns.command.demo2.command.Command;


/**
 * Invoker：请求的发送者，调用命令对象。
 */
public class RemoteControl {

    public void sendCommand(Command command) {
        command.execute();
    }

}
