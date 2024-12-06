public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private String gender;
    private int course;
    private double averageMark;

    public Student(String name, String surname, String patronymic, int age, String gender, int course, double averageMark) throws NotCorrectAgeException {
        if (age < 16 || age > 60) {
            throw new NotCorrectAgeException("Возраст студента должен быть в диапазоне от 16 до 60 лет.");
        }
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, Возраст: %d, Пол: %s, Курс: %d, Средний балл: %.2f",
                name, surname, patronymic, age, gender, course, averageMark);
    }
}
