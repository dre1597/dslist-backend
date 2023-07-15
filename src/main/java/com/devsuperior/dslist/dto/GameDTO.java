package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;

public record GameDTO(
    Long id,
    String title,
    Integer year,
    String genre,
    String platforms,
    Double score,
    String imgUrl,
    String shortDescription,
    String longDescription
) {
  public static GameDTO fromGame(final Game game) {
    return new GameDTO(
        game.getId(),
        game.getTitle(),
        game.getYear(),
        game.getGenre(),
        game.getPlatforms(),
        game.getScore(),
        game.getImgUrl(),
        game.getShortDescription(),
        game.getLongDescription()
    );
  }
}
