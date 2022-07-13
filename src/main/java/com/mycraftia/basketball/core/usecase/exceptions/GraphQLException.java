package com.mycraftia.basketball.core.usecase.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class GraphQLException extends RuntimeException implements GraphQLError {

  public GraphQLException(@NotNull final String message) {
    super(message, null, false, false);
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorType getErrorType() {
    return null;
  }
}
