import java.util.ArrayList;
import java.util.Random;

class Product {
    String name;
    double price;
    double weight;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Продукт{Название = '%s', Цена = %.2f, Вес = %.2f kg}", name, price, weight);
    }
}

public class ProductManager {
    public static void main(String[] args) {
        // 1. Инициализация данных
        ArrayList<Product> products = generateRandomProducts(15);

        System.out.println("Изначальные продукты:");
        products.forEach(System.out::println);

        // 2. Удаление продуктов с весом > 5 кг или стоимостью > 10 000
        products.removeIf(product -> product.weight > 5 || product.price > 10000);

        // 3. Добавление любимого продукта на первое место
        Product favoriteProduct = new Product("Bueno", 9.99, 0.5);
        products.add(0, favoriteProduct);

        // 4. Вывод продуктов с ценой < 10 и весом > 2
        System.out.println("\nПродукты с ценой < 10 and weight > 2:");
        products.stream()
                .filter(product -> product.price < 10 && product.weight > 2)
                .forEach(System.out::println);

        // Итоговый список продуктов
        System.out.println("\nФинальый список продуктов:");
        products.forEach(System.out::println);
    }

    // Метод для генерации случайных продуктов
    private static ArrayList<Product> generateRandomProducts(int count) {
        String[] names = {"Milk", "Bread", "Butter", "Cheese", "Apple", "Banana", "Orange", "Juice", "Meat", "Fish"};
        Random random = new Random();
        ArrayList<Product> products = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)];
            double price = 1 + random.nextDouble() * 20000;
            double weight = 0.1 + random.nextDouble() * 10;

            Product newProduct = new Product(name, price, weight);

            // Проверка на дублирование
            if (!products.contains(newProduct)) {
                products.add(newProduct);
            }
        }

        return products;
    }
}
