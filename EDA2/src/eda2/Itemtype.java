/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package eda2;

/**
 *
 * @author senti
 */
public enum Itemtype {
        BOOLEAN("boolean"),
        STRING("string"),
        NUM("num"),
        ESPECIALCHARACTER("especialcharacter"),
        NULL("null"),
        ERROR("error");
        
    /**
     *
     */
        public final String name;
        private Itemtype(String str){
            name = str;
        }
        
}
