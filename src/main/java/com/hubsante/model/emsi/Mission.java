/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hubsante.model.emsi;

import java.util.Objects;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hubsante.model.emsi.PositionRgeo;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Mission
 */
@JsonPropertyOrder({
        Mission.JSON_PROPERTY_T_Y_P_E,
        Mission.JSON_PROPERTY_F_R_E_E_T_E_X_T,
        Mission.JSON_PROPERTY_I_D,
        Mission.JSON_PROPERTY_O_R_G_I_D,
        Mission.JSON_PROPERTY_N_A_M_E,
        Mission.JSON_PROPERTY_S_T_A_T_U_S,
        Mission.JSON_PROPERTY_S_T_A_R_T_T_I_M_E,
        Mission.JSON_PROPERTY_E_N_D_T_I_M_E,
        Mission.JSON_PROPERTY_R_E_S_O_U_R_C_E_I_D,
        Mission.JSON_PROPERTY_P_A_R_E_N_T_M_I_S_S_I_O_N_I_D,
        Mission.JSON_PROPERTY_C_H_I_L_D_M_I_S_S_I_O_N_I_D,
        Mission.JSON_PROPERTY_M_A_I_N_M_I_S_S_I_O_N_I_D,
        Mission.JSON_PROPERTY_P_O_S_I_T_I_O_N,
        Mission.JSON_PROPERTY_P_R_I_O_R_I_T_Y
})
@JsonTypeName("mission")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-08T11:29:35.594+01:00[Europe/Paris]")
public class Mission {
    /**
     * Le champ MISSION TYPE permet d&#39;identifier l&#39;effet à obtenir souhaité à partir de la combinaison du code ACTOR et du code TYPE. &#x3D;&gt; La table de transcodage permettant d&#39;identifier les concourants et les effets à obtenir à partir d&#39;un code EMSI est fournie en annexe \&quot;Référentiel Effets à Obtenir - correspondance EMSI\&quot;.
     */
    public enum TYPEEnum {
        C2("C2"),

        CBRN("CBRN"),

        FF("FF"),

        FSTT("FSTT"),

        GEN("GEN"),

        INT("INT"),

        MAC("MAC"),

        MIL("MIL"),

        NET("NET"),

        OPR("OPR"),

        POL("POL"),

        REC("REC"),

        RSC("RSC"),

        SAV("SAV"),

        SCS("SCS"),

        SOC("SOC"),

        _C2_DEBRIF("/C2/DEBRIF"),

        _C2_DNRSKA("/C2/DNRSKA"),

        _C2_INASSM("/C2/INASSM"),

        _C2_OIC("/C2/OIC"),

        _C2_POA("/C2/POA"),

        _C2_THRTAS("/C2/THRTAS"),

        _CBRN_CBRNCH("/CBRN/CBRNCH"),

        _CBRN_CBRNDC("/CBRN/CBRNDC"),

        _CBRN_NTRCH("/CBRN/NTRCH"),

        _CBRN_NUCWS("/CBRN/NUCWS"),

        _FF_IN("/FF/IN"),

        _FF_OA("/FF/OA"),

        _FF_SALVAG("/FF/SALVAG"),

        _FF_STR("/FF/STR"),

        _FF_TRP("/FF/TRP"),

        _FSTT_DI("/FSTT/DI"),

        _FSTT_RRHAZ("/FSTT/RRHAZ"),

        _FSTT_TA("/FSTT/TA"),

        _GEN_AIRLAU("/GEN/AIRLAU"),

        _GEN_ASSMBL("/GEN/ASSMBL"),

        _GEN_CRWDCT("/GEN/CRWDCT"),

        _GEN_DEMO("/GEN/DEMO"),

        _GEN_DEPLOY("/GEN/DEPLOY"),

        _GEN_DSTRBT("/GEN/DSTRBT"),

        _GEN_FINANC("/GEN/FINANC"),

        _GEN_MARKNG("/GEN/MARKNG"),

        _GEN_MOVE("/GEN/MOVE"),

        _GEN_RECVRN("/GEN/RECVRN"),

