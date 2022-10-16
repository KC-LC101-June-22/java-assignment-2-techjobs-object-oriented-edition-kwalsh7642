package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {


    private int id;
    private static int nextId = 1;

    private String value;

    // getters and setters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //custom methods

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField that = (JobField) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String aValue) {
        this();
        this.value = aValue;
    }

}
