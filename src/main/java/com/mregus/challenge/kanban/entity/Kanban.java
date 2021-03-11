package com.mregus.challenge.kanban.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "kanban")
@Getter
@Setter
public class Kanban {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "feature_date")
  @CreationTimestamp
  private Date featureDate;

  @Column(name = "owner_name")
  private String ownerName;

  @Column(name = "status")
  private String status;
}
