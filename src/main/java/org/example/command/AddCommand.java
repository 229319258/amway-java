package org.example.command;

import org.example.Calculator;

public class AddCommand extends AbstractCommand {
    public AddCommand(Calculator calculator, int operand) {
        super(calculator, operand);
    }

    @Override
    public void actualExecute() {
        calculator.add(operand);
    }
}
