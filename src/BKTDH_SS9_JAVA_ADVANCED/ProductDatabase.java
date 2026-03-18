package BKTDH_SS9_JAVA_ADVANCED;

import java.util.ArrayList;
import java.util.List;


class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) instance = new ProductDatabase();
        return instance;
    }

    public void addProduct(Product p) { products.add(p); }

    public List<Product> getAllProducts() { return products; }

    public Product findById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean deleteProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}


