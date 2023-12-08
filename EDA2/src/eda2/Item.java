/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda2;

import static eda2.ItemValidation.itemType;

/**
 *
 * @author senti
 */
public class Item {
    String str;
    Itemtype type;
    int index;
    public Item(String str,int index){
        this.str = str;
        type = itemType(str);
        this.index = index;
    }
    @Override
    public String toString(){
        String aux = str+"\n" + type.name;
        return aux;
    }
}
