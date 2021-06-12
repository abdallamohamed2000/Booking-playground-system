package BookingSystem;



public class Playground {

	private static int order=0; 
	private int RentCost;
	private String PitchType;
	private String Name;
	private int capacity;
	private String location;
	private OwnerPlayground owner;
	private Time Hour;
	/**
	 * 
	 * @param capacity
	 * @param location
	 * @param RentCost
	 * @param PitchType
	 */
	Playground(String name,int capacity,String location,int RentCost,String PitchType){
		this.Name=name;
		this.RentCost=RentCost;
		this.location=location;
		this.capacity=capacity;
		this.PitchType=PitchType;
		this.Hour=new Time(this);
		order++;
		setOwner(this.owner);
	}
	
	
	Time getHours() {
		return Hour;
	}
	/**
	 * 
	 * @param newOwner
	 */
	public void setOwner(OwnerPlayground newOwner) {
		if (owner != newOwner) {
			OwnerPlayground old = owner;
			owner = newOwner;
			if (newOwner != null) {
				newOwner.addPlayground(this);
			}
			if (old != null) {
				old.removePlayground(this);
			}
		}
	}
	
	

	
	int getOrder() {
		return order;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}


	public String getPitchType() {
		return PitchType;
	}


	public void setPitchType(String pitchType) {
		this.PitchType = pitchType;
	}


	public int getRentCost() {
		return RentCost;
	}


	public void setRentCost(int rentCost) {
		this.RentCost = rentCost;
	}
	
	void DisplayData() {
		
		System.out.println("Playground No : #"+order);
		System.out.println("Playground Owner : "+owner.nameGetter());
		System.out.println("Phone Number : 0"+owner.phoneGetter());
		System.out.println("Playground Name : "+Name);
		System.out.println("Pitch Type : "+PitchType);
		System.out.println("Playground Maximium Capacity : "+capacity);
		System.out.println("Rent Cost : "+RentCost+"LE");
		System.out.println("Location : "+location);
	}
	
	/**
	 * @Override
	 */
	public String toString(){
		return "Playground Owner : "+owner.nameGetter()+"\n"+"Phone Number : "+owner.phoneGetter()+"\n"+"Playground Name : "+Name+"\n"+"Pitch Type : "+PitchType+"\n"+"Playground Maximium Capacity : "+capacity+"\n"+"Rent Cost : "+RentCost+"LE"+"\n"+"Location : "+location+"\n";
		
	}
	
}
