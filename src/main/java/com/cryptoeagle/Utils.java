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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class Utils {

    public static String cut(String s){

        char[] raw = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        int count = 0;

        for (int i = 0 ; i < raw.length ; i++){

            if (raw[i] == '.'){
                count++;
                continue;
            }


            if (count == 1){
                builder.append(raw[i]);
            }

        }

        return builder.toString();

    }
}
