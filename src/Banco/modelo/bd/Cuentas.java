package Banco.modelo.bd;

import java.util.ArrayList;
import java.util.Iterator;

import Banco.modelo.cuenta.Cuenta;

public class Cuentas {
	 ArrayList<Cuenta> cuentas;

	public Cuentas() {
	
		this.cuentas = new ArrayList<Cuenta>() ;
	}
	 
	
	public void agregarCuenta(Cuenta nuevo) {
		this.cuentas.add(nuevo);
	}
	
	public ArrayList<Cuenta> obtenerListaCuentas(){
		return this.cuentas;
	}
	
	public String toString() {
		String str = "**************************\n";
		Iterator<Cuenta> ite = this.cuentas.iterator();
		while(ite.hasNext()) {
			Cuenta temp = ite.next();
			str += temp.toString();			
		}
		str += "\n**************************\n";
		return str;
	}

	 
}
