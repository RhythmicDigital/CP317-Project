package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Inherited class.
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
	 * Getter for studentId.
	 *
	 * @return this.studentId
	 */
	public int getId() {
		return this.studentId;
	}

	public String getName(){return this.name;}

	/**
	 * Creates formatted String version of src.Student.
	 */
	@Override
	public String toString() {
		return (this.name + ": " + this.studentId);
	}

	public void setMarks(String courseName, ArrayList<Double> marks) {
		this.studentAllMarks.put(courseName, marks);
	}

	public void setFinalMark(String courseName, Double mark) {
		this.studentFinalMarks.put(courseName, mark);
	}

	public HashMap<String, ArrayList<Double>> getAllMarks() {
		return this.studentAllMarks;
	}

	public HashMap<String, Double> getFinalMarks() {
		return this.studentFinalMarks;
	}

	public void debug() {
		for (Map.Entry<String, ArrayList<Double>> student : studentAllMarks.entrySet()) {
			String key = student.getKey();
			ArrayList<Double> value = student.getValue();
			System.out.println(
					"Name: " + this.name + ", ID: " + this.studentId + ", Course: " + key + ", Marks: " + value);
		}
	}

}
