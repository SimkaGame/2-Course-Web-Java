import java.util.Scanner;

public class MetroTickets {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество запланированных поездок: ");
            int p = scanner.nextInt();

            int[] result = minCostTickets(p);

            System.out.println("Необходимое количество билетов на 1, 5, 10, 20, 60 поездок:");
            System.out.println("1 поездка: " + result[4]);
            System.out.println("5 поездок: " + result[3]);
            System.out.println("10 поездок: " + result[2]);
            System.out.println("20 поездок: " + result[1]);
            System.out.println("60 поездок: " + result[0]);
        }
    }

    public static int[] minCostTickets(int p) {
        int[] ticketOptions = {60, 20, 10, 5, 1};
        int[] tickets = new int[5];

        for (int i = 0; i < ticketOptions.length; i++) {
            tickets[i] = p / ticketOptions[i]; // Количество билетов текущего типа
            p %= ticketOptions[i]; // Оставшиеся поездки после использования текущего типа билетов
        }

        return tickets;
    }
}
