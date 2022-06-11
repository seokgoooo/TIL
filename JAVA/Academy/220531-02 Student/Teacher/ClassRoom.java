public class ClassRoom {
	private Student[] students;

	public ClassRoom() {
	}

	public ClassRoom(Student... students) {
		this.students = students;
	}

	public void printNames() {
		for (int i = 0; i < students.length; i++) {
			System.out.println((i + 1) + "번 학생 : " + students[i].getName());
		}
	}

	public int getTotalAvg() {
		int sum = 0;
		for (int i = 0; i < students.length; i++) {
			sum += students[i].getAverage();
		}
		return sum / students.length;
	}

	public Student getTop() {
		Student top = students[0];
		for (int i = 1; i < students.length; i++) {
			top = max(top, students[i]);
		}
		return top;
//		if (stu1.compare(stu2) && stu1.compare(stu3)) {
//			return stu1;
//		} else if (stu2.compare(stu1) && stu2.compare(stu3)) {
//			return stu2;
//		}
	}

	public Student max(Student left, Student right) {
		if (left.getAverage() >= right.getAverage()) {
			return left;
		} else {
			return right;
		}
	}

	public Student getStudent(int index) {
		return students[index];
	}
}
