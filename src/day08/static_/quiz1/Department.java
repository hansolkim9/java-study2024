package day08.static_.quiz1;

public class Department {

    private String departmentName;
    private int studentCount;
    private static int totalStudents;

    Department(String departmentName, int studentCount) {
        this.departmentName = departmentName;
        this.studentCount = studentCount;
        totalStudents += studentCount;
    }

    void addStudent(int number) {
        this.studentCount += number;
        totalStudents += number;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}
