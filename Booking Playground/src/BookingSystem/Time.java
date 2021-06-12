package BookingSystem;

import java.util.Set;

public class Time {

	//private String hour;
	private String[] hourArray= new String[24];
	public String[] tempArray= {"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"};
	private Playground playground;
	
	//String [] hourArray= {"00:00","01:00","02:00","03:00","04:00"};
	Time(Playground playground){
		arraySetter(hourArray);
		this.playground=playground;
		
	}
	
	void arraySetter(String[] hourArray) {
		for(int j=0;j<24;j++) {
			this.hourArray[j]=tempArray[j];
		}
	}
	
	
	void bookTime(Playground play,String h) {
		
		String SelectedHour = play.getHours().find(play.getHours().hourArray, h);
		
		hourArrayEditorToNull(play.getHours().hourArray,play.getHours().getIndex(play.getHours().hourArray, SelectedHour));
		
	}
	
	void hourArrayEditorToNull(String []Array,int index) {
		hourArray[index]=null;
	}
	
	String[] getAllTimes() {
		return hourArray;
	}
	
	
	int getIndex(String []Array,String h){

		int i;          
		if(h.length()==1 && h.charAt(0)=='0'||h.charAt(0)=='0' && h.charAt(1)=='0'){
			return 0;
			
		}else if(h.length()==1 || h.charAt(0)=='0' && h.charAt(1)!='0') {
			
			for(i=1;i<9;i++) {
					
				if(h.charAt(0)=='1'||h.charAt(0)=='0' && h.charAt(1)=='1') {
					return 1;
				}else if(h.charAt(0)=='2'|| h.charAt(0)=='0' && h.charAt(1)=='2') {
					return 2;
				}else if(h.charAt(0)=='3'|| h.charAt(0)=='0' && h.charAt(1)=='3') {
					return 3;
				}else if(h.charAt(0)=='4'|| h.charAt(0)=='0' && h.charAt(1)=='4') {
					return 4;
				}else if(h.charAt(0)=='5'|| h.charAt(0)=='0' && h.charAt(1)=='5') {
					return 5;
				}else if(h.charAt(0)=='6'|| h.charAt(0)=='0' && h.charAt(1)=='6') {
					return 6;
				}else if(h.charAt(0)=='7'|| h.charAt(0)=='0' && h.charAt(1)=='7') {
					return 7;
				}else if(h.charAt(0)=='8'|| h.charAt(0)=='0' && h.charAt(1)=='8') {
					return 8;
				}else if(h.charAt(0)=='9'|| h.charAt(0)=='0' && h.charAt(1)=='9') {
					return 9;
				}
			}
			
		}else if(h.charAt(0)=='1'){
			
			for(i=10;i<19;i++) {
		
				
				if(h.charAt(0)=='1' && h.charAt(1)=='0') {
					return 10;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='1') {
					return 11;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='2') {
					return 12;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='3') {
					return 13;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='4') {
					return 14;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='5') {
					return 15;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='6') {
					return 16;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='7') {
					return 17;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='8') {
					return 18;
				}else if(h.charAt(0)=='1' && h.charAt(1)=='9') {
					return 19;
				}
			}
			
		}else if(h.charAt(0)=='2') {
		
			for(i=20;i<24;i++) {
				if(h.charAt(0)=='2' && h.charAt(1)=='0') {
					return 20;
				}else if(h.charAt(0)=='2' && h.charAt(1)=='1') {
					return 21;
				}else if(h.charAt(0)=='2' && h.charAt(1)=='2') {
					return 22;
				}else if(h.charAt(0)=='2' && h.charAt(1)=='3') {
					return 23;
				}
			}
		}
		
		return -1;

		
	}
	
	String find(String []Array,String h) {
		int i;
		if(h.length()==1 && h.charAt(0)=='0'||h.charAt(0)=='0' && h.charAt(1)=='0'){
			return Array[0];
			
		}else if(h.length()==1 || h.charAt(0)=='0' && h.charAt(1)!='0') {
			
			for(i=1;i<9;i++) {
				
				if(h.charAt(0)=='1'||h.charAt(0)=='0' && h.charAt(1)=='1') {
					return Array[1];
				}else if(h.charAt(0)=='2'|| h.charAt(0)=='0' && h.charAt(1)=='2') {
					return Array[2];
				}else if(h.charAt(0)=='3'|| h.charAt(0)=='0' && h.charAt(1)=='3') {
					return Array[3];
				}else if(h.charAt(0)=='4'|| h.charAt(0)=='0' && h.charAt(1)=='4') {
					return Array[4];
				}else if(h.charAt(0)=='5'|| h.charAt(0)=='0' && h.charAt(1)=='5') {
					return Array[5];
				}else if(h.charAt(0)=='6'|| h.charAt(0)=='0' && h.charAt(1)=='6') {
					return Array[6];
				}else if(h.charAt(0)=='7'|| h.charAt(0)=='0' && h.charAt(1)=='7') {
					return Array[7];
				}else if(h.charAt(0)=='8'|| h.charAt(0)=='0' && h.charAt(1)=='8') {
					return Array[8];
				}else if(h.charAt(0)=='9'|| h.charAt(0)=='0' && h.charAt(1)=='9') {
					return Array[9];
				}
			}
			
		}else if(h.charAt(0)=='1'){
			
			for(i=10;i<19;i++) {
				
				if(h.charAt(0)=='1' && h.charAt(1)=='0') {
					return Array[10];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='1') {
					return Array[11];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='2') {
					return Array[12];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='3') {
					return Array[13];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='4') {
					return Array[14];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='5') {
					return Array[15];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='6') {
					return Array[16];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='7') {
					return Array[17];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='8') {
					return Array[18];
				}else if(h.charAt(0)=='1' && h.charAt(1)=='9') {
					return Array[19];
				}
			}
			
		}else if(h.charAt(0)=='2') {
		
			for(i=20;i<24;i++) {
				if(h.charAt(0)=='2' && h.charAt(1)=='0') {
					return Array[20];
				}else if(h.charAt(0)=='2' && h.charAt(1)=='1') {
					return Array[21];
				}else if(h.charAt(0)=='2' && h.charAt(1)=='2') {
					return Array[22];
				}else if(h.charAt(0)=='2' && h.charAt(1)=='3') {
					return Array[23];
				}
			}
		}
		
		return "Invalid Input";
	}
	
	
	Playground getPlayground() {
		return playground;
	}
	
	void DisplayTimeMenu() {
		System.out.println("01:00  "+"02:00  "+"03:00  "+"04:00");
		System.out.println("05:00  "+"06:00  "+"07:00  "+"08:00");
		System.out.println("09:00  "+"10:00  "+"11:00  "+"12:00");
		System.out.println("13:00  "+"14:00  "+"15:00  "+"16:00");
		System.out.println("17:00  "+"18:00  "+"19:00  "+"20:00");
		System.out.println("21:00  "+"22:00  "+"23:00  "+"00:00");
	}
	
	void  DisplayTimeTable() {
		int i;
		for(i=1;i<24;i++) {
			
			System.out.print(hourArray[i]+"  ");
			
			if(hourArray[i]==null) {
				
				System.out.print(" ");
				
			}else if(i%4==0&&i!=0) {
				
				System.out.print("\n");
				
			}else if(i==23) {
				
				System.out.print(hourArray[0]);
			}
		}
	}
	
}
