package BKTDH_SS9_JAVA_ADVANCED;

class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double specialAttr) {
        if (type == 1) return new PhysicalProduct(id, name, price, specialAttr);
        if (type == 2) return new DigitalProduct(id, name, price, specialAttr);
        return null;
    }
}
