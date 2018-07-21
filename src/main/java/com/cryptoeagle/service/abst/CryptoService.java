package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.CoinC;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.dto.CryptoCoin;

import java.io.IOException;
import java.util.List;

public interface CryptoService {

    List<CryptoCoin> getCoins(String[] ids) ;

    List<PictureCoin> getPicCoins();

    List<CoinC> getAllCoins();

}
