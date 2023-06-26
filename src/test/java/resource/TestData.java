package resource;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.location;

public class TestData {
	
	
	public Addplace payload(String name, String language , String address)
	{
		Addplace a= new Addplace();
		a.setAccuracy(50);
		a.setName(name);
		a.setPhone_number("(+91) 983 743 356");
		a.setAddress(address);
		a.setWebsite("http://google.com");
		a.setLanguage(language);
		List<String> arr =new ArrayList<String>();
		arr.add("shoe parkkkkk");
		arr.add("shopno9");
		a.setTypes(arr);
		location l=new location();
		l.setLat((int) -38.383494);
		l.setLng((int) 33.7827362);
		a.setLocation(l);
		
		return a;
	}

}
