package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.Producto;
import java.io.File;

public class Pedido {
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedidos;
	
	public Pedido(String nombreCliente, String direccionCliente)
	{
		this.numeroPedidos = 1000000000; //No se
		this.idPedido = 10000; //No se
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.itemsPedidos = new ArrayList<Producto>(15);
	}
	public void agregarProducto(Producto nuevoItem)
	{
		this.itemsPedidos.add(nuevoItem);
	}
	private int getPrecioNetoPedido() 
	{
		int Precio = 0;
		for(int i = 0; i < this.itemsPedidos.size(); i++)
		{
			Producto itemPedido = this.itemsPedidos.get(i);
			Precio += itemPedido.getPrecio();
		}
		return Precio;
	}
	private int getPrecioIVAPedido() 
	{
		float IVA = 0.1f;
		int precioNeto = getPrecioNetoPedido();
		int precioIVA  = Math.round(precioNeto * IVA);
		return precioIVA;
	}
	private int getPrecioTotalPedido() 
	{
		int precioTotal = getPrecioNetoPedido() + getPrecioIVAPedido();
		return precioTotal;
	}
	private String generarTextoFactura()
	{
		int precioTotal = getPrecioTotalPedido();
	return String.valueOf(precioTotal);
	}
	public void guardarFactura(File archivo)
	{
		String nuevaFactura = generarTextoFactura();
		System.out.println(nuevaFactura);
	}

}
