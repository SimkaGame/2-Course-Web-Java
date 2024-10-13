import java.util.Scanner;

public class Lab1 {

    // Метод для вычисления площади треугольника по формуле Герона
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);

        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод координат для трёх точек
        System.out.println("Введите координаты первой точки:");
        Point3d p1 = createPoint(scanner);

        System.out.println("Введите координаты второй точки:");
        Point3d p2 = createPoint(scanner);

        System.out.println("Введите координаты третьей точки:");
        Point3d p3 = createPoint(scanner);

        // Проверка на равенство точек
        if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3)) {
            System.out.println("Некоторые точки совпадают. Невозможно вычислить площадь треугольника.");
        } else {
            // Вычисление и вывод площади треугольника
            double area = computeArea(p1, p2, p3);
            System.out.printf("Площадь треугольника: %.2f\n", area);
        }
    }

    // Вспомогательный метод для создания точки
    public static Point3d createPoint(Scanner scanner) {
        System.out.print("X: ");
        double x = scanner.nextDouble();
        System.out.print("Y: ");
        double y = scanner.nextDouble();
        System.out.print("Z: ");
        double z = scanner.nextDouble();
        return new Point3d(x, y, z);
    }
}
