package com.consubanco.services.sap.crm.commons;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.commons.models.PersonInputParameter;
import com.consubanco.services.sap.crm.commons.models.PersonalInfoInputParameter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

import junit.framework.TestCase;

/**
 * @author hsanchez
 *
 */
public class SaveInterlocutorCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog(SaveInterlocutorCommonCRMServiceImplTC.class);

	/**
	 * 
	 */
	public SaveInterlocutorCommonCRMServiceImplTC() {

	}

	/**
	 * @param name
	 */
	public SaveInterlocutorCommonCRMServiceImplTC(String name) {
		super(name);

	}

	public void testAuthCreateBP() throws Exception {

		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();

		CRMLocalConfigEnvironmentData.instance();

		PersonInputParameter person = new PersonInputParameter();
		person.setBpId("");
		person.setBpRolId("ZFS005");
		person.setGroupId("Z01");
		person.setRfc("BEDJ781029M19");
		person.setName1("JUAN");
		person.setName2("RAMON");
		person.setLastname1("BECERRA");
		person.setLastname2("DIAZ");
		person.setClient(true);

		ArrayList returnList = processImpl.saveInterlocutor(person);

		log.info(returnList);

		assertNotNull(returnList);
	}

	public void testAuthUpdateBP() throws Exception {

		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();

		CRMLocalConfigEnvironmentData.instance();

		PersonInputParameter person = new PersonInputParameter();
		person.setBpId("0002606753");
		person.setBpRolId("ZFS005");
		person.setGroupId("Z01");
		person.setRfc("BEDJ781029M19");
		person.setCurp("");
		person.setName1("JUAN");
		person.setName2("RAMON");
		person.setLastname1("BECERRA");
		person.setLastname2("DIAZ");
		person.setNameCompany("");

		person.setDateBirth(Date.valueOf("1978-10-29"));
		person.setPlaceBirth("distrito federal");
		person.setCountryBirthId("MX");
		person.setNationalityId("MX");
		person.setNationalityDesc("mexicana");
		person.setMaritalStatusId("2");
		person.setMaritalStatusDesc("Casado/a");
		person.setEmail("rbecerra@consupago.com");
		person.setLegalEntity("");
		person.setGender("M");
		person.setLevelStudiesId("0002");
		person.setLevelStudiesDesc("Catedrático");
		person.setDateCreate(Date.valueOf("2013-07-09"));
		person.setFIEL("");

		person.setIdentificationType("ZCPRO");
		person.setIdentificationNumber("9517453");

		person.setIdentificationType2("FS0002");
		person.setIdentificationNumber2("9523456789017453");

		PersonalInfoInputParameter personalInfo = new PersonalInfoInputParameter();
		personalInfo.setDependentsEconomicsNumber("2");
		personalInfo.setAgeDependentsEconomics("2,3");
		personalInfo.setPeopleHomeNumber("4");

		person.setPersonalInfo(personalInfo);

		person.setClient(true);
		person.setIdRegimenFiscal("612");
		person.setDescRegimenFiscal("Personas Físicas con Actividades Empresariales y Profesionales");

		ArrayList returnList = processImpl.saveInterlocutor(person);

		log.info(returnList);

		assertNotNull(returnList);
	}

}
