package Banco.controlador;

import java.util.ArrayList;

import Banco.modelo.bd.ClienteDAO;
import Banco.modelo.cliente.Cliente;
import Banco.modelo.cuenta.Cuenta;


public class Controlador {
private ClienteDAO dao;
	
	public Controlador() {
		dao = new ClienteDAO();
	}
	public boolean agregarCliente(Cliente nuevo) {
			dao.agregarCliente(nuevo);
			return true;
		}
	
	public boolean agregarCuenta(Cuenta nuevo) {
		dao.agregarCuenta(nuevo);
		return true;
	}
	public ArrayList<Cliente> obtenerClientes(){
		
		return dao.obtenerClientes();
		
	}

	public ArrayList<Cuenta> obtenerCuentas(){
		
		return dao.obtenerCuentas();
		
	}
	public boolean modificarEdad(String r, int numeroModificar, int opcion) {
		return 	dao.modificarEdad(r, numeroModificar, opcion);

	}
	public boolean modificarGalaxy(String r, int numeroModificar, int opcion) {
		return 	dao.modificarGalaxy(r, numeroModificar, opcion);

	}
	
	public boolean modificarNormal(String r, int numeroModificar, int opcion) {
		return 	dao.modificarNormal(r, numeroModificar, opcion);

	}
	
	public boolean eliminarCliente(String r) {
		return 	dao.eliminarCliente(r);

	}
	
	public boolean realizarGiro(String r, int n) {
		return 	dao.realizarGiro(r, n);

	}
	
	public boolean realizarAbono(String r, int n) {
		return 	dao.realizarAbono(r, n);

	}
	
	public boolean eliminarCuenta(String r) {
		return 	dao.eliminarCuenta(r);

	}
	
	
}
