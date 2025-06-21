public class ProductLinearSearch {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if(p.productName.trim().equalsIgnoreCase(targetName)){
                return p;
            }
        }
        return null;

    }    

}
