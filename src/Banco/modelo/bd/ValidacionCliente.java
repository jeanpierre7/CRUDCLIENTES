package Banco.modelo.bd;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

import Banco.controlador.Controlador;
import Banco.modelo.cliente.Cliente;
import Banco.modelo.cuenta.Cuenta;
import Banco.modelo.cuenta.CuentaCorriente;
import Banco.modelo.cuenta.CuentaDiamante;
import Banco.modelo.cuenta.CuentaVista;




public class ValidacionCliente {
	private Controlador controlador;
	private Cuenta cuentaVista;
	private CuentaVista vista;
	private CuentaCorriente corriente;
	private CuentaDiamante diamante;
	private Cliente cliente;
	private Cuentas cuentas;
	
	
	public boolean ValidarTipoDeCliente(String tipoCliente, int edad, String rut) {
		Scanner teclado = new Scanner(System.in);
		if (tipoCliente.equalsIgnoreCase("normal")) {
			System.out.println("Solo puede tener una cuenta VISTA");
			vista = new CuentaVista(0, rut);
			cuentas = new Cuentas();
			cuentas.agregarCuenta(vista);
			
			return true;
		
		}else if(tipoCliente.equalsIgnoreCase("premium")){
			System.out.println("Cual es la renta");
			int renta = teclado.nextInt();
			if (edad < 25 || renta <= 2000000) {
				System.out.println("No puede ser PREMIUM");
				return false;
			} else  {
					System.out.println("Cliente premium");
					System.out.println("Solo puede tener hasta 3 cuentas y no puede tener cuenta DIAMANTE");
					System.out.println("Que cuentas desea");
					System.out.println("1.- Vista");
					System.out.println("2.- Corriente");
					int opcion = teclado.nextInt();
					if (opcion == 1) {
						vista = new CuentaVista(0, rut);
						cuentas = new Cuentas();
						cuentas.agregarCuenta(vista);
						return true;
					}else if (opcion == 2) {
						vista = new CuentaVista(0, rut);
						cuentas = new Cuentas();
						cuentas.agregarCuenta(corriente);
						return true;
					}
				}		
		}else if(tipoCliente.equalsIgnoreCase("galaxy")) {
			System.out.println("Cual es la renta?");
			int renta = teclado.nextInt();
			System.out.println("Que antiguedad tiene el trabajo?");
			int antiguedad = teclado.nextInt();
			if (edad < 35 && renta <= 3000000 && antiguedad <= 3) {
				System.out.println("No puede ser GALAXY");
				return false;
			}else {
					System.out.println("Cliente GALAXY");
					System.out.println("Puede tener numero indeterminado de cuentas");
					System.out.println("Que cuentas desea");
					System.out.println("1.- Vista");
					System.out.println("2.- Corriente");
					System.out.println("3.- Diamante");
					int opcion = teclado.nextInt();
					if (opcion == 1) {
						vista = new CuentaVista(0, rut);
						cuentas = new Cuentas();
						cuentas.agregarCuenta(vista);
						return true;
					}else if (opcion == 2) {
						vista = new CuentaVista(0, rut);
						cuentas = new Cuentas();
						cuentas.agregarCuenta(corriente);
						return true;
					}else if (opcion == 3) {
						System.out.println("Para cuenta Diamante debe tener salddo de 5000000");
						return true;
							
				}
		}
	}
		
		return false;
  }
	
 }



	
