package Ejercicio1;

import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		// Primer Parcial | Programacion Orientada a Objetos. Alumna: Caterina Marquez
		
		// INICIO 
		
		String[] menu = {"Ingresar Producto", "Mostrar informacion", "Cambiar precio", "Cambiar disponibilidad", "Registrar venta", "Salir"};
		String[] tipoProducto = {"Cafe", "Infusion", "Pasteleria", "Panaderia", "Salado"};
		String[] menuDispo = {"Si", "No"};
		
		int opcionMenu, precio;
		String nombre="", tipo, dispo="";
		LocalDate fechaVenta;

		ProductoCafeteria producto1 = new ProductoCafeteria();
		
		
		// Arranca el programa
		
		JOptionPane.showMessageDialog(null, "Bienvenido al sistema de registro de productos y ventas de GetYourCoffee!","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe.png")));
		
		do {
			opcionMenu = JOptionPane.showOptionDialog(null, "Seleccione la opcion que necesite", null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(Main.class.getResource("/img/cafe.png")), menu, menu[0]);
			
			switch (opcionMenu) {
			case 0:
				JOptionPane.showMessageDialog(null, "Excelente! Vamos a registrar un nuevo producto","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/croissant.png")));
				nombre = validarText();
				precio = validarNum();
				tipo = (String)JOptionPane.showInputDialog(null, "Seleccione la categoria del producto", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/croissant.png")), tipoProducto, tipoProducto[0]);
				dispo = (String)JOptionPane.showInputDialog(null, "Seleccione la disponibilidad del producto", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/croissant.png")), menuDispo, menuDispo[0]);
				producto1.setNombre(nombre);
				producto1.setPrecio(precio);
				producto1.setTipo(tipo);
				producto1.setDispo(dispo);
				break;
			case 1:
				if (!producto1.getNombre().equals("No definido")) {
				JOptionPane.showMessageDialog(null, producto1.mostrarInfo(), " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe.png")));
			} else {
				JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe.png")));
			}
				break;
			case 2:
				if (!producto1.getNombre().equals("No definido") ) {
					precio = validarNum();
					producto1.cambiarPrecio(precio);
				} else {
					JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe.png")));
				}
				break;
			case 3:
				if (!producto1.getNombre().equals("No definido")) {
				dispo = (String)JOptionPane.showInputDialog(null, "Seleccione la disponibilidad del producto", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe.png")), menuDispo, menuDispo[0]);
				producto1.cambiarDispo(dispo);
				} else {
					JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe.png")));
				}
				break;
			case 4:
				if (producto1.getDispo().equals("No") || producto1.getNombre().equals("No definido")) {
					JOptionPane.showMessageDialog(null, "Primero debe ingresar el producto, y debe estar disponible!", " ", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe.png")));
				} else {
					fechaVenta = LocalDate.now();
					producto1.setFechaVenta(fechaVenta);
					JOptionPane.showMessageDialog(null, producto1.registrarVenta(),"", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/croissant.png")));
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Muchas gracias por utilizar nuetro servicio! Hasta pronto :)","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/cafe1.png")));
				break;
				}
			} while (opcionMenu!=5);
		
	} 
	
	// Validaciones
	
	public static String validarText() {
		String text;
		do {
			text = (String)JOptionPane.showInputDialog(null, "Ingrese el nombre del producto:", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/pastel.png")), null, null);
		} while (text.isEmpty());
		return text;
	}
	
	public static int validarNum() { 
		String input;
		int num;
		boolean flag = true;
		do {	
			do {
				input = (String)JOptionPane.showInputDialog(null, "Ingrese el precio del producto:", "", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/pastel.png")), null, null);
			} while (input.isEmpty());
			flag = true;
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					flag = false;
					break;
				} }
			if (flag) {
	            num = Integer.parseInt(input);
	            if (num <= 0) {
	                flag = false;
	                JOptionPane.showMessageDialog(null, "El precio debe ser mayor que 0","", JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("/img/pastel.png")));
	            } }
		} while (!flag);
		return Integer.parseInt(input);
	}
	
}
