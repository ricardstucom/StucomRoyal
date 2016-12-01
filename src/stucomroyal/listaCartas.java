/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 46989075y
 */
public class listaCartas implements Serializable {
    private ArrayList<Carta>lista_carta;
    public listaCartas(){
        lista_carta = new ArrayList<>();
    }
 public void registrarCarta(Carta p){
       
     lista_carta.add(p);
 }
    public ArrayList<Carta> getLista_carta() {
        return lista_carta;
    }

    public void setLista_carta(ArrayList<Carta> lista_carta) {
        this.lista_carta = lista_carta;
    }

      public List<Carta> found (){
         return lista_carta;
    }
    public Carta encontrarCarta(String nombre){
     for(Carta carta : lista_carta){
         if(carta.getNombre().equals(nombre) ){
             return carta;
         }
     }
return null;
 }
}
