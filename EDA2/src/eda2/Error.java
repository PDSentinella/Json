/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda2;

/**
 *
 * @author senti
 */
public class Error {
    String errorMsg;
    Item item;
    int indexerror;
    public Error(String errorMsg,Item item, int indexerror){
        this.errorMsg = errorMsg;
        this.item = item;
        this.indexerror = indexerror;
    }
    
}
