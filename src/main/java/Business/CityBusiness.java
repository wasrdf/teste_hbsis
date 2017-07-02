/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.CityDAO;
import Modelo.City;
import java.util.List;

/**
 *
 * @author washington
 */
public class CityBusiness {
    /**
     * Metodo responsavel por listar as cidades da tabela city passando como parametro o país.
     * @param sigla
     * @return 
     */
    public List<City> listarCidadePorPais(String sigla) {
        CityDAO cityDAO = new CityDAO();
        return cityDAO.listarCity(sigla);
    }
    
    
    /**
     * Metodo responsavel por listar as cidades da tabela city passando como parametro o país.
     * @param id
     * @return 
     */
    public City obterCity(Integer id) {
        CityDAO cityDAO = new CityDAO();
        return cityDAO.obterCity(id);
    }
    
}
