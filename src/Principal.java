//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Scanner;

public class Principal extends convertidor {
    public Principal() {
    }

    public static void main(String[] args) {
        String strJson = consumeURL("https://v6.exchangerate-api.com/v6/a0e129a4d5e8fbb96affe09f/latest/USD");
        Gson gson = new Gson();
        JsonObject jsonObject = (JsonObject)gson.fromJson(strJson, JsonObject.class);
        String monedaO = "";
        String monedaD = "";
        double valueMonedaO = 0.0;
        double valueMonedaD = 0.0;
        double cantidadAConvertir = 0.0;
        Scanner scanner = new Scanner(System.in);
        boolean reintentar = true;

        while(reintentar) {
            System.out.println("*******************************************");
            System.out.println("Bienvenido al conversor de moneda");
            System.out.println("Ingrese la moneda origen");
            monedaO = scanner.next();
            System.out.println("Ingrese la cantidad a convertir");
            cantidadAConvertir = Double.parseDouble(scanner.next());
            System.out.println("Ingrese la moneda destino");
            monedaD = scanner.next();

            try {
                valueMonedaO = jsonObject.getAsJsonObject("conversion_rates").get(monedaO).getAsDouble();
            } catch (Exception var18) {
                monedaO = "COP";
                valueMonedaO = jsonObject.getAsJsonObject("conversion_rates").get("COP").getAsDouble();
            }

            try {
                valueMonedaD = jsonObject.getAsJsonObject("conversion_rates").get(monedaD).getAsDouble();
            } catch (Exception var17) {
                monedaD = "USD";
                valueMonedaD = jsonObject.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
            }

            System.out.println("1 " + monedaO + " equivalen a " + valueMonedaD * 1.0 / valueMonedaO + " " + monedaD);
            double resultado = valueMonedaD * cantidadAConvertir / valueMonedaO;
            System.out.println("" + cantidadAConvertir + " " + monedaO + " equivalen a " + resultado + " " + monedaD);
            System.out.println("Desea continuar con otra conversión ? 1 para SI, 0 para NO");
            String res = scanner.next();
            reintentar = false;
            if (res.equals("1")) {
                reintentar = true;
            }
        }

        scanner.close();
    }
}
