package src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CreateOutputFile {
	// Constants
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void writeNewFile(String outputFilePath, Set<Student> setOfStudents) {
		int studentID;
		String studentName;
		String courseName;
		double finalMark;
		HashMap<String, Double> finalMarks;
		Path path = Paths.get(outputFilePath);

		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			Iterator<Student> studentsIterator = setOfStudents.iterator();
			while (studentsIterator.hasNext()) {
				Student currentStudent = studentsIterator.next();
				studentID = currentStudent.studentId;
				studentName = currentStudent.name;
				finalMarks = currentStudent.studentFinalMarks;

				// Iterate over all of student's courses
				for (Map.Entry<String, Double> course : finalMarks.entrySet()) {
					courseName = course.getKey();
					finalMark = course.getValue();

					String line = studentID + ", " + studentName + ", " + courseName + ", " + finalMark;
					writer.write(line);
					writer.newLine();
					System.out.println("Output: " + line);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
