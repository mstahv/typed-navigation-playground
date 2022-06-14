package org.example;

/**
 * Example DTO
 */
public class User {
    private String name;
    private Integer id;

    public User(String name, Integer integer) {
        this.name = name;
        this.id = integer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComplexJavaClass{" +
                "string='" + name + '\'' +
                ", integer=" + id +
                '}';
    }
}
