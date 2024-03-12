package org.example;

import org.example.command.AddCommand;
import org.example.command.DivideCommand;
import org.example.command.MultiplyCommand;
import org.example.command.SubtractCommand;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Calculator calculator = new Calculator();


        // 执行一系列操作
        calculator.execute(new AddCommand(calculator, 1));
        System.out.println(calculator.getResult());

        calculator.execute(new SubtractCommand(calculator, 3));
        System.out.println(calculator.getResult());

        calculator.execute(new MultiplyCommand(calculator, 2));
        System.out.println(calculator.getResult());

        calculator.execute(new DivideCommand(calculator, 4));
        System.out.println(calculator.getResult());


        System.out.println("-----");
        calculator.redo();

        calculator.undo();
        System.out.println(calculator.getResult());

        calculator.execute(new AddCommand(calculator, 2));
        System.out.println(calculator.getResult());

        calculator.redo();
        calculator.undo();
        System.out.println(calculator.getResult());
        System.out.println("--------");
        calculator.undo();
        System.out.println(calculator.getResult());

        calculator.redo();
        System.out.println(calculator.getResult());

        calculator.redo();
        System.out.println(calculator.getResult());
        calculator.redo();
        System.out.println(calculator.getResult());
    }
}