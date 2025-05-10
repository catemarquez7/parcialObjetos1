package Ejercicio2;

import java.time.LocalDate;

public class ProductoSupermercado {

	//Atributos
	private String nombre;
	private String marca;
	private int precio;
	private String categoria;
	private int stock;
	private LocalDate fechaVenta;
	
	
	//Constructores
	public ProductoSupermercado() {
		this.nombre = "No definido";
		this.marca = "No definida";
		this.precio = 0;
		this.categoria = "No definida";
		this.stock = 0;
		this.fechaVenta = null;
	}	
	
	public ProductoSupermercado(String nombre, int precio) {
		this.nombre = nombre;
		this.marca = "No definida";
		this.precio = precio;
		this.categoria = "No definida";
		this.stock = 0;
		this.fechaVenta = null;
	}
	
	public ProductoSupermercado(String nombre, String marca, int precio, String categoria, int stock) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock; 
		this.fechaVenta = null;

	}
	
	
	// Getters y setters
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return this.marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return this.categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPrecio() {
		return this.precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getFechaVenta() {
		return this.fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	// Metodos
	
	public String mostrarInfo() {
		return "Informacion del producto: \nNombre: " + this.nombre + "\nMarca: " + this.marca + "\nCategoria: " + this.categoria + "\nPrecio: $" + this.precio + "\nStock: " + this.stock;	
		}
	
	public void agregarStock(int stock) {
		this.stock = this.stock + stock;

	}
	
	public void cambiarPrecio(int precio) {
		this.precio = precio;

	}
	
	public String venderProducto() {
		return "Su venta fue registrada con exito!\nNombre: " + this.nombre + "\nMarca: " + this.marca + "\nCategoria: " + this.categoria + "\nPrecio: $" + this.precio + "\nFecha de venta: " + this.fechaVenta;
	}
	
	public int aplicarCupon() {
		this.precio = (int) (this.precio - (this.precio*0.1));
		return this.precio;
	}
	
}
