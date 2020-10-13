/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class TESTARCONEXAO {
    public static void main(String[] args) {
        try {
            new Conectar().getConnection();
            JOptionPane.showMessageDialog(null,"Conectado com suceso"); 
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro na conexão: "+erro); 
        }
    }
}
