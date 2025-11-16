/**
 * 
 */
package com.consubanco.services.sap.crm.puc;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.adobe.forms.PDFManager_CreditStatement;
import com.consubanco.adobe.forms.cub.model.FileBOResponse;
import com.consubanco.adobe.forms.cxn.Field;
import com.consubanco.sap.interfaces.puc.ZCRMPUC_E001_ESTADO_CUENTA_OutputData;
import com.consubanco.sap.interfaces.puc.ZCRMPUC_E001_ESTADO_CUENTA_ProxyImpl;
import com.consubanco.services.sap.crm.puc.models.CreditBalancesPDF;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import ICBSCustomerService.CallWSGetCreditStatement;
import ICBSCustomerService.LoanBO;
import ICBSCustomerService.ResponseGetCrediStat;
import ICBSCustomerService.TransactionBO;

/**
 * @author estefania.montoya
 *
 */
public class CreditStatementImpl implements CreditStatementPDF {

	private static Log log = LogFactory.getLog(CreditStatementImpl.class);
	List<Field> fieldsListCredit = new ArrayList<Field>();
	
	public FileBOResponse getCreditStatementPDF(String appId, String reqId, long crdId, CreditBalancesPDF crdBalance ) throws Exception {
		// Obtener datos webService
		ResponseGetCrediStat resWS = CallWSGetCreditStatement.getMovements(appId, reqId, crdId);
		FileBOResponse response = new FileBOResponse();

		if(resWS.isSuccess()){
			
	
		// Obtener datos RFC
		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		//Obtener datos ICBS..

		ZCRMPUC_E001_ESTADO_CUENTA_ProxyImpl proxy = new ZCRMPUC_E001_ESTADO_CUENTA_ProxyImpl();
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ACCOUNT_ID");
		input.setValue(Formatter.fillStringWithZerosOnLeft(Long.toString(crdId), 12));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		if (returnData != null && !returnData.isEmpty()) {
			Iterator<IProxyOutputData> it = returnData.iterator();
			while (it.hasNext()) {
				ZCRMPUC_E001_ESTADO_CUENTA_OutputData dataRFC = (ZCRMPUC_E001_ESTADO_CUENTA_OutputData) it.next();

				// Validar si el success es falso

				createFieldsCredit("periodo", "Del " + " al");
				createFieldsCredit("fechaEmision", "");
				createFieldsCredit("cuenta", dataRFC.getAccount());
				createFieldsCredit("nombreAcreditado", dataRFC.getBorrowerName());
				createFieldsCredit("nCredito", dataRFC.getCreditId());
				createFieldsCredit("dependencia", dataRFC.getDependency());
				createFieldsCredit("fechaForm", dataRFC.getFormDate());
				createFieldsCredit("montoDispo", dataRFC.getDispoAmount());
				LoanBO[] arrLoan = resWS.getData().getLoanBO();

				if (arrLoan != null) {
					createFieldsCredit("medioDisp", arrLoan[0].getOperationType());
					createFieldsCredit("montoBasMora", arrLoan[0].getNombreMontoBaseInteresMoratorio());
					createFieldsCredit("montoBasOrdin", arrLoan[0].getNombreMontoBaseInteresOrdinario());

					createFieldsCredit("iva", String.valueOf(arrLoan[0].getVatRate()));
				}
				createFieldsCredit("montoTotal", dataRFC.getTotalAmount());
				createFieldsCredit("nPagos", dataRFC.getNumPay());
				createFieldsCredit("descuentPeri", dataRFC.getPeriodDiscount());
				createFieldsCredit("tipoMoneda", dataRFC.getTypeCurrency());
				createFieldsCredit("periocidad", dataRFC.getPayPeriod());
				createFieldsCredit("interesOrdinario", dataRFC.getOrdInterestRate());
				createFieldsCredit("comApertura", dataRFC.getComission());
				createFieldsCredit("totalCom", dataRFC.getTotalComi());
				createFieldsCredit("monedaPesos", dataRFC.getCurrency());
				createFieldsCredit("fechaCobro", dataRFC.getPayDate());
				createFieldsCredit("totalPagado", crdBalance.getTotalPaid());
				createFieldsCredit("saldoPendiente", crdBalance.getOutsBalance());
				createFieldsCredit("pagosPend", String.valueOf(crdBalance.getPendPay()));
				createFieldsCredit("montoInteres", crdBalance.getTotalInterestAmt());
				createFieldsCredit("saldoCapital", crdBalance.getTotalCapitalAmt());

				createFieldsCredit("totalCapital", crdBalance.getTotalCapitalPay());
				createFieldsCredit("totalIntereses", crdBalance.getTotalInterestPay());
				createFieldsCredit("totalIva", crdBalance.getTotalVatAmt());
				createFieldsCredit("interesMora", crdBalance.getTasaMora()+ " %");

				
				TransactionBO[] listTransactions = resWS.getData().getTransactionBO();

				ByteArrayOutputStream file = PDFManager_CreditStatement.createCreditStatementPDF(fieldsListCredit,
						listTransactions);
				
				String base64String = new String(Base64.encodeBase64(file.toByteArray()));
				String fileName = "PUCCreditStatement" + Formatter.formatDate(new Date(), "yyyy-MM-dd-Hms") + ".pdf";

				response.setName(fileName);
				response.setBase64(base64String);
				response.setSuccess(dataRFC.isSuccess());
				response.setMessage(dataRFC.getMessage());
				log.info("Archivo generado : " + response.toString());
			}
		}
		}else{
			response.setSuccess(false);
			response.setMessage(resWS.getMessage());
		}
			
		return response;
	}

	public void createFieldsCredit(String key, String val) {

		Field field = new Field();
		field.setKey(key);
		field.setValue(val);
		fieldsListCredit.add(field);

	}


}
