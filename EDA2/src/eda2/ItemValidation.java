/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda2;

/**
 *
 * @author senti
 */
public class ItemValidation {
    
    public static boolean isString(String str){
        if((str.charAt(0)+"").equals(""))return false;
        if(!(str.charAt(0)+"").equals("\"")){
        return false;
        }
        int i = str.length()-1;
        while (i>=1){
            if((str.charAt(i)+"").equals("\"")){
                return true;
            }
            i--;
        }
        
        return false;
    }
    public static boolean isBoolean(String str){
        return "true".equals(str) || "false".equals(str);
    }
    
    public static boolean isNum(String str){
        try{
            Double d = Double.valueOf(str);
            return true;
            
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    public static boolean isNull(String str){
        return str.equals("null");
    }
    
    public static boolean isEspecialCharacter(String str){
        return "[]{},:\"".contains(str);
    }
    
    public static Itemtype itemType(String str){
        if(isString(str)){
            return Itemtype.STRING;
        }
        if(isNum(str)){
            return Itemtype.NUM;
        }
        if(isBoolean(str)){
            return Itemtype.BOOLEAN;
        }
        if(isEspecialCharacter(str)){
            return Itemtype.ESPECIALCHARACTER;
        }
        if(isNull(str)){
            return Itemtype.NULL;
        }
        return Itemtype.ERROR;
    }
}
