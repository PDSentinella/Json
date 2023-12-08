/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstruturaDeDados;

import eda2.Item;


/**
 *
 * @author senti
 */
//não deve guardar um item com data = null, ou seja, não se deve guardar um objecto nullo na pilha
public class PilhaItems {
    private Elementos top;
    private int lenght;
    
    public PilhaItems(){
        top = null;
        lenght = 0;
    }
    public PilhaItems(PilhaItems p){
        PilhaItems aux1 = new PilhaItems();
        PilhaItems aux2 = new PilhaItems();
        while(p.peek()!=null){
            Item i = p.pop();
            aux1.push(i);
        }
        while(aux1.peek()!=null){
            Item i = aux1.pop();
            aux2.push(i);
            p.push(i);
        }
    }
  
    public boolean isEmpty() {
        return top ==null;
    }
    public int lenght(){
        return this.lenght;
    }
    
    public Item pop() {
        if(this.isEmpty()){
            return null;
        }
        lenght -=1;
        Item data = top.data;
        top = (Elementos) top.next;
        return data;
    }
    
    
    public void push(Item item) {
        Elementos novo = new Elementos();
        novo.data = item;
        novo.next = top;
        top = novo;
        lenght +=1;
    }

    
    public Item peek() {
        if(this.isEmpty()){
            return null;
        }
        return top.data;
    }
    private class Elementos{
        Item data;
        Elementos next;
    }
    @Override
    public String toString(){
        //Pilha aux = new Pilha(this);
        Elementos i = new Elementos();
        i.next = top;
        String str ="";
        while(i.next !=null){
            str += i.next.data.toString()+"\n";
            i.next = i.next.next;
        }
        return str;
    }

    public void Log(){
        String str = this.toString();
        System.out.println(str);
    }
    public static PilhaItems invert(PilhaItems p){
        PilhaItems aux = new PilhaItems();
        while(p.peek()!=null){
            aux.push(p.pop());
        }
        return aux;
    }
    
}
