package src.inputComponent;

import src.Student;

import java.io.File;
import java.util.Objects;
import java.util.Set;

public interface ReadFile {
    void readFile(File file, Set<Student> setOfStudents);

    default boolean isValidStudentId(String id, int lineNumber) {
        if (id == null) {
            System.out.println("Error at line " + lineNumber + ": Student ID is null.");
            return false;
        }

        if (!id.matches("\\d{9}")) {
            System.out.println("Error at line " + lineNumber + ": Invalid student ID format. It must be a 9-digit number.");
            return false;
        }

        return true;
    }

    default boolean isValidStudentName(String name, int lineNumber) {
        if (Objects.equals(name, "")) {
            System.out.println("Error at line " + lineNumber + ": Student name is null.");
            return false;
        }

        if (!name.matches("[A-Za-z]+([\\s-][A-Za-z]+)?")) {
            System.out.println("Error at line " + lineNumber + ": Invalid student name format. It should be in the format 'First', 'First Last', 'First-Last', or 'FirstLast'.");
            return false;
        }

        return true;
    }


    default boolean isValidCourseCode(String code, int lineNumber) {
        if (code == null) {
            System.out.println("Error at line " + lineNumber + ": Course code is null.");
            return false;
        }

        if (!code.matches("[A-Za-z]{2}\\d{3}")) {
            System.out.println("Error at line " + lineNumber + ": Invalid course code format. It should be 2 letters followed by 3 numbers.");
            return false;
        }

        return true;
    }

    default boolean isValidMark(String mark, int lineNumber) {
        if (mark == null) {
            System.out.println("Error at line " + lineNumber + ": Mark is null.");
            return false;
        }

        try {
            double value = Double.parseDouble(mark);
            if (value < 0 || value > 100) {
                System.out.println("Error at line " + lineNumber + ": Invalid mark value. Marks should be between 0 and 100.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error at line " + lineNumber + ": Invalid mark format. It should be a valid number or float.");
            return false;
        }
    }
}
