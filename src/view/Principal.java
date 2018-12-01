package view;
import controller.Controller_prestacao_contas;
import java.sql.SQLException;
import java.util.Date;
import model.Model_cartao;
import model.Model_funcionario;
import model.Model_prestacao_contas;
public class Principal {
    public static void main(String[] args) throws SQLException {

       Controller_prestacao_contas instancia = new Controller_prestacao_contas();
       Model_prestacao_contas insert = new Model_prestacao_contas();
      // insert.id_funcionario = 2;
      // insert.id_cartao = 3;
       
       //boolean result = instancia.deletar(insert);
      //System.out.println(result);
       
       Model_funcionario chefe = new Model_funcionario();
       chefe.id_funcionario = 1;
       chefe.nome = "filipe";
       String resultado = instancia.listar_aprovados_chefe(chefe);
        System.out.println(resultado);
   /*   if(resultados != null){      ;
        for(Model_prestacao_contas resultado : resultados){
            if(resultado != null){
                 System.out.println(resultado.funcionario + " "+ resultado.valor);
            }
        }
       }else{
        System.out.println("NADA A MOSTRAR");
    }*/
       
    }
}
