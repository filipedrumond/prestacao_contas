package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Connection;
import java.util.Random;

public class Model_cartao {
    public String validade;
    public String nome_impresso;
    public String cod_seguranca;
    public int id_funcionario;
    private final Connection conn;
    public Model_cartao() {
       this.conn  = ConnectionDB.getConnection();
    }
    public Model_cartao[] listar_cartao_usuario(int id_funcionario) throws SQLException{
        String query = "select * from cartoes where id_funcionario = ?;";
        try (PreparedStatement  pst = conn.prepareStatement(query)) {
            pst.setInt (1, id_funcionario);
            int tamanho = 128;
            Model_cartao[] resultado = new Model_cartao[tamanho];
            int counter = 0;  
            try {
                ResultSet rs = pst.executeQuery();
                System.out.println(pst);
                counter = 0;
                while (rs.next())
                {
                    resultado[counter]= new Model_cartao();
                    resultado[counter].validade = rs.getString("validade");
                    resultado[counter].nome_impresso = rs.getString("nome_impresso");
                    resultado[counter].cod_seguranca = rs.getString("cod_seguranca");
                    resultado[counter].id_funcionario = rs.getInt("id_funcionario");
                counter++;
                }
            }            
            catch(SQLException e){ System.out.println(e); }
            if(counter !=0){ return resultado;}
            else{ return null; }
        }
    }
    public boolean inserir(int id_funcionario) throws SQLException{
        Model_funcionario instancia_func = new Model_funcionario();
        Model_funcionario dados_aux = instancia_func.selecionar(id_funcionario);
        String query = "insert into cartoes(validade,nome_impresso,cod_seguranca,id_funcionario) values(?,?,?,?);";
        try (PreparedStatement  st = conn.prepareStatement(query)) {
            Random rand = new Random();
            int n = rand.nextInt(999) + 100;
            st.setString (1, "05/22");
            st.setString (2, dados_aux.nome);
            st.setString (3, String.valueOf(n));
            st.setInt (4, id_funcionario);
            return st.execute();
        } 
    }
    public boolean deletar(int id_funcionario) throws SQLException{
        String query = "delete from cartoes where id_funcionario = ?;";
        try (PreparedStatement  st = conn.prepareStatement(query)) {
            st.setInt (1, id_funcionario);
            return st.execute();
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
}
