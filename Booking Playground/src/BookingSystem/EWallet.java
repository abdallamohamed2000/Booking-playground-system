package BookingSystem;

public class EWallet {

	private int balance ;
	private Account account;
	
	EWallet(Account account){
		this.account=account;
		deposit(500);
	}
	
	Account getAccount() {
		return account;
	}
	
	/*EWallet(Player player){
		
		this.player=player;
	}
	
	Player getPlayer() {
		return player;
	}
	*/
	void balanceSetter(int b) {
		this.balance=b;
	}
	
	int balanceGetter() {
		return balance;
	}
	
	
	void deposit(float amount) {
		if(amount!=0){
			balance += Math.abs(amount);
		}
	}
	
	public void withdraw(int amount) {
		if(amount!=0&& balance-Math.abs(amount)>=0){
			balance-=Math.abs(amount);
			
		}else {
			System.out.println("Insuffectint Funds :(");
		}
		
	}
	
	void TransferFunds(EWallet wallet, float amount) {
		balance-=amount;
		wallet.deposit(amount);
	}
	
	/*
	@override
	*/
	public String toString(){
		return "Balance : "+balance+"\n";
	}
}
