/**
 * <p>File: DecimalFloating.java</p>
 * <p>Title: Numerical methods</p>
 * <p>Description: Course on numerical analysis</p>
 * <p>Date: July 2009</p>
 * @author Faton M. Berisha
 * @version 5.0.0
 */

package numerike_II;

import java.math.*;

/**
 * Provides decimal floating point arithmetics
 * 		with an arbitrary number of significant digits.
 */
public class DecimalFloating {
	
	private static int numDigits = 16;  // Number of significant digits.
	private static RoundingMode rounding = RoundingMode.HALF_UP;  // Rounding mode.

	/**
	 * "Chopping" rounding mode.
	 */
	public static final RoundingMode CHOPPING = RoundingMode.DOWN;
	
	/**
	 * "Usual" rounding mode.
	 */
	public static final RoundingMode ROUNDING = RoundingMode.HALF_UP;
	
	/**
	 * Rounds a <code>double</code> to the number of significant digits.
	 * @param val <code>double</code> value to be rounded
	 * @return <code>double</code> value rounded to the number of significant digits
	 */
	public static double fl(double val) {
		BigDecimal bigDec = new BigDecimal(val);
		MathContext context = new MathContext(numDigits, rounding);
		bigDec = bigDec.round(context);
		return bigDec.doubleValue();
	}

	/**
	 * Gets the number of significant digits.
	 * @return number of significant digits
	 */
	public int getNumDigits() {
		return numDigits;
	}

	/**
	 * Sets the number of significant digits.
	 * @param numDigits number of significant digits
	 */
	public  void setNumDigits(int numDigits) {
		this.numDigits = numDigits;
	}

	/**
	 * Gets the rounding mode.
	 * @return rounding mode
	 */
	public RoundingMode getRounding() {
		return rounding;
	}

	/**
	 * Sets the rounding mode.
	 * @param numDigits rounding mode
	 */
	public void setRounding(RoundingMode rounding) {
		this.rounding = rounding;
	}

}
