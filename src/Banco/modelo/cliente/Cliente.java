package Banco.modelo.cliente;

import java.util.ArrayList;

import Banco.modelo.bd.Cuentas;
import Banco.modelo.cuenta.Cuenta;
import Banco.modelo.cuenta.CuentaVista;

public class Cliente {
   protected String rut;
   protected String nombre;
   protected int edad;
   protected String tipoCliente;
   protected Cuenta cuenta;
   protected CuentaVista cuentaVista;
   protected int renta;
   protected int antiguedad;
   protected String tipoCuenta;
   
public Cliente(String rut, String nombre, int edad, String tipoCliente, String t) {

	this.rut = rut;
	this.nombre = nombre;
	this.edad = edad;
	this.tipoCliente = tipoCliente;
	this.tipoCuenta = t;

}

public Cliente(String rut, String nombre, int edad, String tipoCliente) {

	this.rut = rut;
	this.nombre = nombre;
	this.edad = edad;
	this.tipoCliente = tipoCliente;


}
public Cliente(String rut, String nombre, int edad, String tipoCliente, Cuenta cuenta) {

	this.rut = rut;
	this.nombre = nombre;
	this.edad = edad;
	this.tipoCliente = tipoCliente;
	this.cuenta = new CuentaVista(0, rut);

}

public Cliente() {

	this.rut = "";
	this.nombre = "";
	this.edad = 0;
	this.tipoCliente = "";
	cuentaVista = new CuentaVista(0, rut);

}

public Cliente(String rut, String nombre, int edad, String tipoCliente, int r, int a) {

	this.rut = rut;
	this.nombre = nombre;
	this.edad = edad;
	this.tipoCliente = tipoCliente;
	renta = r;
	antiguedad = a;
	cuenta = new Cuenta();

}


public Cliente(String rut, String nombre, int edad, String tipoCliente, Cuenta cuenta, int renta, int antiguedad) {
	super();
	this.rut = rut;
	this.nombre = nombre;
	this.edad = edad;
	this.tipoCliente = tipoCliente;
	this.cuenta = cuenta;
	this.renta = renta;
	this.antiguedad = antiguedad;
}





@Override
public String toString() {
	return "Cliente [rut=" + rut + ", nombre=" + nombre + ", edad=" + edad + ", tipoCliente=" + tipoCliente
			+ ", cuenta=" + cuenta + ", renta=" + renta + ", antiguedad=" + antiguedad + ", tipoCuenta=" + tipoCuenta
			+ "]";
}

public String getRut() {
	return rut;
}

public void setRut(String rut) {
	this.rut = rut;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

public String getTipoCliente() {
	return tipoCliente;
}

public void setTipoCliente(String tipoCliente) {
	this.tipoCliente = tipoCliente;
}

public Cuenta getCuenta() {
	return cuenta;
}

public void setCuenta(Cuenta cuenta) {
	this.cuenta = cuenta;
}

public int getRenta() {
	return renta;
}

public void setRenta(int renta) {
	this.renta = renta;
}

public int getAntiguedad() {
	return antiguedad;
}

public void setAntiguedad(int antiguedad) {
	this.antiguedad = antiguedad;
}

public String getTipoCuenta() {
	return tipoCuenta;
}

public void setTipoCuenta(String tipoCuenta) {
	this.tipoCuenta = tipoCuenta;
}





   
   
   
}
