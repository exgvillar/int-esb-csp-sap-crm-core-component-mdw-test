/**
 * 
 */
package com.consupago.services.sap.crm.convenios;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.convenios.ZFM_FECHAS_JURIDICO_OutputData;

/**
 * @author ramon.becerra
 *
 */
public class ConveniosLegalDatesImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ConveniosLegalDatesImplTC.class );
	
	/**
	 * 
	 */
	public ConveniosLegalDatesImplTC() {
		
	}

	/**
	 * @param name
	 */
	public ConveniosLegalDatesImplTC(String name) {
		super(name);
	}

	public void testFunction( ) throws Exception {
		ConveniosLegalDatesImpl convImpl = new ConveniosLegalDatesImpl();
		ZFM_FECHAS_JURIDICO_OutputData data = convImpl.getConveniosLegalDates("10000027");
		log.info( data.toString() );
	}
}
