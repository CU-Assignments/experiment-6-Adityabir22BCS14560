import java.util.*;
import java.util.stream.*;

class Product {
    String name, category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class hard {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.99),
            new Product("Smartphone", "Electronics", 899.50),
            new Product("Tablet", "Electronics", 499.99),
            new Product("Headphones", "Accessories", 150.75),
            new Product("Backpack", "Accessories", 80.25),
            new Product("Coffee Machine", "Home Appliances", 250.00),
            new Product("Vacuum Cleaner", "Home Appliances", 300.99),
            new Product("Refrigerator", "Home Appliances", 1200.00),
            new Product("Blender", "Home Appliances", 99.99)
        );

        // Group products by category
        var groupedByCategory = products.stream().collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products by Category:\n" + groupedByCategory + "\n");

        // Find most expensive product per category
        var mostExpensive = products.stream()
            .collect(Collectors.groupingBy(p -> p.category, 
                    Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(p -> p.price)), Optional::get)));
        System.out.println("Most Expensive Product per Category:\n" + mostExpensive + "\n");

        // Compute average price
        double avgPrice = products.stream().mapToDouble(p -> p.price).average().orElse(0.0);
        System.out.println("Average Price: $" + String.format("%.2f", avgPrice));
    }
}
