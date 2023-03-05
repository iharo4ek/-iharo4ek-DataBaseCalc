package my.tms_hw.entity;

public class Operation {

    public double num1;
    public double num2;
    public  OperationTypes type;
    public double result;

    public Operation(double num1, double num2, OperationTypes type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public Operation(double num1, double num2, OperationTypes type, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;
    }

}
