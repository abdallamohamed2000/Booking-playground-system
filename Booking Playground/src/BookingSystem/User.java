package BookingSystem;

abstract class User {

	protected String userName;
	protected long phone ; 
	protected String address;
	protected String Password;
	protected Account account;
	
	public
	
	
		void nameSetter(String n) {
			this.userName=n;
		}
		
		String nameGetter() {
			return userName;
		}
		
		void phoneSetter(long ph) {
			this.phone=ph;
		}
		
		long phoneGetter() {
			return phone;
		}
		
		void addressSetter(String address) {
			this.address=address;
		}
		
		String addressGetter() {
			return address;
		}
		
		void passwordSetter(String pass) {
			this.Password=pass;
		}
		
		String passwordGetter() {
			return Password;
		}
		
		public Account getAccount() {
			return account;
		}
		
		public void setAccount(Account account) {
			this.account = account;
		}
		
		
		boolean Login(String Name,String Pass) {
			
			if(userName.equalsIgnoreCase(Name)&&Password==Pass) {
				return true;
			}
			return false;
			
		}
		
	
		abstract void DisplayData() ;
		
			
	
		
}
