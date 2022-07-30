package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.GameBasic;
import com.dan232.pricer.comparator.model.GamePriced;

import java.util.List;

public interface GameQueryUseCase {

    GetAllGames getGames();

    GetGame getGame(String id);

    GetGamesByCategory getGamesByCategory(String category);

    interface GetAllGames{
        List<GameBasic> perform();
    }

    interface GetGame{
        GamePriced perform();
    }

    interface GetGamesByCategory{
        List<GameBasic> perform();
    }

}
