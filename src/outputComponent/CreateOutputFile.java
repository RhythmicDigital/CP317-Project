package src.outputComponent;

import src.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CreateOutputFile {
	// Constants
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void writeNewFile(Set<Student> setOfStudents) {
		// Generate output file name with the current date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = dateFormat.format(new Date());
		String outputFolderPath = "Output";
		String outputFileName = outputFolderPath + "/Output-" + currentDate + ".txt";

		Path path = Paths.get(outputFileName);

		try {
			Files.createDirectories(Paths.get(outputFolderPath)); // Create the Output folder if it doesn't exist
			try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
				for (Student currentStudent : setOfStudents) {
					int studentID = currentStudent.getId();
					String studentName = currentStudent.getName();
					HashMap<String, Double> finalMarks = currentStudent.getFinalMarks();

					// Iterate over all of the student's final marks
					for (Map.Entry<String, Double> entry : finalMarks.entrySet()) {
						String courseName = entry.getKey();
						double finalMark = entry.getValue();

						String line = studentID + ", " + studentName + ", " + courseName + ", " + finalMark;
						writer.write(line);
						writer.newLine();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
