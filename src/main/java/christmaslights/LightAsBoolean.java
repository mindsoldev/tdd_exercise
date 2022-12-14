package christmaslights;

public class LightAsBoolean {
	
	private boolean on;

	public boolean isOn() {
		return on;
	}
	
	public void turnOn() {
		on = true;
	}

	public void turnOff() {
		on = false;
	}
	
	public void toggle() {
		if (isOn()) {
			turnOff();
		} else {
			turnOn();
		}
	}

}
