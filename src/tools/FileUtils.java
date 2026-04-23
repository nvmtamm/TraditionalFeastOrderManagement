/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khach
 */
public class FileUtils {
    /**
 * Phương thức cho phép đọc dữ liệu có trong tập tin yêu cầu
 * @param filePath đường dẫn tới file
 * @param <T> kiểu dữ liệu generic
 * @return danh sách dữ liệu có sẳn trong file
 */
public static <T> List<T> readFromFile(String filePath) {
    List<T> result = new ArrayList<>();
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    try {
        // ---- 1. Tạo File object để ánh xạ lên thiết bị ----
        File f = new File(filePath);
        if (!f.exists()) {
            System.out.println("File not found: " + filePath);
            return result;
        }

        // ---- 2. Tạo luồng đọc file nhị phân ----
        fis = new FileInputStream(f);

        // ---- 3. Tạo ObjectInputStream để đọc object ----
        ois = new ObjectInputStream(fis);

        // ---- 4. Đọc dữ liệu cho đến khi hết file ----
        while (true) {
            try {
                T x = (T) ois.readObject();
                result.add(x);
            } catch (EOFException e) {
                break; // kết thúc khi đọc hết file
            }
        }

    } catch (IOException | ClassNotFoundException ex) {
        System.out.println("Error reading file!");
    } finally {
        // ---- 5. Đóng luồng ----
        try {
            if (ois != null) ois.close();
            if (fis != null) fis.close();
        } catch (IOException ex) {
            System.out.println("Error closing file!");
        }
    }

    return result;
}



/**
 * Phương thức cho phép ghi dữ liệu vào object file
 * @param <T> kiểu dữ liệu generic
 * @param li danh sách dữ liệu cần ghi
 * @param filePath đường dẫn file
 */
public static <T> void saveToFile(List<T> li, String filePath) {
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    try {
        // ---- 1. Tạo File object ----
        File f = new File(filePath);

        // ---- 2. Tạo FileOutputStream ánh xạ tới File object ----
        fos = new FileOutputStream(f);

        // ---- 3. Tạo ObjectOutputStream để ghi dữ liệu xuống thiết bị ----
        oos = new ObjectOutputStream(fos);

        // ---- 4. Lặp để ghi dữ liệu ----
        for (T i : li) {
            oos.writeObject(i);
        }

        // ---- 5. Đóng ObjectOutputStream sau khi xử lý ----
        oos.close();

    } catch (FileNotFoundException ex) {
        System.out.println("File not found!");
    } catch (IOException ex) {
        System.out.println("Error writing file!");
    } finally {
        // ---- 6. Đóng FileOutputStream ----
        try {
            if (fos != null) fos.close();
        } catch (IOException ex) {
            System.out.println("Error closing file!");
        }
    }
}

/*
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
*/
    
}
