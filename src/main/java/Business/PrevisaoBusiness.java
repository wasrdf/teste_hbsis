/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Modelo.ForCast;
import Modelo.Previsao;
import Modelo.Weather;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author washington
 */
public class PrevisaoBusiness {

    /**
     * Metodo responsavel por obter o forCast de 5 dias da API Weather
     *
     * @param codCididade
     * @return
     */
    public Previsao obterPrevisao(Integer codCididade) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://api.openweathermap.org/data/2.5/forecast?id=" + codCididade + "&lang=pt&units=metric&appid=eb8b1a9405e659b2ffc78f0a520b1a46");
            Response response = target.request().get();
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            List<Previsao> retorno = new ArrayList<>();
            String json = response.readEntity(String.class);
            Previsao previsao = new Previsao();
            if (!(json.equals("")) || !(json.equals("[]"))) {
                Gson gson = new Gson();
                Previsao array = gson.fromJson(json, Previsao.class);
                previsao = array;
            }

            for (ForCast f : previsao.getList()) {
                if (f.getData() != null || f.getData().equals("")) {                    
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        f.setDataPrevisao(formatter.parse(f.getData().trim()));
                    } catch (ParseException ex) {                        
                        System.out.println(ex.getMessage());
                        throw new RuntimeException(ex.getMessage());
                    }
                }
                for (Weather weather : f.getWeather()) {
                       f.setClima(weather.getDescription());
                }
                
            }
            return previsao;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
