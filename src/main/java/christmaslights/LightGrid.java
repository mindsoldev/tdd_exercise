package christmaslights;

import java.util.function.Consumer;

public class LightGrid {

	private Light[][] lights = new Light[1000][1000];

	public Light getLight(int row, int col) {
		Light light = lights[row][col];
		if (light == null) {
			light = new Light();
			lights[row][col] = light;
		}
		return light;
	}
	
	public void turnOn(CoordinatePair coordinatePair) {
		eachLight(coordinatePair, Light::turnOn);
	}

	public void toggle(CoordinatePair coordinatePair) {
		eachLight(coordinatePair, Light::toggle);
	}

	public void turnOff(CoordinatePair coordinatePair) {
		eachLight(coordinatePair, Light::turnOff);
	}
	
	public void eachLight(CoordinatePair coordinatePair, Consumer<Light> consumer) {
		for (int col=coordinatePair.getLeftTopX(); col<=coordinatePair.getRightBottomX(); col++) {
			for (int row=coordinatePair.getLeftTopY(); row<=coordinatePair.getRightBottomY(); row++) {
				consumer.accept(getLight(row, col));
			}			
		}
	}


}
