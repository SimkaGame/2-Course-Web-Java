import java.util.Scanner;

public class IceCream {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество шариков: ");
            int k = scanner.nextInt();
            if (canBuy(k)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean canBuy(int k) {
        if(k == 3 || k == 5 || k == 8){
            return true;
        }
        else{
            return false;
        }
    }
}
