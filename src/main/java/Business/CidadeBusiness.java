/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.CidadeDAO;
import Modelo.Cidade;
import java.util.List;

/**
 *
 * @author washington
 */
public class CidadeBusiness {
    
    CidadeDAO cidadeDAO;
    /**
     * metodo responsavel por inserir cidade na tabela cidade
     * @param cidade
     * @return 
     */
    public Boolean inserirCidade(Cidade cidade) {
        cidadeDAO = new CidadeDAO();
        return cidadeDAO.inserirCidade(cidade);
    }
    
    /**
     * metodo responsavel por listar as cidades da tabela cidade
     * @return 
     */
    public List<Cidade> listarCidades() {
        cidadeDAO = new CidadeDAO();
        return cidadeDAO.listarCidades();
    }
    
}
