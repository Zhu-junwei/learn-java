package com.zjw.io.stream.objectstream.serial;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

/**
 * @author Cay Horstmann
 * @version 1.12 2021-09-10
 */
class ObjectStreamTest {

   @TempDir
   Path tempDir;

    @Test
    @SneakyThrows
    public void writeAndReadObject() {
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        var tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);

        var staff = new Employee[3];

        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

       File file = tempDir.resolve("employee.ser").toFile();
        // save all employee records to the file employee.ser
        try (var out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(staff);
        }

        try (var in = new ObjectInputStream(new FileInputStream(file))) {
            // retrieve all records into a new array

            var newStaff = (Employee[]) in.readObject();

            // raise secretary's salary
            newStaff[1].raiseSalary(10);

            // print the newly read employee records
            for (Employee e : newStaff)
                System.out.println(e);
        }
    }
}