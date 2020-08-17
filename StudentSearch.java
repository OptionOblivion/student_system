import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Dean Hartley
 * @version 4/26/2020
 *
 */

public class StudentSearch{

    /** This is the main program function*/
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        BinarySearchTree students = new BinarySearchTree();
        ArrayList<Student> sList = new ArrayList<>();
        System.out.println("Start student search program.\n");
        initialStudents(sList,students);
        int i=0;
        do
            {
                System.out.println("\f");
                System.out.println("-Student List-");
                students.print();
                menu();
                System.out.println("Enter number in []: ");
                int c = in.nextInt();
                switch (c)
                    {
                        case 1:
                            createStudent(in, students, sList);
                            break;
                        case 2:
                            searchStudent(in, students);
                            break;
                        case 3:
                            removeStudent(in, students);
                            break;
                        case 4:
                            majorList(in, sList);
                            break;
                        case 5:
                            System.out.println("Student search program ended.");
                            return;
                    }
            } while (i != 1);
    }

    /** createStudent method has the user add a new student object to the tree. Takes in Scanner in,
     * BinarySearchTree students, and ArrayList sList.
     *
      * @param in- reference to Scanner in.
     * @param students - reference to the BinarySearchTree students.
     * @param sList - reference to the ArrayList sList.
     */
    public static void createStudent(Scanner in, BinarySearchTree students, ArrayList<Student> sList)
    {
        try
            {
                System.out.println("-[Add Student]-");
                System.out.println("Please enter new student name: ");
                String name = in.next();
                in.nextLine();
                System.out.println("Enter new student ID#: ");
                int studentId = in.nextInt();
                System.out.println("Please enter new student 3 character major code: ");
                String major = in.next().toUpperCase();
                major = major.trim();
                if (major.length() == 3)
                {
                    Student stud = new Student(studentId, name, major);
                    students.add(stud);
                    sList.add(stud);
                    System.out.println("\nStudent Added.");
                } else
                    {
                        System.out.println("Error: Major must be 3 characters");
                    }
            } catch(Exception q)
                {
                    System.out.println("Invalid input!");
                    in.nextLine();
                }
    }

    /** removeStudent method allows the user to remove a student object from the BinarySearchTree.
     * Takes in Scanner in, BinarySearchTree students.
     *
     * @param in - reference to Scanner in.
     * @param students - reference to the BinarySearchTree students.
     */
    public static void removeStudent(Scanner in, BinarySearchTree students)
    {
        try
            {
                System.out.println("-[Remove Student]-");
                System.out.println("Enter student ID to be removed: ");
                int ID = in.nextInt();
                Student s = new Student(ID);
                System.out.println(students.find(s) + "[removed]");
                students.remove(s);
            }
        catch (InputMismatchException e)
            {
                System.out.println("Invalid input!");
            }
    }

    /** searchStudents method allows the use to search a student object to be displayed on screen.
     * Takes in Scanner in, BinarySearchTree students.
     * @param in - reference to Scanner in.
     * @param students - reference to BinarySearchTree students.
     */
    public static void searchStudent(Scanner in, BinarySearchTree students)
    {
        try
            {
                System.out.println("-[Search Student]-");
                System.out.println("Please enter the students number to display: ");
                int x = in.nextInt();
                Student s = new Student(x);
                if (students.find(s) == null)
                    {
                        System.out.println("Student not found!");
                    } else
                        {
                            System.out.print(students.find(s));
                        }
            }
            catch (InputMismatchException e)
                {
                    System.out.println("Invalid input!");
                }
    }

    /**majorList allows the user to sort the student list by major code.
     * Takes in Scanner in, ArrayList sList.
     * @param in - reference to Scanner in.
     * @param sList - reference to ArrayList sList.
     */
    public static void majorList(Scanner in, ArrayList<Student> sList)
    {
        try
            {
                System.out.println("-[List by Major]-");
                System.out.println("Enter 3 character major to sort from: ");
                String major = in.next().toUpperCase();
                for (Student stu : sList)
                    {
                        if (stu.getMajor().equals(major))
                            {
                                System.out.println(stu.toString());
                            }
                    }
            }
        catch(InputMismatchException e)
            {
                System.out.println("Invalid input!");
            }
    }

    /** initialStudents method creates 5 student objects and adds them to the BinarySearchTree.
     *
     * @param sList - reference to ArrayList sList.
     * @param students - reference to BinarySearchTree students.
     */
    public static void initialStudents(ArrayList<Student> sList, BinarySearchTree students)
    {
        Student s1 = new Student(123,"Harry Johnson","DPR");
        Student s2 = new Student(104,"Jake Swift","MAT");
        Student s3 = new Student(215,"Justin Long","COM");
        Student s4 = new Student(164,"Larry O'Reilly","ENG");
        Student s5 = new Student(199,"Michael Peterson","COM");
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);
        sList.add(s5);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }

    /** menu method displays all menu options.
     *
     */
    public static void menu()
    {
        System.out.println("\n   *[Main Menu]*   ");
        System.out.println("[1] Add Student");
        System.out.println("[2] Search Student");
        System.out.println("[3] Remove Student");
        System.out.println("[4] List Major");
        System.out.println("[5] Quit");
    }
}
