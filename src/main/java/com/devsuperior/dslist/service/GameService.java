package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entity.Game;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
  private final GameRepository gameRepository;

  public GameService(final GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    return result.stream().map(GameMinDTO::fromGame).toList();
  }
}
