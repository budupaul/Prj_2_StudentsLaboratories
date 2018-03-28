import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;
import model.Student;
import validator.Validator;

public class TestBBT extends TestCase {
	@Test
	public void testRegistrationNumber() throws NumberFormatException, IOException {
		Validator val = new Validator();
		Student student = new Student("asdf4321","Budu Paul", 435);
		assert(Validator.validateStudent(student) == true);
		student = new Student("asdf432","Budu Paul", 435);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asdf43215","Budu Paul", 435);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asf4321","Budu Paul", 435);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asfadf4321","Budu Paul", 435);
		assert(Validator.validateStudent(student) == false);
		student = new Student("","Budu Paul", 435);
		assert(Validator.validateStudent(student) == false);
	}
	
	@Test
	public void testName() throws NumberFormatException, IOException {
		Validator val = new Validator();
		Student student = new Student("asdf4321","Budu Paul", 435);
		assert(Validator.validateStudent(student) == true);
		student = new Student("asdf4321","Budu", 435);
		assert(Validator.validateStudent(student) == true);
		student = new Student("asdf4321","Budu Paul6", 435);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asdf4321","", 435);
		assert(Validator.validateStudent(student) == false);
	}
	
	@Test
	public void testGroup() throws NumberFormatException, IOException {
		Validator val = new Validator();
		Student student = new Student("asdf4321","Budu Paul", 435);
		assert(Validator.validateStudent(student) == true);
		student = new Student("asdf4321","Budu Paul", 43);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asdf4321","Budu Paul", 0);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asdf4321","Budu Paul", -5);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asdf4321","Budu Paul", 1000);
		assert(Validator.validateStudent(student) == false);
		student = new Student("asdf4321","Budu Paul", 1600);
		assert(Validator.validateStudent(student) == false);
	}
}