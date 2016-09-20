public class Student {
	private int studentID;
	private static int numStudents = 0;

	public Student() {
		this.studentID = numStudents++;

	}

	public int getID() {
		return this.studentID;
	}

}
