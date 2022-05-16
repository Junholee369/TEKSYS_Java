package jpa.service;

import java.util.Collections;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO{

	  @Override
	    public List<Course> getAllCourses() {
		  Session sess = new Configuration().configure().buildSessionFactory().openSession();
	        try {
	        TypedQuery tQuery = sess.createQuery("FROM Course");
	        List<Course> results= tQuery.getResultList();
	        sess.close();
	        return results;
	        } catch (NoResultException e){
	        	sess.close();
	            System.out.println("No Courses Found");
	            return Collections.emptyList();
	        }
	    }
}
