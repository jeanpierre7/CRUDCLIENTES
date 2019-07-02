package Banco.modelo.bd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Banco.controlador.Controlador;
import Banco.modelo.cliente.Cliente;
import Banco.modelo.cuenta.Cuenta;
import Banco.modelo.cuenta.CuentaVista;




public class BaseDeDatos {
	ArrayList<Cliente> lista;
	ArrayList<Cuenta> cuentas;
	Controlador controlador;
	
	public BaseDeDatos() {
		int codigo = 0;
		lista = new ArrayList<Cliente>();
		cuentas = new ArrayList<Cuenta>();
	}
	
	public boolean insert(Cliente nuevo) {
		lista.add(nuevo);
		return true;
	}
	
	public ArrayList<Cliente> select(){
		return this.lista;
	}
	
	public boolean realizarAbono(String r, int n) {
		Iterator<Cuenta> ite = cuentas.iterator();
		while (ite.hasNext()) {
			Cuenta cuenta = ite.next();	
			if (cuenta.getRut().equalsIgnoreCase(r)) {
				int total = 0;
				int comodin = cuenta.getSaldo();
				int num = n;
				total = comodin + n;
				cuenta.setSaldo(total);
				 return true;
			}
		}
		return false;


	}
	
	public boolean realizarGiro(String r, int n) {
		Iterator<Cuenta> ite = cuentas.iterator();
		while (ite.hasNext()) {
			Cuenta cuenta = ite.next();	
			if (cuenta.getRut().equalsIgnoreCase(r)) {
				int total = 0;
				int comodin = cuenta.getSaldo();
				int num = n;
				total = comodin - n;
				cuenta.setSaldo(total);
				 return true;
			}
		}
		return false;

	}
	
	public ArrayList<Cuenta> obtenerCuentas(){
		
		return this.cuentas;
		
	}
	
	public boolean agregarCuenta(Cuenta nuevo) {
		cuentas.add(nuevo);
		return true;
	}
	
	public boolean eliminarCuenta(String r) {
		Iterator<Cuenta> ite = cuentas.iterator();
		while (ite.hasNext()) {
			Cuenta cuenta = ite.next();	
			if (cuenta.getRut().equalsIgnoreCase(r)) {
				 ite.remove();
				 return true;
			}
		}
		return false;

	}
	
	public boolean eliminarCliente(String r) {
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();	
			if (cliente.getRut().equalsIgnoreCase(r)) {
				 ite.remove();
				 return true;
			}
		}
		return false;
	}
	public boolean modificarEdad(String r, int t, int opcion) {
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();	
			if (cliente.getRut().equalsIgnoreCase(r)) {
				if (cliente.getTipoCliente().equalsIgnoreCase("premium")) {
					switch (opcion) {
					case 1:
						cliente.setEdad(t);
						return true;
					
					case 2:
						cliente.setRenta(t);
						return true;
						
					default:
						return true;
					}
					
				}
			}
		
		}
		return false;
	}
	
	public boolean modificarGalaxy(String r, int t, int opcion) {
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();	
			if (cliente.getRut().equalsIgnoreCase(r)) {
				if (cliente.getTipoCliente().equalsIgnoreCase("galaxy")) {
					switch (opcion) {
					case 1:
						cliente.setEdad(t);
						return true;
					
					case 2:
						cliente.setRenta(t);
						return true;
						
					case 3:
						cliente.setAntiguedad(t);
						return true;
					default:
						return true;
					}
					
				}
			}
		
		}
		return false;
	}
	
	public boolean modificarNormal(String r, int t, int opcion) {
		Iterator<Cliente> ite = lista.iterator();
		while (ite.hasNext()) {
			Cliente cliente = ite.next();	
			if (cliente.getRut().equalsIgnoreCase(r)) {
				if (cliente.getTipoCliente().equalsIgnoreCase("normal")) {
					switch (opcion) {
					case 1:
						cliente.setEdad(t);
						return true;
				
					default:
						return true;
					}
					
				}
			}
		
		}
		return false;
	}
	
}

