package bowlinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BowlingGameTest {
	
	private Game g;

	@BeforeEach
	protected void setUp() throws Exception {
		g = new Game();
	}
	
	private void rollMany(int n, int pins) {
		for( int i=0; i<n; i++) {
			g.roll(pins);
		}
	}
	
	@Test
	public void testGutterGame() throws Exception {
		rollMany(20, 0);
		assertThat(g.score()).isEqualTo(0);
	}
	
	@Test
	public void testAllOnes() throws Exception {
		rollMany(20, 1);
		assertThat(g.score()).isEqualTo(20);
	}
	
	@Test
	public void testOneSpare() throws Exception {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		assertThat(g.score()).isEqualByComparingTo(16);
	}

	@Test
	public void testOneStrike() throws Exception {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertThat(g.score()).isEqualByComparingTo(24);
	}
	
	@Test
	public void testPerfectGame() throws Exception {
		rollMany(12, 10);
		assertThat(g.score()).isEqualTo(300);
	}
	
	private void rollStrike() {
		g.roll(10);
	}
	
	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

}
