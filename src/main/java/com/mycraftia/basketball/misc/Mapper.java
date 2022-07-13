package com.mycraftia.basketball.misc;

import org.jetbrains.annotations.NotNull;

public interface Mapper<F,T> {

  @NotNull
  T toData(@NotNull F from);

  @NotNull
  F toEntity(@NotNull T target);

}
