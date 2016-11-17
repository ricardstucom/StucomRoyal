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
public class tropa extends carta {
    private double nivelAtaque;
    private double calcularNivelAtaque;
    
    public tropa(double nivelAtaque,double calcularNivelAtaque,String nombre,int costeElixir, int nivelVida) {
        super( nombre, costeElixir, nivelVida);
        this.calcularNivelAtaque = calcularNivelAtaque;
         this.nivelAtaque = nivelAtaque;
    }

    public double getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(double nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public double getCalcularNivelAtaque() {
        return calcularNivelAtaque;
    }

    public void setCalcularNivelAtaque(double calcularNivelAtaque) {
        this.calcularNivelAtaque = calcularNivelAtaque;
    }
    
    
    
    
    
}