        _GEN_RECVRY("/GEN/RECVRY"),

        _GEN_REDPLN("/GEN/REDPLN"),

        _GEN_REORGN("/GEN/REORGN"),

        _GEN_REPAIR("/GEN/REPAIR"),

        _GEN_RESPLN("/GEN/RESPLN"),

        _GEN_RESTNG("/GEN/RESTNG"),

        _GEN_RETIRE("/GEN/RETIRE"),

        _GEN_RLFPLC("/GEN/RLFPLC"),

        _GEN_RNDZVS("/GEN/RNDZVS"),

        _GEN_SCNMNG("/GEN/SCNMNG"),

        _GEN_SECRNG("/GEN/SECRNG"),

        _GEN_STNGUP("/GEN/STNGUP"),

        _GEN_SUPRTN("/GEN/SUPRTN"),

        _GEN_TRNSPN("/GEN/TRNSPN"),

        _INT_BIOSMP("/INT/BIOSMP"),

        _INT_CHMSMP("/INT/CHMSMP"),

        _INT_IDENT("/INT/IDENT"),

        _INT_ILLUMN("/INT/ILLUMN"),

        _INT_LOCTNG("/INT/LOCTNG"),

        _INT_NUCSMP("/INT/NUCSMP"),

        _INT_OBSRNG("/INT/OBSRNG"),

        _INT_PLUMOD("/INT/PLUMOD"),

        _INT_PTRLNG("/INT/PTRLNG"),

        _INT_RECCE("/INT/RECCE"),

        _INT_SRVMET("/INT/SRVMET"),

        _INT_SRVSEN("/INT/SRVSEN"),

        _INT_WITNSN("/INT/WITNSN"),

        _MAC_AII("/MAC/AII"),

        _MAC_COL("/MAC/COL"),

        _MIL_BCESC("/MIL/BCESC"),

        _MIL_BLOCKN("/MIL/BLOCKN"),

        _MIL_BOMBNG("/MIL/BOMBNG"),

        _MIL_CAPTUR("/MIL/CAPTUR"),

        _MIL_CTRATK("/MIL/CTRATK"),

        _MIL_DEFEND("/MIL/DEFEND"),

        _MIL_DISENG("/MIL/DISENG"),

        _MIL_DIVRSN("/MIL/DIVRSN"),

        _MIL_DLBATK("/MIL/DLBATK"),

        _MIL_DSRPTN("/MIL/DSRPTN"),

        _MIL_ENVLPN("/MIL/ENVLPN"),

        _MIL_FIX("/MIL/FIX"),

        _MIL_HARASS("/MIL/HARASS"),

        _MIL_HIDE("/MIL/HIDE"),

        _MIL_HLDDEF("/MIL/HLDDEF"),

        _MIL_HLDOFF("/MIL/HLDOFF"),

        _MIL_INFLTN("/MIL/INFLTN"),

        _MIL_INTCPN("/MIL/INTCPN"),

        _MIL_INTDCT("/MIL/INTDCT"),

        _MIL_MASFOR("/MIL/MASFOR"),

        _MIL_MIL("/MIL/MIL"),

        _MIL_WPNFIR("/MIL/WPNFIR"),

        _NET_COMDEA("/NET/COMDEA"),

        _NET_DATTRF("/NET/DATTRF"),

        _NET_NETJAM("/NET/NETJAM"),

        _NET_NETSEI("/NET/NETSEI"),

        _NET_SGNC("/NET/SGNC"),

        _NET_SGNLE("/NET/SGNLE"),

        _POL_NTRCOM("/POL/NTRCOM"),

        _POL_NTREXP("/POL/NTREXP"),

        _POL_SCNMNG("/POL/SCNMNG"),

        _POL_SCNPRS("/POL/SCNPRS"),

        _POL_SHELTR("/POL/SHELTR"),

        _POL_SUSHOS("/POL/SUSHOS"),

        _POL_WITDRL("/POL/WITDRL"),

        _REC_CLROBS("/REC/CLROBS"),

        _REC_COMACT("/REC/COMACT"),

