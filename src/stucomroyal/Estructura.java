/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

/**
 *
 * @author 46989075y
 */
public class Estructura extends Carta {
    private double nivelDefensa;

    
    
    public Estructura(){
        
    }
    public Estructura(double nivelDefensa, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelDefensa = nivelDefensa;
    }

    public double getNivelDefensa() {
        return nivelDefensa;
    }

    public void setNivelDefensa(double nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    @Override
    public String toString() {
        return "estructura{" + "nivelDefensa=" + nivelDefensa + '}';
    }
    
}
