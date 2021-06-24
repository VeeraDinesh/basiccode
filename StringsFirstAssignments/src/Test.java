
public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		String email="my.email@gmail.com";
		t.maskEmailAddress(email);
	}
	
	public static String maskEmailAddress(final String email) {
	    final String mask = "*****";
	    final int at = email.indexOf("@");
	    if (at > 2) {
	        final int maskLen = Math.min(Math.max(at / 2, 2), 4);
	        final int start = (at - maskLen) / 2;
	        return email.substring(0, start) + mask.substring(0, maskLen) + email.substring(start + maskLen);
	    }
	    return email;
	}

}
