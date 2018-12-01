package prestacao_contas;
import java.sql.SQLException;
import java.util.Date;
import model.Model_cartao;
import model.Model_funcionario;
import model.Model_prestacao_contas;
public class Prestacao_contas {
    public static void main(String[] args) throws SQLException {

       Model_cartao instancia = new Model_cartao();
       Model_cartao insert = new Model_cartao();
       insert.id_funcionario = 1;
       insert.id_cartao = 3;
       
       boolean result = instancia.deletar(insert);
       System.out.println(result);
           
       Model_cartao[] resultados = instancia.listar_cartao_usuario(insert);
       for(Model_cartao resultado : resultados){
           if(resultado != null){
                System.out.println(resultado.nome_impresso + " "+ resultado.cod_seguranca);
           }
       }
       
    }
}
