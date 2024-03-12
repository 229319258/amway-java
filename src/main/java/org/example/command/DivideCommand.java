package org.example.command;

import org.example.Calculator;

public class DivideCommand extends AbstractCommand {
    public DivideCommand(Calculator calculator, int operand) {
        super(calculator, operand);
    }

    @Override
    public void actualExecute() {
        calculator.divide(operand);
    }
}
