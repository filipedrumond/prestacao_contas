package prestacao_contas;
import java.sql.SQLException;
import model.Model_funcionario;
import model.Model_tipo_funcionario;
public class Prestacao_contas {
    public static void main(String[] args) throws SQLException {
        Model_funcionario intancia_func = new Model_funcionario();
        //Model_tipo_funcionario resultado = intancia_func.selecionar_id(1);
       // System.out.println(resultado.tipo_funcionario);
        Model_funcionario[] resultados = intancia_func.logar("Filipe Dru","123qwe!@#");
        for (Model_funcionario resultado : resultados) {
            if (resultado != null) {
                System.out.println(resultado.tipo_funcionario +" "+ resultado.nome);
            }
        }
    }
}
