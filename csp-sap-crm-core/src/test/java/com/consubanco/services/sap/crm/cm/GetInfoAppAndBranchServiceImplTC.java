package com.consubanco.services.sap.crm.cm;

import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cm.models.BranchModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class GetInfoAppAndBranchServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetInfoAppAndBranchServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetInfoAppAndBranchServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetInfoAppAndBranchServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		ICMService processImpl = new CMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		BranchModel branch = new BranchModel();
		branch.setBranchId( "50000036" );
		branch.setStartDate( Date.valueOf("2017-05-01") );
		branch.setEndDate( Date.valueOf("2017-05-31") );
		
		ArrayList<IProxyOutputData> returnList = processImpl.getInfoByAppAndBranch("50001724", branch );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
