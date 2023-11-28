package src;


import src.outputComponent.CreateOutputFile;
import src.processingComponent.Processing;
import src.inputComponent.ReadName;
import src.inputComponent.ReadCourse;
import src.userInterfaceComponent.UserInterface;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ProjectMain {

	// Constants
	private final static ReadName NAME_READER = new ReadName();
	private final static ReadCourse COURSE_READER = new ReadCourse();
	public static Set<Student> setOfStudents = new HashSet<Student>();

	/**
	 * For testing. Reads contents of "CourseFile.txt" and "NameFile.txt" from root
	 * of project and outputs to "OutputFile.txt".
	 *
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		String[] inputFiles = UserInterface.getFileNamesFromUser();
		String COURSE_FILE_PATH = "./input/" + inputFiles[1] + ".txt";
		String NAME_FILE_PATH = "./input/" + inputFiles[0] + ".txt";
		File courseFile = new File(COURSE_FILE_PATH);
		File nameFile = new File(NAME_FILE_PATH);
		NAME_READER.readFile(nameFile, setOfStudents, inputFiles[0]);
		COURSE_READER.readFile(courseFile, setOfStudents, inputFiles[1]);
		Processing.calculateFinal(setOfStudents);
		CreateOutputFile.writeNewFile(setOfStudents);
	}
}