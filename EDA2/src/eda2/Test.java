/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda2;

/**
 *
 * @author senti
 */
public class Test {
    public static void main(String[] args){
        String json; 
        //json = "{\"chave\":[1,}";
        json = "{\n" +
"    \"pessoa\":{\n" +
"        \"nome\": \"João\",\n" +
"        \"idade\": 30,\n" +
"        \"enderecos\": [\n" +
"            {\n" +
"                \"tipo\": \"Residencial\",\n" +
"                \"logradouro\": \"Rua A\",\n" +
"                \"cidade\": \"Cidade A\"\n" +
"            },\n" +
"            {\n" +
"                \"tipo\": \"Comercial\",\n" +
"                \"logradouro\": \"Rua B\",\n" +
"                \"cidade\": \"Cidade B\"\n" +
"            }\n" +
"        ]\n" +
"    },\n" +
"    \"produtos\": [\n" +
"        {\n" +
"            \"nome\": \"Produto A\",\n" +
"            \"preco\": 20\n" +
"        },\n" +
"        {\n" +
"            \"nome\": \"Produto B\",\n" +
"            \"preco\": 30\n" +
"        }\n" +
"    ]\n" +
"}";//*/
        JsonIterador test = new JsonIterador(json);
 
        test.percorrerJson();
        //test.percorrerJson();
        //test.pilha.Log();
        JsonValidation2 testar = new JsonValidation2(json.replaceAll("\n", "").replaceAll(" ","")+" ");
        //System.out.println(test.closingChracter());
        testar.validation1(test.pilha);
        //System.out.println(test.closingChracter());
    }
    
}
