/**
 * 
 */
package com.consupago.services.sap.crm.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;

/**
 * @author Juan Ramon
 *
 */
public final class SAPFormatter {

	 /**
     * Log4J instance class, write the events of this class in the specified log file
     */
    private static Log log = LogFactory.getLog( SAPFormatter.class );
  
	
    public static String fillStringWithZerosOnLeft( String str, int toLength ) {
    	StringBuffer buffer = new StringBuffer();
    	if( str.length() >= toLength )
    		buffer.append( str );
    	else {
    		int j = str.length();
    		for(int i = j; i < toLength; i ++ ) {
    			buffer.append("0");
    		}
    		buffer.append( str );
    	}
    		
    	return( buffer.toString() );
    }    
    
    public static byte[] convertFileBinario(String base64Content) {
		BASE64Decoder bd64 = new BASE64Decoder();
		byte[] decodedBytes = null;
		
		if(StringUtils.trimToNull(base64Content) != null) {
			try {
				decodedBytes = bd64.decodeBuffer( base64Content );
			} catch (IOException e) {
				log.error("Error :: Parsing Bytes " + e.getStackTrace(), e);
			}
		}
		
		return decodedBytes;		
	}
}
