package my.tms_hw.storage;


import my.tms_hw.entity.Operation;
import my.tms_hw.entity.OperationTypes;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class DataBaseOperationStorage implements OperationStorage{
    Connection connection;
    Statement statement;
    PreparedStatement prepareStatement;

    {
        try {
            connection = getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void save(Operation operation)   {
        int typeoperation = -1;
        switch (operation.type) {
            case SUM :
                typeoperation = 1;
                break;
            case SUB:
                typeoperation = 2;
                break;
            case MUL:
                typeoperation = 3;
                break;
            case DIV:
                typeoperation = 4;
                break;
        }

        try {
            prepareStatement = connection.prepareStatement(
                    "insert into Operation (num1, num2, Id_OperationType, result) values (?,?,?,?)"
            );
            prepareStatement.setDouble(1, operation.num1);
            prepareStatement.setDouble(2, operation.num2);
            prepareStatement.setInt(3, typeoperation);
            prepareStatement.setDouble(4, operation.result);
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        typeoperation = -1;
    }

    @Override
    public List<Operation> findAll()   {
        List<Operation> history = new ArrayList<>();
        Operation operation;
        try {
            ResultSet resultSet = statement.executeQuery(
                    "select num1,num2,NameOperationType," +
                    "result from operation inner join " +
                    "OperationTypes on Operation.Id_OperationType" +
                    " = OperationTypes.Id_OperationType;"
            );
            while (resultSet.next()) {
                double num1 = resultSet.getDouble(1);

                double num2 = resultSet.getDouble(2);

                OperationTypes type = OperationTypes.valueOf(resultSet.getString(3));
                double result = (resultSet.getDouble(4));

                operation = new Operation(num1,num2,type,result);
                history.add(operation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return history;
    }
}
