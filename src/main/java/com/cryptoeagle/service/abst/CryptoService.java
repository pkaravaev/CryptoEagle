package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.dto.CryptoCoin;

import java.io.IOException;
import java.util.List;

public interface CryptoService {

    List<CryptoCoin> getCoins() throws IOException;
}
