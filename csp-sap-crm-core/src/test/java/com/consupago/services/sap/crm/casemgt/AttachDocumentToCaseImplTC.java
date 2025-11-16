package com.consupago.services.sap.crm.casemgt;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author ramon.becerra
 *
 */
public class AttachDocumentToCaseImplTC extends TestCase {

	private static Log log = LogFactory.getLog( AttachDocumentToCaseImplTC.class );
	
	/**
	 * 
	 */
	public AttachDocumentToCaseImplTC() {
		
	}

	/**
	 * @param name
	 */
	public AttachDocumentToCaseImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		AttachDocumentToCaseImpl processImpl = new AttachDocumentToCaseImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		
		FileInputStream inputStream = new FileInputStream( new File("/SAPJCo_MigrationGuide_2.x_3.0_EN.pdf") );
		ByteArrayOutputStream out = new ByteArrayOutputStream( );				
		
		
		byte[] buf = new byte[4096];  
		int read;     
		while ((read = inputStream.read(buf)) != -1) {         
			out.write(buf, 0, read);
		}
		
		BASE64Encoder b64 = new BASE64Encoder();
		
		
		String base64Content = b64.encode( out.toByteArray() );
        
		System.out.println(" base64 -> " + base64Content );
        
		
		String contentURL = processImpl.attachDocumentToQuotation("50006663", "SAPJCo_MigrationGuide_2.x_3.0_EN.pdf", base64Content);
		
		log.info( contentURL );
		
		assertNotNull( contentURL );
	}

	
}
