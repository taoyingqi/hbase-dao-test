package com.mikemunhall.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mikemunhall.util.ConstantPropertyNamingStrategy;

@JsonNaming(ConstantPropertyNamingStrategy.class)
public class FlightInfo {

    private String ID;
    private String PFID;
    private String SCHID;
    private String FLNO;
    private String SSRMC;
    private String SOURCE;
    private String SOBT;
    private String SOBT_SITA;
    private String SIBT;
    private String SIBT_SITA;
    private String EOBT;
    private String EOBT_SITA;
    private String EIBT;
    private String EIBT_SITA;
    private String ATOT;
    private String ATOT_SITA;
    private String ALDT;
    private String ALDT_SITA;
    private String ADEPS;
    private String ADEPE;
    private String ADEPA;
    private String ADESS;
    private String ADESE;
    private String ADESA;
    private String ACTTS;
    private String ACTTE;
    private String REGNS;
    private String REGNE;
    private String SALTITUDE;
    private String ESPD;
    private String EALTITUDE;
    private String STYPE;
    private String MTYPE;
    private String SLEVEL;
    private String EXECSTAT;
    private String ISEXEC;
    private String LOCKSTAT;
    private String ABSTAT;
    private String ALN1E;
    private String ALN2E;
    private String ROUTS;
    private String ROUTE;
    private String EXECDATE;
    private String ISDEL;
    private String COMMON_INFO;
    private String POBT;
    private String ELDT;
    private String DETA;
    private String EXIT;
    private String AXIT;
    private String AIBT;
    private String COBT;
    private String TOBT;
    private String ECZT;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPFID() {
        return PFID;
    }

    public void setPFID(String PFID) {
        this.PFID = PFID;
    }

    public String getSCHID() {
        return SCHID;
    }

    public void setSCHID(String SCHID) {
        this.SCHID = SCHID;
    }

    public String getFLNO() {
        return FLNO;
    }

    public void setFLNO(String FLNO) {
        this.FLNO = FLNO;
    }

    public String getSSRMC() {
        return SSRMC;
    }

    public void setSSRMC(String SSRMC) {
        this.SSRMC = SSRMC;
    }

    public String getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(String SOURCE) {
        this.SOURCE = SOURCE;
    }

    public String getSOBT() {
        return SOBT;
    }

    public void setSOBT(String SOBT) {
        this.SOBT = SOBT;
    }

    public String getSOBT_SITA() {
        return SOBT_SITA;
    }

    public void setSOBT_SITA(String SOBT_SITA) {
        this.SOBT_SITA = SOBT_SITA;
    }

    public String getSIBT() {
        return SIBT;
    }

    public void setSIBT(String SIBT) {
        this.SIBT = SIBT;
    }

    public String getSIBT_SITA() {
        return SIBT_SITA;
    }

    public void setSIBT_SITA(String SIBT_SITA) {
        this.SIBT_SITA = SIBT_SITA;
    }

    public String getEOBT() {
        return EOBT;
    }

    public void setEOBT(String EOBT) {
        this.EOBT = EOBT;
    }

    public String getEOBT_SITA() {
        return EOBT_SITA;
    }

    public void setEOBT_SITA(String EOBT_SITA) {
        this.EOBT_SITA = EOBT_SITA;
    }

    public String getEIBT() {
        return EIBT;
    }

    public void setEIBT(String EIBT) {
        this.EIBT = EIBT;
    }

    public String getEIBT_SITA() {
        return EIBT_SITA;
    }

    public void setEIBT_SITA(String EIBT_SITA) {
        this.EIBT_SITA = EIBT_SITA;
    }

    public String getATOT() {
        return ATOT;
    }

    public void setATOT(String ATOT) {
        this.ATOT = ATOT;
    }

    public String getATOT_SITA() {
        return ATOT_SITA;
    }

    public void setATOT_SITA(String ATOT_SITA) {
        this.ATOT_SITA = ATOT_SITA;
    }

    public String getALDT() {
        return ALDT;
    }

    public void setALDT(String ALDT) {
        this.ALDT = ALDT;
    }

    public String getALDT_SITA() {
        return ALDT_SITA;
    }

    public void setALDT_SITA(String ALDT_SITA) {
        this.ALDT_SITA = ALDT_SITA;
    }

    public String getADEPS() {
        return ADEPS;
    }

    public void setADEPS(String ADEPS) {
        this.ADEPS = ADEPS;
    }

    public String getADEPE() {
        return ADEPE;
    }

    public void setADEPE(String ADEPE) {
        this.ADEPE = ADEPE;
    }

    public String getADEPA() {
        return ADEPA;
    }

    public void setADEPA(String ADEPA) {
        this.ADEPA = ADEPA;
    }

    public String getADESS() {
        return ADESS;
    }

    public void setADESS(String ADESS) {
        this.ADESS = ADESS;
    }

    public String getADESE() {
        return ADESE;
    }

