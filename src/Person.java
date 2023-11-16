package src;

/**
 * Base class.
 *
 * @author Team
 * @version 2023-11-6
 */
public class Person implements Comparable<Person> {

    protected String firstName = null;

    protected String lastName = null;

    /**
     * src.Person constructor.
     *
     * @param lastName  src.Person last name (surname)
     * @param firstName src.Person first name (given name)
     */
    public Person(final String lastName, final String firstName) {
	    this.lastName = lastName;
	    this.firstName = firstName;
    }

    @Override
    public int compareTo(final Person person) {
	// Compares two src.Person objects by lastName then firstName.

	int flag = this.lastName.compareTo(person.lastName);

	if (flag == 0) {
	    // last names are the same - compare first names.
	    flag = this.firstName.compareTo(person.firstName);
	}
	return flag;
    }

    /**
     * Getter for firstName.
     *
     * @return this.firstName
     */
    public String getFirstName() {
	    return this.firstName;
    }

    /**
     * Getter for lastName.
     *
     * @return this.lastName
     */
    public String getLastName() {
	    return this.lastName;
    }

    /**
     * Getter for first name and last name.
     *
     * @return this.firstName + " " + this.lastName
     */
    public String getName() {
	    return this.firstName + " " + this.lastName;
    }

    /**
     * Creates formatted string version of src.Person.
     */
    @Override
    public String toString() {
	    return (this.lastName + ", " + this.firstName);
    }
}
