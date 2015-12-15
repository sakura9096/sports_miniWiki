package sports_miniWiki;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GetTennisScheduleTest {

	private GetTennisSchedule schedule;
	
	@Before
	public void setUp() throws Exception {
		schedule = new GetTennisSchedule();
	}
	
	@Test
	public void testScheduleNotNull() {
		assertNotNull("Schedule cannot be null", schedule);
	}
	
	@Test
	public void testATPScheduleMonthNumber() {
		int numberOfMonth = schedule.getATPschedule().size();
		assertEquals("ATP's schedule shoud be from January to November", 11, numberOfMonth);
	}
	
	@Test
	public void testWTAScheduleMonthNumber() {
		int numberOfMonth = schedule.getWTAschedule().size();
		assertEquals("WTA's schedule shoud be from January to November", 11, numberOfMonth);
	}
	
	@Test
	public void testTournamentName() {
		String name1 = schedule.getATPschedule().get("January").get(0).getName();
		String name2 = schedule.getATPschedule().get("January").get(1).getName();
		assertNotEquals("Two tournament name should not be the same", name1, name2);
	}
	
	@Test
	public void testTournamentTime() {
		String start = schedule.getATPschedule().get("November").get(0).getStart();
		String end = schedule.getATPschedule().get("November").get(0).getEnd();
		
		assertNotEquals("The start and end time of one tournament should not be the same", start, end);
	}
	
	@Test
	public void testTournamentAttributes() {
		String type = schedule.getATPschedule().get("June").get(0).getType();
		String ground = schedule.getATPschedule().get("June").get(0).getGround();
		String prize = schedule.getATPschedule().get("June").get(0).getPrize();
		String currency = schedule.getATPschedule().get("June").get(0).getCurrency();
		
		assertNotNull("Tournament type cannot be null", type);
		assertNotNull("Tournament ground cannot be null", ground);
		assertNotNull("Tournament prize cannot be null", prize);
		assertNotNull("Prize's currency cannot be null", currency);
	}
	

}
