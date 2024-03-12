package org.example.command;

import org.example.Calculator;

public abstract class AbstractCommand implements Command {
    protected final Calculator calculator;
    /**
     * 操作数
     */
    protected final int operand;
    /**
     * 保存上个命令操作的结果，降低undo的运算成本
     */
    protected int preValue;

    public AbstractCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }


    @Override
    public final void execute() {
        preValue = calculator.getResult();
        actualExecute();
    }

    public abstract void actualExecute();

    @Override
    public final void undo() {
        calculator.setResult(preValue);
        undoAfter();
    }

    public void undoAfter() {

    }

}
