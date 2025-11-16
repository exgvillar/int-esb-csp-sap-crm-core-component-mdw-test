package com.consubanco.services.sap.crm.common.formatF02;

import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_FAMILIAR_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_INGRESO_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class FormatF02CRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( FormatF02CRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public FormatF02CRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public FormatF02CRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		FormatF02CRMServiceImpl processImpl = new FormatF02CRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZTL_PEPS_Model pepData = new ZTL_PEPS_Model();
		
		pepData.setNumCliente("142");
		pepData.setNumSolicitud( "60000256" );
		pepData.setPuestoPEP("Diputado Plurinominal");
		pepData.setAreaDepto("Senado");
		pepData.setCargoEleccionPopular("Diputado");
		pepData.setFechaInicioGestion( Date.valueOf("2010-11-15") );
		pepData.setNombreDependencia("Nacional");
		pepData.setDireccionDependencia("Av. Juárez No. 1425, Col. Centro, Méx. D.F.");
		pepData.setIngresoBrutoMensual(10000);
		pepData.setOtrosNegocios("empresa particula");
		pepData.setDescOtrosNegocios("venta de calefactores");
        
        // add ingresos
        ArrayList<ZTL_PEPS_INGRESO_Model> ingresos = new ArrayList<ZTL_PEPS_INGRESO_Model>();
        ZTL_PEPS_INGRESO_Model ingreso1 = new ZTL_PEPS_INGRESO_Model(); 
        ingreso1.setCveIngreso("AR");
        ingreso1.setDescIngreso(""); // puede no enviarse
        ingreso1.setValor("X");
        ingresos.add(ingreso1);
        pepData.setIngresos(ingresos);
        
        //add familiares
        ArrayList<ZTL_PEPS_FAMILIAR_Model> familiares = new ArrayList<ZTL_PEPS_FAMILIAR_Model>();
        ZTL_PEPS_FAMILIAR_Model familiar1 = new ZTL_PEPS_FAMILIAR_Model();
        familiar1.setNombre("JUAN PEREZ GARCIA");
        familiar1.setOcupacion("SECRETARIO DE ESTADO");
        familiar1.setEstadoRadica("COLIMA");
        familiares.add( familiar1 );
        
        ZTL_PEPS_FAMILIAR_Model familiar2 = new ZTL_PEPS_FAMILIAR_Model();
        familiar2.setNombre("ANDREA PINEDA LOPEZ");
        familiar2.setOcupacion("DIPUTADA LOCAL");
        familiar2.setEstadoRadica("NUEVO LEON");
        familiares.add( familiar2 );

        pepData.setFamiliares(familiares);
                
		processImpl.saveFormatF02("", pepData);
		
	
	}


	 
}
