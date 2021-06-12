package BookingSystem;


public class Player extends User {
	
	private ManagmentSystem system;
	static int count=0;
	Player(String Name,String Pass,long phone,String add) {
		nameSetter(Name);
		passwordSetter(Pass);
		addressSetter(add);
		phoneSetter(phone);
		setAccount(new Account(this));
		count++;
	}
	
	Player(){
		nameSetter(" ");
		passwordSetter(" ");
	}
	
	Player(String Name,String Pass){
		nameSetter(Name);
		passwordSetter(Pass);
	}
	
	public void setSystem(ManagmentSystem newSystem) {
		if (system != newSystem) {
			ManagmentSystem old = system;
			system = newSystem;
			if (newSystem != null)
				newSystem.addPlayer(this);
			if (old != null)
				old.addPlayer(this);
		}
	}
	
	
	void DisplayData() {
		
		System.out.println("Player Name : "+super.nameGetter());
		System.out.println("Password : "+super.Password);
		System.out.println("Phone Number : 0"+super.phoneGetter());
		
	}	
		
	
	
	
}
