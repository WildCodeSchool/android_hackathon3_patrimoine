
package patrimoine.wcs.fr.toulousemonuments.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parameters {

    private List<String> dataset = null;
    private Refine refine;
    private String timezone;
    private Integer rows;
    private String format;
    private List<String> facet = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getDataset() {
        return dataset;
    }

    public void setDataset(List<String> dataset) {
        this.dataset = dataset;
    }

    public Refine getRefine() {
        return refine;
    }

    public void setRefine(Refine refine) {
        this.refine = refine;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<String> getFacet() {
        return facet;
    }

    public void setFacet(List<String> facet) {
        this.facet = facet;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
