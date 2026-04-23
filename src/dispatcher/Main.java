/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispatcher;

import business.Customers;
import business.Orders;
import business.SetMenus;
import java.util.List;
import model.Customer;
import tools.Acceptable;
import tools.Inputter;


/**
 *
 * @author khach
 */
public class Main {
    public static void main(String[] args) {
 
        Inputter input = new Inputter(); int choice = 0;
        
        
        //ArrayList()
        Customers customerList = new Customers();
        Orders orderList = new Orders();
        SetMenus menuList = new SetMenus();
        


//------------------------------------ MENU -------------------------------------------------//
        do {
            displayMenu();
            choice = input.getInt("Choose an option: ");
            System.out.println("---------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("Bạn đã chọn nhập thông tin khách hàng mới.");
                    Customer x = input.getCustomerInfo();
                    if (customerList.checkCustomerByID(x.getId())) {
                        System.out.println("Đã tồn tại khách hàng này...");
                        break;
                    }
                    customerList.addNew(x);  
                    System.out.println("         Thêm thành công");
                    break;
            

                case 2:
                    System.out.println("Bạn đã chọn UPdate khách hàng mới.");
                    Customer customerUpdate = customerList.searchById(input.inputAndLoop("      Nhập ID khách hàng cần Update:", Acceptable.CUS_ID_VALID));
                    if (customerUpdate!=null) {
                          customerList.update(customerUpdate);
                          break;
                    }
                    System.out.println("This costomer does not exist!!");
                    break;

                case 3:
                    System.out.println("Bạn đã chọn TÌM KIẾM thông tin khách hàng.");
                    List filterByName = customerList.filterByName(input.getString("Nhập tên cần tìm:  "));
                    if (filterByName.isEmpty() ) {
                        System.out.println("This customer does not exist!!");
                        
                    }else{
                        customerList.showAll(filterByName);
                    }
                          
                    break;

                case 4:
                    System.out.println("Bạn đã chọn hiển thị MENU.");
                    menuList.showAll();
                    break;

                case 5:
                     System.out.println("Bạn đã chọn ĐẶT TIỆC.");
                    // trống
                    break;

                case 6:
                    System.out.println("Bạn đã chọn cập nhật đơn hàng.");
                    //trống
                    break;
                    
                case 8:
                    System.out.println("Bạn đã chọn display info:");
                    boolean loop = true;
                    do {
                        System.out.println("1.Display Costomers: ");
                        System.out.println("2.Display Orders: ");
                        System.out.println("3.Exit.");
                        int c = input.getInt("Nhập lựa chọn của bạn: ");
                        switch (c) {
                        case 1:
                            System.out.println("Bạn đã chọn display Customers: ");
                            customerList.showAll();
                            break;
                        case 2:
                            System.out.println("Bạn đã chọn display OrderList: ");
                            orderList.showAll();
                            break;
                        case 3:
                            System.out.println("Bạn đã chon exit.");
                            loop = false;
                            break;
                        
                       
                        default:
                            throw new AssertionError();
                    }
                    } while (loop);
                   
                    break;

                case 7:
                    System.out.println("Bạn đã chọn Save to File.");
                    customerList.saveToFile();
                    if (customerList.isSaved()) {
                        System.out.println("      Đã lưu vào customers.dat !!!");
                    }
                    orderList.saveToFile();
                    if (orderList.isSaved()) {
                        System.out.println("      Đã lưu vào feast_oder_service.dat !!!");
                    }
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                   

                default:
                    System.out.println("Invalid choice. Please try again!");
            }
            

        } while ( choice >= 1 && choice <=8);
        
    }
    
    //  displayMenu()
    public static void displayMenu() {
    System.out.println("=================================");
    System.out.println(" Traditional Feast Order Management ");
    System.out.println("=================================");
    System.out.println("1. Register customer");
    System.out.println("2. Update customer information");
    System.out.println("3. Search customer by name");
    System.out.println("4. Display feast menus");
    System.out.println("5. Place a feast order");
    System.out.println("6. Update order information");
    System.out.println("7. Save data to file");
    System.out.println("8. Display customer or order list");
    System.out.println("9. Exit");
}

    
}
