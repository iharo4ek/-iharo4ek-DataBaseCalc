package my.tms_hw.storage;

import my.tms_hw.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryoperationStorage implements OperationStorage{

    private final List<Operation> history = new ArrayList<>();
    @Override
    public void save(Operation operation) {
        history.add(operation);
    }

    @Override
    public List<Operation> findAll() {
        return history;
    }


}
