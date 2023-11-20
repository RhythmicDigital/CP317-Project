package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Inherited class.
 *
 * @author Team
 * @version 2023-11-06
 */
public class Student{

    protected String name;
    protected int studentId;
    protected HashMap<String, ArrayList<Integer>> studentAllMarks = new HashMap<String, ArrayList<Integer>>();
    public HashMap<String, Integer> studentFinalMarks = new HashMap<String, Integer>();

    /**
     * src.Student constructor
     *
     *
     * @param name src.Student first name (given name): defined in src.Person
     * @param studentId        src.Student id number
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

    /**
     * Creates formatted String version of src.Student.
     */
    @Override
    public String toString() {
	    return (this.name + ": " + this.studentId);
    }

    public void setMarks(String courseName, ArrayList<Integer> marks){
        this.studentAllMarks.put(courseName, marks);
    }

}
