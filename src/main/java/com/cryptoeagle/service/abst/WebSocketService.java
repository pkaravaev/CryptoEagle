package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.dto.Quote;

public interface WebSocketService  {

    Quote getLasTraderPrice(String symbol);
}
