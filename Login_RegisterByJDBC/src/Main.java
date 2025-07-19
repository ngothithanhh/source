import dao.UserDAO;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt(); sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Nhập username: ");
                String u = sc.nextLine();
                System.out.print("Nhập password: ");
                String p = sc.nextLine();
                User user = new User(u, p);
                if (dao.register(user)) {
                    System.out.println("Đăng ký thành công!");
                } else {
                    System.out.println("Đăng ký thất bại (username có thể bị trùng)!");
                }

            } else if (choice == 2) {
                System.out.print("Nhập username: ");
                String u = sc.nextLine();
                System.out.print("Nhập password: ");
                String p = sc.nextLine();
                if (dao.login(u, p)) {
                    System.out.println("Đăng nhập thành công!");

                    while(true){
                        System.out.println("1. Đổi mật khẩu");
                        System.out.println("2. Xóa tài khoản");
                        System.out.println("0. Thoát");
                        System.out.print("Nhập: ");
                        int btn = sc.nextInt();sc.nextLine(); // clear buffer
                        if(btn == 1){
                            System.out.print("Nhập mật khẩu mới:");
                            String newPass = sc.nextLine();
                            if(dao.changePassword(u,p, newPass)){
                                System.out.println("Đổi mật khẩu thành công!");
                                p = newPass;
                            }
                            else{
                                System.out.println("Đổi mật khẩu không thành công!");
                            }

                        }
                        else if(btn == 2){
                            System.out.print("Nhập mật khẩu để xác nhận xóa tài khoản: ");
                            String tmpPass = sc.nextLine();
                            if(tmpPass.equals(p)){
                                if(dao.deleteAccount(u,p)){
                                    System.out.println("Xóa tài khoản thành công!");
                                    break;
                                }
                                else{
                                    System.out.println("Xóa tài khoản không thành công!");

                                }
                            }
                            else{
                                System.out.println("Mật khẩu sai, không thể xóa");
                            }

                        }
                        else if(btn == 0){
                            System.out.println("Thoát!");
                            break;
                        }
                    }
//                    switch (btn){
//                        case 1:
//                            System.out.print("Nhập mật khẩu mới:");
//                            String newPass = sc.nextLine();
//                            if(dao.changePassword(u,p, newPass)){
//                                System.out.println("Đổi mật khẩu thành công!");
//                            }
//                            else{
//                                System.out.println("Đổi mật khẩu không thành công!");
//                            }
//                            break;
//                        case 2:
//                            System.out.print("Nhập mật khẩu để xác nhận xóa tài khoản: ");
//                            String tmpPass = sc.nextLine();
//                            if(tmpPass.equals(p)){
//                                if(dao.deleteAccount(u,p)){
//                                    System.out.println("Xóa tài khoản thành công!");
//                                }
//                                else{
//                                    System.out.println("Xóa tài khoản không thành công!");
//                                }
//                            }
//                            else{
//                                System.out.println("Mật khẩu sai!, không thể xóa");
//                            }
//                            break;
//                        case 0:
//                            System.out.println("Thoát!");
//                            break;
//                    }
                } else {
                    System.out.println("Sai tài khoản hoặc mật khẩu.");
                }

            } else if (choice == 3) {
                System.out.println("Tạm biệt!");
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }

    }
}