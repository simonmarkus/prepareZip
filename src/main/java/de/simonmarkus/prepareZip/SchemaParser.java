package de.simonmarkus.prepareZip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class SchemaParser {
	
	public static void modifySchema (String xsdDatei, String versionPath, String versionElement, String version) throws DocumentException, IOException {
		File inputFile = new File(xsdDatei); 
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputFile);

		List<Node> nodes = document.selectNodes(versionPath + versionElement);

		for (Node node : nodes) {
		//	System.out.println("Versionen : " + node.valueOf("@value"));
			if (version.equals(node.valueOf("@value"))) {
				return;
			}
		}
		
		((Element) document.selectNodes(versionPath).get(0)).addElement("xs:pattern value=\"" + version + "\"");
		
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("utf-8");
	    XMLWriter writer = new XMLWriter(new FileOutputStream(xsdDatei),format);
	    writer.write(document);
	    writer.close();
	}
	

}
