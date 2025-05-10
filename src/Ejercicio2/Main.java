package Ejercicio2;

import java.time.LocalDate; 
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Primer Parcial | Programacion Orientada a Objetos. Alumna: Caterina Marquez

		
		// INICIO 
		
		String[] menu = {"Ingresar Producto", "Mostrar informacion", "Cambiar precio", "Agregar stock", "Registrar venta", "Salir"};
		String[] categorias = {"Despensa", "Bebidas", "Congelados" ,"Dulces y snacks", "Carnes" , "Fruta y verdura", "Aseo personal", "Limpieza"};
		String[] cupon = {"Si", "No"};
				
		int opcionMenu, precio, stock, opcionCupon;
		String nombre="", categoria, marca;
		LocalDate fechaVenta;

		ProductoSupermercado producto1 = new ProductoSupermercado();
		
		// Arranca el programa
		
				JOptionPane.showMessageDialog(null, "Bienvenido al sistema de registro de productos y ventas de COTO! (yo te conozco) \nComo regalo de bienvenida, le regalamos un cupon de descuento del 10%!","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/supermercado.png")));
				
				do {
					opcionMenu = JOptionPane.showOptionDialog(null, "Seleccione la opcion que necesite", null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource("/img/carrito.png")), menu, menu[0]);
					
					switch (opcionMenu) {
					case 0:
						JOptionPane.showMessageDialog(null, "Excelente! Vamos a registrar un nuevo producto","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fruta.png")));
						JOptionPane.showMessageDialog(null, "Ingrese el nombre del producto!","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
						nombre = validarText();
						categoria = (String)JOptionPane.showInputDialog(null, "Seleccione la categoria del producto", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/merienda.png")), categorias, categorias[0]);
						JOptionPane.showMessageDialog(null, "Ingrese la marca del producto!","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
						marca = validarText();
						JOptionPane.showMessageDialog(null, "Ingrese el precio del producto!","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
						precio = validarNum();
						JOptionPane.showMessageDialog(null, "Ingrese el stock del producto!","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
						stock = validarNum();
						producto1.setNombre(nombre);
						producto1.setPrecio(precio);
						producto1.setMarca(marca);
						producto1.setCategoria(categoria);
						producto1.setStock(stock);
						break;
					case 1:
						if (!producto1.getNombre().equals("No definido")) {
						JOptionPane.showMessageDialog(null, producto1.mostrarInfo(), " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/carrito.png")));
					} else {
						JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
					}
						break;
					case 2:
						if (!producto1.getNombre().equals("No definido")) {
							precio = validarNum();
							producto1.cambiarPrecio(precio);
						} else {
							JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
						}
						break;
					case 3:
						if (!producto1.getNombre().equals("No definido")) {
						stock = validarNum();
						producto1.agregarStock(stock);
						} else {
							JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
						}
						break;
					case 4:
						if (producto1.getNombre().equals("No definido") || producto1.getStock()<=0) {
							JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto, y debe haber stock!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
						} else {
							opcionCupon = JOptionPane.showOptionDialog(null, "Tiene un cupon de descuento?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource("/img/carrito.png")), cupon, cupon[0]);
							switch (opcionCupon) {
							case 0:
								producto1.aplicarCupon();
								JOptionPane.showMessageDialog(null, "Su cupon ha sido aplicado con exito!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
								break;
							case 1:
								break; 	
							}
							fechaVenta = LocalDate.now();
							producto1.setFechaVenta(fechaVenta);
							JOptionPane.showMessageDialog(null, producto1.venderProducto(),"", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/carrito.png")));
						}
						break;
						
					case 5:
						JOptionPane.showMessageDialog(null, "Muchas gracias por utilizar nuetro servicio! Hasta pronto :)","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/supermercado.png")));
						break;
						}
					} while (opcionMenu!=5);
				
	} 
		
	// Validaciones
	
		public static String validarText() {
			String text;
			do {
				text = (String)JOptionPane.showInputDialog(null, "Aqui:", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fruta.png")), null, null);
			} while (text.isEmpty());
			return text;
		}
		
		public static int validarNum() { 
			String input;
			int num;
			boolean flag = true;
			do {	
				do {
					input = (String)JOptionPane.showInputDialog(null, "Aqui:", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/merienda.png")), null, null);
				} while (input.isEmpty());
				flag = true;
				for (int i = 0; i < input.length(); i++) {
					if (!Character.isDigit(input.charAt(i))) {
						flag = false;
						break;
					} }
				if (flag) {
		            num = Integer.parseInt(input);
		            if (num < 0) {
		                flag = false;
		                JOptionPane.showMessageDialog(null, "El numero ingresado debe ser mayor que 0","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/fideos.png")));
		            } }
			} while (!flag);
			return Integer.parseInt(input);
		}
		
}
