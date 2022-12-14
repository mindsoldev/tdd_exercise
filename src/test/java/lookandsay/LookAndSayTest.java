/**
 * 
 */
package lookandsay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author phars
 *
 */
public class LookAndSayTest {
	
	private static List<String> expectedResults;
	private LookAndSay lookAndSay;
	
	@BeforeAll
	public static void staticSetUp() {
		expectedResults = Arrays.asList( new String[] {
				"1",
				"11",
				"21",
				"1211",
				"111221",
				"312211",
				"13112221",
				"1113213211",
				"31131211131221",
				"13211311123113112211"
				}
			);
	}
	
	@BeforeEach
	public void setUp() {
		lookAndSay = new LookAndSay();
	}

	@Test
	public void testOne() {
		assertEquals("", lookAndSay.say(null));
	}
	
	@Test
	public void testTwo() {
		assertEquals("", lookAndSay.say(""));
	}
	
	@Test
	public void testThree() {
		assertEquals(expectedResults.get(1), lookAndSay.say(expectedResults.get(0)));
	}
	
	@Test
	public void testFour() {
		assertEquals(expectedResults.get(2), lookAndSay.say(expectedResults.get(1)));
	}
	
	@Test
	public void testFive() {
		assertEquals(expectedResults.get(3), lookAndSay.say(expectedResults.get(2)));
	}
	
	@Test
	public void testSix() {
		assertEquals(expectedResults.get(4), lookAndSay.say(expectedResults.get(3)));
	}
	
	@Test
	public void testSeven() {
		assertEquals(expectedResults.get(5), lookAndSay.say(expectedResults.get(4)));
	}
	
	@Test
	public void testNine() {
		assertEquals(expectedResults.get(6), lookAndSay.say(expectedResults.get(5)));
	}
	
	@Test
	public void testTen() {
		LookAndSay lookAndSay = new LookAndSay();
		assertEquals(expectedResults.get(7), lookAndSay.say(expectedResults.get(6)));
	}
	
	@Test
	public void testEleven() {
		LookAndSay lookAndSay = new LookAndSay();
		assertEquals(expectedResults.get(8), lookAndSay.say(expectedResults.get(7)));
	}
	
	@Test
	public void testTwelve() {
		assertEquals(expectedResults.get(9), lookAndSay.say(expectedResults.get(8)));
	}
	
	@ParameterizedTest
	@MethodSource("provideStringsForTest")
	public void testForTen(String expected, String input) {
		assertEquals(expected, lookAndSay.say(input));
	}
	
	private static Stream<Arguments> provideStringsForTest() {
//		return Stream.of(
//			      			Arguments.of(expectedResults.get(1), expectedResults.get(0)),
//			      			Arguments.of(expectedResults.get(2), expectedResults.get(1)),
//			      			Arguments.of(expectedResults.get(3), expectedResults.get(2)),
//			      			Arguments.of(expectedResults.get(4), expectedResults.get(3)),
//			      			Arguments.of(expectedResults.get(5), expectedResults.get(4)),
//			      			Arguments.of(expectedResults.get(6), expectedResults.get(5)),
//			      			Arguments.of(expectedResults.get(7), expectedResults.get(6)),
//			      			Arguments.of(expectedResults.get(8), expectedResults.get(7)),
//			      			Arguments.of(expectedResults.get(9), expectedResults.get(8))
//			      		);
		
		Stream.Builder<Arguments> builder = Stream.builder();
		for (int i = 1; i < expectedResults.size(); i++) {
			builder.add(Arguments.of(expectedResults.get(i), expectedResults.get(i-1)));
		}
		return builder.build();
		
	}

}
