/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import tools.Fichero;
import tools.InputData;

/**
 *
 * @author 46989075y
 */
public class StucomRoyal {

    /**
     * @param args the command line arguments
     */
    private static listaJugadores misJugadores;
            private static Fichero miFichero;
    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        miFichero = new Fichero("jugadores.xml");//Si no ponemos ruta absoluta lo creara en la raiz del proyecto
        misJugadores = (listaJugadores) miFichero.leer();
        if (misJugadores == null) {
            misJugadores = new listaJugadores();
        }
        int opcion;
        do {
            mostrarMenu();
            opcion = InputData.pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    
                    break;
                case 3:
                  
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                   
                    break;
                case 7:
                   
                    break;
                case 0:
                    System.out.println("Hasta luegoooo!!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("*****STUCOMROYAL****");
        System.out.println("1.Alta Jugador");
        System.out.println("2.Nuevo presupuesto");
        System.out.println("3.Presupuestos pendientes ");
        System.out.println("4.Listado de presupuestos de un cliente determinado");
        System.out.println("5.Listado de presupuestos rechazados");
        System.out.println("6.Listado de clientes, donde aparezca también el total de presupuestos\n"
                + "que tiene cada uno.");
        System.out.println("7.Cambiar estado de un presupuesto.");
        System.out.println("0. Salir");
    }
 private static void altaCliente() {
        String usuario;
        String password;
        int trofeos=0;
        
        usuario = InputData.pedirCadena("Usuario: ");
        password = InputData.pedirCadena("Password: ");
       
        
           
           
         
        Jugador c = new Jugador(usuario, password, trofeos);
        misJugadores.registrarJugador(c);
        miFichero.grabar(misJugadores);
    }
    }
    

