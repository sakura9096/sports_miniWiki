/**
 * 
 */
package sports_miniWiki;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for the NBAPlayer class.
 * @author yuezhang
 *
 */
public class NBAPlayer_Test {

	private NBAPlayer newPlayer;
	@Before
	public void setUp()  {
		String player = "Aaa";
		String position = "Bbb";
		String number = "1";
		int height = 100;
		int weight = 200;
		String experience = "1";
		
		newPlayer = new NBAPlayer(player, position, number, height, weight, experience);
	}

	@Test
	public void testNBAPlayer_NotNull() {
		assertNotNull("NBAPlayer cannot be null", newPlayer);
	}
	
	@Test
	public void testNBAPlayer_toString() {
		String output = newPlayer.toString();
		String expected = "1 -- Aaa: Bbb  height: 100  weight: 200  experience: 1years\n";
		assertEquals("The toString result should be equal to the expected results", output, expected);
	}

}
