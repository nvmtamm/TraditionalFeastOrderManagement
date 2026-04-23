/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author khach
 */
public class SetMenu {
    private String menuId;
    private String menuName;
    private double price;
    private String ingredients;
    
    //Contructor
    public SetMenu() {
    }

    public SetMenu(String menuId, String menuName, double price, String ingredients) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.price = price;
        this.ingredients = ingredients;
    }
    
    //Getters and Setters
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    
    //toString()
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("---------------------------------------------\n");
    sb.append("Code        : ").append(menuId).append("\n");
    sb.append("Name        : ").append(menuName).append("\n");
    sb.append(String.format("Price       : %, .0f Vnd%n", price));
    sb.append("Ingredients :\n");
    

    String temp = ingredients.replaceAll("\"", "");
    if (temp != null && !temp.isEmpty()) {
        String[] parts = temp.split("#");
        for (String p : parts) {
            sb.append(p.trim()).append("\n");
        }
    }

    sb.append("---------------------------------------------");
    return sb.toString();
}
    //Function for get Price for numberOfTable
    public double getPrice(int numberOfTable){
        return numberOfTable*this.price;
    }

    
    
    
    
}
