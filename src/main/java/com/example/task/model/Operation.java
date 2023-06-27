package com.example.task.model;

public record Operation(Integer numberOne, Integer numberTwo, Integer sum) implements Comparable<Operation> {
    @Override
    public int compareTo(Operation o) {
        return this.sum().compareTo(o.sum());
    }
}
