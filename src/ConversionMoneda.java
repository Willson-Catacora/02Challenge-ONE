import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ConversionMoneda {
    @SerializedName("base_code")
    private String moneda;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversion;

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Map<String, Double> getConversion() {
        return conversion;
    }

    public void setConversion(Map<String, Double> conversion) {
        this.conversion = conversion;
    }
}
