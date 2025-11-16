/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;

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
public class UpdateStatusServiceOrder_TC extends TestCase {

	private static Log log = LogFactory.getLog(UpdateStatusServiceOrder_TC.class);

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();			

		ArrayList<IProxyOutputData> returnList = processImpl.updateStatusServiceOrder("1750000002", "E0002", "ZTER");

		log.info(returnList);

		assertNotNull(returnList);
	}	
}
