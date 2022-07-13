package com.mycraftia.basketball.resolver.input;

import com.mycraftia.basketball.core.domain.Position;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CreatePlayerInput {

  @NotBlank
  private String name;

  @NotBlank
  private String surname;

  private Position position;
}