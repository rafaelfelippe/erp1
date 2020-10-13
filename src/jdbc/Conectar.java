/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rafael
 */
public class Conectar {
    //método retorna um objeto do tipo conexão
    public Connection getConnection(){
        //tratamento de erro
        try {
            //conecta no banco de dados (o verdadeiro), colocar informações
            return  DriverManager.getConnection("jdbc:mysql://127.0.01/bdvendas","usuariotcc","123");
            
        } catch (Exception erro) {
            //caso nao consiga se conectar 
            throw new RuntimeException(erro);
            
        }
    }
}
