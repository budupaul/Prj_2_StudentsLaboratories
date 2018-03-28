import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import junit.framework.TestCase;
import model.Laboratory;
import model.Student;
import validator.Validator;

public class TestWBT extends TestCase {

	@Test
	public void testLaboratoryDate() throws ParseException {
		Validator val = new Validator();
		Laboratory lab = new Laboratory(1, "1/1/2019", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == true);
		try{
			lab = new Laboratory(1, "1/1", 1, "asdf4321");
			assert(false);
		}
		catch(ParseException e){
			assert(true);
		}
		lab = new Laboratory(1, "1/1/2017", 1, "asdf4321");
		assert(Validator.validateLaboratory(lab) == false);
		
	}

}