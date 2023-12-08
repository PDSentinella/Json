/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstruturaDeDados;


/**
 *
 * @author senti
 */
public class Pilha {
    private Elementos top;
    private int lenght;
    
    public Pilha(){
        top = null;
        lenght = 0;
    }
    public Pilha(Pilha p){
        Pilha aux1 = new Pilha();
        Pilha aux2 = new Pilha();
        while(p.peek()!=null){
            Object i = p.pop();
            aux1.push(i);
        }
        while(aux1.peek()!=null){
            Object i = aux1.pop();
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
    
    public Object pop() {
        if(this.isEmpty()){
            return null;
        }
        lenght -=1;
        Object data = top.data;
        top = (Elementos) top.next;
        return data;
    }
    
    
    public void push(Object item) {
        Elementos novo = new Elementos();
        novo.data = item;
        novo.next = top;
        top = novo;
        lenght +=1;
    }

    
    public Object peek() {
        if(this.isEmpty()){
            return null;
        }
        return top.data;
    }
    private class Elementos{
        Object data;
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
    public static Pilha invert(Pilha p){
        Pilha aux = new Pilha();
        while(p.peek()!=null){
            aux.push(p.pop());
        }
        return aux;
    }
    
}

