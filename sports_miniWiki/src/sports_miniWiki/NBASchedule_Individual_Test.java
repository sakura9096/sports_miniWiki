package sports_miniWiki;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for the NBASchedule_Individual class.
 * @author yuezhang
 *
 */
public class NBASchedule_Individual_Test {

	NBASchedule_Individual schedule;
	
	@Before
	public void setUp() {
		String date = "12-25";
		String time = "07:30";
		String away = "Aaa";
		String home = "Bbb";
		schedule = new NBASchedule_Individual(date, time, away, home);
	}

	@Test
	public void testNBASchedule_Individual_NotNull() {
		
		assertNotNull("NBASchedule_Individual should not be null", schedule);
	}
	
	
	@Test
	public void testNBASchedule_Individual_toString() {
		String output = schedule.toString();
		String expected = "12-25 07:30 Aaa VS Bbb";
		assertEquals("The toString method in NBASchedule_Individual class should be equal to expected", output, expected);
	}
	
	@Test
	public void testGetDate() {
		String time = "07:30";
		assertFalse("the getDate method should not return the time", time.equals(schedule.getDate()));
	}

}
