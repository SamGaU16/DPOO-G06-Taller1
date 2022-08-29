package procesamiento;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.BufferedReader;
import modelo.Ingrediente;
import modelo.Combo;
import modelo.ProductoMenu;
import modelo.Producto;


public class CargaRestaurante {


public static Map<String, Ingrediente> cargarIngredientes(String Filedata) throws FileNotFoundException, IOException
	{
		Map<String, Ingrediente> mapaIngredientes = new HashMap<>();	

		BufferedReader br = new BufferedReader(new FileReader(Filedata));
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			String precioIngrediente = partes[1];
			Ingrediente nuevoIngrediente = new Ingrediente(nombreIngrediente, 
					Integer.parseInt(precioIngrediente));
			mapaIngredientes.put(nombreIngrediente, nuevoIngrediente);
			linea = br.readLine();
		}
		br.close();
		return mapaIngredientes;
	}

public static Map<String, ProductoMenu> cargarProductoMenu(String Filedata) throws FileNotFoundException, IOException
		{
			Map<String, ProductoMenu> mapaMenu = new HashMap<>();	

			BufferedReader br = new BufferedReader(new FileReader(Filedata));
			String linea = br.readLine();
			while (linea != null) 
			{
				String[] partes = linea.split(";");
				String nombreProducto = partes[0];
				String precioProducto = partes[1];
				ProductoMenu nuevoProducto = new ProductoMenu(
						nombreProducto, Integer.parseInt(precioProducto));
				mapaMenu.put(nombreProducto, nuevoProducto);
				linea = br.readLine();
			}
			br.close();
			return mapaMenu;
}
public static Map<String, Combo> cargaCombos(String Filedata) throws FileNotFoundException, IOException
{
	Map<String, Combo> mapaCombos = new HashMap<>();

	BufferedReader br = new BufferedReader(new FileReader(Filedata));
	String linea = br.readLine();
	while (linea != null) 
	{
		String[] partes = linea.split(";");
		String nombreCombo = partes[0];
		String descuentoCombo = partes[1];
		Combo nuevoCombo = new Combo(nombreCombo, Double. parseDouble(descuentoCombo));
		for(int i = 2; i < partes.length; i = i + 1)
		{
			String parteCombo = partes[i];
			//Falta buscar en mapa Menu el producto
			Producto nuevoProducto = new Producto(parteCombo);
			nuevoCombo.agregarItemACombo(nuevoProducto);
			
		}
		mapaCombos.put(nombreCombo, nuevoCombo);
		linea = br.readLine();
	}
	br.close();
	return mapaCombos;
}
}