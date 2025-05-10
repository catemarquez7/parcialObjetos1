package Ejercicio1;

import java.time.LocalDate;

public class ProductoCafeteria {

	// Atributos
	
	private String nombre;
	private int precio;
	private String tipo;
	private String dispo;
	private LocalDate fechaVenta;

	
	// Constructores
	
	public ProductoCafeteria(String nombre, int precio, String tipo, String dispo) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.dispo = dispo;
		this.fechaVenta = null;
		}; 

	public ProductoCafeteria(String nombre,String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = 0;
		this.dispo = "No";
		this.fechaVenta = null;
	}; 
	
	public ProductoCafeteria() {
		this.nombre = "No definido";
		this.tipo = "No definido";
		this.precio = 0;
		this.dispo = "No";
		this.fechaVenta = null;
	}; 
	
	
	// Getters y setters
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDispo() {
		return this.dispo;
	}
	public void setDispo(String dispo) {
		this.dispo = dispo;
	}
	
	public LocalDate getFechaVenta() {
		return this.fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	// Metodos
	
	public String mostrarInfo() {
		return "Informacion del producto: \nNombre: " + this.nombre + "\nTipo: " + this.tipo + "\nPrecio: $" + this.precio + "\nDisponibilidad: " + this.dispo;
	}
	
	public void cambiarPrecio(int precio) {
		this.precio = precio;
	}
	
	public void cambiarDispo(String dispo) {
		this.dispo = dispo;
	}
	
	public String registrarVenta() {
		return "Su venta fue registrada con exito!\nNombre: " + this.nombre + "\nPrecio: $" + this.precio + "\nFecha de venta: " + this.fechaVenta;
	}
	
}
