package info;

public class Person {
	public static String personName;
	public static String phoneNumber;
	public static String date;
	public static int age;
	public static String MBTI;
	public static String address;
	public static String gender;
	public static String star;
	
	public static String getPersonName() {
		return personName;
	}
	public static void setPersonName(String personName) {
		Person.personName = personName;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public static void setPhoneNumber(String phoneNumber) {
		Person.phoneNumber = phoneNumber;
	}
	public static String getDate() {
		return date;
	}
	public static void setDate(String date) {
		Person.date = date;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Person.age = age;
	}
	public static String getMBTI() {
		return MBTI;
	}
	public static void setMBTI(String mBTI) {
		MBTI = mBTI;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		Person.address = address;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		Person.gender = gender;
	}
	public static String getStar() {
		return star;
	}
	public static void setStar(String star) {
		Person.star = star;
	}
	@Override
	public String toString() {
		return "[이름 = " + getPersonName() + ", 전화번호 = " + getPhoneNumber() + ", 나이 = " + getAge() + ", 생일 = " + getDate() + ", MBTI = " + getMBTI() + ", 성별 = " + getGender() + ", 별명 = " + getStar()
				+ "]";
	}
}
