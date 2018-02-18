package de.simonmarkus.prepareZipMaven;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.dom4j.DocumentException;


/**
 *
 *
 */
public class App 
{
	public static void main( String[] args )
	{
        
		File propertiesFile = new File("./src/main/resources/prepareZip.properties");
		Properties properties = new Properties();
         
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(propertiesFile))) {
			properties.load(bis);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
         
		//System.out.println(properties.getProperty("schema"));
		
		try {
			SchemaParser.modifySchema(properties.getProperty("schema"),
					properties.getProperty("schema.version.path"),
					properties.getProperty("schema.version.path.element"),
					properties.getProperty("version"));
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
