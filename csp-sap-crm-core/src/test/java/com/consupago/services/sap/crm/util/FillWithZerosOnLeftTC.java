/**
 * 
 */
package com.consupago.services.sap.crm.util;

import junit.framework.TestCase;

/**
 * @author ramon.becerra
 *
 */
public class FillWithZerosOnLeftTC extends TestCase {

	/**
	 * 
	 */
	public FillWithZerosOnLeftTC() {
	}

	/**
	 * @param name
	 */
	public FillWithZerosOnLeftTC(String name) {
		super(name);
	}

	public void testFilled( ) throws Exception {
		assertEquals("0050045270", SAPFormatter.fillStringWithZerosOnLeft("50045270", 10 ) );
	}
}
