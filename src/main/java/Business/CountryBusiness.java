/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.CountryDAO;
import Modelo.Country;
import java.util.List;

/**
 *
 * @author washington
 */
public class CountryBusiness {
     /**
     * Metodo responsavel por listar todos os paises da Tabela Country;
     * @return 
     */
    public List<Country> listarPaises() {
        CountryDAO countryDAO = new CountryDAO();
        return countryDAO.listarPaises();
    }
}
