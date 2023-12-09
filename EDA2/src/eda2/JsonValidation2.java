/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda2;

import EstruturaDeDados.Pilha;
import EstruturaDeDados.PilhaItems;

/**
 *
 * @author senti
 */
public class JsonValidation2 {
    Error error;
    String json;
    public JsonValidation2(String json){
        this.json = json;
    }
    public boolean validation1(PilhaItems p){
        
        if(!validation2(p)){
            ErrorLog();
            return false;
        }
        if(p.lenght()!=0){
            error = new Error("Not valid value",p.peek(),p.pop().index);
            ErrorLog();
            return false;
        }
        //this.p.Log();
        return true;
    }
    public void validationP(Pilha p){
       
    }

    public boolean validation2(PilhaItems p){
        if(p.peek().str.equals("{")){
            //this.p.push(p.pop());
            p.pop();
            return validationObjJson(p);
        }
        else{
            if(p.peek().str.equals("[") ){
                return validacaoArray(p);
            }
            else{
                // não é preciso, mas é boa pratica ? compara se é diferente de error e de espcial caracter
                if(!p.peek().type.equals(Itemtype.ERROR)&&!p.peek().type.equals(Itemtype.ESPECIALCHARACTER)){
                p.pop();
                return true;
            }
            this.error = new Error("Not valid value",p.peek(),p.pop().index);
            return false;
               /* abordagem //compara se é diferente de erro, (não compara se é diferente de especial characters, mas pela estrutura do codigo penso que não dara erros)
                return !p.pop().type.equals(Itemtype.ERROR);*/
            }
        }        
    }
    
    public boolean validationObjJson(PilhaItems p){
        if(p.peek().str.equals("}")){
               //this.p.push(p.pop());
               p.pop();
               return true;
        }
        try{
        if(!chavevalidacao(p.pop()) ){
            return false;
        }
        if(!p.peek().str.equals(":")){
            this.error = new Error("Not valid value, expected (:) but found ("+p.peek().str+")",p.peek(),p.pop().index+1);
            return false;
        }
        p.pop();
        if(! validation2(p)){
            return false;
        }
       
        if(p.peek().str.equals(",")){
            p.pop();
            return validationObjJson(p);
        }
        else{
           if(p.peek().str.equals("}")){
               //this.p.push(p.pop());
               p.pop();
               return true;
           }
            //this.error = new Error("Not valid value, expected (}) but found ("+p.peek().str+")",p.peek(),p.pop().index);
            return false;
        }
        }
        catch(Exception e){
            this.error = new Error("Not valid value",null,0);
            return false;
        }
        
    }
    
    public boolean validacaoArray(PilhaItems p){
        if(p.peek().str.equals("[")){
            //this.p.push(p.pop());
            p.pop();
        }
        if(p.peek().str.equals("]")){
            //this.p.push(p.pop());
            p.pop();
            return true;
        }
        if(!validation2(p)){
                return false;
        }
      
        
        while(!p.peek().str.equals("]") && p.peek()!=null){
            try{
                if(!p.peek().str.equals(",")){
                    this.error = new Error("Not valid value, expected , but found"+p.peek().str,p.peek(),p.pop().index);
                    return false;
                }
                else{
                    p.pop();
                }
                if(!validation2(p)){
                    return false;
                }
                
            
                
            }
            catch(Exception e){
                this.error = new Error("Not valid value",p.peek(),p.pop().index);
                return false;
            }
            
        }
        if(p.peek().str.equals("]")){
            p.pop();
            //this.p.push(p.pop());
            return true;
        }
        this.error = new Error("Not valid value, expected ] but found"+p.peek().str,p.peek(),p.pop().index);
        return false;
    }
    public boolean isAtomicValueValide(Item item){
        this.error = new Error("Not valid value",item,item.index);
        return !item.type.equals(Itemtype.ERROR);
    }
    public boolean chavevalidacao(Item item){
        if(item.type.equals(Itemtype.ERROR)){
            error = new Error("not valid key",item,item.index+1);
            return false;
        }
        String str = item.str;
        for(int i = 1;i<str.length()-1;i++){
            if(!Character.isLetterOrDigit(str.charAt(i))&& str.charAt(i)!='\"'){
               error = new Error("not valid key, expected alpha numeric value",item,item.index+1);
               return false; 
            }
        }
        return true;
    }
    public void ErrorLog(){
        if(error.item!=null){
            System.out.println("At char "+(error.indexerror+1));
            System.out.println(json.substring(error.indexerror,error.indexerror+error.item.str.length()));
            for(int i =0;i<0;i++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println(error.errorMsg);
    }
}
