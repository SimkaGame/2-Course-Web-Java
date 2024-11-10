public class Magazyn {
    private int numberOfCashRegisters;
    private Product[] products;
    private int numberOfSellers;

    public Magazyn() {
    }

    public Magazyn(int numberOfCashRegisters, Product[] products, int numberOfSellers) {
        this.numberOfCashRegisters = numberOfCashRegisters;
        this.products = products;
        this.numberOfSellers = numberOfSellers;
    }

    public double calculateCashRegisterEfficiency() {
        if (numberOfCashRegisters == 0) return 0;
        return (double) numberOfSellers / numberOfCashRegisters;
    }

    public double calculateAverageWeight() {
        if (products == null || products.length == 0) return 0;
        double totalWeight = 0;
        for (Product product : products) {
            totalWeight += product.getWeight();
        }
        return totalWeight / products.length;
    }

    public double calculateStoreEfficiency() {
        double averageWeight = calculateAverageWeight();
        double cashRegisterEfficiency = calculateCashRegisterEfficiency();
        return averageWeight * cashRegisterEfficiency;
    }

    public String toString() {
        return "Магазин{" +
                "Количество касс=" + numberOfCashRegisters +
                ", Количество продавцов=" + numberOfSellers +
                ", Эффективность магазинов=" + calculateStoreEfficiency() +
                '}';
    }

    public static class Product {
        private double weight;
        private double price;

        public Product() {
        }

        public Product(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}

class Supermarket extends Magazyn {
    private double area;
    private String[] productCategories;

    public Supermarket() {
        
    }

    public Supermarket(int numberOfCashRegisters, Product[] products, int numberOfSellers, double area, String[] productCategories) {
        super(numberOfCashRegisters, products, numberOfSellers);
        this.area = area;
        this.productCategories = productCategories;
    }

    public double calculateStoreEfficiency() {
        double cashRegisterEfficiency = calculateCashRegisterEfficiency();
        double categoryEfficiency = area / (productCategories == null ? 1 : productCategories.length);
        return categoryEfficiency * cashRegisterEfficiency;
    }

    public String toString() {
        return "Супермаркет{" +
                "Площадь = " + area +
                ", Категория продуктов = " + String.join(", ", productCategories) +
                ", Эффективность супермаркета = " + calculateStoreEfficiency() +
                '}';
    }
}
