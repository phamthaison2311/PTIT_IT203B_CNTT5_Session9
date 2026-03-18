package BKTDH_SS9_JAVA_ADVANCED;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        int choice = 0;
        do {
            displayMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addProduct(sc, db);
                    break;
                case 2:
                    displayProduct(db);
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String update = sc.nextLine();
                    Product p = db.findById(update);
                    if (p != null) {
                        System.out.printf("Nhập tên mới (hiện tại: %s): ", p.getName());
                        p.setName(sc.nextLine());
                        System.out.printf("Nhập giá mới (hiện tại: %.2f): ",  p.getPrice());
                        p.setPrice(sc.nextDouble());
                        System.out.printf("");
                    }
                case 4:
                case 5:
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }while (choice != 5);
    }

    // case 2: Hiển thị danh sách sản phẩm
    private static void displayProduct(ProductDatabase db) {
        System.out.println("\n----- Danh sách sản phẩm -----");
        db.getAllProducts().forEach(Product ::displayInfo);
    }
    // case 1: Thêm sản phẩm
    private static void addProduct(Scanner sc, ProductDatabase db) {
        System.out.print("Loại (1: Physical, 2: Digital): ");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print(type == 1 ? "Trọng lượng: " : "Dung lượng (MB): ");
        double attr = Double.parseDouble(sc.nextLine());

        Product p = ProductFactory.createProduct(type, id, name, price, attr);
        if (p != null) db.addProduct(p);
    }

    // Hiển thị menu
    public static void displayMenu() {
        System.out.println("\n---------------------- QUẢN LÝ SẢN PHẨM ----------------------");
        System.out.println("1. Thêm mới sản phẩm");
        System.out.println("2. Xem danh sách sản phẩm");
        System.out.println("3. Cập nhật thông tin sản phẩm");
        System.out.println("4. Xoá sản phẩm");
        System.out.println("5. Thoát");
        System.out.println("--------------------------------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
}


