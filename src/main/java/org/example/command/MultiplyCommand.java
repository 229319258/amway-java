package org.example.command;

import org.example.Calculator;

public class MultiplyCommand extends AbstractCommand {
    public MultiplyCommand(Calculator calculator, int operand) {
        super(calculator, operand);
    }

    @Override
    public void actualExecute() {
        calculator.multiply(operand);
    }
}
