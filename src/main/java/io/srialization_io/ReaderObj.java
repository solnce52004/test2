package io.srialization_io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReaderObj {
    public static void main(String[] args) {
//        List<String> employees = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        try (
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream("employees.bin")
                )
        ) {

//            employees = (ArrayList)objectInputStream.readObject();
//            for (String s: employees) {
//                System.out.println(s);
//            }

            employees = getEmployees(employees, objectInputStream);

            if (employees != null) {
                for (Employee e : employees) {
                    System.out.println(e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")//???????
    private static List<Employee> getEmployees(List<Employee> employees, ObjectInputStream objectInputStream) {
        try {
            employees = (ArrayList<Employee>) objectInputStream.readObject();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
