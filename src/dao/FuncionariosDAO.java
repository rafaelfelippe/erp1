/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conectar;
import model.Clientes;
import model.Funcionarios;
import view.Menu;
import view.TelaLogin;

/**
 *
 * @author Rafael
 */
public class FuncionariosDAO {
    //  
     private Connection conexao;
    //objeto que o banco de dados guarda com o Connection é somente chamar o objeto do tipo conexao
    public FuncionariosDAO() {
        this.conexao = new Conectar().getConnection();

    }
    
    //Metodo Cadastrar Funcionario
    public void cadastrarFuncionario(Funcionarios obj) {
        try {
            //criar comando sql 
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //conectar banco de dados e organizar o sql 
            // tratar os comandos sqls e executar (preparedstatement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            //executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    
    //Metodo Alterar Funcionario
    public void alterarFuncionario(Funcionarios obj) {
        try {
            //criar comando sql 
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id =?";
            

            //conectar banco de dados e organizar o sql 
            // tratar os comandos sqls e executar (preparedstatement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            //com base no id alterar o resto
            stmt.setInt(17, obj.getId());

            //executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Excluir Funcionario
    public void excluirFuncionario(Funcionarios obj) {
        try {
            //criar comando sql 
            String sql = "delete from tb_funcionarios where id = ?";
            //conectar banco de dados e organizar o sql 
            // tratar os comandos sqls e executar (preparedstatement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            

            //executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    //metodo listar todos os funcionarios
    
    public List<Funcionarios> listarFuncionarios() {
        try {
            //1criar lista    
            List<Funcionarios> lista = new ArrayList<>();

            //2criar sql, organizar e executar
            String sql = "select * from tb_funcionarios";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //resultando do comando
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
                //retornar a lista com os objetos

            }
            return lista;
            
            } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
            //para não retornar nada
        
}
    }
    
    //METODO CONSULTA FUNCIONARIO DADOS 
        public Funcionarios ConsultaPeloNome(String nome){
            try {
            //criar sql, organizar e executar
            String sql = "select * from tb_funcionarios where nome = ?";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            //se encontrar os objetos, irá retornar ele
            Funcionarios obj = new Funcionarios();
            if(rs.next()) {
                
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                
               

            }
            return obj;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
                return null;
            }
        }
                
        //METODO BUSCAR FUNCIONARIO POR NOME (PESQUISAR) e retorna uma lista 
     public List<Funcionarios> buscaFuncionarioPeloNome(String nome) {
        try {
            //1criar lista    
            List<Funcionarios> lista = new ArrayList<>();

            //2criar sql, organizar e executar
            String sql = "select * from tb_funcionarios where nome like ?";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,nome);
            //resultando do comando
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
                //retornar a lista com os objetos

            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
            //para não retornar nada
        }
    }
     //Metodo LOGIN
     public void logar(Funcionarios obj){
         try {
             //comando sql
             String sql = "select * from tb_funcionarios where email =? and senha =?";
             PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,obj.getEmail());
            stmt.setString(2,obj.getSenha());
            //recebe o retorno da execução
             ResultSet rs = stmt.executeQuery();
             if (rs.next()){
                 //Usuario logou
                 JOptionPane.showMessageDialog(null," Seja Bem vindo ao Sistema");
                 //abrir tela principal 
                 Menu tela = new Menu();
                 tela.usuariologado = rs.getString("nome");
                 tela.setVisible(true);
                 
             }else{
                 //Dados errados
                 JOptionPane.showMessageDialog(null," Dados incorretos/não existe");
                 new TelaLogin().setVisible(true);
             }
             
         } catch (Exception erro) {
             JOptionPane.showMessageDialog(null,"Erro: "+ erro);
         }
     
    
     }

    
    }

