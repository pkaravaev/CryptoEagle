package com.cryptoeagle.service.abst;

import antlr.collections.impl.LList;
import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.IcoData;

import java.util.List;

public interface RestClientService {

     List<Ico> getIcos();

     List<Coin> getCoins();



     List<Ico> getAllIcosFromIcobench();

     List<Ico> getIcoByPage(int page);

     IcoData getDataForIco(int id);
}
