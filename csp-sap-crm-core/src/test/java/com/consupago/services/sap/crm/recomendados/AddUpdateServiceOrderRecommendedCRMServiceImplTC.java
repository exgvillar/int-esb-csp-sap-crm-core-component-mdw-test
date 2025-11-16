package com.consupago.services.sap.crm.recomendados;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData;
import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author omar.corona
 *
 */
public class AddUpdateServiceOrderRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( AddUpdateServiceOrderRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public AddUpdateServiceOrderRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public AddUpdateServiceOrderRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}
    
	public void testAddUpdateServiceOrder( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ORDEN_SERVICIO_Model serviceOrder = new ORDEN_SERVICIO_Model();
		
		serviceOrder.setNumeroOrdenServicio("");

		serviceOrder.setBpRefiere("578020");
		serviceOrder.setBpReferido("578021");
		serviceOrder.setMontoPago(400);
		serviceOrder.setBpEmpleadoResponsable("10002446");
		serviceOrder.setSolClienteReferido("50001181");
		serviceOrder.setTipoSolicitudCredito("ZCSP");
		serviceOrder.setFechaAprobacion(Date.valueOf("2015-07-09"));
		serviceOrder.setObservaciones("Test Case Add Service Order 50001181");
		serviceOrder.setOcurrenciasPago("1");
		serviceOrder.setCanalOrigen("003");
		serviceOrder.setReferenciaPago("");

		
		ArrayList<String> motivos = new ArrayList<String>();
		motivos.add("");
		serviceOrder.setMotivos(motivos);

		List<IProxyOutputData> returnList = processImpl.addUpdateServiceOrder(serviceOrder);

		log.info( "returnList:" + returnList );

		if(returnList!= null){
			
			Iterator<IProxyOutputData> ite = returnList.iterator();
			while(ite.hasNext()){
				ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData osModel = (ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData)ite.next();				
				if(osModel!=null){
					String message = osModel.getMessage();
					log.info( "message:" + message );
					List<ORDEN_SERVICIO_Model> osList = osModel.getOrdenServicioList();
					if(osList!=null){
						Iterator<ORDEN_SERVICIO_Model> osIte = osList.iterator();
						while(osIte.hasNext()){
							ORDEN_SERVICIO_Model osm = (ORDEN_SERVICIO_Model)osIte.next();
							log.info( "osm:" + osm );
						}						
					}					
				}
			}		
		}

		assertNotNull( returnList );
	}

}
