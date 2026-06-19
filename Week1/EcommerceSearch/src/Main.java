import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (array sorted by productName)
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) return products[mid];
            else if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Mobile", "Electronics"),
            new Product(4, "Watch", "Accessories"),
            new Product(5, "Bag", "Fashion")
        };

        // Linear Search
        System.out.println("=== Linear Search ===");
        Product result1 = linearSearch(products, "Mobile");
        if (result1 != null)
            System.out.println("Found: " + result1.productName + " | Category: " + result1.category);
        else
            System.out.println("Product not found");

        // Sort array for Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        // Binary Search
        System.out.println("\n=== Binary Search ===");
        Product result2 = binarySearch(products, "Mobile");
        if (result2 != null)
            System.out.println("Found: " + result2.productName + " | Category: " + result2.category);
        else
            System.out.println("Product not found");

        // Time Complexity Analysis
        System.out.println("\n=== Time Complexity ===");
        System.out.println("Linear Search: O(n) - checks every element");
        System.out.println("Binary Search: O(log n) - eliminates half each time");
        System.out.println("Binary Search is better for large sorted datasets");
    }
}