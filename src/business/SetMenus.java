/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SetMenu;

/**
 *
 * @author khach
 */
public class SetMenus extends ArrayList<SetMenu>  {
     private String pathFile;
     
    //Constructor
    public SetMenus() {
        super();
        this.pathFile = "FeastMenu.csv";
        this.loadFromFile();
    }
    //loadFromFile()
   public void loadFromFile() {
        this.clear();
        FileReader fr = null;
        try {
            //--------1. tao anh xa file tren thiet bi luu tru
            File f = new File(pathFile);
            //--------2. Tao luong anh xa toi file de van chuyen thong tin
            fr = new FileReader(f);
            //------ 3. Tao bo dem de van chuyen thong tin, BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String temp;
            //-------4. Lap de doc cac dong tu file va phan tich thanh obj(Setmenu)
            //doc 1 dong du lieu tu bo dem de gan cho bien temp phai co thi moi lam tiep
            while ((temp = br.readLine()) != null) {
                SetMenu x = dataToObject(temp);
                if (x != null) {
                    this.add(x);
                }
            }   
            //------------------5.Dong: bo dem, tap tin
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(SetMenus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public SetMenu searchById(String menuId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    

    private SetMenu dataToObject(String tam) {
        SetMenu x = null;
        String[] temp = tam.split(",");
        if (temp.length >= 4) {
            try {
               x = new SetMenu(temp[0], temp[1], Double.parseDouble(temp[2]), temp[3]);
            } catch (Exception e) {
            }
   
        }
        return x;
    }

    public void showAll() {
        for (SetMenu thi : this) {
            System.out.println(thi.toString());
        }
    }

   
    
  
    
}
