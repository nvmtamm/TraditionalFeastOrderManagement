/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business;

/**
 *
 * @author khach
 */
public interface Workable<T> {
    //add, update,search,delete
    void addNew (T x);
    void update (T x);
    T searchById(String id);
    void showAll();
    void readFromFile();
    void saveToFile();
    
       
}
