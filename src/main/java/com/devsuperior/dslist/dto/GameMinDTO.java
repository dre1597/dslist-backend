package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;
import com.devsuperior.dslist.projection.GameMinProjection;

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

  public static GameMinDTO fromGameMinProjection(final GameMinProjection projection) {
    return new GameMinDTO(
        projection.getId(),
        projection.getTitle(),
        projection.getYear(),
        projection.getImgUrl(),
        projection.getShortDescription()
    );
  }
}
