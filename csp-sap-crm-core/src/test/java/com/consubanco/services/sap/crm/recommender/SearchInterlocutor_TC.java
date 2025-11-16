/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.recommender.impl.RecommenderServicesImpl;
import com.consubanco.services.sap.crm.recommender.model.SearchInterlocutorRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class SearchInterlocutor_TC extends TestCase {

	private static Log log = LogFactory.getLog(SearchInterlocutor_TC.class);

	/**
	 * 
	 */
	public SearchInterlocutor_TC() {

	}

	/**
	 * @param name
	 */
	public SearchInterlocutor_TC(String name) {
		super(name);

	}

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();

		SearchInterlocutorRequest searchInterlocutorRequest = new SearchInterlocutorRequest();

		searchInterlocutorRequest.setBp("2606553");
		searchInterlocutorRequest.setClientId("");
		searchInterlocutorRequest.setRfc("");
		searchInterlocutorRequest.setCurp("");
		searchInterlocutorRequest.setName1("");
		searchInterlocutorRequest.setName2("");
		searchInterlocutorRequest.setApePat("");
		searchInterlocutorRequest.setApeMat("");
		searchInterlocutorRequest.setCompanyId("");

		ArrayList<IProxyOutputData> returnList = processImpl.searchInterlocutor(searchInterlocutorRequest);

		log.info(returnList);

		assertNotNull(returnList);
	}
}
