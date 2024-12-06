import java.util.ArrayList;

public class Group {
    private ArrayList<Student> students;
    private final int maxSize = 15;

    public Group() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        try {
            if (students.size() >= maxSize) {
                throw new Exception("Группа переполнена! Невозможно добавить нового студента.");
            }
            students.add(student);
            System.out.println("Студент успешно добавлен: " + student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStudent(String name, String surname, String patronymic, int age, String gender, int course, double averageMark) {
        try {
            Student student = new Student(name, surname, patronymic, age, gender, course, averageMark);
            addStudent(student);
        } catch (NotCorrectAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void removeStudent(int index) {
        try {
            if (students.size() <= 3) {
                throw new Exception("Нельзя удалять студентов, если их остается меньше 3.");
            }
            if (index < 0 || index >= students.size()) {
                throw new Exception("Неверный индекс студента.");
            }
            Student removedStudent = students.remove(index);
            System.out.println("Студент удален: " + removedStudent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getStudent(int index) {
        try {
            if (index < 0 || index >= students.size()) {
                throw new Exception("Неверный индекс студента.");
            }
            System.out.println("Информация о студенте: " + students.get(index));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("В группе пока нет студентов.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }
        }
    }

    public void fillGroupRandomly() {
        try {
            for (int i = students.size(); i < maxSize; i++) {
                addStudent(
                        "Имя" + i,
                        "Фамилия" + i,
                        "Отчество" + i,
                        16 + (int) (Math.random() * 45),
                        i % 2 == 0 ? "Муж" : "Жен",
                        1 + (int) (Math.random() * 5),
                        3.0 + Math.random() * 2.0
                );
            }
            System.out.println("Группа заполнена случайными студентами.");
        } catch (Exception e) {
            System.out.println("Ошибка при заполнении группы: " + e.getMessage());
        }
    }

    public boolean isFull() {
        return students.size() >= maxSize;
    }
}
