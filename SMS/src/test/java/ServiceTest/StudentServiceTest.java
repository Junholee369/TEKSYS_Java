package ServiceTest;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.StudentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class StudentServiceTest {

    static StudentService studentService;
    @BeforeAll
    public static void setup() {
        studentService = new StudentService();
    }

    @Test											//Tests for whether or not all the information under student email matches what is expected
    public void testGetStudentByEmail() {
        Student expected = new Student();
        expected.setsEmail("sbowden1@yellowbook.com");
        expected.setsName("Sonnnie Bowden");
        expected.setsPass("SJc4aWSU");

        Student actual = studentService.getStudentByEmail("sbowden1@yellowbook.com");

        Assertions.assertEquals(expected.getsEmail(), actual.getsEmail());
        Assertions.assertEquals(expected.getsName(), actual.getsName());
        Assertions.assertEquals(expected.getsPass(), actual.getsPass());
    }
    
    
    @Test											
	public final void testGetStudentCourses() {
        Student expected = new Student();
		StudentService sService = new StudentService();
		List<Course> expList = expected.getsCourses();
		List<Course> actualList = sService.getStudentCourses(expected.getsEmail());
		
		Course[] actual2 = actualList.toArray(new Course[actualList.size()]);
		Course[] expected2 = expList.toArray(new Course[expList.size()]);
		
		assertArrayEquals(expected2,actual2);
		
				
	}
}
