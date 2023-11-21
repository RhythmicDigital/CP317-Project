package src;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProjectMain {

	// Constants
	private static final String LINE = "-".repeat(40);
	private static final String TEST_LINE = "=".repeat(80);
	final static String COURSE_FILE_PATH = "./input/CourseFile.txt";
	final static String NAME_FILE_PATH = "./input/NameFile.txt";
	final static String OUTPUT_FILE_NAME = "./output/Output.txt";

	private static Set<Student> setOfStudents = new HashSet<Student>();

	/**
	 * For testing. Reads contents of "CourseFile.txt" and "NameFile.txt" from root
	 * of project and outputs to "OutputFile.txt".
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
		testReadFile();
	}

	/**
	 * Simple src.Student tests.
	 */
	public static void testStudent() {
		System.out.println(TEST_LINE);
		System.out.println("Testing src.Student");
		System.out.println(LINE);
		Student student1 = new Student("John Smith", 200713471);
		System.out.println(student1.toString());
	}

	/**
	 * Simple src.ReadFile tests.
	 */
	public static void testReadFile() {
		System.out.println("Testing src.ReadFile");
		System.out.println(LINE);
		ReadFile readFile = new ReadFile();
		File courseFile = new File(COURSE_FILE_PATH);
		File nameFile = new File(NAME_FILE_PATH);
		ReadFile.readFile(courseFile, nameFile, setOfStudents);
		Iterator<Student> studentsIterator = setOfStudents.iterator();
		while (studentsIterator.hasNext()) {
			Student currentStudent = studentsIterator.next();
			currentStudent.getMarks();
		}
	}
}