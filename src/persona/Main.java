package persona;

import java.util.Scanner;
/**
 * Created by nacho on 08-04-2015.
 */
public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("cuantas personas desea crear");
        int tope= Integer.parseInt(scan.nextLine());
        int cont=0;//contador para el limite de personas

        while(cont!=tope){
            Persona nueva=crearPersona();
           // nueva=creaPersona();
            //pasar nueva a la pila de personas
            System.out.println(nueva.toString());
            cont++;
        }



    }


    public static Persona crearPersona(){
        Scanner scaner = new Scanner(System.in); //creamos un scaner de tipo Scanner

        System.out.println("Ingrese valores Persona");
        System.out.println("Ingrese Nombre");
        String nombre = scaner.nextLine();

        System.out.println("Ingrese Apellido paterno");
        String apellidoPaterno = scaner.nextLine();

        System.out.println("Ingrese Apellido materno");
        String apellidoMaterno = scaner.nextLine();

        System.out.println("Ingrese edad");
        int edad =  Integer.parseInt(scaner.nextLine());

        //creamos nuevaPersona y le pasamos los datos capturados nombre, apellidoPaterno, apellidoMaterno
        Persona nuevaPersona = new Persona(nombre, apellidoPaterno, apellidoMaterno, edad);

        return nuevaPersona;
    }

}
