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
public class Tropa extends Carta {
    private double nivelAtaque;
    
    public Tropa(){
        
    }
    public Tropa(double nivelAtaque,String nombre,int costeElixir, int nivelVida) {
        super( nombre, costeElixir, nivelVida);
       
         this.nivelAtaque = nivelAtaque;
    }

    public double getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(double nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    @Override
    public String toString() {
        return "tropa{" + "nivelAtaque=" + nivelAtaque + '}';
    }
}
    
    
    
    
    

