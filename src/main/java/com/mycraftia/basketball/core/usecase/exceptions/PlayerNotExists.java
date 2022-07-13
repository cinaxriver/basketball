package com.mycraftia.basketball.core.usecase.exceptions;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class PlayerNotExists extends GraphQLException {

  public PlayerNotExists(final @NotNull String message) {
    super(message);
  }

  @Override
  public List<Object> getPath() {
    return super.getPath();
  }

  @Override
  public Map<String, Object> toSpecification() {
    return super.toSpecification();
  }

  @Override
  public Map<String, Object> getExtensions() {
    return super.getExtensions();
  }
}
