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

    private static listaJugadores misJugadores;
    private static listaCartas misCartas;
    private static Fichero miFichero;
    private static Fichero ficheroCartas;

    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        miFichero = new Fichero("jugadores.xml");//Si no ponemos ruta absoluta lo creara en la raiz del proyecto
        misJugadores = (listaJugadores) miFichero.leer();
        if (misJugadores == null) {
            misJugadores = new listaJugadores();
        }

        Carta carta = new Carta();
        ficheroCartas = new Fichero("cartas.xml");//Si no ponemos ruta absoluta lo creara en la raiz del proyecto
        misCartas = (listaCartas) ficheroCartas.leer();
        if (misCartas == null) {
            misCartas = new listaCartas();
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
                    loginJugador();
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
        System.out.println("2.Login Jugador");
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
        int trofeos = 0;

        usuario = InputData.pedirCadena("Usuario: ");
        password = InputData.pedirCadena("Password: ");

        Jugador c = new Jugador(usuario, password, trofeos);
        misJugadores.registrarJugador(c);
        miFichero.grabar(misJugadores);
    }

    private static void altaCarta() {
        Tropa t1 = new Tropa(100.0, "chispitas", 6, 100);
        Tropa t2 = new Tropa(200.0, "mago", 4, 50);
        Tropa t3 = new Tropa(50.0, "tesla", 3, 80);

        Hechizo h1 = new Hechizo(100.0, true, "furia", 3, 0);
        Hechizo h2 = new Hechizo(100.0, false, "congelar", 4, 0);
        Hechizo h3 = new Hechizo(20.0, true, "rayo", 2, 0);

        Estructura e1 = new Estructura(200.0, "Inferno", 4, 100);
        Estructura e2 = new Estructura(100.0, "Petu", 2, 50);
        Estructura e3 = new Estructura(250.0, "Eskapulats", 8, 300);

        misCartas.registrarCarta(t1);
        misCartas.registrarCarta(t2);
        misCartas.registrarCarta(t3);

        misCartas.registrarCarta(h1);
        misCartas.registrarCarta(h2);
        misCartas.registrarCarta(h3);

        misCartas.registrarCarta(e1);
        misCartas.registrarCarta(e2);
        misCartas.registrarCarta(e3);

        ficheroCartas.grabar(misCartas);
    }

    private static void loginJugador() {

        String usuario;
        String password;

        usuario = InputData.pedirCadena("Usuario: ");
        password = InputData.pedirCadena("Password: ");
        Jugador jugador = misJugadores.encontrarJugador(usuario, password);

        if (jugador == null) {
            System.out.println("Este usuario no existe");
            String crear;

            crear = InputData.pedirCadena("Quieres crearlo?");
            if (crear.equalsIgnoreCase("SI")) {
                altaCliente();
            }
        } else {
            System.out.println("Login Correcto");
            String nombre = usuario;

            int contador = 0;

            for (Carta cliente : misCartas.getLista_carta()) {

                String quieres;
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Coste Elixir: " + cliente.getCosteElixir());
                System.out.println("Nivel Vida: " + cliente.getNivelVida());

                System.out.println("----------------------------------------");
                quieres = InputData.pedirCadena("Quieres esta carta?: ");
                if (quieres.equalsIgnoreCase("SI")) {
                    if(jugador.getCartas().getLista_carta().size()==0){
                         System.out.println("agregada");
                              Carta carta = misCartas.encontrarCarta(cliente.getNombre());

                            jugador.getCartas().registrarCarta(carta);
                               miFichero.grabar(misJugadores);
                    }else{
                    System.out.println(jugador.getUsuario() + " " + jugador.getCartas().getLista_carta().size());
                     for (Carta j : jugador.getCartas().getLista_carta()) {
                         
                          int quedan = jugador.getCartas().getLista_carta().size() - contador;
                          System.out.println("Te quedan por elegir " + quedan + " cartas");
                          contador++;
                          if (cliente.getNombre().equals(j.getNombre())) {
                                System.out.println("Esta carta ya la tienes");
                                contador--;
                                break;
                            }else{
                              System.out.println("agregada");
                              
                              Carta carta = misCartas.encontrarCarta(cliente.getNombre());
                              quedan = jugador.getCartas().getLista_carta().size() - contador;
                             System.out.println("Te quedan por elegir " + quedan + " cartas");
                            jugador.getCartas().registrarCarta(carta);
                               miFichero.grabar(misJugadores);
                        break;
//                            contador++;
//                            
                                

                               
                          }
                         
                     }
                            
                    //Comprobar si la carta que quiere agregar ya la tiene
                   
                       
                              
                                
                            

                        
                    }  

                }

            }
           
        }

    }

}
