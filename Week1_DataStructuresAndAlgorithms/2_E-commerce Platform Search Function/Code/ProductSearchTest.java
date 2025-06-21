import java.util.Scanner;

public class ProductSearchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample product list
        Product[] products = {
            new Product("101", "Maggie Noodles", "Instant Food"),
            new Product("102", "Shirt", "Clothing"),
            new Product("103", "Lays Chips", "Snacks"),
            new Product("104", "Laptop", "Electronics"),
            new Product("105", "Watch", "Accessories")
        };

        // Ask user for product name
        System.out.print("Enter the product name to search: ");
        String targetName = sc.nextLine().trim();

        // Ask for search type
        System.out.print("Choose search type: (1 for Linear, 2 for Binary): ");
        int choice = sc.nextInt();

        Product result = null;

        if (choice == 1) {
            System.out.println(" Linear Search : ");
            result = ProductLinearSearch.linearSearch(products, targetName);
        } else if (choice == 2) {
            System.out.println(" Binary Search : ");
            result = ProductBinarySearch.binarySearch(products, targetName);
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        // Show result
        if (result != null) {
            System.out.println("Product found:");
            result.displayProduct();
        } else {
            System.out.println("Product not found.");
        }

        sc.close();
    }
}
