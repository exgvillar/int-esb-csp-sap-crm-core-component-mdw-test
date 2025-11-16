/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.adobe.forms.PDFManager_CUB;
import com.consubanco.adobe.forms.cub.model.FileBORequest;
import com.consubanco.adobe.forms.cub.model.FileBOResponse;
import com.consubanco.adobe.forms.cxn.Field;
import com.consubanco.esb.services.sitiaa.crm.ISITIAACRMService;
import com.consubanco.esb.services.sitiaa.crm.SITIAACRMServiceImpl;
import com.consubanco.esb.validator.constants.CommonConstants;
import com.consubanco.sap.interfaces.common.formatF02.ZRFC_PEPS_GET_ProxyImpl;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consubanco.sap.interfaces.common.terminados.ZCRMCRT_P001_SAVE_CONYUGE_Model;
import com.consubanco.sap.interfaces.common.terminados.ZCRMCRT_P001_SAVE_CONYUGE_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMCSB_E002_BUSCABP_OutputData;
import com.consubanco.sap.interfaces.commons.ZCRMCSB_E002_BUSCABP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMCSB_P004_ADDUPDBP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_E005_BUSCADDRBP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_E006_BUSCATTRMKTG_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_P009_UPDTADDRBP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZFM_BP_RELACIONES_ProxyImpl;
import com.consubanco.sap.interfaces.commons.cub.ZCRMCAP_E001_GETINFOFORCUB_OutputData;
import com.consubanco.sap.interfaces.commons.cub.ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl;
import com.consubanco.sap.interfaces.commons.cub.ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImpl;
import com.consubanco.sap.interfaces.commons.employees.ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.employees.ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.employees.model.ZTL_EMPLEOBP_Model;
import com.consubanco.sap.interfaces.commons.orgdata.ZCRMORI_E003_BPORGAN_ProxyImpl;
import com.consubanco.services.sap.crm.commons.models.AddressInputParameter;
import com.consubanco.services.sap.crm.commons.models.MarketingAttributeInputParameter;
import com.consubanco.services.sap.crm.commons.models.PersonInputParameter;
import com.consubanco.services.sap.crm.commons.models.PhoneInputParameter;
import com.consubanco.sitiaa.interfaces.crm.uif.ZCRMUIF_E001_GET_CUSTOMER_UIF_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import mx.com.shermfin.security.LDAPBean;
import mx.com.shermfin.security.model.UserInformationModel;

/**
 * @author ramon.becerra
 *
 */
public class CommonCRMServiceImpl implements CommonCRMService {

	private static Log log = LogFactory.getLog(CommonCRMServiceImpl.class);

