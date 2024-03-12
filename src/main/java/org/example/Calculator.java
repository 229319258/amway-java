package org.example;

import org.example.command.Command;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private int result = 0;

    private static final int maxStackSize = 10000;


    //存储执行过的命令
    private Deque<Command> undoStack = new ArrayDeque<>();
    private Deque<Command> redoStack = new ArrayDeque<>();

    public final void execute(Command command) {
        command.execute();
        undoStack.push(command);
        //新的执行，重做栈应该清空
        redoStack.clear();

        //避免过大
        removeOldCache();
    }

    private void removeOldCache() {
        if (undoStack.size() > maxStackSize) {
            undoStack.removeLast();
        }
        if (redoStack.size() > maxStackSize) {
            redoStack.removeLast();
        }
    }

    /**
     * 撤销
     */
    public final void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Cannot undo,undo is empty");
            return;
        }

        Command command = undoStack.pop();
        command.undo();

        redoStack.push(command);
        removeOldCache();
    }

    /**
     * 重做
     */
    public final void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Cannot redo,redo is empty");
            return;
        }

        Command command = redoStack.pop();
        command.execute();
        undoStack.push(command);
        removeOldCache();
    }

    public void add(int operand) {
        result += operand;
    }

    public void subtract(int operand) {
        result -= operand;
    }

    public void multiply(int operand) {
        result *= operand;
    }

    public void divide(int operand) {
        if (operand == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }

        result = BigDecimal.valueOf(result).divide(BigDecimal.valueOf(operand)).intValue();
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
