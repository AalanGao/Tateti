package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugador {
    private Scanner scanner;

    public Jugador() {
        this.scanner = new Scanner(System.in);  ;
    }

    public int[] elejirPosicion(){
        int[] result = new int[2];
        result[0] = this.verificarNum("Ingrese la fila donde desea colocar(1-3):", 1 , 3) - 1;
        result[1] = this.verificarNum("Ingrese la columna donde desea colocar(1-3):", 1 , 3) - 1;

        return result;
    }

    private int verificarNum(String msj, int min, int max){

        int num = 0;
        boolean entradaValida = false;

        System.out.print(msj);

        while (!entradaValida) {
            try {
                num = scanner.nextInt();
                if(num >= min && num <= max){
                    entradaValida = true;
                }else {
                    System.out.println("Error: Por favor, ingrese un número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next();
            }
        }
        return num;
    }
}
