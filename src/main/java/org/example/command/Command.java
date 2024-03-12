package org.example.command;

public interface Command {
    /**
     * 执行
     */
    void execute();

    /**
     * 回滚
     */
    void undo();
}
