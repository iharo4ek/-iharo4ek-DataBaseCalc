package my.tms_hw.service;

import my.tms_hw.entity.Operation;
import my.tms_hw.util.Calculator;

public class CalculatorService implements Calculator {
    public Operation calculate(Operation operation) {
        switch (operation.type) {
            case SUM:
                operation.result = operation.num1 + operation.num2;
                return operation;
            case SUB:
                operation.result = operation.num1 - operation.num2;
                return operation;
            case MUL:
                operation.result = operation.num1 * operation.num2;
                return operation;
            case DIV:
                operation.result = operation.num1 / operation.num2;
                return operation;
        }
        return operation;
    }



}
