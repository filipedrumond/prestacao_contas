/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Model_funcionario;
import model.Model_prestacao_contas;

/**
 *
 * @author filip
 */
public class Controller_prestacao_contas {
    public Model_prestacao_contas instancia;

    
    public Controller_prestacao_contas() {
        instancia = new Model_prestacao_contas();
    } 
    
    public String inserir(Model_prestacao_contas novo_registro,Model_funcionario usuario){
        try{
            boolean result = instancia.inserir(novo_registro);
            return "Atualizado com sucesso"; 
        }catch(SQLException e){      
            return "ERRO AO ATUALIZAR";   
        }
    }
    public String listar_aprovados_chefe(Model_funcionario chefe) throws SQLException{
        try{
            Model_prestacao_contas[] result = instancia.listar_aprovacao_chefe(chefe);
            return tabelar(result);
        }catch(SQLException e){
            return "ERRO DESCONHECIDO "+ e;
        }
    }
    public String tabelar(Model_prestacao_contas[] dados){
        String retorno ="|- NOME FUNC -|- TIPO PREST -|- NOME CARTAO -|- TIPO DESPESA -|- STATUS -|- VALOR -|"
                + "- DATA -|- DESCRICAO -|- APROVADO POR -|";
        if(dados != null){
            for(Model_prestacao_contas resultado : dados){
                if(resultado != null){
                    if(resultado.nome_impresso_no_cartao == null){
                        resultado.nome_impresso_no_cartao = "S/ cartao";
                    }
                    retorno += "\n| "+resultado.funcionario+" | "+resultado.tipo_prestacao+" | "+resultado.nome_impresso_no_cartao+" | "
                            +resultado.tipo_despesa+" | "+resultado.tipo_aprovacao+" | "+resultado.valor+" | "
                            +resultado.data+" | "+resultado.descricao+" | "+resultado.chefe+" |";
                }
            }
        }
        return retorno;
    }
}
