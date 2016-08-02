package com.epam.gmail.properties;
import java.util.ResourceBundle;

public class PropertyProvider {
	
private static PropertyProvider instance = null;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("com.epam.gmail.properties.UserInfo");
	
	public static PropertyProvider getInstance()
	{
		if(instance==null)
		{
			instance = new PropertyProvider();
		}
		return instance;
	}
	
	public String getValue(Account key)
	{
		return bundle.getString(key.toString().toLowerCase());
	}

}