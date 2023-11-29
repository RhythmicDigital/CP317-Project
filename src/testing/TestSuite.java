package src.testing;


import src.Student;
import src.inputComponent.ReadCourse;
import src.inputComponent.ReadName;
import src.outputComponent.CreateOutputFile;
import src.processingComponent.Processing;
import src.userInterfaceComponent.UserInterface;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSuite {

	// Constants
	private static final String LINE = "-".repeat(40);
	private static final String TEST_LINE = "=".repeat(80);
	private final static ReadName NAME_READER = new ReadName();
	private final static ReadCourse COURSE_READER = new ReadCourse();


	private static final Set<Student> setOfStudents = new HashSet<Student>();

	/**
	 * For testing. Reads contents of "CourseFile.txt" and "NameFile.txt" from root
	 * of project and outputs to "OutputFile.txt".
	 *
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		System.out.println("CP317 Project Class Tests");
		testStudent();
		testReadFile();
		testProcessing();
		testCreateOutputFile();
	}

	/**
	 * Simple src.Student tests.
	 */
	public static void testStudent() {
		System.out.println(TEST_LINE);
		System.out.println("Testing src.Student");
		System.out.println(LINE);
		Student student1 = new Student("John Smith", 200713471);
		System.out.println(student1);
		System.out.println(LINE);
	}

	/**
	 * Simple src.ReadFile tests.
	 */
	public static void testReadFile() {
		System.out.println("Testing src.ReadFile");
		System.out.println(LINE);
		String[] inputFiles = UserInterface.getFileNamesFromUser();
		String COURSE_FILE_PATH = "./input/" + inputFiles[1] + ".txt";
		String NAME_FILE_PATH = "./input/" + inputFiles[0] + ".txt";
		File courseFile = new File(COURSE_FILE_PATH);
		File nameFile = new File(NAME_FILE_PATH);
		NAME_READER.readFile(nameFile, setOfStudents, inputFiles[0]);
		COURSE_READER.readFile(courseFile, setOfStudents, inputFiles[1]);
		Iterator<Student> studentsIterator = setOfStudents.iterator();
		while (studentsIterator.hasNext()) {
			Student currentStudent = studentsIterator.next();
		}
		System.out.println(LINE);
	}

	/**
	 * Simple src.processingComponent.Processing tests.
	 */
	public static void testProcessing() {
		System.out.println("Testing src.processingComponent.Processing");
		System.out.println(LINE);
		Processing.calculateFinal(setOfStudents);
		System.out.println(LINE);
	}

	/**
	 * Simple src.outputComponent.CreateOutputFile tests.
	 */
	public static void testCreateOutputFile() {
		System.out.println("Testing src.outputComponent.CreateOutputFile");
		System.out.println(LINE);
		CreateOutputFile.writeNewFile(setOfStudents);
		System.out.println(LINE);
	}
}