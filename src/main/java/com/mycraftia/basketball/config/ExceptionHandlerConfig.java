package com.mycraftia.basketball.config;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class ExceptionHandlerConfig {

  @ExceptionHandler(value = {GraphQLException.class})
  public ThrowableGraphQLError handle(GraphQLException error) {
    return new ThrowableGraphQLError(error);
  }

  @ExceptionHandler(value = {ConstraintViolationException.class})
  public ThrowableGraphQLError handle(ConstraintViolationException error) {
    return new ThrowableGraphQLError(error);
  }

}