package sports_miniWiki;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yuezhang
 *
 */
public class Sports_miniWiki_Test {

	@Test
	public void testSports_miniWiki_NotNull() throws Exception {
		Sports_miniWiki sports = new Sports_miniWiki();
		assertNotNull("The Sports_miniWiki cannot be null", sports);
	}

}
