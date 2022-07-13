package com.mycraftia.basketball.data.mapper;

import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.data.entity.PlayerData;
import com.mycraftia.basketball.misc.Mapper;
import org.jetbrains.annotations.NotNull;

public class PlayerMapper implements Mapper<Player, PlayerData> {

  @Override
  public @NotNull PlayerData toData(@NotNull final Player from) {
    return PlayerData.builder()
      .id(from.uniqueId())
      .firstName(from.name())
      .lastName(from.surname())
      .position(from.position())
      .build();
  }

  @Override
  public @NotNull Player toEntity(@NotNull final PlayerData target) {
    return Player.builder()
      .id(target.id())
      .name(target.firstName())
      .surname(target.lastName())
      .position(target.position())
      .build();
  }
}
