
public class PalindromeTester {
	public static boolean testMirrorA() {
		{
			try {
				if (!Palindrome.mirrorA('E').equals("E D C B A B C D E")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}

		}

		{
			try {
				if (Palindrome.mirrorA('&').equals("E D C B A B C D E")) {
					return false;
				}
				return false;
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}

		{
			try {
				if (Palindrome.mirrorA('a').equals("E D C B A B C D E")) {
					return false;
				}
				return false;
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean testMirrorAStep() {
		{
			try {
				if (!Palindrome.mirrorA('E', 2).equals("E C A C E")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}

		{
			try {
				if (Palindrome.mirrorA('&', 2).equals("E C A C E")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}

		{
			try {
				if (Palindrome.mirrorA('a', 2).equals("E C A C E")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
				}
			}
		}

		return true;
	}

	public static boolean testMirrorZ() {
		{
			try {
				if (!Palindrome.mirrorZ('V').equals("V W X Y Z Y X W V")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}

		{
			try {
				if (Palindrome.mirrorZ('&').equals("V W X Y Z Y X W V")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}

		{
			try {
				if (Palindrome.mirrorZ('a').equals("V W X Y Z Y X W V")) {
					return false;
				}
				return false;
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean testMirrorZStep() {
		{
			try {
				if (!Palindrome.mirrorZ('V', 2).equals("V X Z X V")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}

		{
			try {
				if (Palindrome.mirrorZ('&', 2).equals("V X Z X V")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
					return false;
				}
			}
		}

		{
			try {
				if (Palindrome.mirrorZ('a', 2).equals("V X Z X V")) {
					return false;
				}
			} catch (IllegalArgumentException e) {
				if (!e.getMessage().equals("The input must be a capital char!")) {
				}
			}
		}
		return true;
	}
	
	public static boolean runAllTests() {
		System.out.println("testMirrorA(): " + testMirrorA());
		System.out.println("testMirrorAStep(): " + testMirrorAStep());
		System.out.println("testMirrorZ(): " + testMirrorZ());
		System.out.println("testMirrorZStep(): " +testMirrorZStep());
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(runAllTests());

	}

}
