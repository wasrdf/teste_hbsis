/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import Modelo.Cidade;
import Modelo.City;
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
public class CidadeDAO {

    public Boolean inserirCidade(Cidade cidade) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO CIDADE (id_cidade) values (?)");
        Connection conn = Conexao.conectar();
        try {
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, cidade.getCity().getId());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

    public List<Cidade> listarCidades() {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM Cidade ");
        sb.append("INNER JOIN City on city.id = cidade.id_cidade order by city.name");

        Connection conn = Conexao.conectar();
        try {
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();
            List<Cidade> cidades = new ArrayList<>();
            while (rs.next()) {
                Cidade c = new Cidade();
                c.setCodigo(rs.getInt("codigo"));
                City city = new City();
                city.setId(rs.getInt("id_cidade"));
                city.setName(rs.getString("name"));
                c.setCity(city);
                cidades.add(c);
            }
            rs.close();
            ps.close();
            return cidades;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
