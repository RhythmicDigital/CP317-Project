package src;


import src.outputComponent.CreateOutputFile;
import src.processingComponent.Processing;
import src.inputComponent.ReadName;
import src.inputComponent.ReadCourse;

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
	final static String OUTPUT_FILE_PATH = "./output/Output.txt";

	final static ReadName nameReader = new ReadName();
	final static ReadCourse courseReader = new ReadCourse();
	private static final Set<Student> setOfStudents = new HashSet<Student>();

	/**
	 * For testing. Reads contents of "CourseFile.txt" and "NameFile.txt" from root
	 * of project and outputs to "OutputFile.txt".
	 *
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		File courseFile = new File(COURSE_FILE_PATH);
		File nameFile = new File(NAME_FILE_PATH);
		nameReader.readFile(nameFile, setOfStudents);
		courseReader.readFile(courseFile, setOfStudents);
		Processing.calculateFinal(setOfStudents);
		CreateOutputFile.writeNewFile(setOfStudents);
	}
}