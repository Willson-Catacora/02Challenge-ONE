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

    public Map<String, Double> getConversion() {
        return conversion;
    }

}
