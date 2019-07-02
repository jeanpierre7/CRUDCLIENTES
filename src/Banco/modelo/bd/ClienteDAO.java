package Banco.modelo.bd;

import java.util.ArrayList;

import Banco.modelo.cliente.Cliente;
import Banco.modelo.cuenta.Cuenta;



public class ClienteDAO {
private BaseDeDatos base;
	
	public ClienteDAO() {
		base = new BaseDeDatos();
	}
	
public ArrayList<Cuenta> obtenerCuentas(){
		
		return base.obtenerCuentas();
		
	}
	public boolean agregarCliente(Cliente nuevo) {
		this.base.insert(nuevo);
		return true;
	}
	
	public ArrayList<Cliente> obtenerClientes() {
		return this.base.select();
	}
	

	public boolean modificarEdad(String r, int numeroModificar, int opcion) {
		return 	base.modificarEdad(r, numeroModificar, opcion);

	}
	
	public boolean realizarGiro(String r, int n) {
		return 	base.realizarGiro(r, n);

	}
	public boolean realizarAbono(String r, int n) {
		return 	base.realizarAbono(r, n);

	}
	
	
	public boolean modificarGalaxy(String r, int numeroModificar, int opcion) {
		return 	base.modificarGalaxy(r, numeroModificar, opcion);

	}
	
	public boolean modificarNormal(String r, int numeroModificar, int opcion) {
		return 	base.modificarNormal(r, numeroModificar, opcion);

	}
	
	public boolean eliminarCliente(String r) {
		return 	base.eliminarCliente(r);

	}
	
	public boolean agregarCuenta(Cuenta nuevo) {
		base.agregarCuenta(nuevo);
		return true;
	}
	
	public boolean eliminarCuenta(String r) {
		return 	base.eliminarCuenta(r);

	}
}
