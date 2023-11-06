import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Inherited class.
 *
 * @author Team
 * @version 2023-11-06
 */
public class Student extends Person {

    protected int studentId;
    protected HashMap<String, ArrayList<Integer>> studentAllMarks = new HashMap<String, ArrayList<Integer>>();
    public HashMap<String, Integer> studentFinalMarks = new HashMap<String, Integer>();

    /**
     * Student constructor
     *
     * @param lastName  Student last name (surname): defined in Person
     * @param firstName Student first name (given name): defined in Person
     * @param studentId        Student id number
     */
    public Student(final String lastName, final String firstName, final int studentId) {
	    super(lastName, firstName);
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
     * Creates formatted String version of Student.
     */
    @Override
    public String toString() {
	    return (super.toString() + ": " + this.studentId);
    }

}
