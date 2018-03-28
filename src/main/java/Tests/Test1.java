package Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import model.Student;
import repository.FileDataPersistence;

public class Test1 {

	@Test
	public void test() throws NumberFormatException, IOException {
		FileDataPersistence repo = new FileDataPersistence("students.txt");
		int size = repo.getStudentsList().size();
		assert(repo.getStudentsList().size() == size);
		Student student = new Student("asdf4321","Budu Paul", 435);
		repo.saveStudent(student);
		assert(repo.getStudentsList().size() == size+1);
		student = new Student("asdf4321","Budu Paul", 88);
		assert(repo.getStudentsList().size() == size+1);
		student = new Student("asdf4321","Budu Paul", 2000);
		assert(repo.getStudentsList().size() == size+1);
		

	}

}
