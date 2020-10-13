/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Conectar;
import model.Clientes;

/**
 *
 * @author Rafael
 */
public class ClientesDAO {

    private Connection conexao;

    //objeto que o banco de dados guarda com o Connection é somente chamar o objeto do tipo conexao
    public ClientesDAO() {
        this.conexao = new Conectar().getConnection();

    }

    //Metodo Cadastrar Cliente
    public void cadastrarCliente(Clientes obj) {
        try {
            //criar comando sql 
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //conectar banco de dados e organizar o sql 
            // tratar os comandos sqls e executar (preparedstatement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            //executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Alterar Cliente
    public void alterarCliente(Clientes obj) {
        try {
            //criar comando sql 
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id =?";
            

            //conectar banco de dados e organizar o sql 
            // tratar os comandos sqls e executar (preparedstatement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            //com base no id alterar o resto
            stmt.setInt(14, obj.getId());

            //executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Excluir Cliente
    public void excluirCliente(Clientes obj) {
        try {
            //criar comando sql 
            String sql = "delete from tb_clientes where id = ?";
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

    //Metodo ListarClientes 
    public List<Clientes> listarClientes() {
        try {
            //1criar lista    
            List<Clientes> lista = new ArrayList<>();

            //2criar sql, organizar e executar
            String sql = "select * from tb_clientes";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //resultando do comando
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
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
        //METODO CONSULTA CLIENTE DADOS 
        public Clientes ConsultaPeloNome(String nome){
            try {
            //criar sql, organizar e executar
            String sql = "select * from tb_clientes where nome = ?";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            //se encontrar os objetos, irá retornar ele
            Clientes obj = new Clientes();
            if(rs.next()) {
                
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
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
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
                return null;
            }
        }
                
        //METODO BUSCAR CLIENTE POR NOME (PESQUISAR) e retorna uma lista 
     public List<Clientes> buscaClientePeloNome(String nome) {
        try {
            //1criar lista    
            List<Clientes> lista = new ArrayList<>();

            //2criar sql, organizar e executar
            String sql = "select * from tb_clientes where nome like ?";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,nome);
            //resultando do comando
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
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
}

