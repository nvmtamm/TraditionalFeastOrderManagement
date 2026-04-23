/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import model.Order;
import tools.FileUtils;

/**
 *
 * @author khach
 */
public class Orders extends HashSet<Order> implements Workable<Order>{
    private final String TABLE_HEADER =
    "-------------------------------------------------------------\n" +
    "Order ID | Event date | Customer code | Set Menu | Price | Tables | Cost\n" +
    "-------------------------------------------------------------";
    
    private final String TABLE_FOOTER =
    "-------------------------------------------------------------";


    private String pathFile;
    private boolean isSaved;
    
    //Constructor
    public Orders() {
        super();
        this.isSaved = true;
        this.pathFile = "feast_oder_service.dat";
        this.readFromFile();
        
    
    }
    
    // isSaved()
    public boolean isSaved(){
        return isSaved;
    }
    /**
     * Kiểm tra trùng đơn hàng. Nếu 2 đơn hàng có 3 thuọc tính giống nhau là trùng
     * Customer ID - SetMenuId - EventDate.
     * @param x Oder Object
     * @return true: Trùng đơn hàng
     */
    public boolean isDuplicated(Order x){
        return this.contains(x);
    }
    
    /**
     * Thêm 1 đơn hàng vào danh sách hiện có nếu đơn hàng không trùng
     * @param x đơn hàng cần thêm
     */
     @Override
    public void addNew(Order x) {

    if (isDuplicated(x)) {
        System.out.println("Duplicate data!");
    } else {
        super.add(x);
        isSaved = false;
        System.out.println("Order added successfully!");
        System.out.println(x);
    }
}
    
  
    /**
     * 
     * @param x 
     */
    @Override
    public void update(Order x) {
        for (Order i : this) {
            if (i.getOrderCode().equals(x.getOrderCode())) {
                i = x;
                break;
            }
        }
    }
    /**
     * 
     * @param orderCode
     * @return result ( là 1 Order kết quả của tìm bởi Id)
     */
    @Override
    public Order searchById(String orderCode) {
       Order result = null;
       Iterator<Order> it = this.iterator();
       while(it.hasNext() && result == null){
           Order x = it.next();
           if (x.getOrderCode().equalsIgnoreCase(orderCode)) {
               result = x;
           }
       }
       return result;
       
    }

    @Override
    /**
     * Function showAll() in ra màn hình toàn bộ dữ liệu của Orders.
     */
    public void showAll() {
        showAll(this);
    }
    public void showAll ( Collection<Order> l){
        System.out.println(TABLE_HEADER);
        for (Order i : l) {
            System.out.println(i);
            
        }
        System.out.println(TABLE_FOOTER);
        
    }
   
  
 @Override
    public void readFromFile() {
        List<Order> list = FileUtils.readFromFile(pathFile);
        this.clear();
        this.addAll(list);
        isSaved = true;
}

@Override
    public void saveToFile() {
        List<Order> list = new ArrayList<>(this);
        FileUtils.saveToFile(list, pathFile);
        isSaved = true;
}
     
}