	/**
	 * 
	 */
	public CommonCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consubanco.services.sap.crm.commons#searchInterlocutor( String
	 * bpId, String clientId, String rfc, String name1, String name2, String
	 * lastname1, String lastname2, String nameCompany ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> searchInterlocutorPlain(String bpId, String clientId, String rfc, String name1, String name2, String lastname1, String lastname2, String curp, String nameCompany, boolean getBasicData)
		throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_E002_BUSCABP_ProxyImpl proxy = new ZCRMCSB_E002_BUSCABP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		if (StringUtils.isNotEmpty(bpId))
			input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(bpId), 10));
		else
			input.setValue(StringUtils.trimToEmpty(bpId));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CLIENT");
		input.setValue(clientId);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_RFC");
		input.setValue(rfc);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_NAME1");
		input.setValue(name1);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_NAME2");
		input.setValue(name2);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_APEPAT");
		input.setValue(lastname1);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_APEMAT");
		input.setValue(lastname2);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_COMPANY");
		input.setValue(nameCompany);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_FIND_BASIC");
		String valueI_FIND_BASIC = getBasicData ? "X" : "";
		input.setValue(valueI_FIND_BASIC);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CURP");
		input.setValue(curp);
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		// Busca en UIF
		if (StringUtils.isNotEmpty(rfc) || StringUtils.isNotEmpty(name1) || StringUtils.isNotEmpty(lastname1) || StringUtils.isNotEmpty(lastname2)) {
			ISITIAACRMService processImpl = new SITIAACRMServiceImpl();
			ArrayList<IProxyOutputData> returnDataUIF = processImpl.getUIFCustomer("", rfc.replace("*", "%"), "", "", "", "",
				"%" + StringUtils.trimToEmpty(lastname1) + "%" + StringUtils.trimToEmpty(lastname2) + "%" + StringUtils.trimToEmpty(name1) + "%" + StringUtils.trimToEmpty(name2) + "%");

			if (returnData != null && returnData.size() > 0) {
				for (int i = 0; i < returnData.size(); i++) {
					ZCRMCSB_E002_BUSCABP_OutputData data = (ZCRMCSB_E002_BUSCABP_OutputData) returnData.get(i);

					for (int j = 0; j < returnDataUIF.size(); j++) {
						ZCRMUIF_E001_GET_CUSTOMER_UIF_OutputData uifData = (ZCRMUIF_E001_GET_CUSTOMER_UIF_OutputData) returnDataUIF.get(j);

						if (data.getBpId().equals(uifData.getBp())) {
							data.setUIFList(true);
							returnData.set(i, data);
							returnDataUIF.remove(j);
						}
					}
				}

			}

			// lee lista UIF si es que tiene registros aún
			for (int j = 0; returnDataUIF != null && j < returnDataUIF.size(); j++) {
				ZCRMUIF_E001_GET_CUSTOMER_UIF_OutputData uifData = (ZCRMUIF_E001_GET_CUSTOMER_UIF_OutputData) returnDataUIF.get(j);

				ZCRMCSB_E002_BUSCABP_OutputData data = new ZCRMCSB_E002_BUSCABP_OutputData();
				data.setBpId(uifData.getBp());
				data.setName1(uifData.getName());
				data.setLastname1(uifData.getLastName());
				data.setLastname2(uifData.getLastName2());
				data.setLocked(true);
				data.setUIFList(true);

				returnData.add(data);
			}
		}

		return (returnData);
	}

	public ArrayList<IProxyOutputData> searchInterlocutor(String bpId, String clientId, String rfc, String name1, String name2, String lastname1, String lastname2, String curp, String nameCompany, boolean getBasicData) throws Exception {
		if (StringUtils.isNotEmpty(rfc) && rfc.length() == 13) {
			log.info("Buscando RFC [" + rfc + " ] a 13 posiciones");
		} else {
			if (StringUtils.isNotEmpty(rfc) && rfc.length() >= 10) {
				log.info("Buscando RFC [" + rfc + " ] a 10 posiciones, no es de 13 pero es mayor a 10 o mucho mayor a 13");
				rfc = rfc.substring(0, 10) + "*";
			} else {
				log.info("No hay búsqueda por RFC...");
			}
		}

		return searchInterlocutorPlain(bpId, clientId, rfc, name1, name2, lastname1, lastname2, curp, nameCompany, getBasicData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consubanco.services.sap.crm.commons#saveInterlocutor(
	 * PersonInputParameter person ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> saveInterlocutor(PersonInputParameter person) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P004_ADDUPDBP_ProxyImpl proxy = new ZCRMCSB_P004_ADDUPDBP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("BP_ID");
		input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(person.getBpId()), 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("CLIENTID");
		input.setValue(StringUtils.trimToEmpty(person.getClientId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("ROLLID");
		input.setValue(StringUtils.trimToEmpty(person.getBpRolId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("GROUPID");
		input.setValue(StringUtils.trimToEmpty(person.getGroupId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("RFC");
		input.setValue(StringUtils.trimToEmpty(person.getRfc()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("CURP");
		input.setValue(StringUtils.trimToEmpty(person.getCurp()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("NAME1");
		input.setValue(StringUtils.trimToEmpty(person.getName1()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("NAME2");
		input.setValue(StringUtils.trimToEmpty(person.getName2()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("LASTNAME1");
		input.setValue(StringUtils.trimToEmpty(person.getLastname1()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("LASTNAME2");
		input.setValue(StringUtils.trimToEmpty(person.getLastname2()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("NAMECOMPANY");
		input.setValue(StringUtils.trimToEmpty(person.getNameCompany()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("DATEBIRTH");
		input.setType("java.util.date");
		input.setDateValue(person.getDateBirth());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("PLACEBIRTH");
		input.setValue(StringUtils.trimToEmpty(person.getPlaceBirth()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("COUNTRYBIRTH");
		if (person.getCountryBirthId().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
			input.setValue("");
		else
			input.setValue(StringUtils.trimToEmpty(person.getCountryBirthId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("NATIONALITY");
		if (person.getNationalityId().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
			input.setValue("");
		else
			input.setValue(StringUtils.trimToEmpty(person.getNationalityId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("DESCNATION");
		input.setValue(StringUtils.trimToEmpty(person.getNationalityDesc()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("MARITALSTATUS");
		if (person.getMaritalStatusId().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
			input.setValue("");
		else
			input.setValue(StringUtils.trimToEmpty(person.getMaritalStatusId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("DESCMARITALST");
		input.setValue(StringUtils.trimToEmpty(person.getMaritalStatusDesc()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("EMAIL");
		input.setValue(StringUtils.trimToEmpty(person.getEmail()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("LEGALENTITY");
		input.setValue(StringUtils.trimToEmpty(person.getLegalEntity()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("GENDER");
		input.setValue(StringUtils.trimToEmpty(person.getGender()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("LEVELSTUDIES");
		if (person.getLevelStudiesId().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
			input.setValue("");
		else
			input.setValue(StringUtils.trimToEmpty(person.getLevelStudiesId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("DESCLEVESTUD");
		input.setValue(StringUtils.trimToEmpty(person.getLevelStudiesDesc()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("DATECREATE");
		input.setType("java.util.date");
		input.setDateValue(person.getDateCreate());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("FIEL");
		input.setValue(StringUtils.trimToEmpty(person.getFIEL()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("RESIDENCECOUNTRY");
		input.setValue(person.getResidenceCountry());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("IDENTIFICATIONTYPE");
		input.setValue(person.getIdentificationType());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("IDENTIFICATIONNUMBER");
		input.setValue(person.getIdentificationNumber());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("COUNTRY_ASSFISC");
		input.setValue(person.getAssignedCountryIdentificationNumber());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("IDENTIFICATIONTYPE2");
		input.setValue(person.getIdentificationType2());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("IDENTIFICATIONNUMBER2");
		input.setValue(person.getIdentificationNumber2());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("ES_CLIENTE");
		if (person.isClient())
			input.setValue("X");
		else
			input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("DEP_ECONOMIC");
		input.setValue(StringUtils.trimToEmpty(person.getPersonalInfo().getDependentsEconomicsNumber()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("EDADES_HIJOS");
		input.setValue(StringUtils.trimToEmpty(person.getPersonalInfo().getAgeDependentsEconomics()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("HABIT_HOGAR");
		input.setValue(StringUtils.trimToEmpty(person.getPersonalInfo().getPeopleHomeNumber()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("IDREGIMENFISCAL");
		input.setValue(StringUtils.trimToEmpty(person.getIdRegimenFiscal()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("DESCREGIMENFISCAL");
		input.setValue(StringUtils.trimToEmpty(person.getDescRegimenFiscal()));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, false);

		return (returnData);
	}

	/***
	 * 
	 */
	public String getBPIdByUsername(String username) throws Exception {
		String businessPartnerId = null;

		UserInformationModel data = LDAPBean.userInformation(username);
		log.info(data.toString());
		businessPartnerId = data.getUrl();

		return (businessPartnerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consubanco.services.sap.crm.commons#searchAddress( String bpId )
	 * throws Exception;
	 */
	public ArrayList<IProxyOutputData> searchAddress(String bpId) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_E005_BUSCADDRBP_ProxyImpl proxy = new ZCRMORI_E005_BUSCADDRBP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(bpId), 10));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consubanco.services.sap.crm.commons#saveAddress( String bpId,
	 * ArrayList<AddressInputParameter> address ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> saveAddress(String bpId, ArrayList<AddressInputParameter> address) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P009_UPDTADDRBP_ProxyImpl proxy = new ZCRMORI_P009_UPDTADDRBP_ProxyImpl();

		ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
		inputParams.setGeneralParam(new ArrayList<ProxyInputParameter>());
		inputParams.setRecordParam(new ArrayList<Object>());

		// general Params
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(bpId), 10));
		inputParams.getGeneralParam().add(input);

		Iterator<AddressInputParameter> it = address.iterator();
		while (it.hasNext()) {
			AddressInputParameter addressRecord = it.next();

			ArrayList<ProxyInputParameter> recordParams = new ArrayList<ProxyInputParameter>();
			ProxyInputParameter inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ADDRESS_ID");
			inputRecord.setValue(addressRecord.getAddressId());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ADDRESS_TYPE");
			if (addressRecord.getAddressTypeId().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
				inputRecord.setValue("");
			else
				inputRecord.setValue(addressRecord.getAddressTypeId());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ADDTYPE_DESC");
			inputRecord.setValue(addressRecord.getAddressTypeDesc());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ADDRESS_TYPEVIA");
			if (addressRecord.getAddressTypeViaId().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
				inputRecord.setValue("");
			else
				inputRecord.setValue(addressRecord.getAddressTypeViaId());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ADDTVIA_DESC");
			inputRecord.setValue(addressRecord.getAddressTypeViaDesc());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("STREET");
			inputRecord.setValue(addressRecord.getStreet());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("INTERNALNUMBER");
			inputRecord.setValue(addressRecord.getInternalNumber());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("EXTERNALNUMBER");
			inputRecord.setValue(addressRecord.getExternalNumber());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ZIPCODE");
			inputRecord.setValue(addressRecord.getZipCode());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("SUBURB");
			inputRecord.setValue(addressRecord.getSuburb());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("SETTLEMENTTYPE");
			if (addressRecord.getSettlementTypeId().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
				inputRecord.setValue("");
			else
				inputRecord.setValue(addressRecord.getSettlementTypeId());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("SETLTYPE_DESC");
			inputRecord.setValue(addressRecord.getSettlementTypeDesc());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("TOWN");
			inputRecord.setValue(addressRecord.getTown());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("TOWNSHIP");
			inputRecord.setValue(addressRecord.getTownship());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("CITY");
			inputRecord.setValue(addressRecord.getCity());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("STATE");
			if (addressRecord.getState().equals(CommonConstants.KEY_CATALOG_NOTFOUND))
				inputRecord.setValue("");
			else
				inputRecord.setValue(addressRecord.getState());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("COUNTRY");
			inputRecord.setValue(addressRecord.getCountry());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("BETWEENSTREET");
			inputRecord.setValue(addressRecord.getBetweenStreet());
			recordParams.add(inputRecord);

			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ANDSTREET");
			inputRecord.setValue(addressRecord.getAndStreet());
			recordParams.add(inputRecord);

			if (addressRecord.getPhones() != null) {
				Iterator<PhoneInputParameter> itPhone = addressRecord.getPhones().iterator();
				while (itPhone.hasNext()) {
					PhoneInputParameter phone = itPhone.next();
					if (phone.getPhoneType().equals(CommonConstants.PHONETYPE_FIJO)) {
						inputRecord = new ProxyInputParameter();
						inputRecord.setKey("TELFIJO");
						inputRecord.setValue(phone.getNumber());
						recordParams.add(inputRecord);
						inputRecord = new ProxyInputParameter();
						inputRecord.setKey("EXTENCI");
						inputRecord.setValue(phone.getExtension());
						recordParams.add(inputRecord);
					} else if (phone.getPhoneType().equals(CommonConstants.PHONETYPE_MOVIL)) {
						inputRecord = new ProxyInputParameter();
						inputRecord.setKey("TELCELU");
						inputRecord.setValue(phone.getNumber());
						recordParams.add(inputRecord);
					} else if (phone.getPhoneType().equals(CommonConstants.PHONETYPE_FAX)) {
						inputRecord = new ProxyInputParameter();
						inputRecord.setKey("TELFAX");
						inputRecord.setValue(phone.getNumber());
						recordParams.add(inputRecord);
						inputRecord = new ProxyInputParameter();
						inputRecord.setKey("EXTFAX");
						inputRecord.setValue(phone.getExtension());
						recordParams.add(inputRecord);
					}
				}
			} else {
				inputRecord = new ProxyInputParameter();
				inputRecord.setKey("TELFIJO");
				inputRecord.setValue("");
				recordParams.add(inputRecord);

				inputRecord = new ProxyInputParameter();
				inputRecord.setKey("EXTENCI");
				inputRecord.setValue("");
				recordParams.add(inputRecord);

				inputRecord = new ProxyInputParameter();
				inputRecord.setKey("TELCELU");
				inputRecord.setValue("");
				recordParams.add(inputRecord);

				inputRecord = new ProxyInputParameter();
				inputRecord.setKey("TELFAX");
				inputRecord.setValue("");
				recordParams.add(inputRecord);

				inputRecord = new ProxyInputParameter();
				inputRecord.setKey("EXTFAX");
				inputRecord.setValue("");
				recordParams.add(inputRecord);
			}

			inputParams.getRecordParam().add(recordParams);

		}

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consubanco.services.sap.crm.commons#getAttributesMarketingBP(
	 * String bpId ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getAttributesMarketingBP(String bpId) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_E006_BUSCATTRMKTG_ProxyImpl proxy = new ZCRMORI_E006_BUSCATTRMKTG_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(bpId), 10));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consubanco.services.sap.crm.commons#saveAttributesMarketingBP(
	 * String bpId, ArrayList<MarketingAttributeInputParameter> attributes )
	 * throws Exception;
	 */
	public boolean saveAttributesMarketingBP(String bpId, ArrayList<MarketingAttributeInputParameter> attributes) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl proxy = new ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl();

		ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
		inputParams.setGeneralParam(new ArrayList<ProxyInputParameter>());
		inputParams.setRecordParam(new ArrayList<Object>());

		// general Params
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(bpId), 10));
		inputParams.getGeneralParam().add(input);

		Iterator<MarketingAttributeInputParameter> it = attributes.iterator();
		while (it.hasNext()) {
			MarketingAttributeInputParameter attributeRecord = it.next();

			ArrayList<ProxyInputParameter> recordParams = new ArrayList<ProxyInputParameter>();
			ProxyInputParameter inputRecord = new ProxyInputParameter();
			inputRecord.setKey("PARTNER");
			inputRecord.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(bpId), 10));
			recordParams.add(inputRecord);
			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("GRUPO_ATRIBUTOS");
			inputRecord.setValue(attributeRecord.getAttributeGroupId());
			recordParams.add(inputRecord);
			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("DESCR_GRUPOATT");
			inputRecord.setValue(attributeRecord.getAttributeGroupDesc());
			recordParams.add(inputRecord);
			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("CLAVE_ATRIBUTO");
			inputRecord.setValue(attributeRecord.getAttributeId());
			recordParams.add(inputRecord);
			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("VALOR_ATRIBUTO");

			if (attributeRecord.getAttributeValue().equals("true") || attributeRecord.getAttributeValue().equals("false")) {
				if (Boolean.parseBoolean(attributeRecord.getAttributeValue()))
					inputRecord.setValue("SI");
				else
					inputRecord.setValue("NO");
			} else
				inputRecord.setValue(attributeRecord.getAttributeValue());
			recordParams.add(inputRecord);
			inputRecord = new ProxyInputParameter();
			inputRecord.setKey("DESCR_ATRIBUTO");
			inputRecord.setValue(attributeRecord.getAttributeDesc());
			recordParams.add(inputRecord);

			inputParams.getRecordParam().add(recordParams);

		}

		boolean returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}

	public ArrayList<IProxyOutputData> getOrgData(String businessPartnerId, String documentType) throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_E003_BPORGAN_ProxyImpl proxy = new ZCRMORI_E003_BPORGAN_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("P_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(businessPartnerId, 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_TIPDOC");
		input.setValue(documentType);
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}

	public ArrayList<IProxyOutputData> getSubordinates(String bpId, String relationType) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZFM_BP_RELACIONES_ProxyImpl proxy = new ZFM_BP_RELACIONES_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(bpId, 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_RELACION");
		input.setValue(relationType);
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}

	public List<IProxyOutputData> saveEmployeesByBP(List<ZTL_EMPLEOBP_Model> employees) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl proxyEmp = new ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl();

		return proxyEmp.executeRemoteFunction(destination, employees);
	}

	public ArrayList<IProxyOutputData> getEmployeesByBp(String bpId) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl proxy = new ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(bpId, 10));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}

	public ArrayList<IProxyOutputData> saveCustomerFlag(String bpId, String operationTyp, String source,String folioApp) throws Exception {
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImpl proxy = new ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(bpId, 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_OPERATIOTYPE");
		input.setValue(operationTyp);
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_SOURCE");
		input.setValue(source);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_FOLIOAPP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(folioApp, 10));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);
		log.info("Response saveCustomerFlag: " + returnData.toString());
		return returnData;
	}

	public FileBOResponse getCUBSurveyByCustomer(String customerBp, String biotaskID,
			ArrayList<FileBORequest> fileList, String applicationId, boolean idResources) throws Exception {
		FileBOResponse response = new FileBOResponse();
		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl proxy = new ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_CUSTOMERBP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(customerBp, 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_BIOTASKID");
		input.setValue(biotaskID);
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);
		List<Field> fieldsList = new ArrayList<Field>();

		if (returnData != null && !returnData.isEmpty()) {
			Iterator<IProxyOutputData> it = returnData.iterator();
			while (it.hasNext()) {
				ZCRMCAP_E001_GETINFOFORCUB_OutputData data = (ZCRMCAP_E001_GETINFOFORCUB_OutputData) it.next();
				Field field = new Field();
				field.setKey("name");
				field.setValue(data.getName());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("lastName");
				field.setValue(data.getLastName());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("lastName2");
				field.setValue(data.getLastName2());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("birthday");
				field.setValue(data.getBirthday());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("gender");
				field.setValue(data.getGender());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("entdFed");
				field.setValue(data.getEntdFed());
				fieldsList.add(field);

				field = new Field();
				field.setKey("countryBirth");
				field.setValue(data.getCountryBirth());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("nationality");
				field.setValue(data.getNationality());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("curp");
				field.setValue(data.getCurp());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("rfc");
				field.setValue(data.getRfc());
				fieldsList.add(field);

				field = new Field();
				field.setKey("clavElect");
				field.setValue(data.getClavElect());
				fieldsList.add(field);

				field = new Field();
				field.setKey("numFirmElec");
				field.setValue(data.getFiel());
				fieldsList.add(field);

				field = new Field();
				field.setKey("ocupacion");
				field.setValue(data.getOcupacion());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("ocupacion");
				field.setValue(data.getOcupacion());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("street");
				field.setValue(data.getStreet());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("numExt");
				field.setValue(data.getNumExt());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("numInt");
				field.setValue(data.getNumInt());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("col");
				field.setValue(data.getCol());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("postCode");
				field.setValue(data.getPostCode());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("municip");
				field.setValue(data.getMunicip());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("state");
				field.setValue(data.getState());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("country");
				field.setValue(data.getCountry());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("tel");
				field.setValue(data.getTel());
				fieldsList.add(field);
				
				field = new Field();
				field.setKey("mail");
				field.setValue(data.getMail());
				fieldsList.add(field);
				
				ByteArrayOutputStream file = PDFManager_CUB.createCUBSurveyByCustomerPDF(fieldsList, fileList, applicationId, idResources );
				byte[] byteArray = file.toByteArray();
				String base64String = new String(Base64.encodeBase64(byteArray));
				String fileName = "CUBSurvey_" + Formatter.formatDate(new Date(), "yyyy-MM-dd-Hms") + ".pdf";

			
			response.setName(fileName);
			response.setBase64(base64String);
			response.setSuccess(data.isSuccess());
			response.setMessage(data.getMessage());
			log.info("Archivo CUB generado : "+response.toString());
		}
		}
		return response;
	}

	public ZTL_PEPS_Model getF02Data(String customerBp, String folioApplication) throws Exception {
		ZTL_PEPS_Model model = null;
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZRFC_PEPS_GET_ProxyImpl proxy = new ZRFC_PEPS_GET_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENT");
        input.setValue( Formatter.fillStringWithZerosOnLeft( customerBp, 10 ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUMDOC");
        input.setValue( Formatter.fillStringWithZerosOnLeft( folioApplication, 10 ) );
        inputParams.add( input );
        		
        model = proxy.executeRemoteFunction(destination, inputParams );
		return model;
	}

	public ArrayList<IProxyOutputData> saveMaritalStatusByBp(ZCRMCRT_P001_SAVE_CONYUGE_Model req) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMCRT_P001_SAVE_CONYUGE_ProxyImpl proxy = new ZCRMCRT_P001_SAVE_CONYUGE_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_CLIENTE");
        input.setValue( Formatter.fillStringWithZerosOnLeft( req.getCustomerId(), 10 ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NOM1_CONYUGE");
        input.setValue( req.getFirstName() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NOM2_CONYUGE");
        input.setValue( req.getMiddleName() );
        inputParams.add( input );        
        input = new ProxyInputParameter();
        input.setKey("I_APEPAT_CONYUGE");
        input.setValue( req.getPaternalLastName() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_APEMAT_CONYUGE");
        input.setValue( req.getMaternalLastName() );
        inputParams.add( input );
              
		return  proxy.executeRemoteFunction(destination, inputParams );
	}

}
