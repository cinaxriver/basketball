package com.mycraftia.basketball.core.domain;

import com.mycraftia.basketball.misc.Uniqued;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
@Builder
public final class Player implements Uniqued {

  private long id;

  @NotNull
  private String name;

  @NotNull
  private String surname;

  @NotNull
  private Position position;

  @Override
  public long uniqueId() {
    return this.id;
  }
}
