package com.dan232.pricer.scrapper;

import com.dan232.pricer.scrapper.model.GamePrice;

import java.util.List;
import java.util.stream.Collectors;

public interface ScrapperPort {

    default List<GamePrice> scrapWeb(){
        return scrapWebForIds().stream().map(this::scrapWeb).collect(Collectors.toList());
    }

    GamePrice scrapWeb(String gameId);

    List<String> scrapWebForIds();

}
