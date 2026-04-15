package herencia;

//Autor: Oscar
//Tema: Herencia, @Override y uso de super

//==========================
//CLASES BASE GENERALES
//==========================

//Clase Cuenta (para ejercicio 2)
class Cuenta {
 protected double saldo;

 public Cuenta(double saldo) {
     this.saldo = saldo;
 }

 public void depositar(double monto) {
     saldo += monto;
 }

 public void retirar(double monto) {
     saldo -= monto;
 }
}

//==========================
//1️⃣ Persona, Docente, Estudiante
//==========================
class Persona {
 protected String nombre;
 protected int edad;

 public Persona(String nombre, int edad) {
     this.nombre = nombre;
     this.edad = edad;
 }

 public void mostrar() {
     System.out.println("Nombre: " + nombre + ", Edad: " + edad);
 }
}

class Docente extends Persona {
 private String especialidad;

 public Docente(String nombre, int edad, String especialidad) {
     super(nombre, edad);
     this.especialidad = especialidad;
 }

 @Override
 public void mostrar() {
     super.mostrar();
     System.out.println("Especialidad: " + especialidad);
 }
}

class Estudiante extends Persona {
 private String carnet;

 public Estudiante(String nombre, int edad, String carnet) {
     super(nombre, edad);
     this.carnet = carnet;
 }

 @Override
 public void mostrar() {
     super.mostrar();
     System.out.println("Carnet: " + carnet);
 }
}

//==========================
//2️⃣ Cuenta y CuentaCorriente
//==========================
class CuentaCorriente extends Cuenta {
 private double limite;

 public CuentaCorriente(double saldo, double limite) {
     super(saldo);
     this.limite = limite;
 }

 @Override
 public void retirar(double monto) {
     if (saldo + limite >= monto) {
         saldo -= monto;
     } else {
         System.out.println("Excede el limite");
     }
 }
}

//==========================
//3️⃣ Producto y ProductoPerecedero
//==========================
class Producto {
 protected String nombre;

 public Producto(String nombre) {
     this.nombre = nombre;
 }
}

class ProductoPerecedero extends Producto {
 private String fechaVencimiento;

 public ProductoPerecedero(String nombre, String fechaVencimiento) {
     super(nombre);
     this.fechaVencimiento = fechaVencimiento;
 }

 public void estaVencido() {
     System.out.println("Verificar fecha: " + fechaVencimiento);
 }
}

//==========================
//4️⃣ Transporte y Bus
//==========================
class Transporte {
 protected int capacidad;

 public Transporte(int capacidad) {
     this.capacidad = capacidad;
 }
}

class Bus extends Transporte {
 private String ruta;

 public Bus(int capacidad, String ruta) {
     super(capacidad);
     this.ruta = ruta;
 }

 public void descripcion() {
     System.out.println("Capacidad: " + capacidad + ", Ruta: " + ruta);
 }
}

//==========================
//5️⃣ Empleado y Gerente
//==========================
class Empleado {
 protected String nombre;
 protected double salario;

 public Empleado(String nombre, double salario) {
     this.nombre = nombre;
     this.salario = salario;
 }

 public double calcularSalario() {
     return salario;
 }
}

class Gerente extends Empleado {
 private double bono;

 public Gerente(String nombre, double salario, double bono) {
     super(nombre, salario);
     this.bono = bono;
 }

 @Override
 public double calcularSalario() {
     return salario + bono;
 }
}
