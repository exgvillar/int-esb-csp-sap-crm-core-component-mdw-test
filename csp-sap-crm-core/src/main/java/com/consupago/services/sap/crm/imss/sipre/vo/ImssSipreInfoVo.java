package com.consupago.services.sap.crm.imss.sipre.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ImssSipreInfoVo implements Serializable {
	private static final long serialVersionUID = -588565564326631064L;
	private Integer mandt;
	private String object_id;
	private Integer zznumprov;
	private String zzdelegacion;
	private String zznss;
	private String zzgrupo;
	private String zznombres;
	private String zzpaterno;
	private String zzmaterno;
	private String zzcurp;
	private String zzclave;
	private BigDecimal zzimp_presta;
	private BigDecimal zzimp_mensual;
	private Integer zznum_meses;
	private String zztipo_mov_immsp;
	private String zznum_contrat;
	private String zzref_dep;
	private String zzarch_org;
	private String zzarch_reno;
	private Date zzfecha_alta;
	private Date zzfecha_compra;
	private String zzf_comprado;
	private Date zzfecha_envio;
	private String zzf_enviado;
	private Double zzintmens;
	private Double zzcat;
	private Double zzimpprest;

	private Integer idconvenio;
	private String convenioName;
	private Integer empresaConvID;
	private String empresaConvName;

	private Integer idProducto;
	private String productoName;
	private Integer empresaProdId;
	private String empresaProdName;

	private boolean isLcom;
	
	private Double montoDctoALiquidar1 = null;
	private Double montoDctoALiquidar2 = null;
	private Double montoDctoALiquidar3 = null;

	public Integer getMandt() {
		return mandt;
	}

	public void setMandt(Integer mandt) {
		this.mandt = mandt;
	}

	public String getObject_id() {
		return object_id;
	}

	public void setObject_id(String objectId) {
		object_id = objectId;
	}

	public Integer getZznumprov() {
		return zznumprov;
	}

	public void setZznumprov(Integer zznumprov) {
		this.zznumprov = zznumprov;
	}

	public String getZzdelegacion() {
		return zzdelegacion;
	}

	public void setZzdelegacion(String zzdelegacion) {
		this.zzdelegacion = zzdelegacion;
	}

	public String getZznss() {
		return zznss;
	}

	public void setZznss(String zznss) {
		this.zznss = zznss;
	}

	public String getZzgrupo() {
		return zzgrupo;
	}

	public void setZzgrupo(String zzgrupo) {
		this.zzgrupo = zzgrupo;
	}

	public String getZznombres() {
		return zznombres;
	}

	public void setZznombres(String zznombres) {
		this.zznombres = zznombres;
	}

	public String getZzpaterno() {
		return zzpaterno;
	}

	public void setZzpaterno(String zzpaterno) {
		this.zzpaterno = zzpaterno;
	}

	public String getZzmaterno() {
		return zzmaterno;
	}

	public void setZzmaterno(String zzmaterno) {
		this.zzmaterno = zzmaterno;
	}

	public String getZzcurp() {
		return zzcurp;
	}

	public void setZzcurp(String zzcurp) {
		this.zzcurp = zzcurp;
	}

	public String getZzclave() {
		return zzclave;
	}

	public void setZzclave(String zzclave) {
		this.zzclave = zzclave;
	}

	public BigDecimal getZzimp_presta() {
		return zzimp_presta;
	}

	public void setZzimp_presta(BigDecimal zzimpPresta) {
		zzimp_presta = zzimpPresta;
	}

	public BigDecimal getZzimp_mensual() {
		return zzimp_mensual;
	}

	public void setZzimp_mensual(BigDecimal zzimpMensual) {
		zzimp_mensual = zzimpMensual;
	}

	public Integer getZznum_meses() {
		return zznum_meses;
	}

	public void setZznum_meses(Integer zznumMeses) {
		zznum_meses = zznumMeses;
	}

	public String getZztipo_mov_immsp() {
		return zztipo_mov_immsp;
	}

	public void setZztipo_mov_immsp(String zztipoMovImmsp) {
		zztipo_mov_immsp = zztipoMovImmsp;
	}

	public String getZznum_contrat() {
		return zznum_contrat;
	}

	public void setZznum_contrat(String zznumContrat) {
		zznum_contrat = zznumContrat;
	}

	public String getZzref_dep() {
		return zzref_dep;
	}

	public void setZzref_dep(String zzrefDep) {
		zzref_dep = zzrefDep;
	}

	public String getZzarch_org() {
		return zzarch_org;
	}

	public void setZzarch_org(String zzarchOrg) {
		zzarch_org = zzarchOrg;
	}

	public String getZzarch_reno() {
		return zzarch_reno;
	}

	public void setZzarch_reno(String zzarchReno) {
		zzarch_reno = zzarchReno;
	}

	public Date getZzfecha_alta() {
		return zzfecha_alta;
	}

	public void setZzfecha_alta(Date zzfechaAlta) {
		zzfecha_alta = zzfechaAlta;
	}

	public Date getZzfecha_compra() {
		return zzfecha_compra;
	}

	public void setZzfecha_compra(Date zzfechaCompra) {
		zzfecha_compra = zzfechaCompra;
	}

	public String getZzf_comprado() {
		return zzf_comprado;
	}

	public void setZzf_comprado(String zzfComprado) {
		zzf_comprado = zzfComprado;
	}

	public Date getZzfecha_envio() {
		return zzfecha_envio;
	}

	public void setZzfecha_envio(Date zzfechaEnvio) {
		zzfecha_envio = zzfechaEnvio;
	}

	public String getZzf_enviado() {
		return zzf_enviado;
	}

	public void setZzf_enviado(String zzfEnviado) {
		zzf_enviado = zzfEnviado;
	}

	public Double getZzintmens() {
		return zzintmens;
	}

	public void setZzintmens(Double zzintmens) {
		this.zzintmens = zzintmens;
	}

	public Double getZzcat() {
		return zzcat;
	}

	public void setZzcat(Double zzcat) {
		this.zzcat = zzcat;
	}

	public Double getZzimpprest() {
		return zzimpprest;
	}

	public void setZzimpprest(Double zzimpprest) {
		this.zzimpprest = zzimpprest;
	}

	public Integer getIdconvenio() {
		return idconvenio;
	}

	public void setIdconvenio(Integer idconvenio) {
		this.idconvenio = idconvenio;
	}

	public String getConvenioName() {
		return convenioName;
	}

	public void setConvenioName(String convenioName) {
		this.convenioName = convenioName;
	}

	public Integer getEmpresaConvID() {
		return empresaConvID;
	}

	public void setEmpresaConvID(Integer empresaConvID) {
		this.empresaConvID = empresaConvID;
	}

	public String getEmpresaConvName() {
		return empresaConvName;
	}

	public void setEmpresaConvName(String empresaConvName) {
		this.empresaConvName = empresaConvName;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getProductoName() {
		return productoName;
	}

	public void setProductoName(String productoName) {
		this.productoName = productoName;
	}

	public Integer getEmpresaProdId() {
		return empresaProdId;
	}

	public void setEmpresaProdId(Integer empresaProdId) {
		this.empresaProdId = empresaProdId;
	}

	public String getEmpresaProdName() {
		return empresaProdName;
	}

	public void setEmpresaProdName(String empresaProdName) {
		this.empresaProdName = empresaProdName;
	}

	public boolean isLcom() {
		return isLcom;
	}

	public void setLcom(boolean isLcom) {
		this.isLcom = isLcom;
	}

	/**
	 * @return the montoDctoALiquidar1
	 */
	public Double getMontoDctoALiquidar1() {
		return montoDctoALiquidar1;
	}

	/**
	 * @param montoDctoALiquidar1 the montoDctoALiquidar1 to set
	 */
	public void setMontoDctoALiquidar1(Double montoDctoALiquidar1) {
		this.montoDctoALiquidar1 = montoDctoALiquidar1;
	}

	/**
	 * @return the montoDctoALiquidar2
	 */
	public Double getMontoDctoALiquidar2() {
		return montoDctoALiquidar2;
	}

	/**
	 * @param montoDctoALiquidar2 the montoDctoALiquidar2 to set
	 */
	public void setMontoDctoALiquidar2(Double montoDctoALiquidar2) {
		this.montoDctoALiquidar2 = montoDctoALiquidar2;
	}

	/**
	 * @return the montoDctoALiquidar3
	 */
	public Double getMontoDctoALiquidar3() {
		return montoDctoALiquidar3;
	}

	/**
	 * @param montoDctoALiquidar3 the montoDctoALiquidar3 to set
	 */
	public void setMontoDctoALiquidar3(Double montoDctoALiquidar3) {
		this.montoDctoALiquidar3 = montoDctoALiquidar3;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
