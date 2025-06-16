package org.example.task2;

public class Worker {

    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    public Worker(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "salary=" + salary +
                '}';
    }

}


