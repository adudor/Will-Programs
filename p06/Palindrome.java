
public class Palindrome {

	public static String mirrorA(char start) throws IllegalArgumentException {
		if (start < 65 || start > 90) {
			throw new IllegalArgumentException("The input must be a capital char!");
		}
		String returnString = "" + start;
		if (start > 'A') {
			return returnString + " " + mirrorA((char) (start - 1)) + " " + returnString;
		} else {
			return "A";
		}
	}

	public static String mirrorA(char start, int step) throws IllegalArgumentException {
		if ((start < 65 || start > 90) && step > 0) {
			throw new IllegalArgumentException("The input must be a capital char!");
		}
		String returnString = "" + start;
		if (start > 'A') {
			if (start - step >= 'A') {
				return returnString + " " + mirrorA((char) (start - step), step) + " " + returnString;
			}
		}
		if (start == 'A') {
			return "A";
		} else {
			return returnString + " " + returnString;
		}

	}

	public static String mirrorZ(char start) throws IllegalArgumentException {
		if (start < 65 || start > 90) {
			throw new IllegalArgumentException("The input must be a capital char!");
		}
		String returnString = "" + start;
		if (start < 'Z') {
			return returnString + " " + mirrorZ((char) (start + 1)) + " " + returnString;
		} else {
			return "Z";
		}
	}

	public static String mirrorZ(char start, int step) throws IllegalArgumentException {
		if ((start < 65 || start > 90) && step > 0) {
			throw new IllegalArgumentException("The input must be a capital char!");
		}
		String returnString = "" + start;
		if (start < 'Z') {
			if (start + step <= 'Z') {
				return returnString + " " + mirrorZ((char) (start + step), step) + " " + returnString;
			}
		}
		if (start == 'Z') {
			return "Z";
		} else {
			return returnString + " " + returnString;
		}

	}

}
