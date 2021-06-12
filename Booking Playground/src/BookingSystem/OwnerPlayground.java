package BookingSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OwnerPlayground extends User {
	
	private ManagmentSystem system;
	private int  NUM=2;
	private Set<Playground> Playgrounds;
	
	OwnerPlayground(String Name,String Pass,long Phone,String add){
		phoneSetter(Phone);
		nameSetter(Name);
		addressSetter(add);
		passwordSetter(Pass);
		Playgrounds =new HashSet<Playground>();
		setAccount(new Account(this));
	}
	
	OwnerPlayground(){
		
		nameSetter(" ");
		passwordSetter(" ");
	}
	
	OwnerPlayground(String Name,String Pass){
		nameSetter(Name);
		passwordSetter(Pass);
	}
	
	Playground getEqual(int index, Set<Playground> all) {         // searching for certain playground
		  for (Playground one : all) {
		    if (one.getOrder()==index-1) {
		      return one;
		    }
		  } 
		  return null;
	}
	
	
	
	int getNUM() {
		return NUM;
	}
	
	public void addPlayground(Playground p) {
		Playgrounds.add(p);
		p.setOwner(this);
	}
	public void removePlayground(Playground p) {
		Playgrounds.remove(p);
		p.setOwner(null);
	}
	
	Set<Playground> getPlaygrounds(){
		return Playgrounds;
		
	}
	
	void DisplayPlaygrounds() {
		System.out.println(Playgrounds.toString());
	}
	
	
	Playground getSpecificPlayground(int index, Set<Playground> all) {
		
		ArrayList<Playground> list =new ArrayList<Playground>(all);
		
		  for (int i=0;i<list.size();i++) { 
			  
		    if (list.get(i).getOrder()==index-1) {
		      return list.get(i);
		    }
		  } 
		return null;
	}

	public void setSystem(ManagmentSystem newSystem) {
		if (system != newSystem) {
			ManagmentSystem old = system;
			system = newSystem;
			if (newSystem != null) {
				newSystem.addOwner(this);
			}
			if (old != null) {
				old.addOwner(this);
			}
		}
	}
	
	void DisplayData() {
		
		System.out.println("Playground Owner Name : "+super.nameGetter());
		System.out.println("Password : "+super.Password);
		System.out.println("Phone Number : 0"+super.phoneGetter());
		
	}	
		
	
}
