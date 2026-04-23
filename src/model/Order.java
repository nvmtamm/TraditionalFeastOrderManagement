/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


/**
 *
 * @author khach
 */
public class Order implements Serializable{
    private String orderCode;
    private String customId;
    private String setMenuId;
    private int numOfTables;
    private Date eventDate;
    private double price = 0;

    //HashSet dùng hàm băm ra
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.customId);
        hash = 61 * hash + Objects.hashCode(this.setMenuId);
        hash = 61 * hash + Objects.hashCode(this.eventDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.customId, other.customId)) {
            return false;
        }
        if (!Objects.equals(this.setMenuId, other.setMenuId)) {
            return false;
        }
        return Objects.equals(this.eventDate, other.eventDate);
    }
    
    
    
    
    /**
     * Create the unique orderCode base on the Time Stamp
     * @return 
     */
    private String generateOrderCode(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(now);
    }
    
    
    //Constructor
    public Order() {
        this.orderCode = generateOrderCode();
        this.customId = "";
        this.setMenuId = "";
        this.numOfTables = 0;
        this.eventDate = new Date();
        
    }
    
    public Order( String customId, String setMenuId, int numOfTables, Date eventDate) {
        this.orderCode = generateOrderCode();
        this.customId = customId;
        this.setMenuId = setMenuId ;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
    }
    
    public double getPrice() {
        return price;
    }

    //Getter , Setter
    public void setPrice(double price) {    
        this.price = price;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getSetMenuId() {
        return setMenuId;
    }

    public void setSetMenuId(String setMenuId) {
        this.setMenuId = setMenuId;
    }

    public int getNumOfTables() {
        return numOfTables;
    }

    public void setNumOfTables(int numOfTables) {
        this.numOfTables = numOfTables;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Order{" + "orderCode=" + orderCode + ", customId=" + customId + ", setMenuId=" + setMenuId + ", numOfTables=" + numOfTables + ", eventDate=" + eventDate + ", price=" + price + '}';
    }
    
    

   
    
    
}
