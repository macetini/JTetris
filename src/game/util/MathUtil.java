package game.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for mathematical operations used in the Tetris game.
 */
public class MathUtil {

	/** Random number generator instance. */
	private static final Random rand = new Random();

	/**
	 * Private constructor to prevent instantiation.
	 */
	private MathUtil() {
	}

	/**
	 * Returns a random integer between 0 (inclusive) and the specified bound
	 * (exclusive).
	 *
	 * @param bound the upper bound (exclusive). Must be positive.
	 * @return a random integer between 0 (inclusive) and bound (exclusive)
	 */
	public static int getRand(int bound) {
		return ThreadLocalRandom.current().nextInt(bound);
	}
}