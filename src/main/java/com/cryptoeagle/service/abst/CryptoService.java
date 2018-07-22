package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.dto.CryptoCoin;

import java.util.List;

public interface CryptoService {

    List<CryptoCoin> getCoins(String[] ids) ;

    List<Coin> getTopGainCoins();

    List<Coin> getTopLoserCoins();

    List<PictureCoin> getPicCoins();

    List<Coin> getAllCoins();

}
