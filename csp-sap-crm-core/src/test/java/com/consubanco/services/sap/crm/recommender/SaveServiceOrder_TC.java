/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.recommender.impl.RecommenderServicesImpl;
import com.consubanco.services.sap.crm.recommender.model.SaveServiceOrderRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class SaveServiceOrder_TC extends TestCase {

	private static Log log = LogFactory.getLog(SaveServiceOrder_TC.class);

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();			

		SaveServiceOrderRequest saveServiceOrderRequest = new SaveServiceOrderRequest();
		saveServiceOrderRequest.setServiceOrderId( "" );
		saveServiceOrderRequest.setRecommenderBp("");
		saveServiceOrderRequest.setEmployeeBp( "" );
		saveServiceOrderRequest.setRecommendedBp( "" ); 
		saveServiceOrderRequest.setFolioApplication( "" );
		saveServiceOrderRequest.setSourceChannel( "" );
		saveServiceOrderRequest.setAmount( 0 );
		saveServiceOrderRequest.setObservations( "" );		
		
		ArrayList<IProxyOutputData> returnList = processImpl.saveServiceOrder(saveServiceOrderRequest);

		log.info(returnList);

		assertNotNull(returnList);
	}	
}
