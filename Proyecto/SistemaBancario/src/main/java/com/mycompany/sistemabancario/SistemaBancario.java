/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabancario;
import java.util.HashMap;
import java.util.Scanner;

public class SistemaBancario {
    private static final int EDAD_MINIMA = 18;
    private static HashMap<String, Usuario> usuarios = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarPantallaPrincipal();
    }

    private static void mostrarPantallaPrincipal() {
        System.out.println("Bienvenido a su sistema bancario");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Crear usuario");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                crearUsuario();
                break;
            default:
                System.out.println("Opcion invalida. Intente de nuevo.");
                mostrarPantallaPrincipal();
        }
    }

    private static void crearUsuario() {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su número de cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Ingrese un nombre de usuario (debe contener un número): ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese una contraseña (debe tener al menos un carácter y un número): ");
        String contrasena = scanner.nextLine();

        if (validarEdad(fechaNacimiento) && validarNombreUsuario(nombreUsuario) && validarContrasena(contrasena)) {
            Usuario nuevoUsuario = new Usuario(nombre, apellido, cedula, fechaNacimiento, nombreUsuario, contrasena);
            usuarios.put(nombreUsuario, nuevoUsuario);
            System.out.println("Usuario creado exitosamente.");
        } else {
            System.out.println("No se pudo crear el usuario. Revise los datos ingresados.");
        }

        mostrarPantallaPrincipal();
    }

    private static void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarios.containsKey(nombreUsuario)) {
            Usuario usuario = usuarios.get(nombreUsuario);
            if (usuario.getContrasena().equals(contrasena)) {
                System.out.println("Bienvenido, " + usuario.getNombre() + ".");
                // Aquí puedes agregar el menú de opciones del sistema bancario
            } else {
                System.out.println("Las credenciales no son correctas. ¿Olvidó su contraseña?");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }

        mostrarPantallaPrincipal();
    }

    private static boolean validarEdad(String fechaNacimiento) {
        // Implementar la lógica para calcular la edad a partir de la fecha de nacimiento
        // y verificar que sea mayor o igual a EDAD_MINIMA
        return true;
    }

    private static boolean validarNombreUsuario(String nombreUsuario) {
        // Verificar que el nombre de usuario contenga al menos un número
        return nombreUsuario.matches(".*\\d.*");
    }

    private static boolean validarContrasena(String contrasena) {
        // Verificar que la contraseña tenga al menos un carácter y un número
        return contrasena.matches(".*[a-zA-Z].*") && contrasena.matches(".*\\d.*");
    }

    private static class Usuario {
        private String nombre;
        private String apellido;
        private String cedula;
        private String fechaNacimiento;
        private String nombreUsuario;
        private String contrasena;

        public Usuario(String nombre, String apellido, String cedula, String fechaNacimiento, String nombreUsuario, String contrasena) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.cedula = cedula;
            this.fechaNacimiento = fechaNacimiento;
            this.nombreUsuario = nombreUsuario;
            this.contrasena = contrasena;
        }

        public String getNombre() {
            return nombre;
        }

        public String getContrasena() {
            return contrasena;
        }
    }
}
