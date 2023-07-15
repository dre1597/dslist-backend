package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
  private final GameService gameService;

  public GameController(final GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping
  public List<GameMinDTO> findAll() {
    return gameService.findAll();
  }

  @GetMapping(value = "/{id}")
  public GameDTO findById(@PathVariable Long id) {
    return gameService.findById(id);
  }
}
