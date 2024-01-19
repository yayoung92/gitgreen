package info;

public class User {
	public static int idx;
	public static String userId;
	public static String userPassword;
	
	public static int getIdx() {
		return idx;
	}
	public static void setIdx(int idx) {
		User.idx = idx;
	}
	public static String getUserId() {
		return userId;
	}
	public static void setUserId(String userId) {
		User.userId = userId;
	}
	public static String getUserPassword() {
		return userPassword;
	}
	public static void setUserPassword(String userPassword) {
		User.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
