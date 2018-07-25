package com.cryptoeagle.service;

import com.cryptoeagle.entity.dto.Quote;
import com.cryptoeagle.service.abst.WebSocketService;
import net.sealake.binance.api.client.BinanceApiClientFactory;
import net.sealake.binance.api.client.BinanceApiWebSocketClient;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl  implements WebSocketService {

   private static final BinanceApiWebSocketClient client = BinanceApiClientFactory.newInstance().newWebSocketClient();

    @Override
    public Quote getLasTraderPrice(String symbol) {

        Quote quote = new Quote();
        client.onAggTradeEvent(symbol.toLowerCase(),
                response -> quote.setPrice(Double.parseDouble(response.getPrice())));
        return quote;
    }

}
