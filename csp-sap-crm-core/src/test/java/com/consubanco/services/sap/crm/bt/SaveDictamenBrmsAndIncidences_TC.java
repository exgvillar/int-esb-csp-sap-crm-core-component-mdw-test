/**
 * 
 */
package com.consubanco.services.sap.crm.bt;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bt.model.ZESCRMBT_E002_INCIDENCIAS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author juribe
 *
 */
public class SaveDictamenBrmsAndIncidences_TC extends TestCase {

private static Log log = LogFactory.getLog( SearchPhonesOwnerServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveDictamenBrmsAndIncidences_TC() {
		
	}

	/**
	 * @param name
	 */
	public SaveDictamenBrmsAndIncidences_TC(String name) {
		super(name);
		
	}
	
	public void test() throws Exception {
		
		CRMBuroTelefonicoService processImpl = new CRMBuroTelefonicoServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		String idSolicitud= "0050386200";
		String bpId = "0002500500";
		String phone = "5580123345";
		boolean dictamenBrms = true;
		List<ZESCRMBT_E002_INCIDENCIAS_Model> incidences = new ArrayList<ZESCRMBT_E002_INCIDENCIAS_Model>();
		ZESCRMBT_E002_INCIDENCIAS_Model incidence = null;
		
		incidence = new ZESCRMBT_E002_INCIDENCIAS_Model();
		incidence.setDescExt("descExt");
		incidence.setDescInt("descInterna");
		incidence.setIdCausa("1");
		incidence.setIdIncidencia(1);
		incidence.setIdMotivo("20");
		incidence.setIdSolicitud(idSolicitud);
		incidence.setPhone(phone);
		String protocolCalledQuality = "PROTO";
		String ownerPhoneBp = "07654321";
		
		incidences.add(incidence);
		
		
		ArrayList<IProxyOutputData> returnList = processImpl.saveDictamenBrmsAndIncidences(idSolicitud, bpId, phone, dictamenBrms, protocolCalledQuality , ownerPhoneBp, incidences);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
}
