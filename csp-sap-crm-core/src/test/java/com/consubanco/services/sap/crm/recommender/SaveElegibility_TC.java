/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.recommender.impl.RecommenderServicesImpl;
import com.consubanco.services.sap.crm.recommender.model.SaveElegibilityRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class SaveElegibility_TC extends TestCase {

	private static Log log = LogFactory.getLog(SaveElegibility_TC.class);

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();			

		SaveElegibilityRequest saveElegibilityRequest = new SaveElegibilityRequest();
		saveElegibilityRequest.setServiceOrderId( "1525000050" );
		saveElegibilityRequest.setRecommenderBp("1525000050");
		saveElegibilityRequest.setRecommendedBp( "1525000050" );			
		saveElegibilityRequest.setSolCotRecomended( "50384083" );		
		saveElegibilityRequest.setAmount( 11000 );
		saveElegibilityRequest.setStatus( "E0006" );			
		List<String> motives = new ArrayList<String>();		
		motives.add("E0001");
		saveElegibilityRequest.setMotives(motives );		
		saveElegibilityRequest.setRecommendedNumber( 2 );
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 10, 8);
		saveElegibilityRequest.setElegibilityDate( cal.getTime() );
		saveElegibilityRequest.setElegibility( true );
					
		ArrayList<IProxyOutputData> returnList = processImpl.saveElegibility(saveElegibilityRequest );

		log.info(returnList);

		assertNotNull(returnList);
	}	
}
