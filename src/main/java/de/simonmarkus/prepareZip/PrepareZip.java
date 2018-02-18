package de.simonmarkus.prepareZip;

import java.io.IOException;
import java.util.Properties;

import org.dom4j.DocumentException;


/**
 *
 *
 */
public class PrepareZip 
{
	public static void main( String[] args )
	{
		Properties properties = new Properties();
		
		try {
			properties.load(PrepareZip.class.getResourceAsStream("/prepareZip.properties"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
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
