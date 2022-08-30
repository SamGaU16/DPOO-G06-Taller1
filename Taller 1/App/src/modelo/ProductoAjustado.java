package modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	private String nombre;
	private int precioFinal;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado(ProductoMenu base)
	{
		this.nombre = base.getNombre();
		this.precioFinal = base.getPrecio();

		this.agregados = new ArrayList<Ingrediente>(10);
		this.eliminados = new ArrayList<Ingrediente>(10);
	}
	public void agregarAdiciones(Ingrediente nuevaAdicion)
	{
		this.agregados.add(nuevaAdicion);
		int precioExtra = nuevaAdicion.getcostoAdicional();
		this.precioFinal += precioExtra;
	}
	public void quitarAdiciones(Ingrediente quitarIngrediente)
	{
		this.eliminados.add(quitarIngrediente);
	}
	public String getNombre() 
	{
		return this.nombre;
	}
	public int getPrecio()
	{
		return this.precioFinal;
	}
	public String generarTextoFactura()
	{
		return "Hola";
	}
}
