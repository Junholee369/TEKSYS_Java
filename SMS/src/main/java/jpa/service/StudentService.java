package jpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO{

	@Override
    public List<Student> getAllStudents() {
		Session sess = new Configuration().configure().buildSessionFactory().openSession();
        try {
            TypedQuery tq = sess.createQuery("FROM Student");
            List<Student> studentList = tq.getResultList();
            sess.close();
            return studentList;
        } catch (NoResultException e) {
        	sess.close();
            System.out.println("OH NO! WE DON'T HAVE ANY STUDENTS!!");
            return Collections.emptyList();
        }
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
    	Session sess = new Configuration().configure().buildSessionFactory().openSession();
        String st = "From Student s where s.sEmail = :sEmail";
        Query q = sess.createQuery(st).setParameter("sEmail", sEmail);
        try{
            Student studentName = (Student) q.getSingleResult();
            return studentName;
        } catch (NoResultException e){
            System.out.println("Could not find Student under that Email");
            sess.close();
            return null;
        }
    }

    @Override
    public Boolean validateStudent(String sEmail, String sPassword) {
    	Session sess = new Configuration().configure().buildSessionFactory().openSession();
        try {
            TypedQuery tQuery = sess.getNamedQuery("validateStudent");
            tQuery.setParameter("sEmail", sEmail);
            Student student = (Student) tQuery.getSingleResult();
            sess.close();
            return Objects.equals(student.getsPass(), sPassword) && (Objects.equals(student.getsEmail(), sEmail));
        } catch (NoResultException e) {
            System.out.println("No Students Found");
            return false;
        }
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
    	Session sess = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = sess.beginTransaction();
        String hql = "FROM Student s LEFT JOIN FETCH s.sCourses c WHERE s.sEmail = :sEmail";
        String hql2 = "FROM Course c WHERE c.cId = :cId";
        TypedQuery tQuery = sess.createQuery(hql).setParameter("sEmail", sEmail);
        TypedQuery tQuery2 = sess.createQuery(hql2).setParameter("cId", cId);
        Student s = (Student) tQuery.getSingleResult();
        Course c = (Course) tQuery2.getSingleResult();
        try {
            if (s.getsCourses().contains(c)) {
                System.out.println("You are already registered in that course!");
            } else if (!s.getsCourses().contains(c)) {
                s.getsCourses().add(c);
                System.out.println("You are now enrolled in this course.");
                sess.save(s);
                t.commit();
                sess.close();
            }
        } catch (NoResultException e) {
            System.out.println("Could not register student to this course");
        }
    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
    	Session sess = new Configuration().configure().buildSessionFactory().openSession();
        try {
            TypedQuery tQuery = sess.getNamedQuery("getStudentCourses");
            tQuery.setParameter("sEmail", sEmail);
            Student student = (Student) tQuery.getSingleResult();
            List<Course> courseList = student.getsCourses();
            sess.close();
            return courseList;
        } catch (NoResultException e) {
        	sess.close();
            System.out.println("Course not found");
            return Collections.emptyList();
        }
    }
    


}


