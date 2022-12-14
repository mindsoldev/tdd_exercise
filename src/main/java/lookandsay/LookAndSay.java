/**
 * 
 */
package lookandsay;

/**
 * @author phars
 *
 */
public class LookAndSay {

	public String say(String look) {
		StringBuilder say = new StringBuilder();
		if (look == null || look.isBlank()) {
			say.append("");
		}
		else {
			int startPos = 0;
			int changePos;
			do {
				changePos = determineChangePos(look, startPos);
				say.append(changePos-startPos);
				say.append(look.charAt(startPos));
				startPos = changePos;
			} while(changePos<=look.length()-1) ;
		}
		return say.toString();
	}
	
	private int determineChangePos(String look, int startPos) {
		char examinedChar = look.charAt(startPos);
		int changePos = startPos;
		for (; changePos < look.length() && examinedChar == look.charAt(changePos); changePos++);
		return changePos;
	}
	
	public static void main(String[] args) {
		LookAndSay lookAndSay = new LookAndSay();
		String say = "1";
		System.out.println(say);
		for (int i=0; i<9; i++) {
			say = lookAndSay.say(say);
			System.out.println(say);
		}
		
	}

}
