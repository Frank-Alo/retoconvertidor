//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class convertidor {
    public convertidor() {
    }

    public static String consumeURL(String urlString) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(urlString);
            URLConnection conexion = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
        } catch (IOException var6) {
            IOException e = var6;
            e.printStackTrace();
        }

        return response.toString();
    }
}
