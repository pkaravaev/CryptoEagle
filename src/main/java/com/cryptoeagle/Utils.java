package com.cryptoeagle;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



public class Utils {

    public static String HMAC384sign(String key, String data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA384");
            Mac mac = Mac.getInstance("HmacSHA384");
            mac.init(keySpec);
            byte[] bytes = data.getBytes();
            byte[] rawHmac = mac.doFinal(data.getBytes());
            return    Base64.getEncoder().encodeToString(rawHmac);

        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (InvalidKeyException e) {
            return "";
        }

    }

    public static String readInputStreamToString(HttpURLConnection connection) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        }
        catch (Exception e) {

            result = null;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {

                }
            }
        }

        return result;
    }
}
