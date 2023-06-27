package com.example.task.api;

import com.example.task.model.Operation;
import com.example.task.service.OperationService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class Controller {
    @Autowired
    OperationService operationService;


    @GetMapping(path="/operation")
    public Operation getOperation(@RequestParam @Min(0) @Max(100) Integer numberOne,
            @RequestParam @Min(0) @Max(100) Integer numberTwo) {
        return operationService.getOperation(numberOne, numberTwo);
    }

    @GetMapping(path="/operations")
    public List<Operation> getOperations(@RequestParam(required = false) @Min(0) @Max(100) Integer val,
            @RequestParam boolean isDescending) {
        return operationService.getOperations(val, isDescending);
    }

}
