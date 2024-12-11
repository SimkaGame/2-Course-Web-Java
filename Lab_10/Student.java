public class Student {
    private String fullName;
    private int age;
    private double averageGrade;
    private double scholarship;
    private int attendedClasses;
    private int missedClasses;

    public Student(String fullName, int age, double averageGrade, double scholarship, int attendedClasses, int missedClasses) {
        this.fullName = fullName;
        this.age = age;
        this.averageGrade = averageGrade;
        this.scholarship = scholarship;
        this.attendedClasses = attendedClasses;
        this.missedClasses = missedClasses;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public double getScholarship() {
        return scholarship;
    }

    public int getAge() {
        return age;
    }

    public double getAttendancePercentage() {
        int totalClasses = attendedClasses + missedClasses;
        return totalClasses == 0 ? 0 : (attendedClasses * 100.0) / totalClasses;
    }

    @Override
    public String toString() {
        return String.format("%s | Age: %d | Grade: %.2f | Scholarship: %.2f | Attendance: %.2f%%",
                fullName, age, averageGrade, scholarship, getAttendancePercentage());
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    public void incrementAttended() {
        attendedClasses++;
    }

    public void incrementMissed() {
        missedClasses++;
    }

    public String getFullName() {
        return fullName;
    }
}
