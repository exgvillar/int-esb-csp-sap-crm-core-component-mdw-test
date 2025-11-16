package com.consubanco.services.sap.crm.common.formatF02;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_QEQ_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class SaveQEQCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveQEQCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveQEQCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveQEQCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		FormatF02CRMServiceImpl processImpl = new FormatF02CRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZTL_PEPS_Model pepData = new ZTL_PEPS_Model();
		
        // add qeq
        ArrayList<ZTL_QEQ_Model> qeqList = new ArrayList<ZTL_QEQ_Model>();
        ZTL_QEQ_Model _qeqData = new ZTL_QEQ_Model(); 
        
        _qeqData.setId("1");
        _qeqData.setQeqId("QEQ011305");
        _qeqData.setNombres("HECTOR");
        _qeqData.setApellidoPaterno("RAMIREZ");
        _qeqData.setApellidoMaterno("RODRIGUEZ");
        _qeqData.setCurp("0");
        _qeqData.setRfc("");
        _qeqData.setFechaNacimiento(null);
        _qeqData.setListaQEQ("FAMI");
        _qeqData.setEstatusQEQ("INACTIVO");
        _qeqData.setDependencia("");
        _qeqData.setPuesto("");
        _qeqData.setIdDispo("0");
        _qeqData.setCurpOk("0");
        _qeqData.setIdRel("QEQ002066");
        _qeqData.setRelationship("Hijo");
        _qeqData.setRazonSocial("");
        _qeqData.setRfcMoral("");
        _qeqData.setISSSTE("");
        _qeqData.setIMSS("");
        _qeqData.setIncome("");
        
        qeqList.add( _qeqData );
        pepData.setQeq( qeqList );
        
		processImpl.saveQEQ("142", "60000256", pepData);
		
	
	}


	 
}
