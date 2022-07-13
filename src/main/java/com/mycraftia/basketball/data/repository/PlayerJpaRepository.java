package com.mycraftia.basketball.data.repository;

import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.core.usecase.PlayerRepository;
import com.mycraftia.basketball.data.entity.PlayerData;
import com.mycraftia.basketball.data.mapper.PlayerMapper;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerData, Long>, PlayerRepository {

  @NotNull
  PlayerMapper mapper = new PlayerMapper();

  @Override
  @NotNull
  default Player persist(@NotNull Player player) {
    return mapper.toEntity(save(mapper.toData(player)));
  }

  @Override
  default boolean contains(long id) {
    return existsById(id);
  }

  //@todo pagination?
  @Override
  default @NotNull List<Player> fetchAll() {
    final List<Player> players = new ArrayList<>();
    for (final PlayerData next : findAll()) {
      players.add(mapper.toEntity(next));
    }
    return players;
  }

  @Override
  @NotNull
  default Player remove(long player) {
    final PlayerData playerData = findById(player).orElseThrow(() -> new IllegalArgumentException("Player not found"));
    deleteById(player);
    return mapper.toEntity(playerData);
  }
}
