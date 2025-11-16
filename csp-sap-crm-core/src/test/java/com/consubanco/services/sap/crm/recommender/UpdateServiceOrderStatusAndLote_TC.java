/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.recommender.impl.RecommenderServicesImpl;
import com.consubanco.services.sap.crm.recommender.model.UpdateServiceOrderStatusAndLoteRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class UpdateServiceOrderStatusAndLote_TC extends TestCase{

	
	private static Log log = LogFactory.getLog(UpdateServiceOrderStatusAndLote_TC.class);

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();			

		UpdateServiceOrderStatusAndLoteRequest request = new UpdateServiceOrderStatusAndLoteRequest();
		
		request.setIdOrdenServicio("1525000047");
		request.setIdEstatus("E0010");
		request.setIdLote("1");
		request.setConcepto("00055124811250300003");
		request.setCodigo("1125000000000001525000047");
		
		ArrayList<IProxyOutputData> returnList = processImpl.updateServiceOrderStatusAndLote(request );

		log.info(returnList);

		assertNotNull(returnList);
	}	
}
