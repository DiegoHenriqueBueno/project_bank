package App;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner digitScanner = new Scanner(System.in);

		Bank santander = new Bank("0001");

		while (true) {
			System.out.println("O que deseja fazer? \n 1 - Criar Conta \n 2 - Sair");
			int optionSelected = digitScanner.nextInt();

			if (optionSelected == 1) {
				System.out.println("Digite o seu nome: ");
				String nameAccount = digitScanner.next();
				Account accountCreate = santander.generateAccount(nameAccount);
				santander.insertAccount(accountCreate);

				operateAccount(accountCreate);
			} else if (optionSelected == 2) {
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Opção inválida. Tente novamente.\n");
			}

		}

		List<Account> accounts = santander.getAccounts();
		for (Account account : accounts) {
			System.out.println(account);
		}

		santander.outputTotal();

		digitScanner.close();
	}

	static void operateAccount(Account account) {
		Scanner digitScanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Digite: \n 1: Depositar. \n 2: Sacar. \n 3: Sair.");
			int optionSelected = digitScanner.nextInt();

			if (optionSelected == 1) {
				System.out.println("Informe o valor a ser depositado.");
				double valueDeposit = digitScanner.nextDouble();
				account.deposit(valueDeposit);
			} else if (optionSelected == 2) {
				System.out.println("Informe o valor a ser sacado.");
				double valueWithDraw = digitScanner.nextDouble();
				account.withDraw(valueWithDraw);
			} else if (optionSelected == 3) {
				break;
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
		digitScanner.close();
	}
}