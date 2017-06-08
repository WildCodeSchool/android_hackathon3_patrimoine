
package patrimoine.wcs.fr.toulousemonuments.models;

import com.google.api.client.util.Key;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fields {

    @Key
    private String commune;
    @Key
    private String descriptif;
    @Key
    private String nomCdt;
    @Key
    private String codePost;
    @Key
    private String adresse;
    @Key
    private String precision;
    @Key
    private List<Double> geoPoint2d = null;
    @Key
    private String icone;
    @Key
    private String idCdt;
    @Key
    private String etiquette;
    @Key
    private String source;
    @Key
    private String codeInsee;
    @Key
    private GeoShape geoShape;
    @Key
    private String nom;
    @Key
    private Double id;
    @Key
    private String imgCdt;
    @Key
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getNomCdt() {
        return nomCdt;
    }

    public void setNomCdt(String nomCdt) {
        this.nomCdt = nomCdt;
    }

    public String getCodePost() {
        return codePost;
    }

    public void setCodePost(String codePost) {
        this.codePost = codePost;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public List<Double> getGeoPoint2d() {
        return geoPoint2d;
    }

    public void setGeoPoint2d(List<Double> geoPoint2d) {
        this.geoPoint2d = geoPoint2d;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getIdCdt() {
        return idCdt;
    }

    public void setIdCdt(String idCdt) {
        this.idCdt = idCdt;
    }

    public String getEtiquette() {
        return etiquette;
    }

    public void setEtiquette(String etiquette) {
        this.etiquette = etiquette;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public GeoShape getGeoShape() {
        return geoShape;
    }

    public void setGeoShape(GeoShape geoShape) {
        this.geoShape = geoShape;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getImgCdt() {
        return imgCdt;
    }

    public void setImgCdt(String imgCdt) {
        this.imgCdt = imgCdt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
