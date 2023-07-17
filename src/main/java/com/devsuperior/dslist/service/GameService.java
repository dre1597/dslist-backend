package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class GameService {
  private final GameRepository gameRepository;

  public GameService(final GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    var result = gameRepository.findAll();
    return result.stream().map(GameMinDTO::fromGame).toList();
  }

  @Transactional(readOnly = true)
  public GameDTO findById(final Long id) {
    return GameDTO.fromGame(Objects.requireNonNull(gameRepository.findById(id).orElse(null)));
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByList(Long gameListId) {
    var result = gameRepository.searchGameList(gameListId);
    return result.stream().map(GameMinDTO::fromGameMinProjection).toList();
  }

}
