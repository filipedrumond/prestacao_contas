package prestacao_contas;
import java.sql.SQLException;
import model.Model_funcionario;
public class Prestacao_contas {
    public static void main(String[] args) throws SQLException {
        Model_funcionario intancia_func = new Model_funcionario();
        //Model_tipo_funcionario resultado = intancia_func.selecionar_id(1);
       // System.out.println(resultado.tipo_funcionario);
        Model_funcionario resultado = intancia_func.selecionar(1);

        
        System.out.println(resultado.tipo_funcionario +" "+ resultado.nome);
            
        
    }
}
