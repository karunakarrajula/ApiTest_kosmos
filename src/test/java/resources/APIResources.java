package resources;


public enum APIResources {
	GetResults("http://1k-dev.1kosmos.net/healthz"),
	GetEula("https://1k-dev.1kosmos.net/api/v3/rest/default/eula?tenant=1kosmos");
	
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
