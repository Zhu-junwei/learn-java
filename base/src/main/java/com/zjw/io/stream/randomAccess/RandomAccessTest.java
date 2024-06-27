package com.zjw.io.stream.randomAccess;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;

/**
 * 通过DataOutputStream向文件中写入指定类型的字节数据。
 * 通过RandomAccessFile从文件中读取指定类型的字节数据。（如果文件是有规则，可以随机访问指定的数据）
 */
public class RandomAccessTest {

    @TempDir
    Path tempDir;

    @SneakyThrows
    @Test
    public void testWriteAndRead(){

        var file = new File(tempDir.toFile(), "employee.dat");
        var staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try (var out = new DataOutputStream(new FileOutputStream(file))) {
            // save all employee records to the file employee.dat
            for (Employee e : staff)
                writeData(out, e);
        }

        // r: 读 ，rw: 读写
        try (var in = new RandomAccessFile(file, "r")) {
            // retrieve all records into a new array

            // compute the array size
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            var newStaff = new Employee[n];

            // read employees in reverse order
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee();
                // 指到最后一条数据，从后往前读取数据
                in.seek((long) i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            // print the newly read employee records
            for (Employee e : newStaff)
                System.out.println(e);
        }
    }

    /**
     * Writes employee data to a data output
     *
     * @param out the data output
     * @param e   the employee
     */
    public static void writeData(DataOutput out, Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out); // 2 * 40
        out.writeDouble(e.getSalary()); // 8

        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear()); // 4
        out.writeInt(hireDay.getMonthValue()); // 4
        out.writeInt(hireDay.getDayOfMonth()); // 4
    }

    /**
     * Reads employee data from a data input
     *
     * @param in the data input
     * @return the employee
     */
    public static Employee readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m - 1, d);
    }
}