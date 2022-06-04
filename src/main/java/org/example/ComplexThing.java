package org.example;

public class ComplexThing {
    private String string;
    private int integer;

    public ComplexThing(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        return "ComplexJavaClass{" +
                "string='" + string + '\'' +
                ", integer=" + integer +
                '}';
    }
}
