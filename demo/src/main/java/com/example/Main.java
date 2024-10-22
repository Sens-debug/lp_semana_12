package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[]nombres = {"Juan Perez","María González","Jose Alvarez"};
        double[] saldos= {1500.00, 800.00, 600.00};
        boolean centinelaW=true;
        Scanner tecaldo3 = new Scanner(System.in);
            int indice = seleccionarCuenta(nombres);
            if (indice == -1) {
                centinelaW = false;
            }
        while (centinelaW) {
            
            mostrarMenu();
            System.out.println("Ingrese una opcion valida dentro del menu");
            int opcion = tecaldo3.nextInt();
            switch (opcion) {
                case 1:
                System.out.println("SELECCIONO --> DEPOSITAR");
                depositar(indice, saldos, nombres);
                    break;
                
                case 2:
                Scanner teclado3 = new Scanner(System.in);
                System.out.println("SELECCIONO ---> RETIRAR");
                System.out.println("INGTRESE LA CANTIDAD QUE DESEA RETIRAR");
                double retiro = teclado3.nextDouble();
                retirar(indice, saldos, nombres,retiro);
                break;

                case 3:
                consultarSaldo(indice, saldos, nombres);
                break;

                case 4:
                centinelaW=false;
                break;
                
                default:
                System.out.println("OPCION IVALIDA");
                    break;
            }
        }
            

    }
    public static void mostrarMenu(){
        System.out.println("-------------MENU-------------------------------");
        System.out.println("1 . Depositar");
        System.out.println("2 . Retirar" );
        System.out.println("3 . Consultar Saldo");
        System.out.println("4 . Salir");
        System.out.println("-------------------------------");
}
    public static int seleccionarCuenta(String[]nombresCuentas) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Seleccione el indice de la cuenta a utilizar");
    int seleccion = 0;
        for(int i=0; i<nombresCuentas.length; i++) {
        System.out.println("INDICE -->"+i+ " "+nombresCuentas[i] + " ");
        }seleccion=teclado.nextInt();
        if (seleccion >= nombresCuentas.length || seleccion<0) {System.out.println("INDICE INVALIDO");
        seleccion=-1;}
        return seleccion;}

    public static void depositar(int indiceCuenta,double[]saldosCuentas,String[]nombresCuentas){
        Scanner teclado2 = new Scanner(System.in);
        System.out.println("Ingrese el monto a depositar:");
        double deposito = teclado2.nextDouble();
        if (deposito < 0) {System.out.println("DEPOSITO INVALIDO");
            
        }else{
        saldosCuentas[indiceCuenta] += deposito;
        System.out.println("Deposito realizado con éxito. "+nombresCuentas[indiceCuenta]+ " Su Nuevo saldo es : " + saldosCuentas[indiceCuenta]);
        }}

    public static void retirar(int indiceCuenta, double[] saldosCuentas, String[] nombresCuentas, double cantidadRetiro){
    
        if(saldosCuentas[indiceCuenta]<cantidadRetiro || cantidadRetiro<0){
        System.out.println("FONDOS INSUFICIENTES");}
        else{
        saldosCuentas[indiceCuenta] -= cantidadRetiro;
        System.out.println("Retiro realizado con éxito. "+nombresCuentas[indiceCuenta]+ " Su Nuevo saldo es : " + saldosCuentas[indiceCuenta]);
    }
}

    public static void consultarSaldo(int indiceCuenta, double[] saldosCuentas, String[]nombresCuentas) {System.out.println(nombresCuentas[indiceCuenta]+" Su Saldo Actual es : "+saldosCuentas[indiceCuenta]);

    }


}

