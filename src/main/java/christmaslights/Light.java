package christmaslights;

public class Light {
	
	private int brightness;

	public void toggle() {
		brightness = Math.min(Integer.MAX_VALUE, brightness+2);
	}

	public boolean isOn() {
		return brightness > 0;
	}
	
	public void turnOff() {
		brightness = Math.max(0, brightness-1);
	}
	
	public void turnOn() {
		brightness = Math.min(Integer.MAX_VALUE, brightness+1);
	}
	
	public int getBrightness() {
		return brightness;
	}

}
