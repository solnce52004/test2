package io.srialization_io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterObj {
    public static void main(String[] args) {
//        List<String> employees = new ArrayList<>();
//        employees.add("Mary");
//        employees.add("Ann");
//        employees.add("Kate");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mary", 39));
        employees.add(new Employee("Ann", 20));
        employees.add(new Employee("Kate", 43));

        try (
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream("employees.bin")
                )
        ) {
            objectOutputStream.writeObject(employees);
            System.out.println("Employees was recorded!!!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
