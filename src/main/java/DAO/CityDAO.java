/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import Modelo.City;
import Modelo.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author washington
 */
public class CityDAO {
    
    public List<City> listarCity(String sigla) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM City where sigla = '").append(sigla).append("'").append(" order by  name" );
        System.out.println(sb.toString());
        Connection conn = Conexao.conectar();
        try {
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();
            List<City> cities = new ArrayList<>();
            while(rs.next()) {
                City city = new City();
                Country c = new Country();
                c.setSigla(rs.getString("sigla"));
                city.setCountry(c);
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                cities.add(city);
            }
            rs.close();
            ps.close();
            return cities;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public City obterCity(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM City where id = ").append(id);
        System.out.println(sb.toString());
        Connection conn = Conexao.conectar();
        try {
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();            
            City city = new City();
            if(rs.next()) {                
                Country c = new Country();
                c.setSigla(rs.getString("sigla"));
                city.setCountry(c);
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));                
            }
            rs.close();
            ps.close();
            return city;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
}
