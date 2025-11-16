/**
 * 
 */
package com.consubanco.services.sap.crm.formalizacion;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.formalizacion.FormalizacionServiceImpl;
import com.consupago.sap.interfaces.proxy.convenios.ZFM_FECHAS_JURIDICO_OutputData;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_OutputData;

/**
 * @author ramon.becerra
 *
 */
public class FormalizacionServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( FormalizacionServiceImplTC.class );
	
	/**
	 * 
	 */
	public FormalizacionServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public FormalizacionServiceImplTC(String name) {
		super(name);
	}

	public void testFunction( ) throws Exception {
		FormalizacionServiceImpl formaSrv = new FormalizacionServiceImpl();
		ArrayList<String> arrSolic = new ArrayList<String>();
		for(int i=0;i<150;i++){
			arrSolic.add("0050383643");
			arrSolic.add("0050362073");
		}
		long startTime = System.currentTimeMillis(), endTime = 0, elapsedTime = 0;
		
		ArrayList<ZCRMTESO_E001_INFO_FORMALIZA_OutputData> arrRet = formaSrv.Formalizasolicitudes(arrSolic);
//		for (ZCRMTESO_E001_INFO_FORMALIZA_OutputData outputInfo : arrRet) {
//			System.out.println(outputInfo );
//		}
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.println( new java.sql.Timestamp( endTime ) + " :: Elapsed time :: " +  (((float)elapsedTime) / 1000f) + " seconds.");
		
	}
}
