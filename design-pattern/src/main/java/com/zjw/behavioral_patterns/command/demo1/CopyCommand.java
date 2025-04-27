package com.zjw.behavioral_patterns.command.demo1;

/**
 * 将所选文字复制到剪贴板
 */
public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}