/**
 * 
 */
package com.consubanco.services.sap.crm.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Juan Ramon
 *
 */
public final class Formatter {

	 /**
     * Log4J instance class, write the events of this class in the specified log file
     */
    private static Log log = LogFactory.getLog( Formatter.class );
  
	protected static String fdrTransactionFormatDate = null;
	protected static String fdrTemporaryCreditDate = null;
	
	static {
		String str_name = "customization.config";
		InputStream inStream = ClassLoader.getSystemResourceAsStream( str_name );
		if( inStream == null ) inStream = Formatter.class.getClassLoader().getResourceAsStream( str_name );
		Properties properties = new Properties();
		try {
			if( inStream != null ) properties.load( inStream );
			fdrTransactionFormatDate = properties.getProperty( "fdr.transaction.format.date" );
			fdrTemporaryCreditDate = properties.getProperty( "fdr.temporary.date" );
		} catch( IOException ex ) {
			log.error( "reading configuration file - " + str_name, ex );
		}
	}
    
    public static String fillStringWithZerosOnLeft( String str, int toLength ) {
    	StringBuffer buffer = new StringBuffer();
    	if( str.length() >= toLength )
    		buffer.append( str );
    	else {
    		int j = str.length();
    		for(int i = j; i < toLength; i ++ ) {
    			buffer.append("0");
    		}
    		buffer.append( str );
    	}
    		
    	return( buffer.toString() );
    }
    
    public static long retrieveCurrentSequence( String accountNumber ) {
    	StringBuffer buffer = new StringBuffer();
		buffer.append( StringUtils.substring( accountNumber, 10, 15 ) );
		return Long.parseLong( buffer.toString() );
    }
    
    public static String rewriteIncrementedAccountNumber( String accountNumber, long sequence )  {
//    	StringBuffer buffer = new StringBuffer();
//    	buffer.append( StringUtils.substring( accountNumber, 0, 10 ) ).append( fillStringWithZerosOnLeft( String.valueOf( sequence ), 5 ) ).append(" ");
    	return( accountNumber );
    }
    
    /**
     * @deprecated
     * @param accountNumber
     * @param sequence
     * @return
     */
    public static String rewriteIncrementedAccountNumberDeprecated( String accountNumber, long sequence )  {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append( StringUtils.substring( accountNumber, 0, 10 ) ).append( fillStringWithZerosOnLeft( String.valueOf( sequence ), 5 ) ).append(" ");
    	return( buffer.toString() );
    }
    
