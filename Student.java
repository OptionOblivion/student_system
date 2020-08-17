/**
 * Student class contains int StudentID, String studentName, String studentMajor.
 */

public class Student implements Comparable
{
    public int studentID;
    public String studentName;
    public String studentMajor;

    /** Default constructor.
     *
     */
    public Student()
    {
        studentID=0;
        studentName="";
        studentMajor="";
    }

    /** Special constuctor used for the search method.
     *
     * @param x - reference to studentID number for searching.
     */
    public Student(int x)
    {
        this.studentID=x;
        studentName="";
        studentMajor="";
    }

    /** Parameter constructor
     *
     * @param ID - reference to studentID string
     * @param name - reference to studentName string.
     * @param major - reference to studentMajor string.
     */
    public Student(int ID, String name, String major)
    {
        setID(ID);
        setName(name);
        setMajor(major);
    }

    /** setID method sets the studentID int.
     *
     * @param ID - reference to studentID.
     */
    public void setID(int ID)
    {
        studentID=ID;
    }

    /** setName method sets the studentName string.
     *
     * @param name - reference to studentName string.
     */
    public void setName(String name)
    {
        studentName=name;
    }

    /** setMajor method sets the studentMajor string.
     *
     * @param major - reference to studentMajor string.
     */
    public void setMajor(String major)
    {
            studentMajor=major;
    }

    /** getID method returns the studentID.
     *
     * @return - returns studentID int.
     */
    public int getID()
    {
        return studentID;
    }

    /** getName method returns studentName string.
     *
     * @return - returns studentName string.
     */
    public String getName()
    {
        return studentName;
    }

    /** getMajor method returns the studentMajor string.
     *
     * @return - returns studentMajor string.
     */
    public String getMajor()
    {
        return studentMajor;
    }

    /** toString method returns studentID, studentName, and studentMajor.
     *
     * @return - returns studentID, studentName, and studentMajor in string form.
     */
    public String toString()
    {
        return "#"+getID()+"\t"+getMajor()+" \t"+getName()+"\n";
    }

    /** compareTo method overrides compareTo method used to search the BinaryTree.
     *
     * @param o - reference to Student ID object searched.
     * @return - returns object studentID.
     */
    @Override
    public int compareTo(Object o)
    {
        Student s = (Student) o;
        return studentID - s.studentID;
    }
}

