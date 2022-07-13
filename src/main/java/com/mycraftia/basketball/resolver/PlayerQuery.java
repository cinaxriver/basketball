package com.mycraftia.basketball.resolver;

import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.core.usecase.GetAllPlayerUseCase;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PlayerQuery implements GraphQLQueryResolver {

  @NotNull
  private final GetAllPlayerUseCase getAllPlayerUseCase;

  @NotNull
  public List<Player> allPlayers() {
    return getAllPlayerUseCase.execute(GetAllPlayerUseCase.Input.builder().build()).players() ;
  }
}
