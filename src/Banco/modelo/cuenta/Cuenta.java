package Banco.modelo.cuenta;

public class Cuenta {
	
   protected String rut;
   protected String tipoDeCuenta;
   protected int saldo;
   

public Cuenta(int saldo, String rut, String s) {
	this.saldo = saldo;
	this.rut = rut;
	this.tipoDeCuenta = s;
}
public Cuenta(int saldo, String rut) {
	this.saldo = saldo;
	this.rut = rut;

}

public Cuenta(String rut, String t) {
	
	this.rut = rut;
	this.tipoDeCuenta = t;

}


public Cuenta() {
	this.saldo = 0;
	this.rut = "";
	this.tipoDeCuenta = "VISTA";
}

@Override
public String toString() {
	return "Cuenta [rut=" + rut + ", tipoDeCuenta=" + tipoDeCuenta + ", saldo=" + saldo + "]";
}
public String getRut() {
	return rut;
}
public void setRut(String rut) {
	this.rut = rut;
}
public String getTipoDeCuenta() {
	return tipoDeCuenta;
}
public void setTipoDeCuenta(String tipoDeCuenta) {
	this.tipoDeCuenta = tipoDeCuenta;
}
public int getSaldo() {
	return saldo;
}
public void setSaldo(int saldo) {
	this.saldo = saldo;
}




   
 
   
   
}
