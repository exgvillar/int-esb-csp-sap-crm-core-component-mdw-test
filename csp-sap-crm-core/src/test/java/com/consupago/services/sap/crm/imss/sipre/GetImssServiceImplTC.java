/**
 * 
 */
package com.consupago.services.sap.crm.imss.sipre;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.services.sap.crm.imss.sipre.vo.ImssSipreInfoVo;

/**
 * @author ramon.becerra
 *
 */
public class GetImssServiceImplTC extends TestCase {
	private static Log log = LogFactory.getLog( GetImssServiceImplTC.class );

	public void testFunction( ) throws Exception {
		CRMLocalConfigEnvironmentData.instance();
		GetImssServiceImpl imssSrv = new GetImssServiceImpl();
		ImssSipreInfoVo data = imssSrv.getImssSipreInfo("2267514", null);
		log.info( data.toString() );
	}
	
	
	
}
