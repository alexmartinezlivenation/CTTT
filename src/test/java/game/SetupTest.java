package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetupTest {
	Setup setupper = new Setup();

	@Test
	public void testInitializeGame() {
		assertNotNull(setupper);
	}

}
