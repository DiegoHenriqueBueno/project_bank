package App;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String agency;
	private List<Account> accounts;
	private int lastAccount = 1;

	public Bank(String agency) {
		this.agency = agency;
		this.accounts = new ArrayList<>();
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public Account generateAccount(String name) {
		Account accountGenerated = new Account(agency, "0001", "" + lastAccount);
		lastAccount++;
		return accountGenerated;
	}

	public void insertAccount(Account account) {
		accounts.add(account);
	}

	public void outputTotal() {
		double total = 0;
		for (Account account : accounts) {
			double balanceTotal = account.getBalance();
			total += balanceTotal;
		}
		System.out.println("O banco possui: R$ " + total);
	}
}
