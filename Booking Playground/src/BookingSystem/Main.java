package BookingSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		Scanner scan =new Scanner(System.in);
		
		ManagmentSystem app=new ManagmentSystem("GoFo");
		
		app.SignUpAdmin("admin","3333"); 
		
		
		while(true) {
			
			System.out.println();
			System.out.println("<<< Thanks for choosing US >>>");
			app.ShowMainMenu();
			char input =scan.next().charAt(0);
			switch(input) {
				case('A'):
				
					System.out.println("Enter your Name");
			 		String n=scan.next();
			 		System.out.println("Enter your Password");
					String pass= scan.next();
					System.out.println("Enter your Address");
					String add =scan.next();
					System.out.println("Enter your Phone Number");
					long phon_num=scan.nextLong();
					app.ShowUserTypeMenu();
				    input =scan.next().charAt(0);
					switch(input) {
						case('A'):
							app.SignUpPlayer(n, pass, phon_num,add);        //c  standard client with standard account	-
							app.getPlayer().DisplayData();	
							break;
				 		case('B'):
				 			app.SignUpPlaygroundOwner(n, pass, phon_num,add);         //cc  standard client with special account	
							app.getOwner().DisplayData();
							app.getOwner().DisplayPlaygrounds();
							break;	
						
					}
					System.out.println("/////////////////////////////////////////////");
					
				case('B'):
					System.out.println("<< Welcome >>");
					System.out.println("Enter your UserName");
					String name=scan.next();
					System.out.println("Enter your Password");
					String Pass=scan.next();
					
					Player p=new Player(name,Pass);
					OwnerPlayground o=new OwnerPlayground(name,Pass);
					Administrator a=new Administrator(name,Pass);
					
					                                                   //Searching for the existing account
				
					if(app.getEqual(o, app.getAllOwners())==null) {
						System.out.println("There is not an Existing Account with this Information");
						System.out.println("Please Create a new Account");
						break;
						
					}else if(app.getEqual(p, app.getAllPlayers())==null) {
						System.out.println("There is not an Existing Player Account with this Information");
						System.out.println("Please Create a new Account");
						break;
						
					}else if(app.getEqual(a, app.getAllAdmins())==null) {
						System.out.println("There is not an Existing Administrator Account with this Information");
						System.out.println("Please Create a new Account");
						break;
						
					}
				
					
					System.out.println("Valid Account");
					
					
					Player mainPlayer=new Player(name,Pass);
					OwnerPlayground mainOwner=new OwnerPlayground(name,Pass);
					Administrator mainAdmin=app.getEqual(a, app.getAllAdmins());
					
					if(mainPlayer!=null||mainPlayer.Login(name, Pass)) {
						Player player=app.getEqual(p, app.getAllPlayers());
						app.ShowPlayerAccountMethodsMenu();
						input =scan.next().charAt(0);
						switch(input) {
						case('A'):
							player.DisplayData();
						
						case('B'):
							
							
							//join  Team
							
						case('C'):
							
							System.out.println(app.ApprovedPlaygrounds);
							System.out.println("Select Playground Number");
							int selected =scan.nextInt();
							OwnerPlayground selectedOwner=app.getSpecificOwner(selected, app.getAllOwners());
							Playground selectedPlayground=selectedOwner.getSpecificPlayground(selected, selectedOwner.getPlaygrounds());
							selectedPlayground.getHours().DisplayTimeTable();
							System.out.println("Select Hour");
							String selectedHour =scan.next();
							player.getAccount().getEWallet().TransferFunds(selectedOwner.getAccount().getEWallet(), selectedPlayground.getRentCost());
							app.bookPlayground(app.ApprovedPlaygrounds, selected, selectedHour);
							
						case('D'):
							
							app.removePlayer(player);
						
						}
						
					}else if(mainOwner!=null||mainOwner.Login(name, Pass)){
						OwnerPlayground owner=app.getEqual(o, app.getAllOwners());
						app.ShowOwnerAccountMethodsMenu();
						input =scan.next().charAt(0);
						switch(input) {
						case('A'):
							owner.DisplayData();
						case('B'):
							System.out.println("Enter Playground Name");
					 		String title=scan.nextLine();
					 		System.out.println("Enter Maximium Capacity");
							int size= scan.nextInt();
							System.out.println("Enter Playground Location");
							String location =scan.next();
							System.out.println("Enter Rent Cost per Hour");
							int rent= scan.nextInt();
							System.out.println("Enter Pitch Type");
							String pitchType=scan.nextLine();
							Playground play=new Playground(title,size,location,rent,pitchType);
							
							app.AddPlayground(play);
					
							play.DisplayData();
							
						case('C'):
							owner.DisplayPlaygrounds();
						
						case('D'):
							app.removeOwner(owner);
						
						}
						
					}else if(mainAdmin!=null||mainAdmin.Login(a.nameGetter(), a.passwordGetter())){
						Administrator activeAdmin =app.getEqual(a, app.getAllAdmins());
						app.ShowAdminAccountMethodsMenu();
						input =scan.next().charAt(0);
						switch(input) {
						
						case('A'):
							activeAdmin.DisplayData();
							break;
							
						case('B'):
							int balance=activeAdmin.getAccount().getEWallet().balanceGetter();
							System.out.println("Balance : "+balance);
							break;
							
						case('C'):
							
							System.out.println("Transfer Amount");
							float amount =scan.nextFloat();
							activeAdmin.getAccount().getEWallet().TransferFunds(p.getAccount().getEWallet(), amount);
							
						case('D'):
							
							System.out.println(app.ApprovedPlaygrounds);
							System.out.println("Select Playground Number");
							int index =scan.nextInt();
							app.deletePlayground(app.ApprovedPlaygrounds, index);
						
						case('E'):
							System.out.println(app.ApprovedPlaygrounds);
							System.out.println("Select Playground Number");
							int index2 =scan.nextInt();
							app.suspendPlayground(app.ApprovedPlaygrounds, index2);
							
						case('F'):
							System.out.println(app.pendingPlaygrounds);
							System.out.println("Select Playground Number");
							int index3 =scan.nextInt();
							app.approvePlayground(app.pendingPlaygrounds, index3);
							
						case('G'):
							app.removeAdmin(activeAdmin);
						
						}
						
					}
				
	
	
	

			
			}
			
			//System.out.println("Do you want to Display All information ?"); 
			/*
			System.out.println("Yes/No (y/n)"); 
			input =scan.next().charAt(0);                                            //Display bank data
			if(input=='y'||input=='Y') {
				
				                                                            
			}*/
			System.out.println("Do you need any other Services ?"); 
			System.out.println("Yes/No (y/n)"); 
			input =scan.next().charAt(0);
			
			
			if(input=='n'||input=='N') {
				
				System.out.println("A Pleasure to Serve you :)"); 
				break;
			}else if(input=='y'||input=='Y') {
				
				continue;
			}
			
			
		}
		
		
		
		
		
		
		
		
		//==========================================================================================
	//	OwnerPlayground i=new OwnerPlayground("Ahmed","112132",1095702620);
		//Playground p2=new Playground(11,"213e3e333333bffffbsdbu snido",210,"Natural pure Grass");
//		p2.setOwner(i);
	//	p2.DisplayData();
		/*
		System.out.println("//////////////////////////////////////////");
		Playground p=new Playground(5,"213151547sdubsdbu snido",130,"Natural Grass");
		p.setOwner(o);
		p.DisplayData();
		System.out.println("//////////////////////////////////////////");
		o.addPlayground(p2);
		
		o.DisplayPlaygrounds();
		System.out.println("//////////////////////////////////////////");
		
		o.removePlayground(p2);
		o.DisplayPlaygrounds();
	*//*
		
		p2.getHours().DisplayTimeTable();
		
		
		String s=scan.next();
		
		String c=p2.getHours().find(p2.getHours().getAllTimes(),s);	
		System.out.println(c);
		
		p2.getHours().bookTime(p2, c);
		p2.getHours().DisplayTimeTable();
		*/
		//System.out.println(p2.getHours().getAllTimes().toString());
		//System.out.println(o.getAccount().toString());
		
		
		
		
		
		
		
		
		
	}

}
