package resource;

public enum Resources {
	
	
	AddPlaceAPI("/maps/api/place/add/json"),
	DeleteplaceAPI("/maps/api/place/delete/json"),
	GetplaceAPI("/maps/api/place/get/json");
	
private String resource;
	Resources(String resource)
	{
		this.resource=resource;
		
	}
public String getreource()
{
	return resource;
}
}
