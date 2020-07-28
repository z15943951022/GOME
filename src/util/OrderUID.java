package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class OrderUID {
	
	public static String getUID(){
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	    String date=sdf.format(new Date());
	    String newDate=sdf.format(new Date());
	    Random random=new Random();
	    String rd="";
	    for(int i=0;i<3;i++){
	    	rd+=random.nextInt(10);
	    }
		return newDate+rd;
	}

}
