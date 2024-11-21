package com.stulikov.public_transport_stops_on_spring;


import com.stulikov.public_transport_stops_on_spring.exceptions.ConnectException;
import com.stulikov.public_transport_stops_on_spring.forecast.Forecast;
import com.stulikov.public_transport_stops_on_spring.transformation.Parsing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Request {
    public static List<Forecast> httpRequest(int stopID) throws ConnectException, IOException {
        Document document = null;
        URL url = new URL("https://tosamara.ru/xml_bridge.php/");
        String params = String.format("method=getFirstArrivalToStop&KS_ID=%d&COUNT=10&version=main&eng=0", stopID);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setDoOutput(true);
        try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
            dos.writeBytes(params);
        }
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            document = Jsoup.parse(con.getInputStream(), "UTF-8", "https://tosamara.ru/xml_bridge.php/");
        }

        if (document == null) throw new ConnectException("C соединением проблемы");
        return Parsing.parseHttpResponse(document);
    }

}
