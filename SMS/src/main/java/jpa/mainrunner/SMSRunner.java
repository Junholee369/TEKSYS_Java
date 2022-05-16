package jpa.mainrunner;

import jpa.dao.CourseDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Scanner;

public class SMSRunner {

	Session sess = new Configuration().configure().buildSessionFactory().openSession();
    Scanner sc = new Scanner(System.in);
    CourseDAO courseDAO= new CourseService();
    StudentDAO studentDAO= new StudentService();

    public static void main(String[] args) {

        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    private void run() {
        int userChoice = 0;
        System.out.println("Please type the number you want to select.");
        System.out.println("Login Menu");
        System.out.println("1.Student Login");
        System.out.println("2.Quit");
        

        try {
            userChoice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter the number by your selection.");
        }
        switch (userChoice) {
            case 1:
                System.out.println("Please enter your login information.");
                runLogin();
                break;
            case 2:
                System.out.println("Thank you for visiting!");
                return;
            default:
                System.out.println("Invalid input. Please try again.");
                run();
        }
    }

    public void runLogin() {
        System.out.println("Plase enter your Email: ");
        String email = sc.nextLine();
        System.out.println("Please enter your password: ");
        String pass = sc.nextLine();
        try {
            if (studentDAO.validateStudent(email, pass)) {
                Student studentVerified = studentDAO.getStudentByEmail(email);
                System.out.println("Welcome, " + studentVerified.getsName());
                runClassMenu(studentVerified);
            }else {
                System.out.println("Invalid input. Please try again.");
                runLogin();
            }
        }  catch (NoResultException e) {
            System.out.println("Student could not be found in the system. Please try again.");
            runLogin();
        }
    }

    public void runClassMenu(Student studentVerified) {
        int userChoice2 = 0;
        System.out.println("Student Verification Successful!");
        System.out.println("Courses Menu");
        System.out.println("1 - View Current Enrolled Courses");
        System.out.println("2 - Register For a Course");
        System.out.println("3 - Quit");
        try {
            userChoice2 = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter the number by your selection.");
            runClassMenu(studentVerified);
        }
        switch (userChoice2) {
            case 1:
                System.out.println("You are currently enrolled in these Courses: ");
                findMyCourses(studentVerified);
                break;
            case 2:
                System.out.println("Course Registration Menu");
                runCourseRegister(studentVerified);
                break;
            case 3:
                System.out.println("Thank you for visiting!");
                System.exit(userChoice2);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                runClassMenu(studentVerified);
        }
    }

    private void findMyCourses(Student studentVerified) {
        if(studentDAO.getStudentCourses(studentVerified.getsEmail()).size() > 0) {
            List<Course> courseList = studentDAO.getStudentCourses(studentVerified.getsEmail());
            courseList.forEach(Course -> System.out.println(Course.getcName() + " with " + Course.getcInstructorName()));
            runClassMenu(studentVerified);
        }  else  {
            System.out.println("You are not registered to any courses.");
            System.out.println("Please try again after registering to a course.");
            runClassMenu(studentVerified);
        }
    }

    private void runCourseRegister(Student studentVerified) {
        System.out.println("Which course would you like to register for?");
        try {
            List<Course> courseList = courseDAO.getAllCourses();
            courseList.forEach(Course -> System.out.println(Course.getcId() + " for " + Course.getcName() + " with " + Course.getcInstructorName()));
            int courseSelection = Integer.parseInt(sc.nextLine());
            studentDAO.registerStudentToCourse(studentVerified.getsEmail(), courseSelection);
            System.out.println("Returning to Course Menu");
            runClassMenu(studentVerified);
        } catch (NoResultException e) {
            System.out.println("Sorry, there is no course for the selected Student ID. Please try again.");
            runCourseRegister(studentVerified);
        } catch (NumberFormatException e) {
            System.out.println("Please enter the Class ID of the Course.");
            runCourseRegister(studentVerified);
        }
    }

}

