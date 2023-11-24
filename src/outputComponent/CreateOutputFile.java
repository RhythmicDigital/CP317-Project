package src.outputComponent;

import src.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CreateOutputFile {
	// Constants
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void writeNewFile(String outputFilePath, Set<Student> setOfStudents) {
		Path path = Paths.get(outputFilePath);

		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			for (Student currentStudent : setOfStudents) {
				int studentID = currentStudent.getId();
				String studentName = currentStudent.getName();
				HashMap<String, Double> finalMarks = currentStudent.getFinalMarks();

				// Iterate over all of the student's courses
				for (Map.Entry<String, Double> course : finalMarks.entrySet()) {
					String courseName = course.getKey();
					double finalMark = course.getValue();

					String line = studentID + ", " + studentName + ", " + courseName + ", " + finalMark;
					writer.write(line);
					writer.newLine();
					System.out.println("Output: " + line);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
