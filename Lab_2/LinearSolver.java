import java.util.Scanner;

public class LinearSolver {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

        //Dходные данные
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        

        if (a == 0) {
            if (b == 0) {
                //Решений бесконечно много
                System.out.println("INF");
            } else {
                // Если a == 0 и b != 0, решений нет
                System.out.println("NO");
            }
        } else {
            // Если a != 0, ищем целое решение
            if (b % a == 0) {
                System.out.println(-b / a);
            } else {
                System.out.println("NO");
            }
        }
    }
        }
}