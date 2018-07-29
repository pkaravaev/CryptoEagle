package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.crypto.Ico;
import com.cryptoeagle.entity.crypto.IcoData;

import java.util.List;

public interface RestClientService {

     List<Ico> getIcos();

     List<Coin> getCoins();



     List<Ico> getAllIcosFromIcobench();

     List<Ico> getIcoByPage(int page);

     IcoData getDataForIco(int id);
}
