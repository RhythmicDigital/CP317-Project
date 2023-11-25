package src.inputComponent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import src.Student;

public class ReadName implements ReadFile {
	@Override
	public void readFile(File nameFile, Set<Student> setOfStudents) {
		try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
			String line;
			int lineNumber = 0;

			while ((line = reader.readLine()) != null) {
				lineNumber++;
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String name = parts[1].trim();
					String id = parts[0].trim();

					if (isValidStudentName(name, lineNumber) && isValidStudentId(id, lineNumber)) {
						Student newStudent = new Student(name, Integer.parseInt(id));
						if (!setOfStudents.contains(newStudent)) {
							setOfStudents.add(newStudent);
						} else {
							System.out.println("Error at line " + lineNumber + ": Duplicate student ID in name file.");
						}
					} else {
						// Do not process the line if validation fails
					}
				} else {
					System.out.println("Error at line " + lineNumber + ": Invalid format in name file.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}