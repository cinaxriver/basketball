package com.mycraftia.basketball;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.mycraftia.basketball.core.domain.Player;
import com.mycraftia.basketball.core.domain.Position;
import com.mycraftia.basketball.core.usecase.PlayerRepository;
import com.mycraftia.basketball.data.entity.PlayerData;
import com.mycraftia.basketball.data.repository.PlayerJpaRepository;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "basketball.create=false")
public class ResolverTest {

  @Autowired
  private GraphQLTestTemplate graphQLTestTemplate;

  @Autowired
  private PlayerJpaRepository repository;

  @Test
  public void create_player() throws IOException {
    final GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/create.graphql");
    assertThat(response.isOk()).isTrue();
    assertThat(response.get("$.data.create.id")).isEqualTo("1");
    assertThat(response.get("$.data.create.name")).isEqualTo("charles");
    assertThat(response.get("$.data.create.surname")).isEqualTo("broskoski");
    assertThat(response.get("$.data.create.position")).isEqualTo("C");
    assertThat(repository.count()).isEqualTo(1);
  }

  @Test
  public void create_player_blank() throws IOException {
    final GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/create_blank.graphql");
    response.assertThatNumberOfErrors().isEqualTo(1);
    assertThat(repository.count()).isEqualTo(1);
  }

  @Test
  public void create_player_same_position() throws IOException {
    final GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/create_blank.graphql");
    response.assertThatNumberOfErrors().isEqualTo(1);
    assertThat(repository.count()).isEqualTo(1);
  }

  @Test
  public void get_all_players() throws IOException {
    final GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/getplayers.graphql");
    assertThat(response.isOk()).isTrue();
    assertThat(response.get("$.data.allPlayers[0].id")).isEqualTo("1");
    assertThat(response.get("$.data.allPlayers[0].name")).isEqualTo("charles");
    assertThat(response.get("$.data.allPlayers[0].surname")).isEqualTo("broskoski");
    assertThat(response.get("$.data.allPlayers[0].position")).isEqualTo("C");
  }

  @Test
  public void delete_player() throws IOException {
    final GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/delete.graphql");
    assertThat(response.isOk()).isTrue();
    assertThat(response.get("$.data.delete.id")).isEqualTo("1");
    assertThat(repository.count()).isEqualTo(0);
  }


  @Test
  public void delete_unknown() throws IOException {
    final GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/delete_unknown.graphql");
    response.assertThatNumberOfErrors().isEqualTo(1);
  }
}
