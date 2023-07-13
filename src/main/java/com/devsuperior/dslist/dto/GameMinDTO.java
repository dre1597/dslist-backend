package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;

public record GameMinDTO(
    Long id,
    String title,
    Integer year,
    String imgUrl,
    String shortDescription
) {
  public static GameMinDTO fromGame(final Game game) {
    return new GameMinDTO(
        game.getId(),
        game.getTitle(),
        game.getYear(),
        game.getImgUrl(),
        game.getShortDescription()
    );
  }
}
