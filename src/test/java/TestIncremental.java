import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import controller.LaboratoriesController;
import model.Laboratory;
import model.Student;
import validator.Validator;

public class TestIncremental {

	@Test
	public void testA() {
		Validator val = new Validator();
		Student student = new Student("asdf4321","Budu Paul", 435);
		assert(Validator.validateStudent(student) == true);
	}
	
	@Test
	public void testAB() throws ParseException {
		Student student = new Student("asdf4321","Budu Paul", 435);
		Laboratory lab = new Laboratory(1, "1/1/2019", 1, "asdf4321");
		LaboratoriesController c = new LaboratoriesController("studentsTest.txt", "laboratoriesTest.txt");
		c.saveLaboratory(lab);
	    c.saveStudent(student);
	}
	
	@Test
	public void testABC() throws ParseException {
		Student student = new Student("asdf4321","Budu Paul", 435);
		Laboratory lab = new Laboratory(1, "1/1/2019", 1, "asdf4321");
		LaboratoriesController c = new LaboratoriesController("studentsTest.txt", "laboratoriesTest.txt");
		c.saveLaboratory(lab);
	    c.saveStudent(student);
	    try {
			c.addGrade("asdf4321", "1", 3);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
