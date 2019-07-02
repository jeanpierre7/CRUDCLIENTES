package Banco.vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Banco.controlador.Controlador;
import Banco.modelo.bd.ModificarDatosDeCliente;
import Banco.modelo.bd.ValidacionCliente;
import Banco.modelo.cliente.Cliente;
import Banco.modelo.cuenta.Cuenta;



public class Menu {
private Controlador controlador;
private ValidacionCliente validacionCliente;
private ModificarDatosDeCliente modificarDatosDeCliente;
	
	public Menu() {
		this.controlador = new Controlador();
		validacionCliente = new ValidacionCliente();
		modificarDatosDeCliente = new ModificarDatosDeCliente();
	}

	public void mostrarMenu() {
		int opcion = 0;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("******BANCO*****");
			System.out.println("1.- Crear nuevo cliente");
			System.out.println("2.- Modificar datos de un cliente");
			System.out.println("3.- Listar Clientes");
			System.out.println("4.- Eliminar cliente");
			System.out.println("5.- Crear cuenta");
			System.out.println("6.- Eliminar cuenta");
			System.out.println("7.- Realizar giro");
			System.out.println("8.- Realizar abono");
			System.out.println("9.- Salir");
			opcion = teclado.nextInt();
			switch(opcion) {
				case 1:
					crearNuevoCliente(teclado);
				break;
				case 3:
					listarClientes();
				break;
				case 2:
					modificarCliente(teclado);
				case 4:
					eliminarCliente(teclado);
				break;
				case 5:
					CrearCuenta(teclado);
				break;
				case 6:
					eliminarCuenta(teclado);
				break;
				case 7:
					realizarGiro(teclado);
				break;
				case 8:
					realizarAbono(teclado);
				break;
							
			}
		} while(opcion != 9);		
	}
	
	public void realizarGiro(Scanner teclado) {
		System.out.println("Ingrese rut del titular de la cuenta");
		teclado.nextLine();
		String rut = teclado.nextLine();
		ArrayList<Cuenta> lista = controlador.obtenerCuentas();
		Iterator<Cuenta> ite = lista.iterator();
		while (ite.hasNext()) {
			Cuenta cuenta = ite.next();
			if (cuenta.getRut().equalsIgnoreCase(rut)) {
				int saldo = cuenta.getSaldo();
				System.out.println("El saldo del cliente es : " + saldo);
				System.out.println("Cuanto dinero quiere girar");
				int n = teclado.nextInt();
				boolean resultado = controlador.realizarGiro(rut, n);
				if (resultado) {
					System.out.println("Giro exitoso");
				}else {
					System.out.println("Error");
				}
			}
		}
			
		
	}
	
	public void realizarAbono(Scanner teclado) {
		System.out.println("Ingrese rut del titular de la cuenta");
		teclado.nextLine();
		String rut = teclado.nextLine();
		ArrayList<Cuenta> lista = controlador.obtenerCuentas();
		Iterator<Cuenta> ite = lista.iterator();
		while (ite.hasNext()) {
			Cuenta cuenta = ite.next();
			if (cuenta.getRut().equalsIgnoreCase(rut)) {
				int saldo = cuenta.getSaldo();
				System.out.println("El saldo del cliente es : " + saldo);
				System.out.println("Cuanto dinero quiere abonar");
				int n = teclado.nextInt();
				boolean resultado = controlador.realizarAbono(rut, n);
				if (resultado) {
					System.out.println("Abono exitoso");
				}else {
					System.out.println("Error");
				}
			}
		}
			
		
	}
	
	public void CrearCuenta(Scanner teclado) {
		System.out.println("Ingrese rut a la cual esta asociada la cuenta");
		teclado.nextLine();
		String rut = teclado.nextLine();
		System.out.println("Ingrese el tipo de cuenta (VISTA, CORRIENTE, DIAMANTE)");
		String cuenta = teclado.nextLine();
		//boolean CrearCuenta =validacionCliente.ValidarTipoDeCliente(tipoCliente, edad);
		   Cuenta nuevaCuenta = new Cuenta(rut, cuenta);
			boolean resultado = controlador.agregarCuenta(nuevaCuenta);
			if (resultado) {
				System.out.println("Cliente insertado correctamente");
			}else {
				System.out.println("Error al agregar el cliente");
			}
		
		
	}
	public void eliminarCliente(Scanner teclado) {
		System.out.println("Ingrese el rut del cliente a eliminar");
		teclado.nextLine();
		String codigo = teclado.nextLine();
		ArrayList<Cliente> lista = controlador.obtenerClientes();
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();
			if (cliente.getRut().equalsIgnoreCase(codigo)) {
				boolean resultado = controlador.eliminarCliente(codigo);
				if (resultado) {
					System.out.println("Eliminado correctamente");
				}else {
					System.out.println("Error");
				}
			}
			
		}
	}
	
	
	public void eliminarCuenta(Scanner teclado) {
		System.out.println("Ingrese el rut del cliente de la cuenta a eliminar");
		teclado.nextLine();
		String codigo = teclado.nextLine();
		ArrayList<Cliente> lista = controlador.obtenerClientes();
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();
			if (cliente.getRut().equalsIgnoreCase(codigo)) {
				boolean resultado = controlador.eliminarCuenta(codigo);
				if (resultado) {
					System.out.println("Eliminado correctamente");
				}else {
					System.out.println("Error");
				}
			}
			
		}
	}
	public void crearNuevoCliente(Scanner teclado) {
		System.out.println("Ingrese rut");
		teclado.nextLine();
		String rut = teclado.nextLine();
		System.out.println("Ingrese nombre");
		String nombre = teclado.nextLine();
		System.out.println("Ingrese edad");
		int edad = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Ingrese tipo de Cliente (NORMAL, PREMIUM, GALAXY) :");
		String tipoCliente = teclado.nextLine();
	
	    boolean cliente =validacionCliente.ValidarTipoDeCliente(tipoCliente, edad, rut);
	    
		if (cliente) {
			Cliente nuevoCliente = new Cliente(rut, nombre, edad, tipoCliente);
			boolean resultado = controlador.agregarCliente(nuevoCliente);
			if (resultado) {
				System.out.println("Cliente insertado correctamente");
			}else {
				System.out.println("Error al agregar el cliente");
			}
		}
		
	}
	
	private void listarClientes() {
		System.out.println("*****************************************");
		ArrayList<Cliente> lista = controlador.obtenerClientes();
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();
			System.out.println(cliente.toString());
		}
		System.out.println("*****************************************");
	}
	
	private void modificarCliente(Scanner teclado) {
		System.out.println("Ingrese el rut del cliente");
		teclado.nextLine();
		String codigo = teclado.nextLine();
		ArrayList<Cliente> lista = controlador.obtenerClientes();
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();	
			if (cliente.getRut().equalsIgnoreCase(codigo)) {
				if (cliente.getTipoCliente().equalsIgnoreCase("premium")) {
					System.out.println("Es Cuenta PREMIUM Solo tiene la opcion de modificar:");
					System.out.println("1. Edad:");
					System.out.println("2. Renta:");
					int opcion = teclado.nextInt();
					switch (opcion) {
					case 1:
						System.out.println("La edad actual del Cliente es : ");
						int mostrar = cliente.getEdad();
						System.out.println(mostrar);
						System.out.println("Ingrese la nueva edad: ");
						int numero = teclado.nextInt();
						boolean resultado = controlador.modificarEdad(codigo, numero, opcion);
						if (resultado) {
							System.out.println("Cambio insertado correctamente");
						}else {
							System.out.println("Error");
						}
						break;
				
					case 2:
						System.out.println("La renta actual del Cliente es : ");
						int renta = cliente.getRenta();
						System.out.println(renta);
						System.out.println("Ingrese la nueva renta: ");
						int numero1 = teclado.nextInt();
						boolean resultado2 = controlador.modificarEdad(codigo, numero1, opcion);
						if (resultado2) {
							System.out.println("Cambio insertado correctamente");
						}else {
							System.out.println("Error");
						}
						break;
						
					
					default:
						break;
						
					}
					
				}else if(cliente.getTipoCliente().equalsIgnoreCase("galaxy")) {
						System.out.println("Es Cuenta GALAXY Solo tiene la opcion de modificar:");
						System.out.println("1. Edad:");
						System.out.println("2. Renta:");
						System.out.println("3. Antiguedad:");
						int opcion = teclado.nextInt();
						switch (opcion) {
						case 1:
							System.out.println("La edad actual del Cliente es : ");
							int mostrar = cliente.getEdad();
							System.out.println(mostrar);
							System.out.println("Ingrese la nueva edad: ");
							int numero2 = teclado.nextInt();
							boolean resultado = controlador.modificarGalaxy(codigo, numero2, opcion);
							if (resultado) {
								System.out.println("Cambio insertado correctamente");
							}else {
								System.out.println("Error");
							}
							break;
						
						case 2:
							System.out.println("La renta actual del Cliente es : ");
							int renta = cliente.getRenta();
							System.out.println(renta);
							System.out.println("Ingrese la nueva renta: ");
							int numero3 = teclado.nextInt();
							boolean resultado2 = controlador.modificarGalaxy(codigo, numero3, opcion);
							if (resultado2) {
								System.out.println("Cambio insertado correctamente");
							}else {
								System.out.println("Error");
							}
							break;
						case 3:
							System.out.println("La antiguedad actual del Cliente es : ");
							int anti = cliente.getAntiguedad();
							System.out.println(anti);
							System.out.println("Ingrese la nueva antiguedad: ");
							int numero4 = teclado.nextInt();
							boolean resultado3 = controlador.modificarGalaxy(codigo, numero4, opcion);
							if (resultado3) {
								System.out.println("Cambio insertado correctamente");
							}else {
								System.out.println("Error");
							}
							break;
						default:
							break;
						}
					} else if (cliente.getTipoCliente().equalsIgnoreCase("normal")) {
						System.out.println("Es cuenta NORMAL Solo tiene la opcion de modificar:");
						System.out.println("1. Edad:");
						int opcion = teclado.nextInt();
						switch (opcion) {
						case 1:
							System.out.println("La edad actual del Cliente es : ");
							int mostrar = cliente.getEdad();
							System.out.println(mostrar);
							System.out.println("Ingrese la nueva edad: ");
							int numero5 = teclado.nextInt();
							boolean resultado = controlador.modificarNormal(codigo, numero5, opcion);
							if (resultado) {
								System.out.println("Cambio insertado correctamente");
							}else {
								System.out.println("Error");
							}

						default:
							break;
					}
				}
			}
		
		}
	}
}
