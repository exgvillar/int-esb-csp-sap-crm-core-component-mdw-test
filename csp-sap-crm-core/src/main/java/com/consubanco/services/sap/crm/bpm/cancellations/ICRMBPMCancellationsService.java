package com.consubanco.services.sap.crm.bpm.cancellations;


import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationRequestBOP;
import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationResponseBOP;


public interface ICRMBPMCancellationsService {

	public CancelApplicationResponseBOP cancellApplicationCxN( CancelApplicationRequestBOP cancelApplicationRequestBOP ) throws Exception;
	

}
