package fileio;

public class Student {
//@Override
	/*public String toString() {
		return "Student [studentid=" + studentid + ", studentName=" + studentName + ", marks=" + marks + "]";
	}*/
private int studentid;
private String studentName;
private int marks;
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public void display() {
	// TODO Auto-generated method stub
	System.out.println("student id is "+studentid+"\t"+"student name is "+studentName+"\t"+"marks is "+marks);
}
}

