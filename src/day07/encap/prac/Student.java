package day07.encap.prac;

public class Student {

//    **학생 정보 시스템**
//    - 학생의 이름(name), 학번(studentId), 학과(department) 정보를 관리하는 `Student` 클래스를 만드세요.
//    - 모든 정보 필드는 private으로 선언하고, 각 필드의 getter와 setter 메소드를 public으로 만드세요.
//    - setter 메소드에서는 유효하지 않은 입력(예: null 값 또는 빈 문자열)에 대한 검증 로직을 포함하세요.

    private String name;
    private String studentId;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty() || name == null) {
            System.out.println("유효하지 않은 이름 입니다.");
        } else {
            this.name = name;
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String sutdentId) {
        if(sutdentId.isEmpty() || sutdentId == null) {
            System.out.println("유효하지 않은 학번 입니다.");
        } else {
            this.studentId = sutdentId;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department.isEmpty() || department == null) {
            System.out.println("유효하지 않은 학과 입니다.");
        } else {
            this.department = department;
        }
    }
}
