import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import junit.framework.TestCase;
import model.Laboratory;
import validator.Validator;

public class TestWBT extends TestCase {

	@Test
	public void testLaboratoryDateGood() throws ParseException {
		Laboratory lab = new Laboratory(1, "1/1/2019", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == true);
		
	}
	
	@Test
	public void testLaboratoryDateError() throws ParseException {
		try{
			Laboratory lab = new Laboratory(1, "1/1", 1, "asdf4321");
			assert(false);
		}
		catch(ParseException e){
			assert(true);
		}
	}
	
	@Test
	public void testLaboratoryDateBad() throws ParseException{
		Laboratory lab = new Laboratory(1, "1/1/2017", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == false);
		
	}
	
	@Test
	public void testLaboratoryNumberGood() throws ParseException{
		Laboratory lab = new Laboratory(1, "1/1/2019", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == true);
		
	}
	
	@Test
	public void testLaboratoryNumberBad() throws ParseException{
		Laboratory lab = new Laboratory(0, "1/1/2019", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == false);
		
	}
	
	@Test
	public void testProblemNumberGood() throws ParseException{
		Laboratory lab = new Laboratory(2, "1/1/2019", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == true);
		
	}
	
	@Test
	public void testProblemNumberBad1() throws ParseException{
		Laboratory lab = new Laboratory(3, "1/1/2019", 0, "asdf4321");
		assert(Validator.validateLaboratory(lab) == false);
		
	}
	
	@Test
	public void testProblemNumberBad2() throws ParseException{
		Laboratory lab = new Laboratory(3, "1/1/2019", 11, "asdf4321");
		assert(Validator.validateLaboratory(lab) == false);
		
	}
	
	@Test
	public void testGradeGood() {
		assert(Validator.validateGrade(2) == true);
		
	}
	
	@Test
	public void testGradeBad1() {
		assert(Validator.validateGrade(0) == false);
		
	}
	
	@Test
	public void testGradeBad2() {
		assert(Validator.validateGrade(11) == false);
		
	}

}