import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить студента вручную");
            System.out.println("2. Удалить студента");
            System.out.println("3. Посмотреть студента по номеру");
            System.out.println("4. Список студентов");
            System.out.println("5. Заполнить группу случайно");
            System.out.println("6. Выход");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (group.isFull()) {
                        System.out.println("Группа уже заполнена. Добавление невозможно.");
                        break;
                    }
                    System.out.print("Введите имя: ");
                    String name = scanner.next();
                    System.out.print("Введите фамилию: ");
                    String surname = scanner.next();
                    System.out.print("Введите отчество: ");
                    String patronymic = scanner.next();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    System.out.print("Введите пол (Муж/Жен): ");
                    String gender = scanner.next();
                    System.out.print("Введите курс: ");
                    int course = scanner.nextInt();
                    System.out.print("Введите средний балл: ");
                    double averageMark = scanner.nextDouble();

                    group.addStudent(name, surname, patronymic, age, gender, course, averageMark);
                    break;

                case 2:
                    System.out.print("Введите номер студента для удаления: ");
                    int removeIndex = scanner.nextInt() - 1;
                    group.removeStudent(removeIndex);
                    break;

                case 3:
                    System.out.print("Введите номер студента: ");
                    int index = scanner.nextInt() - 1;
                    group.getStudent(index);
                    break;

                case 4:
                    group.listStudents();
                    break;

                case 5:
                    group.fillGroupRandomly();
                    break;

                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
            }
        }
    }
}
