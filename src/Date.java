import java.util.*;
class Date1{
	 static String DateReturn(){ 
		Calendar cal=Calendar.getInstance();
		int d=cal.get(Calendar.DATE);
		int m=(cal.get(Calendar.MONTH)+1);
		int y=cal.get(Calendar.YEAR);
		String s=(d+"-"+m+"-"+y);
		return s;
	}
}