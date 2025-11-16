/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.recommender.impl.RecommenderServicesImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class GetEnrollmentTaskByStatus_TC extends TestCase {

	private static Log log = LogFactory.getLog(GetEnrollmentTaskByStatus_TC.class);

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();			

		List<String> statusList = new ArrayList<String>();
		
		statusList.add("E0001");
		statusList.add("E0002");
		statusList.add("E0003");
		statusList.add("E0004");
		
		ArrayList<IProxyOutputData> returnList = processImpl.getEnrollmentTaskByStatus(statusList );

		log.info(returnList);

		assertNotNull(returnList);
	}	
}