        _REC_COMRES("/REC/COMRES"),

        _REC_CONSTN("/REC/CONSTN"),

        _REC_ENGCN("/REC/ENGCN"),

        _REC_ENGCNN("/REC/ENGCNN"),

        _REC_PROCUR("/REC/PROCUR"),

        _REC_PRVACC("/REC/PRVACC"),

        _REC_PRVAGR("/REC/PRVAGR"),

        _REC_PRVBDD("/REC/PRVBDD"),

        _REC_PRVCMP("/REC/PRVCMP"),

        _REC_PRVCNS("/REC/PRVCNS"),

        _REC_PRVDCN("/REC/PRVDCN"),

        _REC_PRVEDU("/REC/PRVEDU"),

        _REC_PRVHLT("/REC/PRVHLT"),

        _REC_PRVHSN("/REC/PRVHSN"),

        _REC_PRVINF("/REC/PRVINF"),

        _REC_PRVLND("/REC/PRVLND"),

        _REC_PRVRPR("/REC/PRVRPR"),

        _REC_PRVSCY("/REC/PRVSCY"),

        _REC_PRVSHL("/REC/PRVSHL"),

        _REC_PRVSTG("/REC/PRVSTG"),

        _REC_PRVTRS("/REC/PRVTRS"),

        _REC_PSO("/REC/PSO"),

        _REC_SPLLDB("/REC/SPLLDB"),

        _REC_SPLWAT("/REC/SPLWAT"),

        _REC_UTILTY("/REC/UTILTY"),

        _REC_WATER("/REC/WATER"),

        _RSC_COVERN("/RSC/COVERN"),

        _RSC_FRFGTN("/RSC/FRFGTN"),

        _RSC_MEDEVC("/RSC/MEDEVC"),

        _RSC_SAR("/RSC/SAR"),

        _SAV_AR("/SAV/AR"),

        _SAV_ASC("/SAV/ASC"),

        _SAV_RHD("/SAV/RHD"),

        _SAV_RTA("/SAV/RTA"),

        _SAV_SARCSL("/SAV/SARCSL"),

        _SAV_SARHHA("/SAV/SARHHA"),

        _SAV_SRW("/SAV/SRW"),

        _SAV_USAR("/SAV/USAR"),

        _SAV_UW("/SAV/UW"),

        _SCS_EDU("/SCS/EDU"),

        _SOC_CNDCNF("/SOC/CNDCNF"),

        _SOC_CNDMED("/SOC/CNDMED"),

        _SOC_CNDRCR("/SOC/CNDRCR"),

        _SOC_CNDSCL("/SOC/CNDSCL"),

        _SOC_CNDSPT("/SOC/CNDSPT"),

        _SOC_ISSMDA("/SOC/ISSMDA"),

        _SOC_ISSMDD("/SOC/ISSMDD"),

        _SOC_ISSPRS("/SOC/ISSPRS"),

        _SOC_MN("/SOC/MN"),

        _SOC_PUBMDA("/SOC/PUBMDA"),

        _SOC_PUBMDD("/SOC/PUBMDD"),

        _SOC_PUBPRS("/SOC/PUBPRS");

        private String value;

        TYPEEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TYPEEnum fromValue(String value) {
            for (TYPEEnum b : TYPEEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_T_Y_P_E = "TYPE";
    private TYPEEnum TYPE;

    public static final String JSON_PROPERTY_F_R_E_E_T_E_X_T = "FREETEXT";
    private String FREETEXT;

    public static final String JSON_PROPERTY_I_D = "ID";
    private String ID;

    public static final String JSON_PROPERTY_O_R_G_I_D = "ORG_ID";
    private String ORG_ID;

    public static final String JSON_PROPERTY_N_A_M_E = "NAME";
    private String NAME;

    /**
     * Définit le statut de la demande de concours. La demande de concours étant en cours, le champ doit être valorisé avec le libellé \&quot;IPR\&quot;
     */
    public enum STATUSEnum {
        ABO("ABO"),

        CANCLD("CANCLD"),

        COM("COM"),

        IPR("IPR"),

        NST("NST"),

        PAU("PAU");

        private String value;

        STATUSEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static STATUSEnum fromValue(String value) {
            for (STATUSEnum b : STATUSEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_S_T_A_T_U_S = "STATUS";
    private STATUSEnum STATUS;

    public static final String JSON_PROPERTY_S_T_A_R_T_T_I_M_E = "START_TIME";
    private OffsetDateTime START_TIME;

    public static final String JSON_PROPERTY_E_N_D_T_I_M_E = "END_TIME";
    private OffsetDateTime END_TIME;

    public static final String JSON_PROPERTY_R_E_S_O_U_R_C_E_I_D = "RESOURCE_ID";
    private List<String> RESOURCE_ID;

    public static final String JSON_PROPERTY_P_A_R_E_N_T_M_I_S_S_I_O_N_I_D = "PARENT_MISSION_ID";
    private List<String> PARENT_MISSION_ID;

    public static final String JSON_PROPERTY_C_H_I_L_D_M_I_S_S_I_O_N_I_D = "CHILD_MISSION_ID";
    private List<String> CHILD_MISSION_ID;

    public static final String JSON_PROPERTY_M_A_I_N_M_I_S_S_I_O_N_I_D = "MAIN_MISSION_ID";
    private String MAIN_MISSION_ID;

    public static final String JSON_PROPERTY_P_O_S_I_T_I_O_N = "POSITION";
    private PositionRgeo POSITION;

    /**
     * Indique une échelle de priorité pour la demande de concours. Dans le cadre du standard EMSI, cette échelle doit être comprise entre 0 et 5. Ce champ peut ne pas être interprété ni alimenté par les LRMs.
     */
    public enum PRIORITYEnum {
        _0("0"),

        _1("1"),

        _2("2"),

        _3("3"),

        _4("4"),

        _5("5");

        private String value;

        PRIORITYEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static PRIORITYEnum fromValue(String value) {
            for (PRIORITYEnum b : PRIORITYEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_P_R_I_O_R_I_T_Y = "PRIORITY";
    private PRIORITYEnum PRIORITY;

    public Mission() {
    }

    public Mission TYPE(TYPEEnum TYPE) {

        this.TYPE = TYPE;
        return this;
    }

    /**
     * Le champ MISSION TYPE permet d&#39;identifier l&#39;effet à obtenir souhaité à partir de la combinaison du code ACTOR et du code TYPE. &#x3D;&gt; La table de transcodage permettant d&#39;identifier les concourants et les effets à obtenir à partir d&#39;un code EMSI est fournie en annexe \&quot;Référentiel Effets à Obtenir - correspondance EMSI\&quot;.
     *
     * @return TYPE
     **/
    @JsonProperty(JSON_PROPERTY_T_Y_P_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public TYPEEnum getTYPE() {
        return TYPE;
    }


    @JsonProperty(JSON_PROPERTY_T_Y_P_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTYPE(TYPEEnum TYPE) {
        this.TYPE = TYPE;
    }


    public Mission FREETEXT(String FREETEXT) {

        this.FREETEXT = FREETEXT;
        return this;
    }

    /**
     * Contient des commentaires relatifs aux moyens sollicités dans le cadre de la demande de concours. Les équipements supplémentaires souhaités ou le nom/ prénom des patients à prendre en charge peuvent être explicitement indiqués ici
     *
     * @return FREETEXT
     **/
    @JsonProperty(JSON_PROPERTY_F_R_E_E_T_E_X_T)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFREETEXT() {
        return FREETEXT;
    }


    @JsonProperty(JSON_PROPERTY_F_R_E_E_T_E_X_T)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFREETEXT(String FREETEXT) {
        this.FREETEXT = FREETEXT;
    }


    public Mission ID(String ID) {

        this.ID = ID;
        return this;
    }

    /**
     * Contient un identifiant de demande de concours unique. Cet identifiant sera réutilisable par le partenaire pour répondre à cette demande.
     *
     * @return ID
     **/
    @JsonProperty(JSON_PROPERTY_I_D)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getID() {
        return ID;
    }


    @JsonProperty(JSON_PROPERTY_I_D)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setID(String ID) {
        this.ID = ID;
    }


    public Mission ORG_ID(String ORG_ID) {

        this.ORG_ID = ORG_ID;
        return this;
    }

    /**
     * Indique l&#39;organisation du partenaire concerné par la Demande de Concours (voir DSF 8.4). Le code CRRA ou le code du SIS peut être utilisé.
     *
     * @return ORG_ID
     **/
    @JsonProperty(JSON_PROPERTY_O_R_G_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getORGID() {
        return ORG_ID;
    }


    @JsonProperty(JSON_PROPERTY_O_R_G_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setORGID(String ORG_ID) {
        this.ORG_ID = ORG_ID;
    }


    public Mission NAME(String NAME) {

        this.NAME = NAME;
        return this;
    }

    /**
     * Le nom de la mission est construit à partir de l&#39;expression régulière suivante : \&quot;#DEMANDE_CONCOURS#\&quot;{libelle_cadre_conventionnel}\&quot;#\&quot;{code_cadre_conventionnel}\&quot;#\&quot; où le code_cadre_conventionnel est issue d&#39;une nomenclature CISU-Cadre Conventionnel (A Venir) NB : ce champ est détourné par rapport au standard EMSI pour permettre l&#39;expression d&#39;une demande de concours et indiquer le cadre conventionnel dans lequel elle est effectuée
     *
     * @return NAME
     **/
    @JsonProperty(JSON_PROPERTY_N_A_M_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getNAME() {
        return NAME;
    }


    @JsonProperty(JSON_PROPERTY_N_A_M_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }


    public Mission STATUS(STATUSEnum STATUS) {

        this.STATUS = STATUS;
        return this;
    }

    /**
     * Définit le statut de la demande de concours. La demande de concours étant en cours, le champ doit être valorisé avec le libellé \&quot;IPR\&quot;
     *
     * @return STATUS
     **/
    @JsonProperty(JSON_PROPERTY_S_T_A_T_U_S)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public STATUSEnum getSTATUS() {
        return STATUS;
    }


    @JsonProperty(JSON_PROPERTY_S_T_A_T_U_S)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSTATUS(STATUSEnum STATUS) {
        this.STATUS = STATUS;
    }


    public Mission START_TIME(OffsetDateTime START_TIME) {

        this.START_TIME = START_TIME;
        return this;
    }

    /**
     * Indique l&#39;heure d’arrivée sur le lieu de la Demande de concours. Le délai d&#39;intervention en est déduit en calculant le délai entre la date et heure de création (cf. CONTEXT.CREATION) et le champ MISSION.START_TIME. Si la date de création du message EMSI est identique à celui de la mission, la demande de concours demande un départ immédiat
     *
     * @return START_TIME
     **/
    @JsonProperty(JSON_PROPERTY_S_T_A_R_T_T_I_M_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public OffsetDateTime getSTARTTIME() {
        return START_TIME;
    }


    @JsonProperty(JSON_PROPERTY_S_T_A_R_T_T_I_M_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSTARTTIME(OffsetDateTime START_TIME) {
        this.START_TIME = START_TIME;
    }


    public Mission END_TIME(OffsetDateTime END_TIME) {

        this.END_TIME = END_TIME;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, ne doit pas être renseigné
     *
     * @return END_TIME
     **/
    @JsonProperty(JSON_PROPERTY_E_N_D_T_I_M_E)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getENDTIME() {
        return END_TIME;
    }


    @JsonProperty(JSON_PROPERTY_E_N_D_T_I_M_E)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setENDTIME(OffsetDateTime END_TIME) {
        this.END_TIME = END_TIME;
    }


    public Mission RESOURCE_ID(List<String> RESOURCE_ID) {

        this.RESOURCE_ID = RESOURCE_ID;
        return this;
    }

    public Mission addRESOURCEIDItem(String RESOURCE_IDItem) {
        if (this.RESOURCE_ID == null) {
            this.RESOURCE_ID = new ArrayList<>();
        }
        this.RESOURCE_ID.add(RESOURCE_IDItem);
        return this;
    }

    /**
     * Get RESOURCE_ID
     *
     * @return RESOURCE_ID
     **/
    @JsonProperty(JSON_PROPERTY_R_E_S_O_U_R_C_E_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getRESOURCEID() {
        return RESOURCE_ID;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_R_E_S_O_U_R_C_E_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRESOURCEID(List<String> RESOURCE_ID) {
        if (RESOURCE_ID == null) {
            return;
        }
        if (this.RESOURCE_ID == null) {
            this.RESOURCE_ID = new ArrayList<>();
        }
        this.RESOURCE_ID.addAll(RESOURCE_ID);
    }


    public Mission PARENT_MISSION_ID(List<String> PARENT_MISSION_ID) {

        this.PARENT_MISSION_ID = PARENT_MISSION_ID;
        return this;
    }

    public Mission addPARENTMISSIONIDItem(String PARENT_MISSION_IDItem) {
        if (this.PARENT_MISSION_ID == null) {
            this.PARENT_MISSION_ID = new ArrayList<>();
        }
        this.PARENT_MISSION_ID.add(PARENT_MISSION_IDItem);
        return this;
    }

    /**
     * Get PARENT_MISSION_ID
     *
     * @return PARENT_MISSION_ID
     **/
    @JsonProperty(JSON_PROPERTY_P_A_R_E_N_T_M_I_S_S_I_O_N_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getPARENTMISSIONID() {
        return PARENT_MISSION_ID;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_P_A_R_E_N_T_M_I_S_S_I_O_N_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPARENTMISSIONID(List<String> PARENT_MISSION_ID) {
        if (PARENT_MISSION_ID == null) {
            return;
        }
        if (this.PARENT_MISSION_ID == null) {
            this.PARENT_MISSION_ID = new ArrayList<>();
        }
        this.PARENT_MISSION_ID.addAll(PARENT_MISSION_ID);
    }


    public Mission CHILD_MISSION_ID(List<String> CHILD_MISSION_ID) {

        this.CHILD_MISSION_ID = CHILD_MISSION_ID;
        return this;
    }

    public Mission addCHILDMISSIONIDItem(String CHILD_MISSION_IDItem) {
        if (this.CHILD_MISSION_ID == null) {
            this.CHILD_MISSION_ID = new ArrayList<>();
        }
        this.CHILD_MISSION_ID.add(CHILD_MISSION_IDItem);
        return this;
    }

    /**
     * Get CHILD_MISSION_ID
     *
     * @return CHILD_MISSION_ID
     **/
    @JsonProperty(JSON_PROPERTY_C_H_I_L_D_M_I_S_S_I_O_N_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getCHILDMISSIONID() {
        return CHILD_MISSION_ID;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_C_H_I_L_D_M_I_S_S_I_O_N_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCHILDMISSIONID(List<String> CHILD_MISSION_ID) {
        if (CHILD_MISSION_ID == null) {
            return;
        }
        if (this.CHILD_MISSION_ID == null) {
            this.CHILD_MISSION_ID = new ArrayList<>();
        }
        this.CHILD_MISSION_ID.addAll(CHILD_MISSION_ID);
    }


    public Mission MAIN_MISSION_ID(String MAIN_MISSION_ID) {

        this.MAIN_MISSION_ID = MAIN_MISSION_ID;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, ne doit pas être renseigné
     *
     * @return MAIN_MISSION_ID
     **/
    @JsonProperty(JSON_PROPERTY_M_A_I_N_M_I_S_S_I_O_N_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMAINMISSIONID() {
        return MAIN_MISSION_ID;
    }


    @JsonProperty(JSON_PROPERTY_M_A_I_N_M_I_S_S_I_O_N_I_D)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMAINMISSIONID(String MAIN_MISSION_ID) {
        this.MAIN_MISSION_ID = MAIN_MISSION_ID;
    }


    public Mission POSITION(PositionRgeo POSITION) {

        this.POSITION = POSITION;
        return this;
    }

    /**
     * Get POSITION
     *
     * @return POSITION
     **/
    @JsonProperty(JSON_PROPERTY_P_O_S_I_T_I_O_N)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public PositionRgeo getPOSITION() {
        return POSITION;
    }


    @JsonProperty(JSON_PROPERTY_P_O_S_I_T_I_O_N)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPOSITION(PositionRgeo POSITION) {
        this.POSITION = POSITION;
    }


    public Mission PRIORITY(PRIORITYEnum PRIORITY) {

        this.PRIORITY = PRIORITY;
        return this;
    }

    /**
     * Indique une échelle de priorité pour la demande de concours. Dans le cadre du standard EMSI, cette échelle doit être comprise entre 0 et 5. Ce champ peut ne pas être interprété ni alimenté par les LRMs.
     *
     * @return PRIORITY
     **/
    @JsonProperty(JSON_PROPERTY_P_R_I_O_R_I_T_Y)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PRIORITYEnum getPRIORITY() {
        return PRIORITY;
    }


    @JsonProperty(JSON_PROPERTY_P_R_I_O_R_I_T_Y)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPRIORITY(PRIORITYEnum PRIORITY) {
        this.PRIORITY = PRIORITY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mission mission = (Mission) o;
        return Objects.equals(this.TYPE, mission.TYPE) &&
                Objects.equals(this.FREETEXT, mission.FREETEXT) &&
                Objects.equals(this.ID, mission.ID) &&
                Objects.equals(this.ORG_ID, mission.ORG_ID) &&
                Objects.equals(this.NAME, mission.NAME) &&
                Objects.equals(this.STATUS, mission.STATUS) &&
                Objects.equals(this.START_TIME, mission.START_TIME) &&
                Objects.equals(this.END_TIME, mission.END_TIME) &&
                Objects.equals(this.RESOURCE_ID, mission.RESOURCE_ID) &&
                Objects.equals(this.PARENT_MISSION_ID, mission.PARENT_MISSION_ID) &&
                Objects.equals(this.CHILD_MISSION_ID, mission.CHILD_MISSION_ID) &&
                Objects.equals(this.MAIN_MISSION_ID, mission.MAIN_MISSION_ID) &&
                Objects.equals(this.POSITION, mission.POSITION) &&
                Objects.equals(this.PRIORITY, mission.PRIORITY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TYPE
                , FREETEXT
                , ID
                , ORG_ID
                , NAME
                , STATUS
                , START_TIME
                , END_TIME
                , RESOURCE_ID
                , PARENT_MISSION_ID
                , CHILD_MISSION_ID
                , MAIN_MISSION_ID
                , POSITION
                , PRIORITY);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Mission {\n");
        sb.append("    TYPE: ").append(toIndentedString(TYPE)).append("\n");
        sb.append("    FREETEXT: ").append(toIndentedString(FREETEXT)).append("\n");
        sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
        sb.append("    ORG_ID: ").append(toIndentedString(ORG_ID)).append("\n");
        sb.append("    NAME: ").append(toIndentedString(NAME)).append("\n");
        sb.append("    STATUS: ").append(toIndentedString(STATUS)).append("\n");
        sb.append("    START_TIME: ").append(toIndentedString(START_TIME)).append("\n");
        sb.append("    END_TIME: ").append(toIndentedString(END_TIME)).append("\n");
        sb.append("    RESOURCE_ID: ").append(toIndentedString(RESOURCE_ID)).append("\n");
        sb.append("    PARENT_MISSION_ID: ").append(toIndentedString(PARENT_MISSION_ID)).append("\n");
        sb.append("    CHILD_MISSION_ID: ").append(toIndentedString(CHILD_MISSION_ID)).append("\n");
        sb.append("    MAIN_MISSION_ID: ").append(toIndentedString(MAIN_MISSION_ID)).append("\n");
        sb.append("    POSITION: ").append(toIndentedString(POSITION)).append("\n");
        sb.append("    PRIORITY: ").append(toIndentedString(PRIORITY)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
