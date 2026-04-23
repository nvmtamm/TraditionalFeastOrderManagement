/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import model.Customer;
import tools.Acceptable;
import tools.FileUtils;
import tools.Inputter;

/**
 *
 * @author khach
 */
public class Customers extends HashMap<String, Customer>  implements Workable<Customer>,Acceptable {
    private final String TABLE_HEADER =
        "--------------------------------------------------------------------------\n" +
        "    ID   |          Name             |    Phone   |       Email       \n" +
        "--------------------------------------------------------------------------";

    private final String TABLE_FOOTER =
        "--------------------------------------------------------------------------";
    private String pathFile;
    private boolean isSaved;
    private Inputter input;
    
    //Constructor
    public Customers() {
        super();
        this.input = new Inputter();
        this.isSaved = true;
        this.pathFile = "customers.dat"; 
        this.readFromFile();
    }

    
    // isSaved()
    public boolean isSaved(){
     return isSaved;
        
    }
    
    
    public void readFromFile() {
        List<Customer> list = FileUtils.readFromFile(pathFile);
        this.clear();

        for (Customer c : list) {
            this.put(c.getId(), c);
        }

        this.isSaved = true;
}

    //saveToFile()
    public void saveToFile() {
        List<Customer> list = new ArrayList<>(this.values());
        FileUtils.saveToFile(list, pathFile);
        this.isSaved = true;
    }

 
    /**
     * Function 3: SearchByName
     * @param Name
     * @return 
     */
    public List<Customer> filterByName(String Name){
        List<Customer> result = new ArrayList<>();
        
        //Kiểm tra mảng xem có dữ liệu không
        if (this.isEmpty()) {
            return result;
        }    
        //Duyệt mảng lấy dữ liệu
        for (Customer customer : this.values()) {
            if (customer.getName().toLowerCase().endsWith(Name.toLowerCase())) {
                result.add(customer);
            }      
        }   
        return result;
    }
     
/**
 * Hàm này dùng để add new customer
 * @param x 
 */
    @Override
    public void addNew(Customer x) {
       this.putIfAbsent(x.getId(), x);
          
    }

    /**
     * Function: Update Customer'information.
     * @param 
     */
    @Override
    public void update(Customer t) {
        boolean loop = true;
        int choice;
        do {
            System.out.println("1.Update Name.");
            System.out.println("2.Update PhoneNumber.");
            System.out.println("3.Update Email.");
            choice = input.getInt("Enter your choice:");
            System.out.println("---------------------------------");
            
            switch (choice) {
                case 1:
                    System.out.println("You choosen Update Name.");
                    t.setName(input.inputAndLoop("Enter new NAME:", Acceptable.NAME_VALID));
                    System.out.println("Update Successfully!!!");
                    break;
                case 2:
                    System.out.println("You choosen Update PhoneNumber.");
                    t.setPhone(input.inputAndLoop("Enter new PhoneNumber:", Acceptable.PHONE_VALID));
                    System.out.println("Update Successfully!!!");     
                    break;
                case 3:
                    System.out.println("You choosen Update Email.");
                    t.setEmail(input.inputAndLoop("Enter new Email:", Acceptable.EMAIL_VALID));
                    System.out.println("Update Successfully!!!");
                    break;
                case 4:
                    System.out.println("You choosen Exit.");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter valid choice !!");
            }
        } while (loop);
                
            
  
  }
       
    @Override
    /**
     * Function showAll() in ra màn hình toàn bộ dữ liệu của  Customers.
     */
    public void showAll() {
        showAll( this.values());
    }
    public void showAll ( Collection<Customer> l){
        System.out.println(TABLE_HEADER);
        for (Customer i : l) {
            System.out.println(i);
            
        }
        System.out.println(TABLE_FOOTER);
        
    }
    
    /**
     * Function 3: Search By Id 
     * @param id
     * @return 
     */
     @Override
    public Customer searchById(String id) {
       return this.get(id);
    }
    
    /**
     * Hàm này dùng để check xem đã tồn tại customer với id đầu vào chưa
     * @param id
     * @return 
     */
    public boolean checkCustomerByID(String id){
        boolean x = false;
        for (Customer i : this.values()) {
            if (i.getId().equals(id)) {
               x = true; 
            }
        }
        return x;
    }
    
   
}
