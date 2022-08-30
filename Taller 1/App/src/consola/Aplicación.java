package consola;

import modelo.Restaurante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class Aplicación {
	
	private Restaurante elRestaurante;
	
	public void ejecutarAplicacion()
	{
		System.out.println("Menú creador de Restaurante\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCrearRestaurante();
				else if (opcion_seleccionada == 2 && elRestaurante != null)
					ejecutarAtletasPorAnio();
				else if (opcion_seleccionada == 3 && elRestaurante != null)
					ejecutarMedallasEnRango();
				else if (opcion_seleccionada == 4 && elRestaurante != null)
					ejecutarAtletasPorPais();
				else if (opcion_seleccionada == 5 && elRestaurante != null)
					ejecutarPaisConMasMedallistas();
				else if (opcion_seleccionada == 6 && elRestaurante != null)
					ejecutarMedallistasPorEvento();
				else if (opcion_seleccionada == 7)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (elRestaurante == null)
				{
					System.out.println("Para poder ejecutar esta "
							+ "opción primero debe crear el restaurante.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public void mostrarMenu()
	{
		System.out.println("\n Opciones de la aplicación creador\n");
		System.out.println("1. Crear un restaurante");
		System.out.println("2. Crear pedido ");
		System.out.println("3. Consultar menu");
		System.out.println("4. Consultar ");
		System.out.println("5. Consultar ");
		System.out.println("6. Consultar ");
		System.out.println("7. Salir de la aplicación\n");
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	private void ejecutarCrearRestaurante()
	{
		this.elRestaurante = new Restaurante();
		System.out.println("\n" + "Creador del restaurante" + "\n");
		
		String nombreRestaurante = input("Por favor "
				+ "ingrese el nombre del restaurante");
		
		System.out.println("\n" + "Bienvenido a " + nombreRestaurante + "\n");
		ejecutarCargaRestaurante();
	}
	
	private void ejecutarCargaRestaurante()
	{
		System.out.println("\n" + "Carga datos restaurante" + "\n");

		String nombreIngredientes = input("Por favor "
				+ "ingrese el nombre del archivo TXT con los ingredientes");
		String nombreMenu = input("Por favor "
				+ "ingrese el nombre del archivo TXT con los productos del menú");
		String nombreCombos = input("Por favor "
				+ "ingrese el nombre del archivo TXT con los combos");
		
		try
		{
			File archivoIngredientes = new File("./data/" + nombreIngredientes);
			File archivoMenu = new File("./data/" + nombreMenu);
			File archivoCombos = new File("./data/" + nombreCombos);
			this.elRestaurante.cargarInformacionRestaurante(
					archivoIngredientes, archivoMenu, archivoCombos);
			System.out.println("Se cargaron los archivos del restaurante correctamente.");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: alguno de los archivos indicados no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		Aplicación consola = new Aplicación();
		consola.ejecutarAplicacion();
	}
}
