package com.consubanco.services.sap.crm.commons;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.commons.BiometricsService;
import com.consubanco.services.sap.crm.commons.BiometricsServiceImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class BiometricsServiceImplTC extends TestCase {
	
	private static final Log log = LogFactory.getLog(BiometricsServiceImplTC.class);

	public BiometricsServiceImplTC() {
		super();
	}

	public BiometricsServiceImplTC(String name) {
		super(name);
	}

	/*
	 * Adjunta los biometricos
	 */
	public void testAttachFingerPrintServiceImpl( ) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		BiometricsService biometricsService = new BiometricsServiceImpl();
		
		String bpId="0002600768";
		String fileName = "fingerPrint-0002600768.fpt";
		String pathOrigenHuella = "C:/temp/enrollment/" + fileName;
		String pathOrigenFoto = "C:/tmp/prueba.jpg";
		
		File fingerPrint = null;
		fingerPrint = new File(pathOrigenHuella);
		
		File photo = null;
		photo = new File(pathOrigenFoto);
		byte[] contenidoArchivoFP = getContenidoArchivo(fingerPrint);
		byte[] encodeBase64FP = Base64.encodeBase64(contenidoArchivoFP);
		String fingerPrintEncodeBase64 = new String(encodeBase64FP);
		
		byte[] contenidoArchivoPH = getContenidoArchivo(photo);
		byte[] encodeBase64PH = Base64.encodeBase64(contenidoArchivoPH);
		String photoEncodeBase64 = new String(encodeBase64PH);
		
		ArrayList<IProxyOutputData> returnList = biometricsService.attachBiometricsByBP(bpId, fingerPrintEncodeBase64 , photoEncodeBase64);
		
		log.info(returnList.toString());
				
		assertFalse(returnList.isEmpty());
		
	}
	
	/*
	 * Obtiene los biometricos
	 */
	public void testGetAttachFingerPrintServiceImpl( ) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		BiometricsService biometricsService = new BiometricsServiceImpl();
		
		String bpId="0002600768";
		int tipoBiometrico = 3;
		ArrayList<IProxyOutputData> returnList = biometricsService.getGetBiometricsByBpId(bpId, tipoBiometrico);
		
		log.info(returnList.toString());
		
		assertFalse(returnList.isEmpty());
		
	}
	
	/*
	 * Bloquea/Desbloquea un BP
	 */
	public void testLockBPServiceImpl( ) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		BiometricsService biometricsService = new BiometricsServiceImpl();
		
		String bpId="0002600768";
		boolean isLock = false;
		int counter = 0;
		ArrayList<IProxyOutputData> returnList = biometricsService.lockBP(bpId, isLock, counter );
		
		log.info(returnList.toString());
		
		assertFalse(returnList.isEmpty());
		
	}
	
	private byte[] getContenidoArchivo(File file) throws Exception {

		if(file == null)
			return null;
		FileInputStream stream = new FileInputStream(file);
		byte[] data = new byte[stream.available()];
		stream.read(data);
		stream.close();

		return data;
	}

}
