package BookingSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ManagmentSystem {
	 
	private String Name;
	private OwnerPlayground owner;
	private Player player;
	private Administrator admin;
	private Set<Player> Players;
	private Set<OwnerPlayground> Owners;
	private Set<Administrator> Admins;
	
	ArrayList<Playground> pendingPlaygrounds=new ArrayList<Playground>();
	ArrayList<Playground> ApprovedPlaygrounds=new ArrayList<Playground>();
	ArrayList<Playground> BookedPlaygrounds=new ArrayList<Playground>();
	
	
	public ManagmentSystem(String Name) {
		
		this.Name=Name;
		Players = new HashSet<Player>();
		Owners = new HashSet<OwnerPlayground>();
		Admins=new HashSet<Administrator>(5);
	}
	public void addPlayer(Player p) {
		Players.add(p);
		p.setSystem(this);
	}
	public void removePlayer(Player p) {
		Players.remove(p);
		p.setSystem(null);
	}
	
	public void addOwner(OwnerPlayground O) {
		Owners.add(O);
		O.setSystem(this);
	}
	public void removeOwner(OwnerPlayground O) {
		Owners.remove(O);
		O.setSystem(null);
	}
	
	public void addAdmin(Administrator a) {
		Admins.add(a);
		a.setSystem(this);
	}
	public void removeAdmin(Administrator a) {
		Admins.remove(a);
		a.setSystem(null);
	}
	
	OwnerPlayground getSpecificOwner(int index, Set<OwnerPlayground> all) {
		
		ArrayList<OwnerPlayground> list =new ArrayList<OwnerPlayground>(all);
		
		  for (int i=0;i<list.size();i++) { 
			  
			  Set<Playground> play=list.get(i).getPlaygrounds();
			 // ArrayList<Playground> list2 =new ArrayList<Playground>(play);
		    if (list.get(i).getEqual(index, play).getOrder()==index) {
		      return list.get(i);
		    }
		  } 
		return null;
	}
	
	
	Set<Player> getAllPlayers(){
		return Players;
	}
	
	Set<OwnerPlayground> getAllOwners(){
		return Owners;
	}
	
	Set<Administrator> getAllAdmins(){
		return Admins;
	}
	/*ManagmentSystem(){
		ArrayList<Playground> pendingPlaygrounds=new ArrayList< Playground>();
		ArrayList<Playground> ApprovedPlaygrounds=new ArrayList<Playground>();
		ArrayList<Playground> BookedPlaygrounds=new ArrayList<Playground>();
	}
	*/
	void SignUpPlayer(String Name,String Pass,long phone,String add) {
		this.player=new Player(Name,Pass,phone,add);
		addPlayer(player);
	}
	
	void SignUpAdmin(String Name,String Pass) {
		admin=new Administrator(Name,Pass);
		addAdmin(admin);
	}
	
	void SignUpPlaygroundOwner(String Name,String Pass,long phone,String add) {
		owner= new OwnerPlayground(Name,Pass,phone,add);
		addOwner(owner);
	}
	
	Player getEqual(Player sample, Set<Player> all) {                            // searching for certain player
		ArrayList<Player> list =new ArrayList<Player>(all);
		  for (int i=0;i<list.size();i++) { 
		    if (list.get(i).nameGetter()==sample.nameGetter() && list.get(i).passwordGetter()==sample.passwordGetter()||list.get(i).equals(sample)) {
		      return list.get(i);
		    }
		  } 
		  
	//	  Player pp=new Player();                    // dumpy empty object
		  return null;
	}
	
	OwnerPlayground getEqual(OwnerPlayground sample, Set<OwnerPlayground> all) {         // searching for certain Owner
		ArrayList<OwnerPlayground> list =new ArrayList<OwnerPlayground>(all);	
		
		  for (int i=0;i<list.size();i++) { 
		    if (list.get(i).nameGetter().equals(sample.nameGetter()) && list.get(i).passwordGetter().equals(sample.passwordGetter())||list.get(i).equals(sample)) {
		      return list.get(i);
		    }
		  }
		  
		//  OwnerPlayground oo =new OwnerPlayground();                                  // dumpy empty object
		  
		  return null;
	}
	
	Administrator getEqual(Administrator sample, Set<Administrator> all) {           // searching for certain admin
		ArrayList<Administrator> list =new ArrayList<Administrator>(all);
		  for (int i=0;i<list.size();i++) { 
		    if (list.get(i).nameGetter()==sample.nameGetter() && list.get(i).passwordGetter()==sample.passwordGetter()||list.get(i).equals(sample)) {
		      return list.get(i);  
		    }
		  } 
		  
		 
		 // Administrator aa=new Administrator();                                       // dumpy empty object
		  
		  return null;
	}
	
	Player getPlayer() {               // get last added player
			
		return player;
	}
	
	OwnerPlayground getOwner() {          // get last added owner
		return owner;
	}
	
	Administrator getAdmin() {               // get last added admin
		return admin;
	}
	
	void suspendPlayground(ArrayList<Playground> approved,int order) {
		Playground Selected=approved.get(order-1);
		ApprovedPlaygrounds.remove(Selected);
		ApprovedPlaygrounds.add(null);
		pendingPlaygrounds.add(Selected);
		System.out.println("Playground suspended Successfully");
	}
	
	void deletePlayground(ArrayList<Playground> approved,int order) {
		Playground Selected=approved.get(order-1);
		ApprovedPlaygrounds.remove(Selected);
		ApprovedPlaygrounds.add(null);
		System.out.println("Playground deleted Successfully");
	}
	
	void AddPlayground(Playground play) {
		owner.addPlayground(play);
		pendingPlaygrounds.add(play);
	}
	
	void removePlayground(Playground play) {
		ApprovedPlaygrounds.remove(play);
		ApprovedPlaygrounds.add(null);
	}
	
	void approvePlayground(ArrayList<Playground> pending,int order) {
		
		Playground Selected=pending.get(order-1);
		pendingPlaygrounds.remove(order-1);
		pendingPlaygrounds.add(null);
		ApprovedPlaygrounds.add(Selected);
		System.out.println("Playground added Successfully");
		
	}
	
	void bookPlayground(ArrayList<Playground> approved,int order,String hour) {
		Playground Selected=approved.get(order-1);
		Selected.getHours().bookTime(Selected, hour);
		BookedPlaygrounds.add(Selected);
		System.out.println("Playground booked Successfully");
		
	}
	
	public String getName() {
		return Name;
	}
	
	
	public void setName(String name) {
		Name = name;
	}
	
	
	void ShowMainMenu() {
		
		System.out.print("A:Create a new account              ");
		System.out.println("B: Existing Account");
	}

	void ShowUserTypeMenu() {
		
		System.out.print("A:Player              ");
		System.out.println("B:Playground Owner");
		
	}
	
	
	void ShowOwnerAccountMethodsMenu() {
		
		System.out.println("A:Show Owner Information ");
		System.out.println("B:Add Playground ");
		System.out.println("C:Show My Playgrounds ");
		System.out.println("D:Delete Account ");
	}
	
	void ShowAdminAccountMethodsMenu() {
		
		System.out.println("A:Show Admin Information ");
		System.out.println("B:Check balance ");
		System.out.println("C:Transfer Funds ");
		System.out.println("D:Delete Playground ");
		System.out.println("E:Suspend Playground ");
		System.out.println("F:Approve Playground ");
		System.out.println("G:Delete Account ");
	}
	
	void ShowPlayerAccountMethodsMenu() {
		
		System.out.println("A:Show Player Information ");
		System.out.println("B:Join Team ");
		System.out.println("C:Book Playground ");
		System.out.println("D:Delete Account ");
		//System.out.println("D:My Booking ");
	}
	
}
