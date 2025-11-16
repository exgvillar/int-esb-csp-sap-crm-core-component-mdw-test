package com.consupago.services.sap.crm.casemgt;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class GetFileListCaseImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetFileListCaseImplTC.class );
	
	/**
	 * 
	 */
	public GetFileListCaseImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetFileListCaseImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		AttachDocumentToCaseImpl processImpl = new AttachDocumentToCaseImpl();
		
		CRMLocalConfigEnvironmentData.instance();		
		
		
		ArrayList<IProxyOutputData> fileList = processImpl.getFileListFromCMN( "0050093472" );
		
		log.info( fileList );
			
	}

	
}
