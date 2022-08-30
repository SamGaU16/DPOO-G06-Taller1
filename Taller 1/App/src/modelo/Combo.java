package modelo;

public class Combo implements Producto{
	private double descuento;
	private String nombre;
	private int precio;
	public Combo(String nombre, double descuento)
	{
		this.nombre = nombre;
		this.descuento = descuento;
		this.precio = 0;
	}
	public void agregarItemACombo(Producto ItemCombo) 
	{
		int precioItem = ItemCombo.getPrecio();
		this.precio += Math.round(precioItem*this.descuento);
	}
	public String getNombre() 
	{
	return this.nombre;
	}
	public int getPrecio()
	{
	return this.precio;
	}
	public String generarTextoFactura()
	{
	return "Hola";
	}
}
