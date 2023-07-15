package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.GameList;

public record GameListDTO(Long id, String name) {
  public static GameListDTO fromGameList(final GameList gameList) {
    return new GameListDTO(
        gameList.getId(),
        gameList.getName()
    );
  }
}
