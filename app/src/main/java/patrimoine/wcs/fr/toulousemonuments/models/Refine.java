
package patrimoine.wcs.fr.toulousemonuments.models;

import java.util.HashMap;
import java.util.Map;

public class Refine {

    private String icone;
    private String commune;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
