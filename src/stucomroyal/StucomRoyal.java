package stucomroyal;

import java.util.ArrayList;
import tools.Fichero;
import tools.InputData;

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

                    batalla();
                    break;
                case 4:
                    ranking();
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
        System.out.println("3.Empezar batalla ");

        System.out.println("4.Ranking ");

        System.out.println("0. Salir");

    }

    private static void altaCliente() {
        String usuario;
        String password;
        int trofeos = 1;

        usuario = InputData.pedirCadena("Usuario: ");
        password = InputData.pedirCadena("Password: ");
        while (usuario.equals("")) {
            usuario = InputData.pedirCadena("Usuario: ");
        }
        while (password.equals("")) {
            password = InputData.pedirCadena("Password: ");
        }
        Jugador c = new Jugador(usuario, password, trofeos);
        misJugadores.registrarJugador(c);
        miFichero.grabar(misJugadores);
    }

    private static void altaCarta() {
        Tropa t1 = new Tropa(100, "chispitas", 1, 40);
        Tropa t2 = new Tropa(200, "mago", 2, 50);
        Tropa t3 = new Tropa(50, "tesla", 2, 80);

        Hechizo h1 = new Hechizo(100, true, "furia", 2, 50);
        Hechizo h2 = new Hechizo(100, false, "congelar", 2, 30);
        Hechizo h3 = new Hechizo(20, true, "rayo", 2, 10);

        Estructura e1 = new Estructura(100, "Inferno", 2, 100);
        Estructura e2 = new Estructura(50, "Petu", 2, 95);
        Estructura e3 = new Estructura(60, "Eskapulats", 2, 80);

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
        ArrayList<Carta> cartasCopia = new ArrayList<Carta>();

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
            System.out.println("--------------------");
            String nombre = usuario;

            int contador = 0;
            for (Carta j : jugador.getCartas().getLista_carta()) {
                contador++;
            }
            int numero = 6 - contador;
            while (numero > 0) {
                for (Carta cliente : misCartas.getLista_carta()) {

                    String quieres;
                    System.out.println("Nombre: " + cliente.getNombre());
                    System.out.println("Coste Elixir: " + cliente.getCosteElixir());
                    System.out.println("Nivel Vida: " + cliente.getNivelVida());

                    System.out.println("----------------------------------------");
                    quieres = InputData.pedirCadena("Quieres esta carta?: ");
                    if (quieres.equalsIgnoreCase("SI")) {
                        boolean repetida = false;
                        //Comprobar si tiene cartas, si no tiene entra aqui
                        if (jugador.getCartas().getLista_carta().isEmpty()) {
                            System.out.println("Primera Carta Agregada");
                            Carta carta = misCartas.encontrarCarta(cliente.getNombre());
                            jugador.getCartas().registrarCarta(carta);
                            numero--;
                            miFichero.grabar(misJugadores);
                        } //Si ya tiene cartas entra aqui
                        else {

                            for (Carta copia : jugador.getCartas().getLista_carta()) {

                                if (cliente.getNombre().equals(copia.getNombre())) {
                                    System.out.println("-------------------------");
                                    System.out.println("Te quedan por elegir " + numero + " cartas");
                                    System.out.println("-------------------------");
                                    System.out.println("La carta :" + cliente.getNombre() + " ya la tienes");
                                    System.out.println("-------------------------");
                                    break;

                                } else {
                                    System.out.println("La carta: " + cliente.getNombre() + " ha sido agregada.");
                                    numero--;
                                    //Busco la carta y la devuelvo para grabarla
                                    Carta carta = misCartas.encontrarCarta(cliente.getNombre());
                                    //quedan = jugador.getCartas().getLista_carta().size() - contador;
                                    System.out.println("Te quedan por elegir " + numero + " cartas");
                                    jugador.getCartas().registrarCarta(carta);
                                    miFichero.grabar(misJugadores);
                                    break;

                                }

                            }

                        }

                    }
                }

            }

            System.out.println("Has llegado al máximo de cartas disponibles");
            for (Carta j : jugador.getCartas().getLista_carta()) {
                System.out.println("Nombre: " + j.getNombre());
                System.out.println("Coste Elixir: " + j.getCosteElixir());
                System.out.println("Nivel Vida: " + j.getNivelVida());

                System.out.println("----------------------------------------");
            }

        }

    }

    public static void batalla() {
        //Creo dos arrays para guardar las 3 cartas de cada jugador, de esta forma no modifico las oficiales
        ArrayList<Carta> cartasJugador1 = new ArrayList<Carta>();
        ArrayList<Carta> cartasJugador2 = new ArrayList<Carta>();

        //Login de los dos jugadores con un boolean cada uno para comprobar que los dos hacen login correcto
        String usuario1;
        String usuario2;
        String password1;
        String password2;
        boolean comprobado1 = false;
        boolean comprobado2 = false;

        System.out.println("-----------------JUGADOR 1--------------");
        usuario1 = InputData.pedirCadena("Usuario: ");
        password1 = InputData.pedirCadena("Password: ");
        System.out.println("----------------------------------");
        Jugador jugador1 = misJugadores.encontrarJugador(usuario1, password1);

        while (comprobado1 == false) {
//            

            if (jugador1 == null) {
                System.out.println("Este usuario no existe");

            } else {
                System.out.println("Usuario correcto");
                comprobado1 = true;
                int max = 0;

                System.out.println("-----------ESTAS SON TUS CARTAS-------------");
                System.out.println("Escoje 3 cartas de tu mazo");
                System.out.println("--------------------------------------");
                for (Carta player1 : jugador1.getCartas().getLista_carta()) {
                    if (cartasJugador1.size() >= 3) {
                            break;
                        }
                   
                        
                        String elegir;
                        System.out.println("------------------------");
                        System.out.println(player1.getNombre());
                        System.out.println(player1.getCosteElixir());
                        System.out.println("------------------------");
                        elegir = InputData.pedirCadena("Quieres incorporar esta carta a tu mazo?: ");
                        if (elegir.equalsIgnoreCase("SI")) {

                            boolean repetido = false;
                            for (Carta repetidas : cartasJugador1) {

                                if (repetidas.getNombre().equals(player1.getNombre())) {
                                    System.out.println("Esta carta ya la tienes");
                                    //cartasJugador1.remove(repetidas);
                                    repetido = true;
                                }

                            }

                            if (repetido == false) {
                                max = max + player1.getCosteElixir();
                                Carta carta = misCartas.encontrarCarta(player1.getNombre());
                                cartasJugador1.add(carta);
                                System.out.println("Carta Agregada");
                            }
                        }

                    

                }
                System.out.println("Has llegado a tu numero máximo de cartas");

                System.out.println("Estan son tus cartas:");
                for (int i = 0; i < cartasJugador1.size(); i++) {
                    System.out.println(cartasJugador1.get(i));
                }

            }
        }
        System.out.println("-----------------JUGADOR 2--------------");
        usuario2 = InputData.pedirCadena("Usuario: ");
        password2 = InputData.pedirCadena("Password: ");
        System.out.println("----------------------------------");
        Jugador jugador2 = misJugadores.encontrarJugador(usuario2, password2);
         while (comprobado2 == false) {
//            

            if (jugador2 == null) {
                System.out.println("Este usuario no existe");

            } else {
                System.out.println("Usuario correcto");
                comprobado2 = true;
                int max = 0;

                System.out.println("-----------ESTAS SON TUS CARTAS-------------");
                System.out.println("Escoje 3 cartas de tu mazo");
                System.out.println("--------------------------------------");
                for (Carta player2 : jugador2.getCartas().getLista_carta()) {
                    if (cartasJugador2.size() >= 3) {
                            break;
                        }
                   
                        if (cartasJugador2.size() >= 3) {
                            break;
                        }
                        String elegir;
                        System.out.println("------------------------");
                        System.out.println(player2.getNombre());
                        System.out.println(player2.getCosteElixir());
                        System.out.println("------------------------");
                        elegir = InputData.pedirCadena("Quieres incorporar esta carta a tu mazo?: ");
                        if (elegir.equalsIgnoreCase("SI")) {

                            boolean repetido = false;
                            for (Carta repetidas : cartasJugador2) {

                                if (repetidas.getNombre().equals(player2.getNombre())) {
                                    System.out.println("Esta carta ya la tienes");
                                    //cartasJugador1.remove(repetidas);
                                    repetido = true;
                                }

                            }

                            if (repetido == false) {
                                max = max + player2.getCosteElixir();
                                Carta carta = misCartas.encontrarCarta(player2.getNombre());
                                cartasJugador2.add(carta);
                                System.out.println("Carta Agregada");
                            }
                        }

                    

                }
                System.out.println("Has llegado a tu numero máximo de cartas");

                System.out.println("Estan son tus cartas:");
                for (int i = 0; i < cartasJugador2.size(); i++) {
                    System.out.println(cartasJugador2.get(i));
                }

            }
        }

        //Numero random para saber quien ataca primero
        int turno = (int) (Math.random() * 2);
        System.out.println(turno);

        if (turno == 1) {
            for (int i = 0; i < cartasJugador1.size(); i++) {
                if (cartasJugador1.get(i) instanceof Tropa) {
                    cartasJugador2.get(i).setNivelVida(cartasJugador2.get(i).getNivelVida() - (((Tropa) cartasJugador1.get(i)).getNivelAtaque()) / 2);
                    System.out.println("----------------------------");
                    System.out.println("Ataca :" + cartasJugador1.get(i).getNombre());
                    System.out.println("Nivel de Ataque :" + (((Tropa) cartasJugador1.get(i)).getNivelAtaque()));
                    System.out.println("Contricante :" + cartasJugador2.get(i).getNombre());
                    System.out.println("Vida Restante :" + cartasJugador2.get(i).getNivelVida());
                }
                if (cartasJugador1.get(i) instanceof Estructura) {
                    for (int j = 0; j < cartasJugador1.size(); j++) {
                        System.out.println("----------------------------");
                        System.out.println("Carta :" + cartasJugador1.get(i).getNombre());
                        System.out.println("Vida Antes :" + cartasJugador1.get(i).getNivelVida());
                        cartasJugador1.get(j).setNivelVida(((Estructura) cartasJugador1.get(i)).getNivelDefensa() + 8);
                        System.out.println("Vida Después :" + cartasJugador1.get(i).getNivelVida());
                    }
                }
                if (cartasJugador1.get(i) instanceof Hechizo) {

                    boolean dame = (((Hechizo) cartasJugador1.get(i)).getModo());
                    if (dame == true) {
                        System.out.println("----------------------------");
                        System.out.println("Modo Ataque");
                        System.out.println("Ataca :" + cartasJugador1.get(i).getNombre());
                        System.out.println("Nivel Ataque :" + (((Hechizo) cartasJugador1.get(i)).getNivelAlcance()) * 2 / 3);
                        for (int j = 0; j < cartasJugador2.size(); j++) {
                            System.out.println("----------------------------");
                            System.out.println("Defiende :" + cartasJugador2.get(i).getNombre());
                            System.out.println("Vida Antes :" + cartasJugador2.get(i).getNivelVida());
                            cartasJugador2.get(j).setNivelVida(cartasJugador2.get(j).getNivelVida() - (((Hechizo) cartasJugador1.get(i)).getNivelAlcance()) * 2 / 3);
                            System.out.println("Vida Después :" + cartasJugador2.get(i).getNivelVida());
                        }
                    } else {
                        System.out.println("----------------------------");
                        System.out.println("Modo Defensa");
                        System.out.println("Ataca :" + cartasJugador1.get(i).getNombre());
                        System.out.println("Nivel Ataque :" + (((Hechizo) cartasJugador1.get(i)).getNivelAlcance()) * 2 / 3);
                        for (int j = 0; j < cartasJugador1.size(); j++) {
                            System.out.println("----------------------------");
                            System.out.println("Defiende :" + cartasJugador2.get(i).getNombre());
                            System.out.println("Vida Antes :" + cartasJugador2.get(i).getNivelVida());
                            cartasJugador1.get(j).setNivelVida(cartasJugador1.get(j).getNivelVida() + (((Hechizo) cartasJugador1.get(i)).getNivelAlcance()) * 2 / 3);
                            System.out.println("Vida Después :" + cartasJugador2.get(i).getNivelVida());
                            System.out.println("----------------------------");
                        }
                    }

                }

            }
        }

        if (turno == 0) {
            for (int i = 0; i < cartasJugador2.size(); i++) {
                if (cartasJugador2.get(i) instanceof Tropa) {
                    cartasJugador1.get(i).setNivelVida(cartasJugador1.get(i).getNivelVida() - (((Tropa) cartasJugador2.get(i)).getNivelAtaque()) / 2);
                    System.out.println("----------------------------");
                    System.out.println("Ataca :" + cartasJugador2.get(i).getNombre());
                    System.out.println("Nivel de Ataque :" + (((Tropa) cartasJugador2.get(i)).getNivelAtaque()));
                    System.out.println("Contricante :" + cartasJugador1.get(i).getNombre());
                    System.out.println("Vida Restante :" + cartasJugador1.get(i).getNivelVida());
                    System.out.println("----------------------------");
                }
                if (cartasJugador2.get(i) instanceof Estructura) {
                    for (int j = 0; j < cartasJugador2.size(); j++) {
                        System.out.println("----------------------------");
                        System.out.println("Carta :" + cartasJugador2.get(i).getNombre());
                        System.out.println("Vida Antes :" + cartasJugador2.get(i).getNivelVida());
                        cartasJugador2.get(j).setNivelVida(((Estructura) cartasJugador2.get(i)).getNivelDefensa() + 8);
                        System.out.println("Vida Después :" + cartasJugador2.get(i).getNivelVida());
                    }
                }
                if (cartasJugador2.get(i) instanceof Hechizo) {

                    boolean dame = (((Hechizo) cartasJugador2.get(i)).getModo());
                    if (dame == true) {
                        System.out.println("----------------------------");
                        System.out.println("Modo Ataque");
                        System.out.println("Ataca :" + cartasJugador2.get(i).getNombre());
                        System.out.println("Nivel Ataque :" + (((Hechizo) cartasJugador2.get(i)).getNivelAlcance()) * 2 / 3);
                        System.out.println("----------------------------");
                        for (int j = 0; j < cartasJugador1.size(); j++) {
                            System.out.println("Defiende :" + cartasJugador1.get(i).getNombre());
                            System.out.println("Vida Antes :" + cartasJugador1.get(i).getNivelVida());
                            cartasJugador1.get(j).setNivelVida(cartasJugador1.get(j).getNivelVida() - (((Hechizo) cartasJugador2.get(i)).getNivelAlcance()) * 2 / 3);
                            System.out.println("Vida Después :" + cartasJugador1.get(i).getNivelVida());

                        }
                    }
                } else {
                    System.out.println("----------------------------");
                    System.out.println("Modo Defensa");
                    System.out.println("Ataca :" + cartasJugador2.get(i).getNombre());
                    System.out.println("Nivel Ataque :" + (((Hechizo) cartasJugador2.get(i)).getNivelAlcance()) * 2 / 3);
                    System.out.println("----------------------------");
                    for (int j = 0; j < cartasJugador2.size(); j++) {
                        System.out.println("Defiende :" + cartasJugador1.get(i).getNombre());
                        System.out.println("Vida Antes :" + cartasJugador1.get(i).getNivelVida());
                        cartasJugador2.get(j).setNivelVida(cartasJugador2.get(j).getNivelVida() + (((Hechizo) cartasJugador2.get(i)).getNivelAlcance()) * 2 / 3);
                        System.out.println("Vida Después :" + cartasJugador1.get(i).getNivelVida());
                        System.out.println("----------------------------");
                    }
                }

            }

        }
        int totalVida1 = 0;
        int totalVida2 = 0;
        for (int j = 0; j < cartasJugador1.size(); j++) {
            totalVida1 += cartasJugador1.get(j).getNivelVida();

        }
        for (int j = 0; j < cartasJugador2.size(); j++) {
            totalVida2 += cartasJugador2.get(j).getNivelVida();

        }
        System.out.println("---------FINAL-------");
        if (totalVida1 > totalVida2) {
            // jugador1.setTrofeo(1);
            // jugador1.setTrofeos(5);
            misJugadores.definirTrofeos(jugador1, 5);
            miFichero.grabar(misJugadores);
            System.out.println("Ganador Jugador 1");
            if(totalVida1<0){
                System.out.println("Vida Final Jugador 1 : 0");
            }else{
                System.out.println("Vida Final Jugador 1 :" + totalVida1);
            }
            if(totalVida2<0){
                System.out.println("Vida Final Jugador 2 : 0");
            }else{
                System.out.println("Vida Final Jugador 2 :" + totalVida2);
            }
            
        } else 
            if (totalVida1 < totalVida2) {
            // jugador2.setTrofeos(5);
            misJugadores.definirTrofeos(jugador2, 5);
            miFichero.grabar(misJugadores);
            miFichero.grabar(misJugadores);
            System.out.println("Ganador Jugador 2 ");
             if(totalVida1<0){
                System.out.println("Vida Final Jugador 1 : 0");
            }else{
                System.out.println("Vida Final Jugador 1 :" + totalVida1);
            }
            if(totalVida2<0){
                System.out.println("Vida Final Jugador 2 : 0");
            }else{
                System.out.println("Vida Final Jugador 2 :" + totalVida2);
            }
        }
        if (totalVida1 == totalVida2) {
            System.out.println("Empate");
              if(totalVida1<0){
                System.out.println("Vida Final Jugador 1 : 0");
            }else{
                System.out.println("Vida Final Jugador 1 :" + totalVida1);
            }
            if(totalVida2<0){
                System.out.println("Vida Final Jugador 2 : 0");
            }else{
                System.out.println("Vida Final Jugador 2 :" + totalVida2);
            }
        }
    }
public static void ranking(){
   
    
    
    
    
}
}
