package com.mycraftia.basketball.core.usecase;

import com.mycraftia.basketball.core.domain.Player;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface PlayerRepository {

  @NotNull
  Player persist(@NotNull Player player);

  boolean contains(long id);

  @NotNull
  List<Player> fetchAll();

  @NotNull
  Player remove(long player);

}
