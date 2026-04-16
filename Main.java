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

//==========================
//6️⃣ Animal y Perro
//==========================
class Animal {
public void hacerSonido() {
   System.out.println("El animal hace sonido");
}
}

class Perro extends Animal {
@Override
public void hacerSonido() {
   System.out.println("El perro ladra");
}
}

//==========================
//7️⃣ Vehiculo y Moto
//==========================
class Vehiculo {
protected String marca;
protected int velocidad;

public Vehiculo(String marca, int velocidad) {
   this.marca = marca;
   this.velocidad = velocidad;
}
}

class Moto extends Vehiculo {
private int cilindrada;

public Moto(String marca, int velocidad, int cilindrada) {
   super(marca, velocidad);
   this.cilindrada = cilindrada;
}

public void mostrarInfo() {
   System.out.println("Marca: " + marca + ", Velocidad: " + velocidad + ", Cilindrada: " + cilindrada);
}
}

//==========================
//8️⃣ Figura y Rectangulo y Circulo
//==========================
class Figura {
public double calcularArea() {
   return 0;
}
}

class Rectangulo extends Figura {
private double base, altura;

public Rectangulo(double base, double altura) {
   this.base = base;
   this.altura = altura;
}

@Override
public double calcularArea() {
   return base * altura;
}
}

class Circulo extends Figura {
private double radio;

public Circulo(double radio) {
   this.radio = radio;
}

@Override
public double calcularArea() {
   return Math.PI * radio * radio;
}
}

//==========================
//9️⃣ Libro y LibroDigital
//==========================
class Libro {
protected String titulo, autor;

public Libro(String titulo, String autor) {
   this.titulo = titulo;
   this.autor = autor;
}

public void mostrarInfo() {
   System.out.println("Titulo: " + titulo + ", Autor: " + autor);
}
}

class LibroDigital extends Libro {
private double tamanioMB;

public LibroDigital(String titulo, String autor, double tamanioMB) {
   super(titulo, autor);
   this.tamanioMB = tamanioMB;
}

@Override
public void mostrarInfo() {
   super.mostrarInfo();
   System.out.println("Tamaño: " + tamanioMB + " MB");
}
}

//==========================
//🔟 SISTEMA DE FACTURACIÓN
//==========================
class Cliente {
private String nombre;
private String nit;

public Cliente(String nombre, String nit) {
   this.nombre = nombre;
   this.nit = nit;
}

public String getNombre() {
   return nombre;
}

public String getNit() {
   return nit;
}
}

class Factura {
protected int numero;
protected Cliente cliente;
protected double total;

public Factura(int numero, Cliente cliente, double total) {
   this.numero = numero;
   this.cliente = cliente;
   this.total = total;
}

public double calcularTotal() {
   return total;
}

public void mostrar() {
   System.out.println("Factura: " + numero);
   System.out.println("Cliente: " + cliente.getNombre());
   System.out.println("Total: Q" + calcularTotal());
}
}

class FacturaContado extends Factura {
private double descuento;

public FacturaContado(int numero, Cliente cliente, double total, double descuento) {
   super(numero, cliente, total);
   this.descuento = descuento;
}

@Override
public double calcularTotal() {
   double totalFinal = total - descuento;
   if (totalFinal < 0) totalFinal = 0;
   return totalFinal;
}
}

class FacturaCredito extends Factura {
private double recargo;
private int cuotas;

public FacturaCredito(int numero, Cliente cliente, double total, double recargo, int cuotas) {
   super(numero, cliente, total);
   this.recargo = recargo;
   this.cuotas = cuotas;
}

@Override
public double calcularTotal() {
   double totalFinal = total + recargo;
   if (totalFinal < 0) totalFinal = 0;
   return totalFinal;
}

public void mostrarCuotas() {
   System.out.println("Cuotas: " + cuotas);
   System.out.println("Pago por cuota: Q" + (calcularTotal() / cuotas));
}
}
