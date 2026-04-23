/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tools;

/**
 * 
 * @author khach
 */
public interface Acceptable {

    public final String CUS_ID_VALID = "^[CKGckg]\\d{4}$";
    public final String NAME_VALID = "^.{2,25}$";
    public final String PHONE_VALID = "^0\\d{9}$";
    public final String EMAIL_VALID = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public final String INTEGER_VALID = "-?\\d+";
    public final String POSITIVE_INT_VALID = "\\d+";
    public final String DOUBLE_VALID = "-?\\d+(\\.\\d+)?";
    public final String POSITIVE_DOUBLE_VALID = "\\d+(\\.\\d+)?";
    public final String SETMENUID_VALID ="^[P]+[W]+(000)+[1-4]";

    
    /**
     *  Hàm này dùng để check validation của dữ liệu đầu vao 
     * @param data
     * @param pattern
     * @return true nếu validation 
     */
    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
}

