package com.example.task.service;

import com.example.task.model.Operation;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OperationService {
    private static final List<Operation> operations = Collections.synchronizedList(new ArrayList<>());

    public synchronized Operation getOperation(Integer numberOne, Integer numberTwo) {
        Operation operation = new Operation(numberOne, numberTwo, numberOne + numberTwo);
        operations.add(operation);
        return operation;
    }

    public synchronized List<Operation> getOperations(Integer value, boolean isDescending) {
        List<Operation> sortedOperations = isDescending
                ? operations.stream().sorted(Comparator.reverseOrder()).toList()
                : operations.stream().sorted(Comparator.naturalOrder()).toList();
        if (value != null) {
            return sortedOperations.stream().filter(operation -> Objects.equals(operation.numberOne(), value)
                            || Objects.equals(operation.numberTwo(), value)
                            || Objects.equals(operation.sum(), value)).toList();
        }
        return sortedOperations;
    }
}
