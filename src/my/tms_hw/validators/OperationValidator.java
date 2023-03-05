package my.tms_hw.validators;

import my.tms_hw.util.Validator;

import java.util.regex.Pattern;

public class OperationValidator implements Validator {
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("[0-9]*.?[0-9]+");

    private static final Pattern INT_PATTERN = Pattern.compile("[1-4]");


    @Override
    public boolean validateDouble(String string) {
        return DOUBLE_PATTERN.matcher(string).matches();
    }
    public boolean validateIntFromOneToFour(String string) {
        return INT_PATTERN.matcher(string).matches();
    }

}
