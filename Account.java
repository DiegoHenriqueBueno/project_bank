package App;

public class Account {
	private static final int MAX_LENGTH = 12;

	private String agency;
	private String account;
	private String name;

	private double balance;

	private Log logger;

	public Account(String agency, String account, String name) {
		this.agency = agency;
		this.account = account;
		setName(name);
		logger = new Log();
	}
	
	public double getBalance() {
		return balance;
	}

	public void setName(String name) {
		if (name.length() > MAX_LENGTH) {
			this.name = name.substring(0, MAX_LENGTH);
		} else {
			this.name = name;
		}
	}

	public void deposit(double value) {
		balance += value;
		logger.out("DEPÓSITO - R$" + value + "\nSaldo atual: R$" + balance + "\n");
	}

	public boolean withDraw(double value) {
		if (balance < value) {
			logger.out("SALDO INSUFICIENTE. \nSaldo atual: R$" + balance + "\n");
			return false;
		} else {
			balance -= value;
			logger.out("SAQUE - R$" + value + "\nSaldo atual: R$" + balance + "\n");
			return true;
		}
	}

	@Override
	public String toString() {
		return "Nome: " + this.name + "\n" + "Agência: " + this.agency + "\n" + "Conta: " + this.account + "\n"
				+ "Saldo: " + this.balance + "\n";
	}
}
