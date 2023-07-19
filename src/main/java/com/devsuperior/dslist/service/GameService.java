package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.projection.GameMinProjection;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class GameService {
  private final GameRepository gameRepository;
  private final GameListRepository gameListRepository;

  public GameService(
      final GameRepository gameRepository,
      final GameListRepository gameListRepository
  ) {
    this.gameRepository = gameRepository;
    this.gameListRepository = gameListRepository;
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

  @Transactional
  public void move(Long gameListId, int sourceIndex, int destinationIndex) {
    List<GameMinProjection> gameList = gameRepository.searchGameList(gameListId);

    GameMinProjection obj = gameList.remove(sourceIndex);

    gameList.add(destinationIndex, obj);

    int min = Math.min(sourceIndex, destinationIndex);
    int max = Math.max(sourceIndex, destinationIndex);

    for (int i = min; i <= max; i++) {
      gameListRepository.updateBelongingPosition(gameListId, gameList.get(i).getId(), i);
    }
  }

}
