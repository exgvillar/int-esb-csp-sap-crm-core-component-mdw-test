package com.consubanco.services.sap.crm.bpm.queues;


import java.util.ArrayList;
import java.util.Date;

import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P008_UNLOCK_BP_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.models.ZWRKQUEUE_UNASIGN_SOLS_Model;
import com.consubanco.services.sap.crm.bpm.queues.models.RecaptureInputParameter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;


public interface CRMBPMQueuesService {

	public ArrayList<IProxyOutputData> saveUserCOX( ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData employee ) throws Exception;
	
	public ArrayList<IProxyOutputData> getUsersCox( String bp, String username ) throws Exception;
	
	public ArrayList<IProxyOutputData> getProductCategories( ) throws Exception;
	
	public ArrayList<IProxyOutputData> searchConvenioProd( String convenioId, String convenioDesc, String productId, String productDesc ) throws Exception;
	
	public ArrayList<IProxyOutputData> savePrioritiesConvProd( String convProdId, String categoryId, int ratePriority ) throws Exception;
	
	public ArrayList<IProxyOutputData> getCatalogConfField( ) throws Exception;
	
	public ArrayList<IProxyOutputData> saveConfigurablesFields( ArrayList<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData> paramsList ) throws Exception;
	
	public ArrayList<IProxyOutputData> getConfigurablesFields( ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData data ) throws Exception;

	public ArrayList<IProxyOutputData> saveAttentionTimes( ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData attentionTime, boolean remove ) throws Exception;
	
	public ArrayList<IProxyOutputData> getAttentionTimes( String bp, String username ) throws Exception;
	
	public ArrayList<IProxyOutputData> updateStatusUser( ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData user ) throws Exception;
	
	public ArrayList<IProxyOutputData> getApplicationsByNotifications( boolean assigned ) throws Exception;

	public ArrayList<IProxyOutputData> saveMasterQueue( ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData queue ) throws Exception;

	public ArrayList<IProxyOutputData> availableUsers( ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData inputData ) throws Exception;

	public ArrayList<IProxyOutputData> getMasterQueue( ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData data ) throws Exception;

	public ArrayList<IProxyOutputData> getLastUsersAssignedByApp( String folioApplication ) throws Exception;
	
	public ArrayList<IProxyOutputData> monitorMasterQueue( Date startDate, Date endDate, String convenioId, String username, String taskPriorityId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getFolioApplicationGralInfo( String folioApplication ) throws Exception;
	
	public ArrayList<IProxyOutputData> unlockUsersCox( ZCRMWKQUE_P008_UNLOCK_BP_OutputData inputParams ) throws Exception;

	public ArrayList<IProxyOutputData> getPriorityMasterQueue( String executorRol, String taskPriorityKey, String taskPriorityDesc ) throws Exception;
	
	public ArrayList<IProxyOutputData> saveRecaptureMQ( RecaptureInputParameter recapture ) throws Exception;
	
	public ArrayList<IProxyOutputData> asignacionDeSolicitudes(ArrayList<ZWRKQUEUE_UNASIGN_SOLS_Model> dataList) throws Exception;
}
