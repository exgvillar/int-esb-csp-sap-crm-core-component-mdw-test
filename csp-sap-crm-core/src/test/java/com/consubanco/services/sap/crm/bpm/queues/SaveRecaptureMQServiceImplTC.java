package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.bpm.queues.models.IncidenceRecaptureInputParameter;
import com.consubanco.services.sap.crm.bpm.queues.models.RecaptureInputParameter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class SaveRecaptureMQServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveRecaptureMQServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveRecaptureMQServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveRecaptureMQServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		RecaptureInputParameter recapture = new RecaptureInputParameter();
		recapture.setFolioApplication( "0050385712" );
		recapture.setTotalRecapture( 2 );
		recapture.setUserCaptureError( "succorp" );
		recapture.setUserReport( "mesacontrol" );
		recapture.setRoleReport( "MESA_DE_CONTROL" );
		recapture.setUserCaptureResolve( "" ); //succorp
		
		ArrayList<IncidenceRecaptureInputParameter> incidencesRecapture = new ArrayList<IncidenceRecaptureInputParameter>();
		IncidenceRecaptureInputParameter incidence = new IncidenceRecaptureInputParameter();
		incidence.setId(1);
		incidence.setCause("OTRO");
		incidence.setMotive("OTROS");
		incidence.setDescription("ERROR EN APELLIDO PATERNO");
		incidence.setResolve( true );
		incidencesRecapture.add( incidence );
		
		incidence = new IncidenceRecaptureInputParameter();
		incidence.setId(2);
		incidence.setCause("OTRO");
		incidence.setMotive("OTROS");
		incidence.setDescription("ERROR CLAVE PRESUPUESTAL");
		incidence.setResolve( false );
		incidencesRecapture.add( incidence );
		
		recapture.setIncidencesRecapture(incidencesRecapture);
		recapture.setSaveIncidence( true );
		
		ArrayList<IProxyOutputData> returnList = processImpl.saveRecaptureMQ(recapture);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
