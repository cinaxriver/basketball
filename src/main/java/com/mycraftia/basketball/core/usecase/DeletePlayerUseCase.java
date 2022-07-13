package com.mycraftia.basketball.core.usecase;

import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.core.usecase.exceptions.PlayerNotExists;
import com.mycraftia.basketball.misc.UseCase;
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
public class DeletePlayerUseCase extends UseCase<DeletePlayerUseCase.Input, DeletePlayerUseCase.Output> {

  @NotNull
  private final PlayerRepository playerRepository;

  @Override
  public Output execute(final @NotNull Input input) {
    if (!playerRepository.contains(input.id)) {
      throw new PlayerNotExists("Player with id " + input.id + " does not exist");
    }
    return new Output(playerRepository.remove(input.id()));
  }

  @Value
  @Builder
  @Accessors(fluent = true)
  @Getter
  public static class Input {

    long id;
  }

  @Value
  @Builder
  @Accessors(fluent = true)
  @Getter
  public static class Output {

    @NotNull Player player;
  }
}
