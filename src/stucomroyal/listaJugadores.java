/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 46989075y
 */
public class listaJugadores implements Serializable {
     private ArrayList<Jugador> lista_jugadores; 
     public listaJugadores(){
     lista_jugadores = new ArrayList<>();
 }
    public void registrarJugador(Jugador p){
       
     lista_jugadores.add(p);
 }
    
    public ArrayList<Jugador> getlista_jugadores() {
        return lista_jugadores;
    }

    public void setlista_jugadores(ArrayList<Jugador> lista_jugadores) {
        this.lista_jugadores = lista_jugadores;
    }

    public ArrayList<Jugador> getLista_jugadores() {
        return lista_jugadores;
    }
   
    public void definirTrofeos (Jugador p, int trofeos){
        for(Jugador juga : lista_jugadores){
            if(p.getUsuario().equals(juga.getUsuario())){
                juga.setTrofeos(juga.getTrofeos()+trofeos);
            }
        }
    }
    public Jugador encontrarJugador(String usuario, String password){
     for(Jugador jugador : lista_jugadores){
         if(jugador.getUsuario().equals(usuario)&& jugador.getPassword().equals(password) ){
             return jugador;
         }
     }
return null;
 }
     public Jugador encontrarTrofeos(){
     for(Jugador jugador : lista_jugadores){
         
             return jugador;
         
     }
return null;
     }
    
}



