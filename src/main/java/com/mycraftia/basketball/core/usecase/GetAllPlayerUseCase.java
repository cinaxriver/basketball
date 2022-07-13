package com.mycraftia.basketball.core.usecase;

import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.misc.UseCase;
import java.util.List;
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
public class GetAllPlayerUseCase extends UseCase<GetAllPlayerUseCase.Input, GetAllPlayerUseCase.Output> {

  @NotNull
  private final PlayerRepository playerRepository;

  @Override
  public Output execute(@NotNull final Input input) {
    return Output.builder().players(playerRepository.fetchAll()).build();
  }

  @Value
  @Builder
  @Accessors(fluent = true)
  @Getter
  public static class Input {
    /*
    @todo pagination?
     */
  }

  @Value
  @Builder
  @Accessors(fluent = true)
  @Getter
  public static class Output {
    @NotNull List<Player> players;
  }
}
