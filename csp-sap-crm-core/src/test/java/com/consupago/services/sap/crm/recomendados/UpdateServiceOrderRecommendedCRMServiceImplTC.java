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

/**
 * @author omar.corona
 *
 */
public class UpdateServiceOrderRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UpdateServiceOrderRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public UpdateServiceOrderRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UpdateServiceOrderRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}
    
	public void testAddUpdateServiceOrder( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ORDEN_SERVICIO_Model serviceOrder = new ORDEN_SERVICIO_Model();
		
		serviceOrder.setNumeroOrdenServicio("1525000108");
		
		serviceOrder.setBpRefiere("578009");
		serviceOrder.setBpReferido("578007");
		serviceOrder.setMontoPago(700.0);
		serviceOrder.setBpEmpleadoResponsable("10002446");
		serviceOrder.setSolClienteReferido("50001181");
		serviceOrder.setTipoSolicitudCredito("ZCSP");
		serviceOrder.setFechaAprobacion(Date.valueOf("2015-06-01"));
		serviceOrder.setObservaciones("Test Case Update Service Order 50001181");
		serviceOrder.setOcurrenciasPago("3");
		serviceOrder.setCanalOrigen("001");
		serviceOrder.setReferenciaPago("201506091525000108");

		
		ArrayList<String> motivos = new ArrayList<String>();
		motivos.add("ZRC2");
		serviceOrder.setMotivos(motivos);


		serviceOrder.setMotivo("");

		List returnList = processImpl.addUpdateServiceOrder(serviceOrder);

		log.info( "returnList:" + returnList );

		if(returnList!= null){
			
			Iterator ite = returnList.iterator();
			while(ite.hasNext()){
				ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData osModel = (ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData)ite.next();				
				if(osModel!=null){
					String message = osModel.getMessage();
					log.info( "message:" + message );
					List osList = osModel.getOrdenServicioList();
					if(osList!=null){
						Iterator osIte = osList.iterator();
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
