package com.mycraftia.basketball;

import com.mycraftia.basketball.core.domain.Position;
import com.mycraftia.basketball.data.entity.PlayerData;
import com.mycraftia.basketball.data.repository.PlayerJpaRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class TemplateBasketballPlayers {

  @Autowired
  private PlayerJpaRepository repository;

  @Value("${basketball.create:default}")
  private boolean create = true;

  @PostConstruct
  public void init() {
    if (!create) {
      return;
    }
    repository.save(new PlayerData("william", "smith", Position.PG));
    repository.save(new PlayerData("mary", "johnson", Position.SG));
    repository.save(new PlayerData("john", "williams", Position.SF));
    repository.save(new PlayerData("christopher", "miller", Position.PF));
    repository.save(new PlayerData("anna", "brown", Position.C));
  }
}
