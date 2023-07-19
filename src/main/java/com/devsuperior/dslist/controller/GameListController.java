package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game-lists")
public class GameListController {
  private final GameListService gameListService;
  private final GameService gameService;

  public GameListController(GameListService gameListService, GameService gameService) {
    this.gameListService = gameListService;
    this.gameService = gameService;
  }

  @GetMapping
  public List<GameListDTO> findAll() {
    return gameListService.findAll();
  }

  @GetMapping(value = "/{gameListId}/games")
  public List<GameMinDTO> findByList(@PathVariable Long gameListId) {
    return gameService.findByList(gameListId);
  }

  @PostMapping(value = "/{gameListId}/replacement")
  public void move(@PathVariable Long gameListId, @RequestBody ReplacementDTO replacementDTO) {
    gameService.move(gameListId, replacementDTO.sourceIndex(), replacementDTO.destinationIndex());
  }
}
