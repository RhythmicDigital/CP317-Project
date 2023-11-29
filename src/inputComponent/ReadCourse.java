package src.inputComponent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import src.Student;

public class ReadCourse implements ReadFile {

	/**
	 * Method for reading course file.
	 * @param courseFile      course file.
	 * @param setOfStudents   set of students.
	 * @param fileName        file name.
	 */
	@Override
	public void readFile(File courseFile, Set<Student> setOfStudents, String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(courseFile))) {
			String line;
			int lineNumber = 0;

			while ((line = reader.readLine()) != null) {
				lineNumber++;
				String[] parts = line.split(",");
				if (parts.length == 6) {
					String id = parts[0].trim();
					String course = parts[1].trim();
					String test1 = parts[2].trim();
					String test2 = parts[3].trim();
					String test3 = parts[4].trim();
					String finalMark = parts[5].trim();

					if (isValidStudentId(id, lineNumber, fileName) && isValidCourseCode(course, lineNumber, fileName) &&
							isValidMark(test1, lineNumber, fileName) && isValidMark(test2, lineNumber, fileName) && isValidMark(test3, lineNumber, fileName) && isValidMark(finalMark, lineNumber, fileName)) {

						int studentId = Integer.parseInt(id);
						double t1 = Double.parseDouble(test1);
						double t2 = Double.parseDouble(test2);
						double t3 = Double.parseDouble(test3);
						double finalM = Double.parseDouble(finalMark);
						boolean isFound = false;

						for (Student student : setOfStudents) {
							if (student.getId() == studentId) {
								ArrayList<Double> scores = new ArrayList<>();
								scores.add(t1);
								scores.add(t2);
								scores.add(t3);
								scores.add(finalM);

								student.setMarks(course, scores);
								isFound = true;
								break;
							}
						}
						if (!isFound){
							System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Student ID " + studentId + " does not exist.");
							System.exit(1);
						}
					} else {
						System.exit(1);
					}
				} else {
					System.out.println("Error in file " + fileName + " at line " + lineNumber + ": Invalid format in course file.");
					System.exit(1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
