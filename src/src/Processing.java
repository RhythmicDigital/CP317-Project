package src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Processing {
	// Constants
	private static final double TEST_WEIGHT = 0.2;
	private static final double FINAL_EXAM_WEIGHT = 0.4;

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	private static double calculationHelper(ArrayList<Integer> marks) {
		double finalMark = 0;
		int firstMark = marks.get(0);
		int secondMark = marks.get(1);
		int thirdMark = marks.get(2);
		int finalExamMark = marks.get(3);

		finalMark = firstMark * TEST_WEIGHT + secondMark * TEST_WEIGHT + thirdMark * TEST_WEIGHT
				+ finalExamMark * FINAL_EXAM_WEIGHT;
		return finalMark;

	}

	public static void calculateFinal(Set<Student> students) {
		double finalMark = 0;
		HashMap<String, ArrayList<Integer>> allMarks;
		Iterator<Student> studentsIterator = students.iterator();

		// Iterate over all students
		while (studentsIterator.hasNext()) {
			Student currentStudent = studentsIterator.next();
			allMarks = currentStudent.getAllMarks();

			// Iterate over all of student's courses
			for (Map.Entry<String, ArrayList<Integer>> course : allMarks.entrySet()) {
				String courseName = course.getKey();
				ArrayList<Integer> marks = course.getValue();

				// Calculate final mark of current course
				finalMark = round(calculationHelper(marks), 1);
				currentStudent.setFinalMark(courseName, finalMark);
				System.out.println(courseName + ", " + currentStudent.name + ", " + finalMark);
			}
		}
	}
}
