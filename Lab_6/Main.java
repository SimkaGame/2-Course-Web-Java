public class Main {
    public static void main(String[] args) {
        Magazyn.Product[] products = {
            new Magazyn.Product(1.5, 100),
            new Magazyn.Product(2.0, 150),
            new Magazyn.Product(1.7,400)
        };

        Magazyn store = new Magazyn(19, products, 4);
        System.out.println(store);

        String[] categories = {"Фрукты", "Овощи", "Молочные продукты"};
        Supermarket supermarket = new Supermarket(5, products, 10, 200.0, categories);
        System.out.println(supermarket);
    }
}