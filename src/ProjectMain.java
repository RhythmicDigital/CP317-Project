package src;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ProjectMain {

    // Constants
    private static final String LINE = "-".repeat(40);
    private static final String TEST_LINE = "=".repeat(80);

    private Set<Student> setOfStudents = new HashSet<Student>();

    /**
     * For testing. Reads contents of "CourseFile.txt" and "NameFile.txt" from root of project
     * and outputs to "OutputFile.txt".
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        System.out.println("CP317 Project Class Tests");

        String coursePath = "input/CourseFile.txt";
        File courseFile = new File(coursePath);
        String namePath = "input/NameFile.txt";
        File nameFile = new File(namePath);
        testStudent();
    }

    /**
     * Simple src.Student tests.
     */
    public static void testStudent() {
        System.out.println(TEST_LINE);
        System.out.println("Testing src.Student");
        System.out.println(LINE);
        Student student1 = new Student("Smith", "John", 200713471);
        System.out.println(student1.toString());
    }
}