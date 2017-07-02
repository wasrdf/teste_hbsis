/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import Modelo.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author washington
 */
public class CountryDAO  {
    
    public List<Country> listarPaises() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT sigla from Country order by 1");
        
        Connection conn = Conexao.conectar();
        try {
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();
            List<Country> listaCountry = new ArrayList<>();
            while(rs.next()) {
                Country c = new Country();
                c.setSigla(rs.getString("sigla"));
                listaCountry.add(c);
            }
            rs.close();
            ps.close();
            return listaCountry;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        
    }
    
}   
