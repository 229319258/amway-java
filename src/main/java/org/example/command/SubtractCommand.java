package org.example.command;

import org.example.Calculator;

public class SubtractCommand extends AbstractCommand  {
    public SubtractCommand(Calculator calculator, int operand) {
        super(calculator, operand);
    }

    @Override
    public void actualExecute() {
        calculator.subtract(operand);
    }
}
