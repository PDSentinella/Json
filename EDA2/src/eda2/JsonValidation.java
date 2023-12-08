/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda2;

import EstruturaDeDados.Pilha;
import EstruturaDeDados.PilhaItems;
import static EstruturaDeDados.PilhaItems.invert;

/**
 *
 * @author senti
 */
public class JsonValidation {
    Pilha p;
    public JsonValidation(){
        this.p = new Pilha();
    }
    
    public boolean validation2(Pilha p){
        if(p.peek().equals("{")){
            this.p.push(p.pop());
            return validationObjJson(p);
        }
        else{
        if(p.peek().equals("[") ){
            return validacaoArray(p);
        }
        else{
            p.pop();
            return true;
        }
        }        
    }
    
    public boolean validationObjJson(Pilha p){
        if(p.peek().equals("}")){
               this.p.push(p.pop());
               return true;
        }
        try{
        if(!chavevalidacao((Item) p.pop()) ){
            return false;
        }
        if(!p.pop().equals(":")){
            return false;
        }
        if(! validation2(p)){
            return false;
        }
        //
        //p.pop();
        if(p.peek().equals(",")){
            p.pop();
            return validationObjJson(p);
        }
        else{
           if(p.peek().equals("}")){
               this.p.push(p.pop());
               return true;
           }
            return false;
        }
        }
        catch(Exception e){
            return false;
        }
        
    }
    
    public boolean validacaoArray(Pilha p){
        if(p.peek().equals("[")){
            this.p.push(p.pop());
        }
        if(p.peek().equals("]")){
            this.p.push(p.pop());
            return true;
        }
        if(!validation2(p)){
                return false;
        }
        //suposed to be pooped latter on
        //p.pop();
        // [1,2,3,4]
        
        while(!p.peek().equals("]") && p.peek()!=null){
            try{
                if(!p.peek().equals(",")){
                    return false;
                }
                else{
                    p.pop();
                }
                if(!validation2(p)){
                    return false;
                }
                //suposed to be pooped latter on
                //p.pop();
            
                
            }
            catch(Exception e){
                return false;
            }
            
        }
        if(p.peek().equals("]")){
            this.p.push(p.pop());
            return true;
        }
        return false;
    }
    public boolean isAtomicValueValide(Item item){
        return !item.type.equals(Itemtype.ERROR);
    }
    public boolean chavevalidacao(Item item){
        if (!item.type.equals(Itemtype.STRING)){
            return false;
        }
        String str = item.str;
        for(int i = 1;i<str.length()-2;i++){
            if(!Character.isLetterOrDigit(str.charAt(i))){
               return false; 
            }
        }
        return true;
    }
}
