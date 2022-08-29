package modelo;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import procesamiento.CargaRestaurante;


public class Restaurante {
	private Map<String, Ingrediente> ingredientes;

	private Map<String, ProductoMenu> productosMenu;

	private Map<String, Combo> combos;
	
	public restaurante()
	{
		this.ingredientes = new HashMap<>();
		this.productosMenu = new HashMap<>();
		this.combos = new HashMap<>();
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) 
	{
		
	}
	
	public void cerrarYGuardarPedido() 
	{
		
	}
	
	public Pedido getPedidoEnCurso() 
	{
		
	}
	
	public ArrayList<Producto> getMenuBase() 
	{
		
	}
	
	public ArrayList<Ingrediente> getIngredientes() 
	{
		
	}
		
	
	public void cargarInformacionRestaurante(File Ingredientes, File Menu, File Combos)
	{
		cargarIngredientes(Ingredientes);
		cargarMenu(Menu);
		cargarCombos(Combos);
	}

	private void cargarIngredientes(File Ingredientes)
		{
			//this.ingredientes = cargarIngredientes(Ingredientes)
		}

	private void cargarMenu(File Menu)
	{

	}

	private void cargarCombos(File Combos)
	{

	}

}
