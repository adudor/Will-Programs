
public class Palindrome {
	
	public static​ String mirrorA(​char​ start) throws IllegalArgumentException {
		if (start < 65 || start > 90) {
			throw new IllegalArgumentException("The input must be a capital char!");
		}
		if (start == 'A') {
			return "A";
		}
		return start + " " + mirrorA((char)(start-1)) + " " + start;
	}
	
	public static​ String mirrorA(​char​ start, ​int​ step) throwsIllegalArgumentException {
		
	}
	
	public static ​String mirrorZ(​char​ start) throws IllegalArgumentException {
		
	}
	
	public static ​String mirrorZ(​char​ start, ​int​ step) throwsIllegalArgumentException {
		
	}

}

