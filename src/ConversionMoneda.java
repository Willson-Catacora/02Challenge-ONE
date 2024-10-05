import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ConversionMoneda {
    @SerializedName("base_code")
    private String moneda;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversion;

    public void ComvercionDeMoneda(int valor, String moneda, String monedaConvertir){
        System.out.println("moneda "+ moneda);
        System.out.println("moneda ha convertir "+ monedaConvertir);
        System.out.println("valor "+ valor);
        System.out.println("El valor "+(double)valor+" ["+moneda+"] corresponde al valor  final de  =>>> " + (valor * conversion.get(monedaConvertir))+" ["+monedaConvertir+"].");
    }

    public String getMoneda() {
        return moneda;
    }

    public Map<String, Double> getConversion() {
        return conversion;
    }

}
