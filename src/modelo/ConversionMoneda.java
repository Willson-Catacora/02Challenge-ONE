package modelo;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class ConversionMoneda {
    @SerializedName("base_code")
    private String moneda;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversion;

    public String ComvercionDeMoneda(int valor, String moneda, String monedaConvertir) {
//      System.out.println("moneda "+ moneda);
//      System.out.println("moneda ha convertir "+ monedaConvertir);
//      System.out.println("valor "+ valor);
        return "El valor " + (double) valor + " [" + moneda + "] corresponde al valor  final de  =>>> " + redondeo(valor, conversion.get(monedaConvertir)) + " [" + monedaConvertir + "].\n";
    }

    private BigDecimal redondeo(int valor1, double valor2) {
        BigDecimal r = new BigDecimal(Double.toString((valor1 * valor2)));
        return r.setScale(2, RoundingMode.HALF_UP);
    }

    public String getMoneda() {
        return moneda;
    }

    public Map<String, Double> getConversion() {
        return conversion;
    }

}
