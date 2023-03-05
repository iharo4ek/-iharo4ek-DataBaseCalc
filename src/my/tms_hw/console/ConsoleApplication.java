package my.tms_hw.console;


import my.tms_hw.console.util.ConsoleReader;
import my.tms_hw.console.util.ConsoleWriter;
import my.tms_hw.entity.Operation;
import my.tms_hw.entity.OperationTypes;
import my.tms_hw.service.CalculatorService;
import my.tms_hw.storage.DataBaseOperationStorage;
import my.tms_hw.storage.InMemoryoperationStorage;
import my.tms_hw.storage.OperationStorage;
import my.tms_hw.util.*;
import my.tms_hw.validators.OperationValidator;

import java.util.List;

public class ConsoleApplication implements Application {
    private final Writer writer = new ConsoleWriter();
    private final Reader reader = new ConsoleReader();
    private final Calculator calculator = new CalculatorService();

    private final OperationStorage storage = new DataBaseOperationStorage();

    private Validator validator = new OperationValidator();

    public void run() {
        boolean continueCalculations = true;
        while (continueCalculations) {
            double num1 = 0;
            double num2 = 0;
            int operatonType = 0;
            String answer = "";
            boolean isCorrect = false;
            while (!isCorrect) {
                writer.writeLine("введите первое число");
                answer = reader.readLine();
                isCorrect = validator.validateDouble(answer);
                ;
            }
            num1 = Double.parseDouble(answer);

            isCorrect = false;
            while (!isCorrect) {
                writer.writeLine("введите второе число");
                answer = reader.readLine();
                isCorrect = validator.validateDouble(answer);

            }
            num2 = Double.parseDouble(answer);


            isCorrect = false;
            while (!isCorrect) {
                writer.writeLine("Введите тип операции (1 - sum, 2 - sub, 3 - mul, 4 - div)");
                answer = reader.readLine();
                isCorrect = validator.validateIntFromOneToFour(answer);
            }
            operatonType = Integer.parseInt(answer);

            switch (operatonType) {
                case 1: {
                    Operation operation = new Operation(num1, num2, OperationTypes.SUM);
                    Operation result = calculator.calculate(operation);
                    storage.save(result);
                    writer.writeLine("Result = " + result.result);
                    break;
                }
                case 2: {
                    Operation operation = new Operation(num1, num2, OperationTypes.SUB);
                    Operation result = calculator.calculate(operation);
                    storage.save(result);
                    writer.writeLine("Result = " + result.result);
                    break;
                }
                case 3: {
                    Operation operation = new Operation(num1, num2, OperationTypes.MUL);
                    Operation result = calculator.calculate(operation);
                    storage.save(result);
                    writer.writeLine("Result = " + result.result);
                    break;
                }
                case 4: {
                    Operation operation = new Operation(num1, num2, OperationTypes.DIV);
                    Operation result = calculator.calculate(operation);
                    storage.save(result);
                    writer.writeLine("Result = " + result.result);
                    break;
                }
            }
            writer.writeLine("хотите продожить вычесления? (y/n)");
            answer = reader.readLine();

            switch (answer) {
                case "y":
                    break;

                default: {
                    continueCalculations = false;
                    break;
                }
            }
        }

        writer.writeLine("хотите посмотреть историю вычеслений? (+/-)");
        String answer = reader.readLine();
        switch (answer) {
            case "+": {
                List<Operation> operations = storage.findAll();
                for (Operation operation : operations) {
                    writer.writeLine("num1: " + operation.num1 + " " + operation.type + " num2: " + operation.num2 + " = " + operation.result);
                }
            }
            default:
                return;
        }


    }
}
