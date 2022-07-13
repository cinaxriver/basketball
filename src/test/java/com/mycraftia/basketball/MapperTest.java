package com.mycraftia.basketball;

import static org.assertj.core.api.Assertions.assertThat;
import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.core.domain.Position;
import com.mycraftia.basketball.data.entity.PlayerData;
import com.mycraftia.basketball.data.mapper.PlayerMapper;
import org.junit.jupiter.api.Test;

public class MapperTest {

  PlayerMapper mapper = new PlayerMapper();

  @Test
  public void to_entity_test() {
    final Player player = mapper.toEntity(new PlayerData(1, "charles", "broskoski", Position.C));
    assertThat(player.id()).isEqualTo(1);
    assertThat(player.name()).isEqualTo("charles");
    assertThat(player.surname()).isEqualTo("broskoski");
    assertThat(player.position()).isEqualTo(Position.C);
  }

  @Test
  public void to_data_test() {
    final PlayerData player = mapper.toData(new Player(1, "charles", "broskoski", Position.C));
    assertThat(player.id()).isEqualTo(1);
    assertThat(player.firstName()).isEqualTo("charles");
    assertThat(player.lastName()).isEqualTo("broskoski");
    assertThat(player.position()).isEqualTo(Position.C);
  }
}
