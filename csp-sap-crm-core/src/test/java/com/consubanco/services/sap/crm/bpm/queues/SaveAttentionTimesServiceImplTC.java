package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class SaveAttentionTimesServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveAttentionTimesServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveAttentionTimesServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveAttentionTimesServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData data = new ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData();
        data.setBusinessPartner( "10000061" );
        
        ArrayList<String> convenioIdList = new ArrayList<String>();
        convenioIdList.add("10000024");
        data.setConvenioIdList( convenioIdList );
        
        data.setProductCategoryId( "" );
        data.setAttentionTime( 30 );
        data.setUser( "hsanchezag" );
        
		ArrayList<IProxyOutputData> returnList = processImpl.saveAttentionTimes( data, false );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
