package com.cryptoeagle;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Utils {

    public static String HMAC384sign(String key, String data) {
        try {
//            String jsonstring = new ObjectMapper().readValue(data, String.class);


            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA384");
            Mac mac = Mac.getInstance("HmacSHA384");
            mac.init(keySpec);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            String result = Base64.getEncoder().encodeToString(rawHmac);
            return result;

        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (InvalidKeyException e) {
            return "";
        }
//        catch (IOException e) {
//            return "";
//        }
    }
}
