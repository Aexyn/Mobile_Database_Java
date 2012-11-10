import java.util.*;

class Warranty1{
	 static String WarrantyReturn(){ 
		Calendar cal=Calendar.getInstance();
		int d=cal.get(Calendar.DATE);
		int m=(cal.get(Calendar.MONTH)+1);
		int y=(cal.get(Calendar.YEAR)+1);
		String s=(d+"-"+m+"-"+y);
		return s;		
	}
}