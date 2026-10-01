package application;

import entities.Account;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import exceptions.BusinessException;


public class Projeto25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        try {
            System.out.println("*********EXERCÍCIO TRATAMENTO DE ERROS*********: ");
            System.out.println();
            System.out.println("Informe os dados abaixo ");
            System.out.println();

            System.out.print("Digite o número da conta: ");
            int numeroConta = input.nextInt();
            input.nextLine();

            System.out.print("Digite o Titular da conta: ");
            String titular = input.nextLine();

            System.out.print("Digite o saldo inicial da conta: ");
            double saldo = input.nextDouble();

            System.out.print("Digite O limite de saque da conta: ");
            double limite = input.nextDouble();

            Account conta = new Account(numeroConta, titular, saldo, limite);

            System.out.println();
            System.out.print("Informe o valor desejado para saque: ");
            double valorSaque = input.nextDouble();

            conta.withdraw(valorSaque);
            System.out.printf("Novo saldo: R$ %.2f%n", conta.getBalance());
        }
        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Entrada inválida: informe valores numéricos onde for solicitado.\" ");
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado! "+ e.getMessage());
        }
        finally {
            input.close();
        }



    }

}
