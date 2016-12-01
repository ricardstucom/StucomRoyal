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
public class Jugador {
    private String usuario;
    private String password;
    private int trofeos;
    private listaCartas cartas;

    public Jugador(String usuario, String password, int trofeos) {
        this.usuario = usuario;
        this.password = password;
        this.trofeos = trofeos;
        cartas = new listaCartas();
    }

    public Jugador() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    public listaCartas getCartas() {
        return cartas;
    }


    public void setCartas(listaCartas cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Jugador{" + "usuario=" + usuario + ", password=" + password + ", trofeos=" + trofeos + ", cartas=" + cartas + '}';
    }

    

    

    
    
    
}
