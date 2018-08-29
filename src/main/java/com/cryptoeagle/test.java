package com.cryptoeagle;


import com.cryptoeagle.entity.crypto.Chart;
import net.sealake.binance.api.client.domain.market.Candlestick;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.concurrent.TimeUnit;

public class test {


    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void test2(){

        int y= 0;

        for (int x = 0 ; x < 1000000 ; x++)
        {
            y += x;
        }


    }

    public static Chart converter(Candlestick candlestick){

        Chart chart = new Chart();

        long opentime = candlestick.getOpenTime();

        double high = Double.parseDouble(candlestick.getHigh());
        double close = Double.parseDouble(candlestick.getClose());
        double open = Double.parseDouble(candlestick.getOpen());
        double low = Double.parseDouble(candlestick.getLow());

        double[] y = {open, high, low, close};

        chart.setY(y);
        chart.setX(opentime);

        return chart;

    }



    public static void main(String[] args) throws Exception {




    }
}


