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
public class Hechizo extends Carta {
    private double nivelAlcance;
    private boolean modo;

    
    
    public Hechizo(){
        
    }
    
    public Hechizo(double nivelAlcance, boolean modo, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAlcance = nivelAlcance;
        this.modo = modo;
    }

    public double getNivelAlcance() {
        return nivelAlcance;
    }

    public void setNivelAlcance(double nivelAlcance) {
        this.nivelAlcance = nivelAlcance;
    }

    public boolean isModo() {
        return modo;
    }

    public void setModo(boolean modo) {
        this.modo = modo;
    }

    @Override
    public String toString() {
        return "hechizo{" + "nivelAlcance=" + nivelAlcance + ", modo=" + modo + '}';
    }
    
}
