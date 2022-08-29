package consola;

import consola.Aplicación;
import modelo.Restaurante;
import java.io.File;

public class Aplicación {



public static void main(String[] args)
{
	Restaurante elrestaurante = new Restaurante();
	File archivoIngredientes = new File("./data/ingredientes.csv");
	File archivoMenu = new File("./data/menu.csv");
	File archivoCombos = new File("./data/combos.csv");
	elrestaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
}
}
