package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.models.ZM_WORKINGHOURS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class SaveUserCOXServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveUserCOXServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveUserCOXServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveUserCOXServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData data = new ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData();
        data.setBusinessPartner( "0010000061" );
       
        data.setUserName( "nmontero" );
        data.setName1( "NORMA" );
        data.setName2( "ANGELICA" );
        data.setLastName1( "MONTERO" );
        data.setLastName2( "RAMIREZ" );
        data.setAreaKey( "2" );
        data.setAreaDesc( "AUTORIZACION" );
        data.setExperienceLevelKey( "1" );
        data.setExperienceLevelDesc( "BAJO" );
        data.setStatusKey( "1" );
        data.setStatusDesc( "ACTIVO" );
        data.setLocationKey( "1" );
        data.setLocationDesc( "COX" );
        data.setUserLastUpdate( "hsanchez" );
        data.setBreakTime( 60 );
        
        ArrayList<ZM_WORKINGHOURS_Model> workingHoursList = new ArrayList<ZM_WORKINGHOURS_Model>();
        ZM_WORKINGHOURS_Model dataHours = new ZM_WORKINGHOURS_Model();
        dataHours.setDayOfWeek("LUNES");
        dataHours.setCheckIn("0830");
        dataHours.setCheckOut("1600");
        workingHoursList.add( dataHours );
        
        dataHours = new ZM_WORKINGHOURS_Model();
        dataHours.setDayOfWeek("MARTES");
        dataHours.setCheckIn("0800");
        dataHours.setCheckOut("1830");
        workingHoursList.add( dataHours );
        
        data.setWorkingHoursList(workingHoursList);
        
        data.setRfcCrmMode("M");
        
		ArrayList<IProxyOutputData> returnList = processImpl.saveUserCOX( data );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
