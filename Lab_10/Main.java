import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        try {
            while (true) {
                System.out.println("\nМеню:");
                System.out.println("1. Добавить студента");
                System.out.println("2. Удалить студента");
                System.out.println("3. Обновить оценку");
                System.out.println("4. Обновить стипендию");
                System.out.println("5. Отметить посещение");
                System.out.println("6. Показать студентов");
                System.out.println("7. Выйти");
                System.out.print("Выберите опцию: ");

                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1 -> addStudent(scanner, students);
                        case 2 -> removeStudent(scanner, students);
                        case 3 -> updateGrade(scanner, students);
                        case 4 -> updateScholarship(scanner, students);
                        case 5 -> markAttendance(scanner, students);
                        case 6 -> showStudents(scanner, students);
                        case 7 -> {
                            System.out.println("Завершение программы.");
                            System.exit(0);
                        }
                        default -> System.out.println("Неверный выбор. Попробуйте снова.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверный ввод. Пожалуйста, введите число.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void addStudent(Scanner scanner, List<Student> students) {
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите отчество: ");
        String middleName = scanner.nextLine();

        if (lastName.equalsIgnoreCase("Белоусов") && firstName.equalsIgnoreCase("Алексей") && middleName.equalsIgnoreCase("Юрьевич")) {
            throw new IllegalArgumentException("Нельзя добавить студента с ФИО 'Белоусов Алексей Юрьевич'.");
        }

        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите средний балл: ");
        double averageGrade = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите стипендию: ");
        double scholarship = Double.parseDouble(scanner.nextLine());
        System.out.print("Введите количество посещенных занятий: ");
        int attendedClasses = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите количество пропущенных занятий: ");
        int missedClasses = Integer.parseInt(scanner.nextLine());

        String fullName = lastName + " " + firstName + " " + middleName;
        students.add(new Student(fullName, age, averageGrade, scholarship, attendedClasses, missedClasses));
    }

    private static void removeStudent(Scanner scanner, List<Student> students) {
        System.out.print("Введите полное имя студента для удаления: ");
        String fullName = scanner.nextLine();
        students.removeIf(student -> student.getFullName().equalsIgnoreCase(fullName));
    }

    private static void updateGrade(Scanner scanner, List<Student> students) {
        System.out.print("Введите полное имя студента: ");
        String fullName = scanner.nextLine();
        System.out.print("Введите новый средний балл: ");
        double newGrade = Double.parseDouble(scanner.nextLine());

        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                student.setAverageGrade(newGrade);
                break;
            }
        }
    }

    private static void updateScholarship(Scanner scanner, List<Student> students) {
        System.out.print("Введите полное имя студента: ");
        String fullName = scanner.nextLine();
        System.out.print("Введите новую сумму стипендии: ");
        double newScholarship = Double.parseDouble(scanner.nextLine());

        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                student.setScholarship(newScholarship);
                break;
            }
        }
    }

    private static void markAttendance(Scanner scanner, List<Student> students) {
        System.out.print("Введите полное имя студента: ");
        String fullName = scanner.nextLine();
        System.out.print("Занятие посещено (Да/Нет): ");
        String attended = scanner.nextLine().toLowerCase();

        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                if (attended.equals("да")) {
                    student.incrementAttended();
                } else if (attended.equals("нет")) {
                    student.incrementMissed();
                }
                break;
            }
        }
    }
    private static void showStudents(Scanner scanner, List<Student> students) {
        if (students.isEmpty()) {
            System.out.println();
        }
        System.out.println("No students available.");
        System.out.println("\nSorting options:");
        System.out.println("1. By average grade");
        System.out.println("2. By scholarship");
        System.out.println("3. By age");
        System.out.println("4. By attendance percentage");
        System.out.println("5. In original order");
        System.out.print("Choose sorting option: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            List<Student> sortedStudents = new ArrayList<>(students);

            switch (choice) {
                case 1 -> sortedStudents.sort(Comparator.comparingDouble(s -> -s.getAverageGrade()));
                case 2 -> sortedStudents.sort(Comparator.comparingDouble(s -> -s.getScholarship()));
                case 3 -> sortedStudents.sort(Comparator.comparingInt(Student::getAge));
                case 4 -> sortedStudents.sort(Comparator.comparingDouble(s -> -s.getAttendancePercentage()));
                case 5 -> {} // No sorting needed.
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            sortedStudents.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void Sshowtudents(Scanner scanner, List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Студенты отсутствуют.");
            return;
        }

        System.out.println("\nВарианты сортировки:");
        System.out.println("1. По среднему баллу");
        System.out.println("2. По стипендии");
        System.out.println("3. По возрасту");
        System.out.println("4. По проценту посещаемости");
        System.out.println("5. В исходном порядке");
        System.out.print("Выберите вариант сортировки: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            List<Student> sortedStudents = new ArrayList<>(students);

            switch (choice) {
                case 1 -> sortedStudents.sort(Comparator.comparingDouble(s -> -s.getAverageGrade()));
                case 2 -> sortedStudents.sort(Comparator.comparingDouble(s -> -s.getScholarship()));
                case 3 -> sortedStudents.sort(Comparator.comparingInt(Student::getAge));
                case 4 -> sortedStudents.sort(Comparator.comparingDouble(s -> -s.getAttendancePercentage()));
                case 5 -> {} // Сортировка не требуется.
                default -> {
                    System.out.println("Неверный выбор.");
                    return;
                }
            }

            sortedStudents.forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод. Пожалуйста, введите число.");
        }
    }
}