package com.consupago.services.sap.crm.recomendados;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.model.ESTATUS_MOTIVO_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;

/**
 * @author omar.corona
 *
 */
public class UpdateStatusMotiveRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UpdateStatusMotiveRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public UpdateStatusMotiveRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UpdateStatusMotiveRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testUpdateStatusMotive( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ESTATUS_MOTIVO_Model inputParamsData = new ESTATUS_MOTIVO_Model();
		
        inputParamsData.setNumeroOrdenServicio("1525000100");
        inputParamsData.setNuevoEstatus("E0007");
        
        ArrayList<ProxyInputParameter> motivos = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter motivo;
        
        motivo = new ProxyInputParameter();
        motivo.setValue("ZRC1");
        motivos.add(motivo);
        
        motivo = new ProxyInputParameter();
        motivo.setValue("ZRC2");
        motivos.add(motivo);
		
		inputParamsData.setMotivos(motivos);
		
		ArrayList returnList = processImpl.updateStatusMotive( inputParamsData );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	 
}
