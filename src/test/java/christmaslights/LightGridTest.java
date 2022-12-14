package christmaslights;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LightGridTest {
	
	private LightGrid lightGrid;

	@BeforeEach
	private void setUp() {
		lightGrid = new LightGrid();
	}
	
	@Test
	void testTurnOnAllLights() throws Exception {
		lightGrid.turnOn(CoordinatePair.of(0, 0, 999, 999));
		/*
		 * Nem �ll le az els� hib�n�l. Az �sses lellen�rz�st elv�gzi. 
		 * Igen lass�. Csak kis sz�m� l�p�shez aj�nlott.  
		 */
//		SoftAssertions assertions = new SoftAssertions();
//		for (int i=0; i<1000; i++) {
//			for (int j=0; j<1000; j++) {
//				assertions.assertThat(lightGrid.getLight(i, j).isOn()).as("i=%d; j=%d", i, j).isEqualTo(true);
//			}
//		}
		/*
		 * Az els� hib�sn�l �ll le az ellen�rz�si ciklus.
		 * Csak .as() haszn�lata eset�n tudhat� meg pontosan a hiba helye.
		 * Ha az �sszes hib�tlan elmegy a v�g�ig. 
		 * Elfogadhat� sebess�g�
		 */
		for (int i=0; i<1000; i++) {
			for (int j=0; j<1000; j++) {
				assertThat(lightGrid.getLight(i, j).isOn()).as("i=%d; j=%d", i, j).isEqualTo(true);
			}
		}
	}
	
	@Test
	void testToggleFirsLine() throws Exception {
		lightGrid.toggle(CoordinatePair.of(0, 0, 999, 0));
		for (int i=0; i<1000; i++) {
			for (int j=0; j<1000; j++) {
				if (i==0) {
					assertThat(lightGrid.getLight(i, j).isOn()).as("i=%d; j=%d", i, j).isEqualTo(true);
				} else {
					assertThat(lightGrid.getLight(i, j).isOn()).as("i=%d; j=%d", i, j).isEqualTo(false);
				}
			}
		}
	}
	
	@Test
	void testTurnOffFourLightsInTheMiddle() throws Exception {
		lightGrid.turnOn(CoordinatePair.of(0, 0, 999, 999));
		lightGrid.toggle(CoordinatePair.of(0, 0, 999, 0));
		CoordinatePair coordinatePair = CoordinatePair.of(499, 499, 500, 500);
		lightGrid.turnOff(coordinatePair);
		
		lightGrid.eachLight(coordinatePair, light -> assertThat(light.isOn()).isEqualTo(false));
		lightGrid.eachLight(CoordinatePair.of(0, 0, 498, 498), 
				light -> assertThat(light.isOn()).isEqualTo(true));
		lightGrid.eachLight(CoordinatePair.of(500, 0, 999, 498), 
				light -> assertThat(light.isOn()).isEqualTo(true));
		lightGrid.eachLight(CoordinatePair.of(0, 498, 498, 999), 
				light -> assertThat(light.isOn()).isEqualTo(true));
		lightGrid.eachLight(CoordinatePair.of(498, 501, 500, 999), 
				light -> assertThat(light.isOn()).isEqualTo(true));
		lightGrid.eachLight(CoordinatePair.of(499, 501, 500, 999), 
				light -> assertThat(light.isOn()).isEqualTo(true));
		lightGrid.eachLight(CoordinatePair.of(501, 499, 999, 999), 
				light -> assertThat(light.isOn()).isEqualTo(true));
	}

	/*
	 * A f�nyer�ss�g bevezet�ese miatt okafogyott� v�lt!
	 */
//	@Test
//	void testLightsOnAfterInstructions() throws Exception {
//		lightGrid.turnOn(CoordinatePair.of(0, 0, 999, 999));
//		lightGrid.toggle(CoordinatePair.of(0, 0, 999, 0));
//		lightGrid.turnOff(CoordinatePair.of(499, 499, 500, 500));
//		
//		AtomicInteger totalOnLights = new AtomicInteger();
//		lightGrid.eachLight(CoordinatePair.of(0, 0, 999, 999), 
//		light -> {
//			if (light.isOn()) {
//				totalOnLights.addAndGet(1);
//			}
//		});
//		assertThat(totalOnLights.get()).isEqualTo(998996);
//	}

	@Test
	void test1Brightness() throws Exception {
		lightGrid.turnOn(CoordinatePair.of(0, 0, 0, 0));
		AtomicInteger totalBrightness = new AtomicInteger();
		lightGrid.eachLight(CoordinatePair.of(0, 0, 999, 999), 
		light -> totalBrightness.addAndGet(light.getBrightness()));
		assertThat(totalBrightness.get()).isEqualTo(1);
	}
	
	@Test
	void test2000000Brightness() throws Exception {
		lightGrid.toggle(CoordinatePair.of(0, 0, 999, 999));
		AtomicInteger totalBrightness = new AtomicInteger();
		lightGrid.eachLight(CoordinatePair.of(0, 0, 999, 999), 
		light -> totalBrightness.addAndGet(light.getBrightness()));
		assertThat(totalBrightness.get()).isEqualTo(2000000);
	}
	
}
