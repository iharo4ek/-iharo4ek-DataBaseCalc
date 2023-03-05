package my.tms_hw.storage;

import my.tms_hw.entity.Operation;

import java.sql.SQLException;
import java.util.List;

public interface OperationStorage {
    public void save(Operation operation);

    public List<Operation> findAll();
}
