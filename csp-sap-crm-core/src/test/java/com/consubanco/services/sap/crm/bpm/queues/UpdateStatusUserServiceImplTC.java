package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class UpdateStatusUserServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UpdateStatusUserServiceImplTC.class );
	
	/**
	 * 
	 */
	public UpdateStatusUserServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UpdateStatusUserServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData data = new ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData();
       
		data.setBusinessPartner( "10001950" );
        data.setUserName( "brasso" );
        data.setStatusId( "1" );
        data.setStatusDesc( "ACTIVO" );
        
		ArrayList<IProxyOutputData> returnList = processImpl.updateStatusUser( data );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
