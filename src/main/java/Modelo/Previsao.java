/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author washington
 */
public class Previsao implements Serializable {

    @SerializedName("list")
    List<ForCast> list = new ArrayList<>();
    
    public List<ForCast> getList() {
        return list;
    }

    public void setList(List<ForCast> list) {
        this.list = list;
    }

}
