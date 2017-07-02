/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 *
 * @author washington
 */
public class Wind {
    
    @SerializedName("speed")
    private BigDecimal speed;
    @SerializedName("deg")
    private BigDecimal deg;

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getDeg() {
        return deg;
    }

    public void setDeg(BigDecimal deg) {
        this.deg = deg;
    }

   
    
}
