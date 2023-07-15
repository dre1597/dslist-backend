package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.service.GameListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/game-lists")
public class GameListController {
  private final GameListService gameListService;

  public GameListController(GameListService gameListService) {
    this.gameListService = gameListService;
  }

  @GetMapping
  public List<GameListDTO> findAll() {
    return gameListService.findAll();
  }
}