    public static synchronized String formatDate( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatHours( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("kkmmss");
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    public static String formatAccountEntryDate( ) {
    	StringBuffer buffer = new StringBuffer();
    	Calendar calendar = Calendar.getInstance();
		int month = calendar.get( Calendar.MONTH );
		month++;
		buffer.append( fillStringWithZerosOnLeft( String.valueOf( month ), 2) ).append( StringUtils.substring( String.valueOf( calendar.get( Calendar.YEAR ) ), 2, 4 ) );
		return( buffer.toString() );
    }
    
    public static synchronized String formatTemporaryCreditDate( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat(fdrTemporaryCreditDate);
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatTemporaryEndDate( ) {
		StringBuffer buffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		int initialMonth = calendar.get( Calendar.MONTH );
		calendar.roll( Calendar.MONTH, true );
		calendar.roll( Calendar.MONTH, true );
		int month = calendar.get( Calendar.MONTH );
		// change year
		if( month < initialMonth ) {
			calendar.roll( Calendar.YEAR, true );
		}
		buffer.append( formatTemporaryCreditDate( new Date( calendar.getTimeInMillis() ) ) );	
		
		return( buffer.toString() );
	}
    
    public static synchronized String formatPromotionTransactionDate( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat( fdrTransactionFormatDate );
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized boolean compareTransactionsAmount( String promotionAmount, String fdrAmount ) {
		boolean match = false;
		double promotion = Double.parseDouble( promotionAmount );
		double fdr = Double.parseDouble( fdrAmount );
		if( fdr == promotion )
			match = true;
		return( match );
	}
    
    public static synchronized boolean compareTransactionsAmountUnsigned( String promotionAmount, String fdrAmount ) {
		boolean match = false;
		
		double fdr = Math.abs( Double.parseDouble( fdrAmount ) );
		double promotion = Double.parseDouble( promotionAmount );
		if( fdr == promotion )
			match = true;
		return( match );
	}
    
    public static synchronized Date formatPromotionsPostedDate( String date ) {
		if( date == null )
			return null;
		String day = StringUtils.substring( date, 4, 6 );
		String month = StringUtils.substring( date, 2, 4 );
		String year = StringUtils.substring( date, 0, 2 );
		return( Date.valueOf( "20" + year + "-" + month + "-" + day ) );
	}
    
    public static synchronized String formatICAmount( String amount ) throws Exception {
		if( amount == null )
			return null;
		
		BigDecimal decimal = new BigDecimal( amount );		
		double leftSide = decimal.doubleValue();
		NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("00000000000000000.00");
		String output = df.format(leftSide);
		output = StringUtils.replace( output, ".", "");
		return( output );
	}
    
    public static synchronized String formatPromotionsAmount( String amount ) throws Exception {
		if( amount == null )
			return null;
		
		BigDecimal decimal = new BigDecimal( amount );		
		double leftSide = decimal.doubleValue();
		NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("0.00");
		String output = df.format(leftSide);
		output = StringUtils.replace( output, ".", "");
		return( output );
	}
    
    public static synchronized String formatPromotionsBatchAmount( String amount ) throws Exception {
		if( amount == null )
			return null;
		String output = StringUtils.replace( amount, ".", "");
		return( output );
	}
    
    public static synchronized String formatDateEndArchive( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_hhmmssss");
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    
    public static synchronized Date convertFromJulianDate( int jdate ) {
    	Calendar date = Calendar.getInstance();
    	Date gDate = null;
		if( jdate == 0 ) {
			return( null );
		} else {
			date.set(Calendar.DAY_OF_YEAR, jdate );
			gDate = new Date( date.getTimeInMillis() );				
		}
		return( gDate );
	}
    
    public static synchronized String formatCecobanAccount( String amount ) throws Exception {
		if( amount == null )
			return null;
		StringBuffer buffer = new StringBuffer();
		if( amount.length() > 13 )
			return amount;
		
		long account = Long.parseLong( amount );		
		
		NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("0000000000000");
		String output = df.format(account);
		output = StringUtils.replace( output, ".", "");
		return( output );
	}
    
    public static synchronized String formatCecobanCheckNumber( String checkNumber ) throws Exception {
		if( checkNumber == null )
			return null;
		
		long account = Long.parseLong( checkNumber );		
		
		NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("0000000000");
		String output = df.format(account);
		output = StringUtils.replace( output, ".", "");
		return( output );
	}
    
    
    public static synchronized String formatDataMatchCecobanAccount( String amount ) throws Exception {
		if( amount == null )
			return null;
		
		long account = Long.parseLong( amount );		
		
		NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("00000000000");
		String output = df.format(account);
		output = StringUtils.replace( output, ".", "");
		return( output );
	}
    
    public static synchronized String formatDataMatchCecobanCheckNumber( String checkNumber ) throws Exception {
		if( checkNumber == null )
			return null;
		
		long account = Long.parseLong( checkNumber );			
		
		NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("0000000");
		String output = df.format(account);
		output = StringUtils.replace( output, ".", "");
		return( output );
	}
    
    public static synchronized String formatInterfazContableMailAmount( String amount ) {
    	if( amount == null )
			return null;
    	String output = null;
    	try {
    		BigDecimal decimal = new BigDecimal( amount );		
    		double leftSide = decimal.doubleValue();
    		NumberFormat nf = NumberFormat.getNumberInstance( );
    		DecimalFormat df = (DecimalFormat)nf;
    		// "#,##0.##", 
    		df.applyPattern("#,###.##");
    		output = df.format(leftSide);
    		output = StringUtils.replace( output, ".", "");
    	} catch( Exception ex ) {
    		log.error("formatting number", ex );
    	}		
		return( output );
	}
    
    public static synchronized String formatSPEIReferenceNumber( long referenceNumber ) throws Exception {
    	NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("000000");
		String output = df.format(referenceNumber);
		output = StringUtils.replace( output, ".", "");
		return( output );
	}
    
    
    public static synchronized String formatPromotionsPostedArchiveDate( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmsss");
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    /**
     * 
     * @param amount
     * @return
     */
    public static synchronized String formatCollectionsPaymentAmount( String amount ) {
		StringBuffer buffer = new StringBuffer();
		if( amount == null ) {
			buffer.append("");
		} else {
			double db = Double.parseDouble( amount );
			NumberFormat nf = NumberFormat.getNumberInstance( );
    		DecimalFormat df = (DecimalFormat)nf;
    		// "#,##0.##", 
    		df.applyPattern("#########.00");
    		String output = df.format(db);
			buffer.append( StringUtils.replace( output, ",", "." ) );	
		}
		return( buffer.toString() );
	}
    
    /**
     * Input format = AAAAMMDD
     * Output format = DDMMAAAA
     * @param date
     * @return
     */
    public static synchronized String formatCollections500Dates( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("MMddyyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized Date formatCollections500SQLDate( String date ) throws Exception {
    	Date sqlTd = null;
		if( date == null ) {
			sqlTd = null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date td = format.parse( date );
			sqlTd = new Date( td.getTime() );
		}
		return( sqlTd );
	}
    
    public static synchronized Date formatPaymentsDates( String date ) throws Exception {
    	Date sqlTd = null;
		if( date == null ) {
			sqlTd = null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date td = format.parse( date );
			sqlTd = new Date( td.getTime() );
		}
		return( sqlTd );
	}
    
    /**
     * Input format = AAAAMMDD
     * Output format = DDMMAAAA
     * @param date
     * @return
     */
    public static synchronized String formatCollectionsSQLDatetoInputDate( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date.toString() );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("MMddyyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    /**
     * 
     * @param date
     * @return
     * @throws Exception
     */
    public static synchronized String formatCollections500FileName( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized Date format037JulianDate( String date ) throws Exception {
    	Date sqlTd = null;
		if( date == null ) {
			sqlTd = null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyddd");
			java.util.Date td = format.parse( date );
			sqlTd = new Date( td.getTime() );
		}
		return( sqlTd );
	}
    
    public static synchronized Date formatRolloutMonth018( Date reportingDate ) {
		Date rolledDate = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( reportingDate );
		int initialMonth = calendar.get( Calendar.MONTH );
		calendar.roll( Calendar.MONTH, false );
		int month = calendar.get( Calendar.MONTH );
		// change year
		if( month >= initialMonth ) {
			calendar.roll( Calendar.YEAR, false );
		}
		rolledDate = new Date( calendar.getTimeInMillis() );	
		
		return( rolledDate );
	}
    
    public static synchronized boolean detectdAdjustment( String reference ) {
		boolean isAdjustment = false;	
		if( StringUtils.trimToNull( reference ) == null )
			return false;
		if( reference.endsWith("XFRT") )
			isAdjustment = true;
		// TODO HACK!
//		if( StringUtils.contains( reference , "PG") )
//			isAdjustment = true;
		
		return( isAdjustment );
	}
    
    public static synchronized String parseETLCrossReference( String reference ) throws Exception {
    	String str = null;
		if( StringUtils.trimToNull( reference ) == null )
			return null;
		if( StringUtils.equals( reference, "00000000000000000") )
			str = null;
		else if( reference.length() == 17 ) {
			str = StringUtils.substring( reference, 1, 17 );
		} else if( reference.length() == 16 ) {
			str = reference;
		} else {
			throw new Exception("Card number not recognized :: " + reference );
		}
		
		return( str );
	}
    
    public static synchronized String formatToCIFJulianDate( Date date ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
	        SimpleDateFormat julianDate = new SimpleDateFormat("yyyyDDD");
	        buffer.append( julianDate.format(date) );
		}
		return( buffer.toString() );
	}
    
    public static synchronized Date convertJulianToDate( String jdate ) throws Exception {
    	Date date = null;
		if( jdate == null ) {
			date = null;
		} else {
	        SimpleDateFormat format = new SimpleDateFormat("yyyyDDD");
			java.util.Date td = format.parse( jdate );
			date = new Date( td.getTime() );
		}
		return( date );
	}
    
    public static synchronized String calculateCreditLine( String currentCreditLine, String proposedCreditLine, String availableCredit ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( currentCreditLine ) == null ) {
			throw new Exception(" currentCreditLine == null ");
		} else if( StringUtils.trimToNull( proposedCreditLine ) == null ) {
			throw new Exception(" proposedCreditLine == null ");
		} else if( StringUtils.trimToNull( availableCredit ) == null ) {
			throw new Exception(" currentBalance == null ");
		} else {
			double ac = Double.parseDouble( availableCredit );
			double ccl = Double.parseDouble( currentCreditLine );
			double pcl = Double.parseDouble( proposedCreditLine );
			double cb = ccl - ac;
			if( ccl == pcl ) {
				buffer.append( currentCreditLine );	
			} else {
				if( cb > pcl ) {
					double icb = cb * 1.1;
					if( icb > ccl ) {
						buffer.append( currentCreditLine );	
					} else {
						// Redondeado
						BigDecimal bd = new BigDecimal( icb );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointLeft( 2 );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointRight( 2 );
						buffer.append( bd.toString() );
					}
				} else {
					buffer.append( proposedCreditLine );	
				}
			}
		}
		return( buffer.toString() );
	}
    
    public static synchronized String calculateDecrementedCreditLine( String currentCreditLine, String behaviorScore, String availableCredit ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( currentCreditLine ) == null ) {
			throw new Exception(" currentCreditLine == null ");
		} else if( StringUtils.trimToNull( behaviorScore ) == null ) {
			throw new Exception(" behaviorScore == null ");
		} else if( StringUtils.trimToNull( availableCredit ) == null ) {
			throw new Exception(" currentBalance == null ");
		} else {
			double ac = Double.parseDouble( availableCredit );
			double ccl = Double.parseDouble( currentCreditLine );
			int bhs = Integer.parseInt( behaviorScore );
			double cb = ccl - ac;
			if( ac > ccl ) 
				cb = 0;
			
			if( cb == 0 ) {
				buffer.append( "2000" );	
			} else if( ccl <= 2000 ) {
				buffer.append( currentCreditLine );	
			} else if( StringUtils.equals( behaviorScore, "011" ) ) {
				double icb = cb * 1.4;
				if( icb > ccl ) {
					buffer.append( currentCreditLine );	
				} else {
					// Redondeado
					BigDecimal bd = new BigDecimal( icb );
					bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
					bd = bd.movePointLeft( 2 );
					bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
					bd = bd.movePointRight( 2 );
					if( bd.doubleValue() < 2000 )
						buffer.append( "2000" );
					else
						buffer.append( bd.toString() );
					
				}	
			} else {
				if( bhs >= 0 && bhs <= 599 ) {
					buffer.append( currentCreditLine );	
				} else if( bhs >= 600 && bhs <= 669 ) {
					double icb = cb * 1.2;
					if( icb > ccl ) {
						buffer.append( currentCreditLine );	
					} else {
						// Redondeado
						BigDecimal bd = new BigDecimal( icb );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointLeft( 2 );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointRight( 2 );
						if( bd.doubleValue() < 2000 )
							buffer.append( "2000" );
						else
							buffer.append( bd.toString() );
					}
				} else if( bhs >= 670 && bhs <= 699 ) {
					double icb = cb * 1.3;
					if( icb > ccl ) {
						buffer.append( currentCreditLine );	
					} else {
						// Redondeado
						BigDecimal bd = new BigDecimal( icb );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointLeft( 2 );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointRight( 2 );
						if( bd.doubleValue() < 2000 )
							buffer.append( "2000" );
						else
							buffer.append( bd.toString() );
					}	
				} else if( bhs >= 700 ) {
					double icb = cb * 1.4;
					if( icb > ccl ) {
						buffer.append( currentCreditLine );	
					} else {
						// Redondeado
						BigDecimal bd = new BigDecimal( icb );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointLeft( 2 );
						bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
						bd = bd.movePointRight( 2 );
						if( bd.doubleValue() < 2000 )
							buffer.append( "2000" );
						else
							buffer.append( bd.toString() );
					}	
				}
			}
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatDoubleCreditLine( double creditLine ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
    	BigDecimal bd = new BigDecimal( creditLine );
    	bd = bd.setScale( 0, BigDecimal.ROUND_DOWN );
    	buffer.append( bd.toString() );
		return( buffer.toString() );
	}
    
    public static synchronized String formatRFCDate( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
	public static synchronized String generaRfc( String paternal, String maternal, String firstName, String secondName, Date birthDate ) {
		String rfc = "";
		String apellidoPaterno = StringUtils.trimToEmpty( paternal ).trim().toUpperCase();
		rfc += apellidoPaterno.substring(0, 1);
		boolean vocalEncontrada = false;
		int i = 1;
		while (!vocalEncontrada && i < apellidoPaterno.length()) {
			char c = apellidoPaterno.charAt(i);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				rfc += c;
				vocalEncontrada = true;
			}
			i++;
		}
		if( StringUtils.trimToNull( maternal ) != null ) {
			rfc += StringUtils.trimToEmpty( maternal ).substring(0, 1).toUpperCase();
			rfc += StringUtils.trimToEmpty( firstName ).substring(0, 1).toUpperCase();
		} else {
			rfc += StringUtils.trimToEmpty( firstName ).substring(0, 2).toUpperCase();
		}
			
		
		if ( birthDate != null) {
			rfc += Formatter.formatRFCDate( birthDate );
		}
		return rfc;
	}
    
    public static synchronized String formatStatementCycleDate( String cycle, int delay ) throws Exception {	
		StringBuffer buffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.set( Calendar.DAY_OF_MONTH, Integer.parseInt( cycle ) );
		int initialMonth = calendar.get( Calendar.MONTH );
		if( delay == 1 ) {
			calendar.roll( Calendar.MONTH, false );
			calendar.roll( Calendar.MONTH, false );
		} else if( delay == 2 ) {
			calendar.roll( Calendar.MONTH, false );
			calendar.roll( Calendar.MONTH, false );
			calendar.roll( Calendar.MONTH, false );
		} else if( delay == 3 ) {
			calendar.roll( Calendar.MONTH, false );
			calendar.roll( Calendar.MONTH, false );
			calendar.roll( Calendar.MONTH, false );
			calendar.roll( Calendar.MONTH, false );
		} else {
			calendar.roll( Calendar.MONTH, false );
		}
		
		int month = calendar.get( Calendar.MONTH );
		// change year
		if( month > initialMonth ) {
			calendar.roll( Calendar.YEAR, false );
		}
		
		Date date = new Date( calendar.getTimeInMillis() );
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		buffer.append( format.format( date )  );	

		
		return( buffer.toString() );
	}
    
    public static synchronized String formatClubCardTicketsTotalAmount( double total ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
    	BigDecimal bd = new BigDecimal( total );
    	bd = bd.setScale( 2, BigDecimal.ROUND_UP );
    	buffer.append( bd.toString() );
		return( buffer.toString() );
	}
    
    /**
     * 
     * @param date
     * @return
     * @throws Exception
     */
    public static synchronized String formatClubCardFileName( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatTelemedicDate( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatHaypinckReportDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("dd/MM/yyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatChedrauiPaymentsDate( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatProsaPaymentsDate( Date date ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatPaymentAmount( double payment ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
		
		BigDecimal bd = new BigDecimal( payment );
		bd = bd.movePointLeft( 2 );
		buffer.append( bd.toString() );

		return( buffer.toString() );
	}
    
    public static synchronized String formatHaypinckReportFromChedrauiDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("dd/MM/yyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatHaypinckReportFromFDRDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("dd/MM/yyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatHaypinckReportFromProsaDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("dd/MM/yyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    
    public static synchronized long formatICBSAccountWithPrefix( String accountNumber ) throws Exception {
    	long accNbr = 0;
		if( StringUtils.trimToNull( accountNumber ) == null ) {
			accNbr = 0;
		} else {
			if( accountNumber.length() == 11 ) {
				accNbr =  Long.parseLong( StringUtils.substring( accountNumber , 1, 11 ) );
			} else {
				accNbr =  Long.parseLong( accountNumber );
			}			
		}		
		return( accNbr );
	}
    
    public static synchronized String formatICBSAccountWithPrefixAtTwelevePositions( String accountNumber ) throws Exception {
    	long accNbr = 0;
    	String _acctNbr = null;
		if( StringUtils.trimToNull( accountNumber ) == null ) {
			accNbr = 0;
		} else {
			if( accountNumber.length() == 11 ) {
				accNbr =  Long.parseLong( StringUtils.substring( accountNumber , 1, 11 ) );
			} else {
				accNbr =  Long.parseLong( accountNumber );
			}			
		}	
		
		_acctNbr = formatWithZerosRightJustified( accNbr , 12 );
		return( _acctNbr );
	}
    
	//right justified
	public static String formatWithZerosRightJustified(long _integer, int maxlength) {
		StringBuffer _stb = new StringBuffer();
		String _sti = String.valueOf(_integer);
		int len = _sti.length();
		//check!!!
		for(int j = 0; j < maxlength-len; j++) {	_stb.append("0"); }
		_stb.append(_sti);
		return _stb.toString();
	}

	//left justified
	public static String formatWithZerosLeftJustified(String  _str, int maxlength) {
		StringBuffer _stb = new StringBuffer();
		_stb.append(_str);
		int len = _stb.length();
		for(int j = len; j < maxlength; j++) {	_stb.append("0"); }
		return _stb.toString();
	}
	
    public static synchronized String getYearFromDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("yyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    
    public static synchronized String getMonthCodeFromDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("MM");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    
    public static synchronized String getMonthNameFromDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("MMMMM");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String getExpirationDateFromJulianDate( String jdate ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( jdate ) == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyddd");
			java.util.Date td = format.parse( String.valueOf( jdate ) );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("MMyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatHaypinckFileNameDate( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatFDRToBNCDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( date ) == null ) {
			buffer.append("");
		} else if( date.length() == 6 ) {
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("ddMMyyyy");
			buffer.append( format.format( sqlTd )  );
		} else if( date.length() != 7 ) {
			buffer.append("");
		} else {
			String _date = StringUtils.substring( date , 1, 7 );
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			java.util.Date td = format.parse( _date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("ddMMyyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatFDRToBNCDate( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {			
			SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatBNCMontearyImport( String monetaryImport ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
    	BigDecimal bd = new BigDecimal( monetaryImport );
    	bd = bd.setScale( 0, BigDecimal.ROUND_HALF_DOWN );
    	buffer.append( bd.toString() );
		return( buffer.toString() );
	}
    
    public static synchronized String convertDelinquencyCyclesToMOP( String dc ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
    	if( StringUtils.trimToNull( dc ) == null ) {
    		buffer.append("00");
    	} else {
    		int _dc = Integer.parseInt( dc );
    		if( _dc == 0 ) {
    			buffer.append("01");
    		} else if( _dc == 1 ) {
    			buffer.append("02");
    		} else if( _dc == 2 ) {
    			buffer.append("03");
    		} else if( _dc == 3 ) {
    			buffer.append("04");
    		} else if( _dc == 4 ) {
    			buffer.append("05");
    		} else if( _dc == 5 ) {
    			buffer.append("06");
    		} else if( _dc == 6 ) {
    			buffer.append("07");
    		} else if( _dc == 7 ) {
    			buffer.append("07");
    		} else if( _dc == 8 ) {
    			buffer.append("07");
    		} else if( _dc == 9 ) {
    			buffer.append("07");
    		} else if( _dc == 10 ) {
    			buffer.append("07");
    		} else if( _dc == 11 ) {
    			buffer.append("96");
    		} else if( _dc > 11 ) {
    			buffer.append("97");
    		}
    	}
		return( buffer.toString() );
	}
    
    public static synchronized String getDayCodeFromDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("dd");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String lastCycleDate( String _cycleDay ) {
		if( StringUtils.trimToNull( _cycleDay ) == null )
			return("");
		
		String lastCycleDate = null;
    	int cycleDay = Integer.parseInt( _cycleDay );
		Calendar calendar = Calendar.getInstance();
		int initialMonth = calendar.get( Calendar.MONTH );
		int initialDay = calendar.get( Calendar.DAY_OF_MONTH );
		
		if( cycleDay > initialDay ) { // corresponde al mes anterior
			calendar.roll( Calendar.MONTH, false );
			int month = calendar.get( Calendar.MONTH );
			// change year
			if( month >= initialMonth ) {
				calendar.roll( Calendar.YEAR, false );
			}
			
			calendar.set( Calendar.DAY_OF_MONTH, Integer.parseInt( _cycleDay ) );
			Date date = new Date( calendar.getTimeInMillis() );
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			lastCycleDate = format.format( date );	
		} else {
			calendar.set( Calendar.DAY_OF_MONTH, Integer.parseInt( _cycleDay ) );
			Date date = new Date( calendar.getTimeInMillis() );
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			lastCycleDate = format.format( date );	
		}

		
		return( lastCycleDate );
	}
    
    public static synchronized String getProsaRecurrentChargesDateToFileName( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("yyMMdd");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String getProsaRecurrentChargesHeaderDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("ddMMyyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String getScotacControlReportingDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("EEEE, MMMMM dd, yyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String calculateNewStrategyDecrementedCreditLine( String currentCreditLine, String availableCredit, String highestBalance ) throws Exception {
    	StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( currentCreditLine ) == null ) {
			throw new Exception(" currentCreditLine == null ");
		} else if( StringUtils.trimToNull( highestBalance ) == null ) {
			throw new Exception(" highestBalance == null ");
		} else if( StringUtils.trimToNull( availableCredit ) == null ) {
			throw new Exception(" currentBalance == null ");
		} else {
			double ac = Double.parseDouble( availableCredit );
			double ccl = Double.parseDouble( currentCreditLine );
			double hbal = Double.parseDouble( highestBalance );
			double cb = ccl - ac;
			
			double newHighCredLine = hbal * 1.1;
			double newCalcCredLine = cb * 1.2;
			double newCreditLine = 0;
			
			if( newHighCredLine > newCalcCredLine ) {
				newCreditLine = newHighCredLine;
			} else {
				newCreditLine = newCalcCredLine;
			}
			
			if( ccl > 15000 ) {
				if( newCreditLine < 5000 )
					newCreditLine = 5000;
			}
			
			// Redondeado
			BigDecimal bd = new BigDecimal( newCreditLine );
			bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
			bd = bd.movePointLeft( 2 );
			bd = bd.setScale( 0, BigDecimal.ROUND_HALF_UP );
			bd = bd.movePointRight( 2 );
			buffer.append( bd.toString() );
			
		}
		return( buffer.toString() );
	}
    
    
    public static synchronized LinkedList<Date> calculateDifferentialOnDays( Date date ) throws Exception {
		LinkedList<Date> reportingDates = new LinkedList<Date>();
		
		if( date != null ) {
			
			Date today = new Date( System.currentTimeMillis() );
			Calendar endDate = Calendar.getInstance();			
			endDate.setTimeInMillis( date.getTime() );
			
			int initialMonth = endDate.get( Calendar.MONTH );
			
			// Add one day and compare on each iteration
			boolean equalToday = false;
			int ctrlFlag = 0;
			do {
				ctrlFlag++;
				endDate.roll( Calendar.DAY_OF_YEAR, true );
				
				int month = endDate.get( Calendar.MONTH );
				// change year
				if( month < initialMonth ) {
					endDate.roll( Calendar.YEAR, true );
					initialMonth = endDate.get( Calendar.MONTH );
				}
				
				Date rolledDate = new Date( endDate.getTimeInMillis() );
				if( StringUtils.equals( today.toString(), rolledDate.toString() ) ) {
					equalToday = true;
					reportingDates.add( rolledDate );
				} else {
					reportingDates.add( rolledDate );
				}
				if( ctrlFlag > 60 )
					throw new Exception("Too many days has been past from last execution :: " + ctrlFlag);
			} while( !equalToday );
		}
		return( reportingDates );
	}
    
    public static synchronized Date formatFDRDate( String date ) throws Exception {
		Date _date = null;
		if( StringUtils.trimToNull( date ) == null ) {
			_date = null;
		} else if( date.length() == 6 ) {
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			_date = sqlTd;
		} else if( date.length() != 7 ) {
			_date = null;
		} else {
			String _rdate = StringUtils.substring( date , 1, 7 );
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			java.util.Date td = format.parse( _rdate );
			Date sqlTd = new Date( td.getTime() );
			_date = sqlTd;	
		}
		return( _date );
	}
    
    public static synchronized Date formatProsaHeaderDate( String date ) throws Exception {
    	Date sqlTd = null;
		if( date == null ) {
			sqlTd = null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			java.util.Date td = format.parse( date );
			sqlTd = new Date( td.getTime() );
		}
		return( sqlTd );
	}
    
    
    public static synchronized int parseInt( String data ) throws Exception {
    	int i = 0;
		if( StringUtils.trimToNull( data )== null ) {
			i = 0;
		} else {
			i = Integer.parseInt( data );
		}
		return( i );
	}
    
    public static synchronized double parseDouble( String data ) throws Exception {
    	double d = 0;
		if( StringUtils.trimToNull( data )== null ) {
			d = 0;
		} else {
			d = Double.parseDouble( data );
		}
		return( d );
	}
    
    public static synchronized Date formatFAICardholderDate( String date ) throws Exception {
    	Date sqlTd = null;
		if( StringUtils.trimToNull(date)== null ) {
			sqlTd = null;
		} else if( StringUtils.equals( date, "00000000") ) {
			sqlTd = null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date td = format.parse( date );
			sqlTd = new Date( td.getTime() );
		}
		return( sqlTd );
	}
    
    public static synchronized String formatFALCardholderArchiveDate( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {			
			SimpleDateFormat format = new SimpleDateFormat("MMdd");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatDateToFDRDate( Date date, String _format ) {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat( _format );
			buffer.append( format.format( date ) );	
		}
		return( buffer.toString() );
	}
    
    
    public static synchronized String formatBNCDateFromHaypinckDate( String date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( date ) == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat("ddMMyyyy");
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatProsaDateToFDRDate( String date, String _format ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( date ) == null ) {
			buffer.append("");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			java.util.Date td = format.parse( date );
			Date sqlTd = new Date( td.getTime() );
			format = new SimpleDateFormat( _format );
			buffer.append( format.format( sqlTd )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatFDRTapTranArchiveDate( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {			
			SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String renderCalculatedPercentage( long divident, long divisor ) throws Exception {
		BigDecimal Divident_0 = new BigDecimal( divident ), 
	    Divisor_0 = new BigDecimal( divisor ), 
	    Quotient_0 = new BigDecimal(
	        Divident_0.divide(Divisor_0, 4, BigDecimal.ROUND_HALF_UP ).toString() );
		Quotient_0 = Quotient_0.movePointRight( 2 );
		return( Quotient_0.toString() );
	}
    
    public static synchronized Date formatSITIAADate( String date ) throws Exception {
    	Date sqlTd = null;
		if( StringUtils.trimToNull(date)== null ) {
			sqlTd = null;
		} else if( StringUtils.equals( date, " ") ) {
			sqlTd = null;
		} else {
			try {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date td = format.parse( date );
				sqlTd = new Date( td.getTime() );	 
			} catch( Exception pex ) {
				
			}
			
		}
		return( sqlTd );
	}
    
    public static synchronized boolean verifyCancellationCriteria( String lastMonetaryDate, String lastMonetaryCode ) throws Exception {
		boolean ok = false;
		if( StringUtils.equals( lastMonetaryCode, "P") || StringUtils.equals( lastMonetaryCode, "S") || StringUtils.equals( lastMonetaryCode, "C") ) {
			Date ltd = Formatter.formatFDRDate( lastMonetaryDate );
			Date limitDate = Date.valueOf("2010-05-30");
			if( ltd.equals( limitDate ) || ltd.before(limitDate) ) {
				ok = true;
			}
		}
		
		return( ok );
	}
    
    public static synchronized String calculateReportingDateBNC( ) {
		StringBuffer buffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		int initialMonth = calendar.get( Calendar.MONTH );
		calendar.roll( Calendar.MONTH, false );		
		int month = calendar.get( Calendar.MONTH );
		int day = calendar.getMaximum( Calendar.DAY_OF_MONTH );
		calendar.set( Calendar.DAY_OF_MONTH, day );
		
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		buffer.append( format.format( new Date( calendar.getTimeInMillis() ) )  );
		
		return( buffer.toString() );
	}
    
    
    public static synchronized String convertDoubleToLongInString( double value) {
		StringBuffer buffer = new StringBuffer();
		Double d = new Double(value);
		long l = d.longValue();
		buffer.append( l );
		return( buffer.toString() );
	}
    
    public static synchronized String formatCCXmlFilename( String granterKey, Date date, String folioCC ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( granterKey ) == null )
			buffer.append( "" );
		else {
			buffer.append( granterKey );
		}
		buffer.append("_");
		if( date == null ) {
			buffer.append("");
		} else {			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			buffer.append( format.format( date )  );	
		}
		buffer.append("_");
		buffer.append( folioCC );
		return( buffer.toString() );
	}
    
    public static synchronized String extractBirthDateFromRFC( String rfc ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( rfc ) == null ) {
			buffer.append( "" );
		} else {
			String fn = StringUtils.substring( rfc, 4, 10 );
			fn = "19" + fn;
			buffer.append( fn );
		}
		return( buffer.toString() );
	}
    
    public static synchronized String calculateMonthlyFolderCC( ) {
		StringBuffer buffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		Calendar currentCalendar = Calendar.getInstance();
		
		int initialDayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
		if( initialDayOfWeek == Calendar.MONDAY ) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			buffer.append( format.format( new Date( currentCalendar.getTimeInMillis() ) )  );
		} else {
			// calculate previous monday
			calendar.set( Calendar.DAY_OF_WEEK, Calendar.MONDAY );
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			buffer.append( format.format( new Date( calendar.getTimeInMillis() ) )  );
		}
		
		return( buffer.toString() );
	}
    
    public static synchronized String calculateMondayOfCurrentWeek( Date currentDate ) {
    	StringBuffer buffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis( currentDate.getTime() );
		int initialDayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
		if( initialDayOfWeek == Calendar.MONDAY ) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			buffer.append( format.format( new Date( calendar.getTimeInMillis() ) )  );
		} else {
			// calculate previous monday
//			calendar.roll( Calendar.DAY_OF_WEEK, false );		
//			int month = calendar.get( Calendar.MONTH );
//			int day = calendar.getMaximum( Calendar.DAY_OF_MONTH );
			calendar.set( Calendar.DAY_OF_WEEK, Calendar.MONDAY );
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			buffer.append( format.format( new Date( calendar.getTimeInMillis() ) )  );
		}
		
		
		return( buffer.toString() );
	}
    
    public static synchronized String calculateMonthlyFolderCC( Date currentDate ) {
		StringBuffer buffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		Calendar currentCalendar = Calendar.getInstance();
		
		calendar.setTimeInMillis( currentDate.getTime() );
		int currentMonth = calendar.get( Calendar.MONTH );
		
		int initialDayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
		if( initialDayOfWeek == Calendar.MONDAY ) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			buffer.append( format.format( new Date( currentDate.getTime() ) )  );
		} else {
			// calculate previous monday
//			calendar.roll( Calendar.DAY_OF_WEEK, false );		
//			int month = calendar.get( Calendar.MONTH );
//			int day = calendar.getMaximum( Calendar.DAY_OF_MONTH );
			calendar.set( Calendar.DAY_OF_WEEK, Calendar.MONDAY );
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			buffer.append( format.format( new Date( calendar.getTimeInMillis() ) )  );
		}
		
		return( buffer.toString() );
	}
    
   
    public static synchronized Date converDependenciaDate( String date ) throws Exception {
    	int year = (Calendar.getInstance().get(Calendar.YEAR) - 100);
    	Date sqlTd = null;
		if( StringUtils.trimToNull(date)== null ) {
			sqlTd = null;
		} else if( StringUtils.equals( date, " ") ) {
			sqlTd = null;
		} else {
				SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
				java.util.Date td = null;
				try {
					td = format.parse( date );
				} catch (Exception e) {
					throw new Exception("La Fecha capturada es invalida [" + date + "] ");
				}
				if ((td.getYear() + 1900) < year){
					throw new Exception("El año de la Fecha es invalido [" + date + "] ");
				}
				sqlTd = new Date( td.getTime() );	 
		}
		return( sqlTd );
	}

    public static synchronized String formatBRMSDate( Date date ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( date == null ) {
			buffer.append("");
		} else {			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			buffer.append( format.format( date )  );	
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatRFCFromCRM( String rfc ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( rfc ) == null ) {
			buffer.append("");
		} else {			
			if( rfc.contains( "-" ) ) {
				// RFC completado en CRM
				int idx = rfc.indexOf("-");
				buffer.append( StringUtils.substring( rfc, 0, idx ) );
			} else {
				buffer.append( rfc );
			}
		}
		return( buffer.toString() );
	}
    
    public static synchronized String extractFilenameFromURL( String url ) throws Exception {
		StringBuffer buffer = new StringBuffer();

		if( StringUtils.trimToNull( url ) == null ) {
			buffer.append("");
		} else {
			
			int idx = StringUtils.lastIndexOf( url, "/");
			idx++;
			buffer.append( StringUtils.substring( url, idx , url.length() ) );
		}
		return( buffer.toString() );
	}
    
  
    public static synchronized String extractAccountFromCLABE( String clabe ) throws Exception {
		StringBuffer buffer = new StringBuffer();
		if( StringUtils.trimToNull( clabe ) == null ) {
			buffer.append( "" );
		} else if( clabe.length() != 18 ) {
			buffer.append( "" );
		} else {
			String fn = StringUtils.substring( clabe, 7, 17 );
			buffer.append( fn );
		}
		return( buffer.toString() );
	}
    
    public static synchronized String formatNetCashAmount( double amount ) {
		StringBuffer buffer = new StringBuffer();
		
		
		NumberFormat nf = NumberFormat.getNumberInstance( );
		DecimalFormat df = (DecimalFormat)nf;
		// "#,##0.##", 
		df.applyPattern("#############.00");
		String output = df.format(amount);
		buffer.append( output );	
		
		return( buffer.toString() );
	}
}
