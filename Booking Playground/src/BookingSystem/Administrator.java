package BookingSystem;

public class Administrator extends User{

	private ManagmentSystem system;
	private int  NUM=1;
	Administrator(String Name,String Pass){
		nameSetter(Name);
		passwordSetter(Pass);
		setAccount(new Account(this));
	}
	
	Administrator(){
		
		nameSetter(" ");
		passwordSetter(" ");
	}
	
	int getNUM() {
		return NUM;
	}
	
	public void setSystem(ManagmentSystem newSystem) {
		if (system != newSystem) {
			ManagmentSystem old = system;
			system = newSystem;
			if (newSystem != null) {
				newSystem.addAdmin(this);
			}
			if (old != null) {
				old.addAdmin(this);
			}
		}
	}
	
	void DisplayData() {
		
		System.out.println("Admin Name : "+super.nameGetter());
		System.out.println("Password : "+super.Password);
		
		
	}	
		
	
}
