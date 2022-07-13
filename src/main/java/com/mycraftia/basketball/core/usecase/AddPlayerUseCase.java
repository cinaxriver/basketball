package com.mycraftia.basketball.core.usecase;

import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.core.domain.Position;
import com.mycraftia.basketball.core.usecase.exceptions.PositionAlreadyExists;
import com.mycraftia.basketball.misc.UseCase;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class AddPlayerUseCase extends UseCase<AddPlayerUseCase.Input, AddPlayerUseCase.Output> {

  @NotNull
  private final PlayerRepository playerRepository;

  @NotNull
  private final GetAllPlayerUseCase getAllPlayerUseCase;

  @NotNull
  public Output execute(@NotNull final Input input) {
    if (!checkPosition(input.position())) {
      throw new PositionAlreadyExists("Position already exists");
    }
    return new Output(playerRepository.persist(Player.builder()
      .name(input.name())
      .surname(input.surname())
      .position(input.position())
      .build()));
  }

  public boolean checkPosition(Position position) {
    return getAllPlayerUseCase.execute(GetAllPlayerUseCase.Input.builder().build())
      .players()
      .stream()
      .map(Player::position)
      .collect(Collectors.toSet())
      .add(position);
  }

  @Value
  @Builder
  @Accessors(fluent = true)
  @Getter
  public static class Input {

    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    Position position;
  }

  @Value
  @Builder
  @Accessors(fluent = true)
  @Getter
  public static class Output {

    @NotNull
    Player player;
  }
}
