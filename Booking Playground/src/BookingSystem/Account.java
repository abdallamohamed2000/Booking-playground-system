package BookingSystem;

public class Account {

	private String userName; 
	private String Password;
	private EWallet wallet;
	private Player player;
	private Administrator admin;
	private OwnerPlayground owner;
	
		Account(Player player){
			
			this.player=player;
			wallet=new EWallet(this);
			
		}
	
	
		public Player getPlayer() {
			return player;
		}
		
		
		Account(Administrator admin){
			
			this.admin=admin;
			wallet=new EWallet(this);
			
		}
		
		public Administrator getAdmin() {
			return admin;
		}
		
		Account(OwnerPlayground owner){
			
			this.owner=owner;
			wallet=new EWallet(this);
			
		}
		
		public OwnerPlayground getOwner() {
			return owner;
		}
		
		public EWallet getEWallet() {
			return wallet;
		}
		
		void nameSetter(String n) {
			this.userName=n;
		}
		
		String nameGetter() {
			return userName;
		}
		
		void passwordSetter(String pass) {
			this.Password=pass;
		}
		
		String passwordGetter() {
			return Password;
		}
	
		
		public String toString(){
			if(owner.getNUM()==1) {
				return "UserName : "+admin.nameGetter()+"\n"+"Password : "+admin.passwordGetter()+"\n";
			}else if(owner.getNUM()==2) {
				return "UserName : "+owner.nameGetter()+"\n"+"Password : "+owner.passwordGetter()+"\n";
			}
			return "UserName : "+player.nameGetter()+"\n"+"Password : "+player.passwordGetter()+"\n";
		}
		
}
