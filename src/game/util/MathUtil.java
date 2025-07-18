package game.util;

import java.util.Random;

public class MathUtil {
	
	private static final Random rand = new Random();

	private MathUtil() {}
	
	public static int getRand(int bound) {
		return rand.nextInt(bound);
	}
}
