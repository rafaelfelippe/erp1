/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTR;

import dao.FuncionariosDAO;
import java.math.BigInteger;
import model.Funcionarios;
 
/**
 *
 * @author Rafael
 */
public class funcionarioCTR {
    public void CadastrarFuncionarioCTR(String email,String senha){
        Funcionarios objM = new Funcionarios();
        BigInteger cripto;
        objM.setEmail(email);
        cripto = objM.CriptografarSenha(senha);
        objM.setSenha(cripto.toString());
        
        FuncionariosDAO objD = new FuncionariosDAO();
        objD.cadastrarFuncionario(objM);
    }
    public void LogarFuncionarioCTR(String email,String senha){
       Funcionarios objM = new Funcionarios();
       objM.setEmail(email);
       BigInteger cripto;
       cripto = objM.CriptografarSenha(senha);
       objM.setSenha(cripto.toString());
    
       FuncionariosDAO objD = new FuncionariosDAO();
       objD.logar(objM);
    }

}
