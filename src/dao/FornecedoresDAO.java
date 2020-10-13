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
import model.Fornecedores;

/**
 *
 * @author Rafael
 */
public class FornecedoresDAO {
    private Connection conexao;

    //objeto que o banco de dados guarda com o Connection é somente chamar o objeto do tipo conexao
    public FornecedoresDAO() {
        this.conexao = new Conectar().getConnection();

    }
    //Metodo Cadastrar Fornecedor
    public void cadastrarFornecedor(Fornecedores obj) {
        try {
            //criar comando sql 
            String sql = "insert into tb_fornecedores(nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            //conectar banco de dados e organizar o sql 
            // tratar os comandos sqls e executar (preparedstatement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCNPJ());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());

            //executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
         //Metodo Alterar Fornecedor
    public void alterarFornecedor(Fornecedores obj) {
        try {
            //criar comando sql 
            String sql = "update tb_fornecedores set nome=?,cnpj=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id =?";
            

            //conectar banco de dados e organizar o sql 
            // tratar os comandos sqls e executar (preparedstatement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCNPJ());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            //com base no id alterar o resto
            stmt.setInt(13, obj.getId());

            //executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Excluir Fornecedor
    public void excluirFornecedor(Fornecedores obj) {
        try {
            //criar comando sql 
            String sql = "delete from tb_fornecedores where id = ?";
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
    //Metodo ListarFornecedores
    public List<Fornecedores> listarFornecedores() {
        try {
            //1criar lista    
            List<Fornecedores> lista = new ArrayList<>();

            //2criar sql, organizar e executar
            String sql = "select * from tb_fornecedores";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //resultando do comando
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCNPJ(rs.getString("cnpj"));
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

    //METODO CONSULTA FORNECEDOR DADOS 
    public List<Fornecedores> listarFornecedoresPeloNome(String Nome) {
        try {
            //1criar lista    
            List<Fornecedores> lista = new ArrayList<>();

            //2criar sql, organizar e executar
            String sql = "select * from tb_fornecedores where nome like ?";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,Nome);
            //resultando do comando
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCNPJ(rs.getString("cnpj"));
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
    //metodo consultaFornecedoresPorNome
    
        public Fornecedores ConsultaPeloNome(String nome){
            try {
            //criar sql, organizar e executar
            String sql = "select * from tb_fornecedores where nome = ?";
            //chamar a conexão
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            //se encontrar os objetos, irá retornar ele
            Fornecedores obj = new Fornecedores();
            if(rs.next()) {
                
                //armazenar dentro do objeto id
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCNPJ(rs.getString("cnpj"));
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
    
}
