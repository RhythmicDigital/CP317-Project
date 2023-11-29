package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Student class.
 *
 * @author Team
 * @version 2023-11-06
 */
public class Student {

	protected String name;
	protected int studentId;
	protected HashMap<String, ArrayList<Double>> studentAllMarks = new HashMap<String, ArrayList<Double>>();
	public HashMap<String, Double> studentFinalMarks = new HashMap<String, Double>();

	/**
	 * src.Student constructor
	 *
	 *
	 * @param name      src.Student name (given name): defined in output.Person
	 * @param studentId src.Student id number
	 */
	public Student(final String name, final int studentId) {
		this.name = name;
		this.studentId = studentId;
	}

	/**
	 * Getter method for studentId.
	 *
	 * @return this.studentId
	 */
	public int getId() {
		return this.studentId;
	}

	/**
	 * Getter method for student name.
	 *
	 * @return this.name
	 */
	public String getName(){return this.name;}

	/**
	 * Setter for studentAllMarks.
	 * @param courseName name of course.
	 * @param marks      array list of marks.
	 */
	public void setMarks(String courseName, ArrayList<Double> marks) {
		this.studentAllMarks.put(courseName, marks);
	}

	/**
	 * Setter for studentFinalMarks.
	 * @param courseName name of course.
	 * @param mark       mark to set (Double).
	 */
	public void setFinalMark(String courseName, Double mark) {
		this.studentFinalMarks.put(courseName, mark);
	}

	/**
	 * Getter method for student marks.
	 *
	 * @return this.name
	 */
	public HashMap<String, ArrayList<Double>> getAllMarks() {
		return this.studentAllMarks;
	}

	/**
	 * Getter method for student final marks.
	 *
	 * @return this.name
	 */
	public HashMap<String, Double> getFinalMarks() {
		return this.studentFinalMarks;
	}

	/**
	 * Helper method for comparing students.
	 * @param o object to compare.
	 * @return true if this.studentId is equal to other student id.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return studentId == student.studentId;
	}

	/**
	 * Helper method for getting student id hashcode.
	 *
	 * @return hashcode of student id.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}
}
