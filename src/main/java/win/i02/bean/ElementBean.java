package win.i02.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 *
 * Created by Qi on 2017/6/8.
 */
@Table("element")
public class ElementBean {
    @Id
    private int id;
    @Column("c_name_cn")
    private String cNameCn;
    @Column("c_name_en")
    private String cNameEn;
    @Column("c_symbol")
    private String cSymbol;
    @Column("c_atom")
    private int cAtom;
    @Column("c_sn")
    private int cSn;
    @Column("c_ram")
    private double cRam;
    @Column("j_ar")
    private double jAr;
    @Column("j_atomic_volume")
    private double jAtomicVolume;
    @Column("j_covalent_radius")
    private double jCovalentRadius;
    @Column("j_electronic_configuration")
    private String jElectronicConfiguration;
    @Column("j_ion_radius")
    private double jIonRadius;
    @Column("j_oxidation_state")
    private String jOxidationState;
    @Column("c_find")
    private String cFind;
    @Column("c_source")
    private String cSource;
    @Column("c_use")
    private String cUse;
    @Column("p_status")
    private String pStatus;
    @Column("p_melting_point")
    private double pMeltingPoint;
    @Column("p_boiling_point")
    private double pBoilingPoint;
    @Column("p_density")
    private double pDensity;
    @Column("p_spontaneous_point")
    private double pSpontaneousPoint;
    @Column("p_specific_heat")
    private double pSpecificHeat;
    @Column("p_evaporative_heat")
    private double pEvaporativeHeat;
    @Column("p_heat_of_melting")
    private double pHeatOfMelting;
    @Column("p_flash_point")
    private double pFlashPoint;
    @Column("p_conductivity")
    private double pConductivity;
    @Column("p_thermal_conductivity")
    private double pThermalConductivity;
    @Column("c_electronic_model")
    private String cElectronicModel;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcNameCn() {
        return cNameCn;
    }

    public void setcNameCn(String cNameCn) {
        this.cNameCn = cNameCn;
    }

    public String getcNameEn() {
        return cNameEn;
    }

    public void setcNameEn(String cNameEn) {
        this.cNameEn = cNameEn;
    }

    public String getcSymbol() {
        return cSymbol;
    }

    public void setcSymbol(String cSymbol) {
        this.cSymbol = cSymbol;
    }

    public int getcAtom() {
        return cAtom;
    }

    public void setcAtom(int cAtom) {
        this.cAtom = cAtom;
    }

    public int getcSn() {
        return cSn;
    }

    public void setcSn(int cSn) {
        this.cSn = cSn;
    }

    public double getcRam() {
        return cRam;
    }

    public void setcRam(double cRam) {
        this.cRam = cRam;
    }

    public double getjAr() {
        return jAr;
    }

    public void setjAr(double jAr) {
        this.jAr = jAr;
    }

    public double getjAtomicVolume() {
        return jAtomicVolume;
    }

    public void setjAtomicVolume(double jAtomicVolume) {
        this.jAtomicVolume = jAtomicVolume;
    }

    public double getjCovalentRadius() {
        return jCovalentRadius;
    }

    public void setjCovalentRadius(double jCovalentRadius) {
        this.jCovalentRadius = jCovalentRadius;
    }

    public String getjElectronicConfiguration() {
        return jElectronicConfiguration;
    }

    public void setjElectronicConfiguration(String jElectronicConfiguration) {
        this.jElectronicConfiguration = jElectronicConfiguration;
    }

    public double getjIonRadius() {
        return jIonRadius;
    }

    public void setjIonRadius(double jIonRadius) {
        this.jIonRadius = jIonRadius;
    }

    public String getjOxidationState() {
        return jOxidationState;
    }

    public void setjOxidationState(String jOxidationState) {
        this.jOxidationState = jOxidationState;
    }

    public String getcFind() {
        return cFind;
    }

    public void setcFind(String cFind) {
        this.cFind = cFind;
    }

    public String getcSource() {
        return cSource;
    }

    public void setcSource(String cSource) {
        this.cSource = cSource;
    }

    public String getcUse() {
        return cUse;
    }

    public void setcUse(String cUse) {
        this.cUse = cUse;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public double getpMeltingPoint() {
        return pMeltingPoint;
    }

    public void setpMeltingPoint(double pMeltingPoint) {
        this.pMeltingPoint = pMeltingPoint;
    }

    public double getpBoilingPoint() {
        return pBoilingPoint;
    }

    public void setpBoilingPoint(double pBoilingPoint) {
        this.pBoilingPoint = pBoilingPoint;
    }

    public double getpDensity() {
        return pDensity;
    }

    public void setpDensity(double pDensity) {
        this.pDensity = pDensity;
    }

    public double getpSpontaneousPoint() {
        return pSpontaneousPoint;
    }

    public void setpSpontaneousPoint(double pSpontaneousPoint) {
        this.pSpontaneousPoint = pSpontaneousPoint;
    }

    public double getpSpecificHeat() {
        return pSpecificHeat;
    }

    public void setpSpecificHeat(double pSpecificHeat) {
        this.pSpecificHeat = pSpecificHeat;
    }

    public double getpEvaporativeHeat() {
        return pEvaporativeHeat;
    }

    public void setpEvaporativeHeat(double pEvaporativeHeat) {
        this.pEvaporativeHeat = pEvaporativeHeat;
    }

    public double getpHeatOfMelting() {
        return pHeatOfMelting;
    }

    public void setpHeatOfMelting(double pHeatOfMelting) {
        this.pHeatOfMelting = pHeatOfMelting;
    }

    public double getpFlashPoint() {
        return pFlashPoint;
    }

    public void setpFlashPoint(double pFlashPoint) {
        this.pFlashPoint = pFlashPoint;
    }

    public double getpConductivity() {
        return pConductivity;
    }

    public void setpConductivity(double pConductivity) {
        this.pConductivity = pConductivity;
    }

    public double getpThermalConductivity() {
        return pThermalConductivity;
    }

    public void setpThermalConductivity(double pThermalConductivity) {
        this.pThermalConductivity = pThermalConductivity;
    }

    public String getcElectronicModel() {
        return cElectronicModel;
    }

    public void setcElectronicModel(String cElectronicModel) {
        this.cElectronicModel = cElectronicModel;
    }
}
