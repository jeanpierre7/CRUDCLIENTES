package Banco.modelo.bd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Banco.controlador.Controlador;
import Banco.modelo.cliente.Cliente;

public class ModificarDatosDeCliente {

	private Controlador controlador;
	public int opcion;
	
	public ModificarDatosDeCliente() {
		this.controlador = new Controlador();
		this.opcion = 0;
	
	}
	
	public ModificarDatosDeCliente(int opcion) {
		this.opcion = opcion;
	}
	
	

	public int valorOpcion() {
		return opcion;
	}


	public int modificarRenta(String r) {
		int numero =0;
	    Scanner teclado = new Scanner(System.in);
		ArrayList<Cliente> lista = controlador.obtenerClientes();
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();	
			if (cliente.getRut().equalsIgnoreCase(r)) {
		
					if (cliente.getTipoCliente().equalsIgnoreCase("premium")) {
				
						System.out.println("Es Cuenta PREMIUM Solo tiene la opcion de modificar:");
						System.out.println("1. Edad:");
						System.out.println("2. Renta:");
						opcion = teclado.nextInt();
						switch (opcion) {
						case 1:
							System.out.println("La edad actual del Cliente es : ");
							int mostrar = cliente.getEdad();
							System.out.println(mostrar);
							System.out.println("Ingrese la nueva edad: ");
							numero = teclado.nextInt();
							break;
					
						case 2:
							System.out.println("La renta actual del Cliente es : ");
							int renta = cliente.getRenta();
							System.out.println(renta);
							System.out.println("Ingrese la nueva renta: ");
							numero = teclado.nextInt();
							break;
							
						
						default:
							break;
						}
						
				
				}else if(cliente.getTipoCliente().equalsIgnoreCase("galaxy")) {
					System.out.println("Es Cuenta GALAXY Solo tiene la opcion de modificar:");
					System.out.println("1. Edad:");
					System.out.println("2. Renta:");
					System.out.println("3. Antiguedad:");
					opcion = teclado.nextInt();
					switch (opcion) {
					case 1:
						System.out.println("La edad actual del Cliente es : ");
						int mostrar = cliente.getEdad();
						System.out.println(mostrar);
						System.out.println("Ingrese la nueva edad: ");
						numero = teclado.nextInt();
						break;
					
					case 2:
						System.out.println("La renta actual del Cliente es : ");
						int renta = cliente.getRenta();
						System.out.println(renta);
						System.out.println("Ingrese la nueva renta: ");
				
						numero = teclado.nextInt();
						break;
					
						
					case 3:
						System.out.println("La antiguedad actual del Cliente es : ");
						int anti = cliente.getAntiguedad();
						System.out.println(anti);
						System.out.println("Ingrese la nueva antiguedad: ");
						numero = teclado.nextInt();
						break;
						

					default:
						break;
					}
				} else if (cliente.getTipoCliente().equalsIgnoreCase("normal")) {
					System.out.println("Es cuenta NORMAL Solo tiene la opcion de modificar:");
					System.out.println("1. Edad:");
					opcion = teclado.nextInt();
					switch (opcion) {
					case 1:
						System.out.println("La edad actual del Cliente es : ");
						int mostrar = cliente.getEdad();
						System.out.println(mostrar);
						System.out.println("Ingrese la nueva edad: ");
						numero = teclado.nextInt();

					default:
						break;
				}
			}
		
	}
		return numero;
   }
		return numero;
 }
}
 

