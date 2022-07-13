package com.mycraftia.basketball.resolver;

import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.core.usecase.AddPlayerUseCase;
import com.mycraftia.basketball.core.usecase.DeletePlayerUseCase;
import com.mycraftia.basketball.resolver.input.CreatePlayerInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@RequiredArgsConstructor
@Validated
public class PlayerMutation implements GraphQLMutationResolver {

  @NotNull
  private final AddPlayerUseCase addPlayerUseCase;

  @NotNull
  private final DeletePlayerUseCase deletePlayerUseCase;

  public Player create(@Valid CreatePlayerInput input) {
    return addPlayerUseCase.execute(
      AddPlayerUseCase.Input.builder()
        .name(input.getName())
        .surname(input.getSurname())
        .position(input.getPosition())
        .build()
    ).player();
  }

  public Player delete(long id) {
    return deletePlayerUseCase.execute(
      DeletePlayerUseCase.Input.builder()
        .id(id)
        .build()
    ).player();
  }
}
