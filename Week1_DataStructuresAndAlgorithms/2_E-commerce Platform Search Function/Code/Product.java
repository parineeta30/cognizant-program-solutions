public class Product{

        String productID;
        String productName;
        String category;

       public Product(String productID, String productName,String category){
        this.productID = productID;
        this.productName = productName;
        this.category = category;

       }

       public void displayProduct() {
        System.out.println("[" + productID + "] " + productName + " - " + category);
    }

    }
