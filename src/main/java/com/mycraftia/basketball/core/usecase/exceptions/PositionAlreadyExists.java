package com.mycraftia.basketball.core.usecase.exceptions;

import graphql.ErrorType;
import java.util.List;
import java.util.Map;

public class PositionAlreadyExists extends GraphQLException {

  public PositionAlreadyExists(final String message) {
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
  public ErrorType getErrorType() {
    return ErrorType.ExecutionAborted;
  }
}
