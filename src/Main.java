//import BKTDH_SS9_JAVA_ADVANCED.*;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ProductDatabase db = ProductDatabase.getInstance();
//
//        while (true) {
//            System.out.println("\n📝 ---------------------- QUẢN LÝ SẢN PHẨM ----------------------");
//            System.out.println("1. Thêm mới sản phẩm");
//            System.out.println("2. Xem danh sách sản phẩm");
//            System.out.println("3. Cập nhật thông tin sản phẩm");
//            System.out.println("4. Xoá sản phẩm");
//            System.out.println("5. Thoát");
//            System.out.print("Lựa chọn của bạn: ");
//
//            int choice = sc.nextInt();
//            sc.nextLine(); // Clear buffer
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Loại (1: Physical, 2: Digital): ");
//                    int type = sc.nextInt(); sc.nextLine();
//                    System.out.print("ID: "); String id = sc.nextLine();
//                    System.out.print("Tên: "); String name = sc.nextLine();
//                    System.out.print("Giá: "); double price = sc.nextDouble();
//                    System.out.print(type == 1 ? "Trọng lượng: " : "Dung lượng (MB): ");
//                    double attr = sc.nextDouble();
//
//                    Product p = ProductFactory.createProduct(type, id, name, price, attr);
//                    if (p != null) db.addProduct(p);
//                    break;
//
//                case 2:
//                    System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
//                    db.getAllProducts().forEach(Product::displayInfo);
//                    break;
//
//                case 3:
//                    System.out.print("Nhập ID cần cập nhật: ");
//                    String updateId = sc.nextLine();
//                    Product updateP = db.findById(updateId);
//                    if (updateP != null) {
//                        System.out.print("Tên mới: "); updateP.setName(sc.nextLine());
//                        System.out.print("Giá mới: "); updateP.setPrice(sc.nextDouble());
//                        if (updateP instanceof PhysicalProduct) {
//                            System.out.print("Trọng lượng mới: "); ((PhysicalProduct) updateP).setWeight(sc.nextDouble());
//                        } else {
//                            System.out.print("Dung lượng mới: "); ((DigitalProduct) updateP).setSize(sc.nextDouble());
//                        }
//                    } else { System.out.println("Không tìm thấy!"); }
//                    break;
//
//                case 4:
//                    System.out.print("Nhập ID cần xóa: ");
//                    String delId = sc.nextLine();
//                    if (db.deleteProduct(delId)) System.out.println("Đã xóa.");
//                    else System.out.println("Thất bại!");
//                    break;
//
//                case 5:
//                    System.exit(0);
//            }
//        }
//    }
//}
