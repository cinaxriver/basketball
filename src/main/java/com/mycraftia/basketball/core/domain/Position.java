package com.mycraftia.basketball.core.domain;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Getter
@Accessors(fluent = true)
public enum Position {

  PG("Point guard"),
  SG("Shooting guard"),
  SF("Small forward"),
  PF("Power forward"),
  C("Center");

  @NotNull
  private final String display;

  Position(@NotNull final String display) {
    this.display = display;
  }

}
