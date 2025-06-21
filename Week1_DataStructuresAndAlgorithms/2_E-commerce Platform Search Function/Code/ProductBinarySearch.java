public class ProductBinarySearch {

    public static Product binarySearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (products[i].productName.compareToIgnoreCase(products[j].productName) > 0) {
                    // Swap
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }

        // Binary search
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(targetName);

            if (compare == 0) {
                return products[mid]; 
            } else if (compare < 0) {
                low = mid + 1; // Right half
            } else {
                high = mid - 1; // Left half
            }
        }

        return null;
    }
}

