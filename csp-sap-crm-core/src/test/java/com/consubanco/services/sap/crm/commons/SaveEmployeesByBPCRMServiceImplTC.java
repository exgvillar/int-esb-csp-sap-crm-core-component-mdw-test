package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.employees.model.ZTL_EMPLEOBP_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class SaveEmployeesByBPCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveEmployeesByBPCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveEmployeesByBPCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveEmployeesByBPCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<ZTL_EMPLEOBP_Model> employees = new ArrayList<ZTL_EMPLEOBP_Model>();
		ZTL_EMPLEOBP_Model employee = new ZTL_EMPLEOBP_Model();
        
		employee.setBpId("0002614352");	
		employee.setClaveProfesion("1133");        
		employee.setLugarTrabajo("CSB");
		employee.setGiroEmpresa("0000500000");    	
		employee.setActividadEmpresa("0000511015");
		employee.setCargoDesempenadoId("02");   
		employee.setCargoDesempenado("Empleado"); 
		employee.setAntiguedadEmpleoActual(0); 	
		employee.setAntiguedadEmpleoAnterior(0);
		employee.setGiroActividadAltoRiesgo( "1074" );  
         	
		employee.setTelefonoTrabajo("2281001100");        
		employee.setMail("lpercio@gmg.com");
                
		employee.setIngresoMensual(10000.00);	
		employee.setOtrosIngresos(2000);    	
		employee.setFuenteOtrosIngresos("Consultorio");    	
		employee.setIngresoMensual(10000.0);
        
    	employees.add(employee);
    	
    	List<IProxyOutputData> result = processImpl.saveEmployeesByBP( employees );
    	log.info("Resultado :: "+result.toString());
	}
	 
}
