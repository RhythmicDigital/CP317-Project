package src.inputComponent;

import src.Student;

import java.io.File;
import java.util.Objects;
import java.util.Set;

public interface ReadFile {

    /**
     * Abstract method for reading file.
     * @param file          file to read.
     * @param setOfStudents set of students.
     * @param fileName      name of file.
     */
    void readFile(File file, Set<Student> setOfStudents, String fileName);

    /**
     * Helper method for checking student id validity.
     * @param id  student id.
     * @param lineNumber number of lines.
     * @param fileName name of file.
     * @return true if student id is valid.
     */
    default boolean isValidStudentId(String id, int lineNumber, String fileName) {
        if (id == null) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Student ID is null.");
            return false;
        }

        if (!id.matches("\\d{9}")) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Invalid student ID format. It must be a 9-digit number. Found: " + id);
            return false;
        }

        return true;
    }

    /**
     * Helper method for checking student name validity.
     * @param name       student name.
     * @param lineNumber number of lines.
     * @param fileName   name of file.
     * @return true if student name is valid.
     */
    default boolean isValidStudentName(String name, int lineNumber, String fileName) {
        if (Objects.equals(name, "")) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Student name is null.");
            return false;
        }

        if (!name.matches("[A-Za-z]+([\\s-][A-Za-z]+)?")) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Invalid student name format. Found: " + name);
            return false;
        }

        return true;
    }

    /**
     * Helper method for checking course code validity.
     * @param code       course code.
     * @param lineNumber number of lines.
     * @param fileName   name of file.
     * @return true if the course code is valid.
     */
    default boolean isValidCourseCode(String code, int lineNumber, String fileName) {
        if (code == null) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Course code is null.");
            return false;
        }

        if (!code.matches("[A-Za-z]{2}\\d{3}")) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Invalid course code format. It should be 2 letters followed by 3 numbers. Found: " + code);
            return false;
        }

        return true;
    }

    /**
     * Helper method for mark validity.
     * @param mark       course code.
     * @param lineNumber number of lines.
     * @param fileName   name of file.
     * @return true if mark is valid.
     */
    default boolean isValidMark(String mark, int lineNumber, String fileName) {
        if (mark == null) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Mark is null.");
            return false;
        }

        try {
            double value = Double.parseDouble(mark);
            if (value < 0 || value > 100) {
                System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Invalid mark value. Marks should be between 0 and 100. Found: " + mark);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Invalid mark format. It should be a valid number or float. Found: " + mark);
            return false;
        }
    }
}
