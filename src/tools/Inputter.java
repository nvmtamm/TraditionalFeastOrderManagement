/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;


import java.io.Serializable;

import java.util.Scanner;
import model.Customer;

/**
 *
 * @author khach
 */
public class Inputter implements Serializable{
    private Scanner ndl;


    public Inputter() {
        this.ndl = new Scanner(System.in);     
    }
    /**
     * Nhập dữ liệu chuỗi trực tiếp từ bàn phím bởi người dùng
     * @param mess
     * @return 
     */
    public String getString(String mess){
        System.out.print(mess);
        return ndl.nextLine();
    }
    /**
     * Nhập dữ liệu là số nguyên từ bàn phím bởi người 
     * @param mess
     * @return 
     */
    public int getInt(String mess){
        int result = 0;
        String temp = getString(mess);
        if (Acceptable.isValid(temp, Acceptable.INTEGER_VALID)) {
            result = Integer.parseInt(temp);
            
        }
        return result;
    }
    /**
     * Nhập dữ liệu là số double từ bàn phím bởi người sử dụng
     * @param mess
     * @return 
     */
    public double getDouble(String mess){
        double result = 0;
        String temp = getString(mess);
        if (Acceptable.isValid(temp, Acceptable.DOUBLE_VALID)) {
            result = Double.parseDouble(temp);
            
        }
        return result;
    }
    /**
     * Nhập và kiểm tra dữ liệu, nhập lại nếu khong khớp.
     * @param mess
     * @param pattern
     * @param isLoop
     * @return 
     */
    public String inputAndLoop(String mess, String pattern){
        boolean more = true; String result = "";
        do {            
           result = getString(mess);
           more = !Acceptable.isValid(result, pattern);
            if ( more ) {
                System.out.println("Data is invalid ! Re_Enter...Please!!");
                
            }
        } while (more);
        return result;
    }
/**
 * Hàm này dùng để lấy thông tin khách hàng 
 * @return 
 */
    public Customer getCustomerInfo() {
        Customer x = new Customer();
        x.setId(inputAndLoop("Nhập Id:   ", Acceptable.CUS_ID_VALID));
        x.setName(inputAndLoop("Nhập Tên:  ", Acceptable.NAME_VALID)); 
        x.setEmail(inputAndLoop("Nhap Email:  ", Acceptable.EMAIL_VALID));
        x.setPhone(inputAndLoop("Nhập Phone: ", Acceptable.PHONE_VALID));
        return x;
        
    }

   
}

        
    

