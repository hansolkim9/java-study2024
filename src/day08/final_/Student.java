package day08.final_;

public class Student {

	String name;
	final String ssn;     // 주민등록번호
	static final String nation = "대한민국";  // 국적


	Student(final String ssn) {
		this.ssn = ssn;

		double pi = Math.PI;
	}

//    public void setSsn(String ssn) {
//        this.ssn = ssn;
//    }

}
