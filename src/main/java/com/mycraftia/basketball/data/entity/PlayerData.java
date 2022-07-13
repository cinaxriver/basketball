package com.mycraftia.basketball.data.entity;

import com.mycraftia.basketball.core.domain.Position;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity(name = "player")
@Table(name = "player")
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class PlayerData {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "firstName", nullable = false, length = 32)
  private String firstName;

  @Column(name = "lastName", nullable = false, length = 32)
  private String lastName;

  @Column(name = "position", nullable = false)
  @Enumerated(EnumType.STRING)
  private Position position;

  public PlayerData(final String firstName, final String lastName, final Position position) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
  }
}
