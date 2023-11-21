package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ReadFile {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static Set<Student> readStudentFile(File nameFile) {
		Set<Student> setOfStudents = new HashSet<>();
		int lineNumber = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String name = parts[1].trim();
					try {
						int id = Integer.parseInt(parts[0].trim());
						Student newStudent = new Student(name, id);
						log(newStudent.toString());
						if (!setOfStudents.contains(newStudent)) {
							setOfStudents.add(newStudent);
						} else {
							System.out.println("Error: Duplicate student ID at line " + lineNumber);
						}
					} catch (NumberFormatException e) {
						System.out.println("Error: Invalid ID format at line " + lineNumber);
					}
				} else {
					System.out.println("Error: Invalid format at line " + lineNumber);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return setOfStudents;
	}

	private static void addMarksToStudent(File courseFile, Set<Student> setOfStudents) throws IOException {
		int lineNumber = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(courseFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				String[] parts = line.split(",");
				if (parts.length == 6) {
					String courseName = parts[1].trim();
					if (courseName.length() == 5) {
						String courseCode = courseName.substring(0, 2);
						String courseDigits = courseName.substring(2, 5);

						// Check if first two characters (course code) are letters and last three
						// characters are numbers
						Boolean courseCodeCheck = Character.isLetter(courseCode.charAt(0))
								&& Character.isLetter(courseCode.charAt(1));
						Boolean courseDigitsCheck = Character.isDigit(courseDigits.charAt(0))
								&& Character.isDigit(courseDigits.charAt(1))
								&& Character.isDigit(courseDigits.charAt(2));
						if (courseCodeCheck && courseDigitsCheck) {
							int firstMark = Integer.parseInt(parts[2].trim());
							int secondMark = Integer.parseInt(parts[3].trim());
							int thirdMark = Integer.parseInt(parts[4].trim());
							int fourthMark = Integer.parseInt(parts[5].trim());
							ArrayList<Integer> allMarks = new ArrayList<Integer>();
							allMarks.add(firstMark);
							allMarks.add(secondMark);
							allMarks.add(thirdMark);
							allMarks.add(fourthMark);
							try {
								int id = Integer.parseInt(parts[0].trim());
								Iterator<Student> studentsIterator = setOfStudents.iterator();
								Student student = null;
								while (studentsIterator.hasNext() && student == null) {
									Student currentStudent = studentsIterator.next();
									if (currentStudent.studentId == id) {
										student = currentStudent;
									}
								}
								if (student != null) {
									student.setMarks(courseName, allMarks);
								} else {
									System.out.println("Error: Student ID not found" + lineNumber);
								}

							} catch (NumberFormatException e) {
								System.out.println("Error: Invalid ID format at line " + lineNumber);
							}
						} else {
							System.out.println(
									"Error: Invalid course name format. Course names start with 2 letters and end with 3 digits. Line "
											+ lineNumber);
						}
					} else {
						System.out.println("Error: Invalid course name format at line " + lineNumber);
					}
				} else {
					System.out.println("Error: Invalid format at line " + lineNumber);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFile(File courseFile, File nameFile, Set<Student> setOfStudents) {
		setOfStudents.addAll(readStudentFile(nameFile));
		try {
			addMarksToStudent(courseFile, setOfStudents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void log(String msg) {
		System.out.println(msg);
	}
}
