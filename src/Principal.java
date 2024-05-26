import modelo.Pelicula;
import modelo.Serie;
import modelo.Titulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Principal {
    public void muestraElMenu(){
        int opcion = 0;
        ArrayList<Pelicula> listaDePeliculasDeMaraton = new ArrayList<Pelicula>();
        ArrayList<Serie> listaDeSeriesDeMaraton = new ArrayList<Serie>();
        Scanner teclado = new Scanner(System.in);
        while (opcion != 9){
            String menu = """
                    Bienvenido(a) a Screenmatch
                    1. Registrar nueva pelicula
                    2. Registrar nueva serie
                    3. Calculadora de tiempo de maraton con el contenido registrado
                    
                    9. Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    Pelicula peliculaDelUsuario = new Pelicula();
                    peliculaDelUsuario = agregarPelicula(teclado);
                    listaDePeliculasDeMaraton.add(peliculaDelUsuario);
                    break;
                case 2:
                    Serie serieDelUsuario = new Serie();
                    serieDelUsuario = agregarSerie(teclado);
                    listaDeSeriesDeMaraton.add(serieDelUsuario);
                    break;
                case 3:
                    System.out.println("Ingrese el numero de horas diarias que vera el maraton ");
                    int numeroDeHorasDeMaratonDiario = teclado.nextInt();
                    teclado.nextLine();

                    int cantidadTotalDeMinutosDeMaraton = 0;
                    for (Pelicula peliculaDeMaraton: listaDePeliculasDeMaraton) {
                        cantidadTotalDeMinutosDeMaraton += peliculaDeMaraton.getTiempoDeDuracionEnMinutos();
                    }

                    for (Serie serieDeMaraton: listaDeSeriesDeMaraton) {
                        cantidadTotalDeMinutosDeMaraton += serieDeMaraton.getTiempoDeDuracionEnMinutos();
                    }

                    int cantidadDeDiasDeMaraton = (int) (((cantidadTotalDeMinutosDeMaraton/60)/numeroDeHorasDeMaratonDiario) + 0.5);

                    System.out.println("Numero total de dias que tiene que ver el maraton de series y peliculas para terminar: " + cantidadDeDiasDeMaraton);

                    break;
                case 9:
                    System.out.println("Saliendo del programa....");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
    }

    private Pelicula agregarPelicula(Scanner teclado){
        System.out.println("Ingrese el nombre del titulo de la pelicula");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el año de lanzamiento de la pelicula");
        int fechaDeLaPelicula = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese la duración en minutos de la pelicula");
        int duracionDeLaPelicula = teclado.nextInt();
        teclado.nextLine();

        Pelicula peliculaUsuario = new Pelicula();

        peliculaUsuario.setNombre(nombre);
        peliculaUsuario.setFechaDeLanzamiento(fechaDeLaPelicula);
        peliculaUsuario.setTiempoDeDuracionEnMinutos(duracionDeLaPelicula);

        peliculaUsuario.mostrarFichaTecnica();
        return peliculaUsuario;
    }

    private Serie agregarSerie(Scanner teclado){
        System.out.println("Ingrese el nombre del titulo de la serie");
        String nombreDeLaSerie = teclado.nextLine();
        System.out.println("Ingrese el año de lanzamiento de la serie");
        int fechaDeLaSerie = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el numero de temporadas de la serie");
        int temporadas = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el numero de capitulos por temporada de la serie");
        int capitulosPorTemporada = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese promedio en minutos de los capitulos de la serie");
        int duracionDeLosCapitulos = teclado.nextInt();
        teclado.nextLine();

        Serie serieUsuario = new Serie();

        serieUsuario.setNombre(nombreDeLaSerie);
        serieUsuario.setFechaDeLanzamiento(fechaDeLaSerie);
        serieUsuario.setTemporadas(temporadas);
        serieUsuario.setEpisodiosPorTemporada(capitulosPorTemporada);
        serieUsuario.setDuracionEnMinutosPorEpisodio(duracionDeLosCapitulos);

        serieUsuario.mostrarFichaTecnica();
        return serieUsuario;
    }
}
