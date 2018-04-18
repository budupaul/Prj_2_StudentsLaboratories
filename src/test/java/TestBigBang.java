import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import controller.LaboratoriesController;
import model.Laboratory;
import model.Student;
import repository.FileDataPersistence;
import validator.Validator;

public class TestBigBang {

	@Test
	public void testGroup() {
		Validator val = new Validator();
		Student student = new Student("asdf4321","Budu Paul", 435);
		assert(Validator.validateStudent(student) == true);
	}
	
	@Test
	public void testLaboratoryDateBad() throws ParseException{
		Laboratory lab = new Laboratory(1, "1/1/2019", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == true);
		
	}
	
	@Test
	public void testListing(){
	    LaboratoriesController c = new LaboratoriesController("studentsTest.txt", "laboratoriesTest.txt");
	    try {
			c.saveLaboratory(new Laboratory(1, "1/1/2019", 1, "asdf4321"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    c.saveStudent(new Student("asdf4321","Budu Paul", 435));
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
	    
	    try {
			assert(c.passedStudents().size() == 0);
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
	
	@Test
	public void testIntegration() throws ParseException{
		Student student = new Student("asdf4321","Budu Paul", 435);
		Laboratory lab = new Laboratory(1, "1/1/2019", 1, "asdf4321");
		this.testListing();
		LaboratoriesController c = new LaboratoriesController("studentsTest.txt", "laboratoriesTest.txt");
		c.saveLaboratory(lab);
	    c.saveStudent(new Student("asdf4321","Budu Paul", 435));
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
	    
	    try {
			assert(c.passedStudents().size() == 0);
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
