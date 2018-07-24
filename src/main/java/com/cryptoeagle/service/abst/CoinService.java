package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.dto.CryptoCoin;

import java.util.List;

public interface CoinService {

    List<Coin> getCoins(String[] ids);

    void updateCoins();

    List<Coin> getAllCoins();

    List<Coin> getTopGainCoins();

    List<Coin> getTopLoserCoins();

}
