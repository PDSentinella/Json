/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import EstruturaDeDados.PilhaItems;
import eda2.JsonIterador;
import eda2.JsonValidation2;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Test;



/**
 *
 * @author senti
 */
public class JsonSubClassesTests {
    JsonIterador test;
    JsonValidation2 testar;
    public JsonSubClassesTests() {
        
    }
    public PilhaItems prepare(String json){
        this.testar = new JsonValidation2(json);
        test = new JsonIterador(json);
        test.percorrerJson();
        return test.pilha;
    }
    @Test
    public void testJsonValidatoin2(){
        String[] arrayJsonsTest ={"""
                                  {
                                      "pessoa": {
                                          "nome": "Jo\u00e3o",
                                          "idade": 30,
                                          "enderecos": [
                                              {
                                                  "tipo": "Residencial",
                                                  "logradouro": "Rua A",
                                                  "cidade": "Cidade A"
                                              },
                                              {
                                                  "tipo": "Comercial",
                                                  "logradouro": "Rua B",
                                                  "cidade": "Cidade B"
                                              }
                                          ]
                                      },
                                      "produtos": [
                                          {
                                              "nome": "Produto A",
                                              "preco": 20.0
                                          },
                                          {
                                              "nome": "Produto B",
                                              "preco": 30
                                          }
                                      ]
                                  }""",
                       
"{\"chave\":[1,2]}",

"{\"chave\":[1]}"
 
};
        for(int i=0;i<arrayJsonsTest.length;i++){
            assertEquals(true,testar.validation1(prepare(arrayJsonsTest[i])));
        }
        
        
    }
   
}