    public void setADESE(String ADESE) {
        this.ADESE = ADESE;
    }

    public String getADESA() {
        return ADESA;
    }

    public void setADESA(String ADESA) {
        this.ADESA = ADESA;
    }

    public String getACTTS() {
        return ACTTS;
    }

    public void setACTTS(String ACTTS) {
        this.ACTTS = ACTTS;
    }

    public String getACTTE() {
        return ACTTE;
    }

    public void setACTTE(String ACTTE) {
        this.ACTTE = ACTTE;
    }

    public String getREGNS() {
        return REGNS;
    }

    public void setREGNS(String REGNS) {
        this.REGNS = REGNS;
    }

    public String getREGNE() {
        return REGNE;
    }

    public void setREGNE(String REGNE) {
        this.REGNE = REGNE;
    }

    public String getSALTITUDE() {
        return SALTITUDE;
    }

    public void setSALTITUDE(String SALTITUDE) {
        this.SALTITUDE = SALTITUDE;
    }

    public String getESPD() {
        return ESPD;
    }

    public void setESPD(String ESPD) {
        this.ESPD = ESPD;
    }

    public String getEALTITUDE() {
        return EALTITUDE;
    }

    public void setEALTITUDE(String EALTITUDE) {
        this.EALTITUDE = EALTITUDE;
    }

    public String getSTYPE() {
        return STYPE;
    }

    public void setSTYPE(String STYPE) {
        this.STYPE = STYPE;
    }

    public String getMTYPE() {
        return MTYPE;
    }

    public void setMTYPE(String MTYPE) {
        this.MTYPE = MTYPE;
    }

    public String getSLEVEL() {
        return SLEVEL;
    }

    public void setSLEVEL(String SLEVEL) {
        this.SLEVEL = SLEVEL;
    }

    public String getEXECSTAT() {
        return EXECSTAT;
    }

    public void setEXECSTAT(String EXECSTAT) {
        this.EXECSTAT = EXECSTAT;
    }

    public String getISEXEC() {
        return ISEXEC;
    }

    public void setISEXEC(String ISEXEC) {
        this.ISEXEC = ISEXEC;
    }

    public String getLOCKSTAT() {
        return LOCKSTAT;
    }

    public void setLOCKSTAT(String LOCKSTAT) {
        this.LOCKSTAT = LOCKSTAT;
    }

    public String getABSTAT() {
        return ABSTAT;
    }

    public void setABSTAT(String ABSTAT) {
        this.ABSTAT = ABSTAT;
    }

    public String getALN1E() {
        return ALN1E;
    }

    public void setALN1E(String ALN1E) {
        this.ALN1E = ALN1E;
    }

    public String getALN2E() {
        return ALN2E;
    }

    public void setALN2E(String ALN2E) {
        this.ALN2E = ALN2E;
    }

    public String getROUTS() {
        return ROUTS;
    }

    public void setROUTS(String ROUTS) {
        this.ROUTS = ROUTS;
    }

    public String getROUTE() {
        return ROUTE;
    }

    public void setROUTE(String ROUTE) {
        this.ROUTE = ROUTE;
    }

    public String getEXECDATE() {
        return EXECDATE;
    }

    public void setEXECDATE(String EXECDATE) {
        this.EXECDATE = EXECDATE;
    }

    public String getISDEL() {
        return ISDEL;
    }

    public void setISDEL(String ISDEL) {
        this.ISDEL = ISDEL;
    }

    public String getCOMMON_INFO() {
        return COMMON_INFO;
    }

    public void setCOMMON_INFO(String COMMON_INFO) {
        this.COMMON_INFO = COMMON_INFO;
    }

    public String getPOBT() {
        return POBT;
    }

    public void setPOBT(String POBT) {
        this.POBT = POBT;
    }

    public String getELDT() {
        return ELDT;
    }

    public void setELDT(String ELDT) {
        this.ELDT = ELDT;
    }

    public String getDETA() {
        return DETA;
    }

    public void setDETA(String DETA) {
        this.DETA = DETA;
    }

    public String getEXIT() {
        return EXIT;
    }

    public void setEXIT(String EXIT) {
        this.EXIT = EXIT;
    }

    public String getAXIT() {
        return AXIT;
    }

    public void setAXIT(String AXIT) {
        this.AXIT = AXIT;
    }

    public String getAIBT() {
        return AIBT;
    }

    public void setAIBT(String AIBT) {
        this.AIBT = AIBT;
    }

    public String getCOBT() {
        return COBT;
    }

    public void setCOBT(String COBT) {
        this.COBT = COBT;
    }

    public String getTOBT() {
        return TOBT;
    }

    public void setTOBT(String TOBT) {
        this.TOBT = TOBT;
    }

    public String getECZT() {
        return ECZT;
    }

    public void setECZT(String ECZT) {
        this.ECZT = ECZT;
    }
}
