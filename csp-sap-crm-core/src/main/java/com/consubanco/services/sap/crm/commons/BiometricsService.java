/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.io.Serializable;
import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public interface BiometricsService extends Serializable  {
	
	/**
	 * M&eacute;todo que permite adjuntar un biometrico a un BP_ID
	 *
	 * El método guarda la huella o la foto o ambas, al menos una
	 * 
	 * @param bpId Identificador Buisness Partner
	 * @param fingerPrint Archivo que contiene la huella digital 
	 * @param photo Archivo que contiene la fotografia
	 * 
	 * @return mensaje de exito
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> attachBiometricsByBP(String bpId, String fingerPrintBase64, String photoBase64) throws Exception;
	
	/**
	 * M&eacute;todo que permite leer los biometricos de un BP_ID
	 * 
	 * @param bpId
	 * @param typeBiometric 1: Descarga la huella digital <br/> 2: Descarga la fotografia <br/> 3: Descarga ambos archivos
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> getGetBiometricsByBpId(String bpId, int typeBiometric)throws Exception;
	
	/**
	 * 
	 * M&eacute;todo que permite bloquear un BP si ha tenido 3 intentos fallidos al verificar huella digital 
	 * 
	 * @param bpId Identificador de Business Partner
	 * @param isLock TRUE = bloquear BP
	 * @param counter permite saber cuantos intentos fallidos al verificar su huella
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> lockBP(String bpId, boolean isLock, int counter) throws Exception;
	
}
