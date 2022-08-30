package modelo;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Restaurante {
	private Map<String, Ingrediente> ingredientes;

	private Map<String, ProductoMenu> productosMenu;

	private Map<String, Combo> combos;
	
	private ArrayList<Pedido> pedidos;
	
	public Restaurante()
	{
		this.ingredientes = new HashMap<>();
		this.productosMenu = new HashMap<>();
		this.combos = new HashMap<>();
		this.pedidos = new ArrayList<Pedido>(100);
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) 
	{
		Pedido pedidoNuevo = new Pedido(nombreCliente, direccionCliente);
		this.pedidos.add(pedidoNuevo);
	}
	
	public void cerrarYGuardarPedido() 
	{
	}
	
	public Pedido getPedidoEnCurso() 
	{
		
	}
	
	public ArrayList<Producto> getMenuBase()
	{
		ArrayList<Producto> listaProductosMenu = new ArrayList<Producto>(this.productosMenu.size());
		for (String llave: this.productosMenu.keySet())
		{
			Producto productoMenu = this.productosMenu.get(llave);
			listaProductosMenu.add(productoMenu);
		}
		return listaProductosMenu;
	}
	
	public ArrayList<Ingrediente> getIngredientes() 
	{
		ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>(this.ingredientes.size());
		for (String llave: this.ingredientes.keySet())
		{
			Ingrediente nuevoingrediente = this.ingredientes.get(llave);
			listaIngredientes.add(nuevoingrediente);
		}
		return listaIngredientes;
		
	}		
	
	public void cargarInformacionRestaurante(File Ingredientes, File Menu, File Combos) throws FileNotFoundException, IOException
	{
		cargarIngredientes(Ingredientes);
		cargarMenu(Menu);
		cargarCombos(Combos);
	}

	private void cargarIngredientes(File Filedata) throws FileNotFoundException, IOException
	{	
		BufferedReader br = new BufferedReader(new FileReader(Filedata));
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			String precioIngrediente = partes[1];
			Ingrediente nuevoIngrediente = new Ingrediente(nombreIngrediente, 
					Integer.parseInt(precioIngrediente));
			this.ingredientes.put(nombreIngrediente, nuevoIngrediente);
			linea = br.readLine();
		}
		br.close();
	}
	private void cargarMenu(File Filedata) throws FileNotFoundException, IOException
	{

		BufferedReader br = new BufferedReader(new FileReader(Filedata));
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			String precioProducto = partes[1];
			ProductoMenu nuevoProducto = new ProductoMenu(
					nombreProducto, Integer.parseInt(precioProducto));
			this.productosMenu.put(nombreProducto, nuevoProducto);
			linea = br.readLine();
		}
		br.close();
	}
	private void cargarCombos(File Filedata) throws FileNotFoundException, IOException
	{

		BufferedReader br = new BufferedReader(new FileReader(Filedata));
		String linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String descuentoCombo = partes[1];
			Combo nuevoCombo = new Combo(nombreCombo, 
					Double.parseDouble(descuentoCombo));
			for(int i = 2; i < partes.length; i = i + 1)
			{
				String parteCombo = partes[i];
				Producto productoCombo = this.productosMenu.get(parteCombo);	 
				nuevoCombo.agregarItemACombo(productoCombo);
			}
			this.combos.put(nombreCombo, nuevoCombo);
			linea = br.readLine();
		}
		br.close();
	}

}
