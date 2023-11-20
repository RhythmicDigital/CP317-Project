package src;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class ReadFile {
    public static Set<Student> readStudentFile(File nameFile) {
        Set<Student> setOfStudents = new HashSet<>();
        int lineNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[1].trim();
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        Student newStudent = new Student(name, id);
                        if (!setOfStudents.contains(newStudent)) {
                            setOfStudents.add(newStudent);
                        } else {
                            System.out.println("Error: Duplicate student ID at line " + lineNumber);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid ID format at line " + lineNumber);
                    }
                } else {
                    System.out.println("Error: Invalid format at line " + lineNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return setOfStudents;
    }
}
