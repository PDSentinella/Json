/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda2;

import EstruturaDeDados.Pilha;
import static EstruturaDeDados.PilhaItems.invert;
import static EstruturaDeDados.Pilha.invert;

import EstruturaDeDados.PilhaItems;

/**
 *
 * @author senti
 */
public class JsonIterador {
    String json;
    int counter;
    public PilhaItems pilha;
    public static void main(String[] arg){
        
    }
   
    public JsonIterador(String json){
        this.json = json.replaceAll("\n", "").replaceAll(" ","")+" ";
        pilha = new PilhaItems();
        counter =0;
    }
    public void clearPilha(){
        pilha = new PilhaItems();
    }
    public Pilha closingChracter(){
        Pilha aux = new Pilha();
        for(int i = 0;i<json.length()-1;i++){
            if("{}[]".contains((json.charAt(i)+"")))aux.push((json.charAt(i)+""));
        }
        //aux = invert(aux);
        return aux;
    }
    //itera todos os elementos do json
    public void percorrerJson(){
        while(this.counter<json.length()-1){
            //nextItem retorna String do item
           
           //colocar item em uma pilha
          
          String str =nextItem().trim();
          if(!str.equals("")){
              Item i = new Item(str,counter-str.length()-1);
               pilha.push(i);
          }
          
        }
        counter = 0;
        pilha = invert(pilha);
        //pilha.Log();
    }
    //precorre json por items e devolve um item (consoate ao conuter)
     public String nextItem(){
        String item = "";
        int i ;
        for (i=counter;i<json.length()-1;i++){
            if(isEspecialCharacter(json.charAt(i)+"")||json.charAt(i)==' '){
                if(json.charAt(i)==' '){
                    if(isEspecialCharacter(json.charAt(i+1)+"") ){
                            item +=json.charAt(i);
                            counter = i +1;
                            //System.out.println(item);
                            return item;
                        }
                }
                else{
                    item = json.charAt(i)+"";
                    counter = i + 1;
                    //System.out.println(item);
                    return item;
                }
                
            }
            else{

                        if(isEspecialCharacter(json.charAt(i+1)+"") ){
                            item +=json.charAt(i);
                            counter = i +1;
                            //System.out.println(item);
                            return item;
                        }
                        else{
                            
                            item +=json.charAt(i);       
                       }

                
                
            }
        }
    counter = i+1;
    return item;    
        
    }
    public void tirarEspaços(){
        PilhaItems aux = pilha;
        PilhaItems aux2 = new PilhaItems();
        while(aux.peek()!=null){
            if(aux.peek().str.equals(" ")){
                aux.pop();
            }
            else{
                aux2.push(aux.pop());
            }
            
        }
        while(aux.peek()!=null){
            aux.push(aux2.pop());
        }
        pilha = aux;
        
    }
    //verifica se é caractere especial
    public boolean isEspecialCharacter(String str){
        return "{}[]:,".contains(str);
    }
    public String log(){
        return "";
    }

}
