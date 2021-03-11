package com.mregus.challenge.kanban.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

  private EntityManager entityManager;

  @Autowired
  public DataRestConfig(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

    exposeIds(config);
  }

  private void exposeIds(RepositoryRestConfiguration config) {

    // get list of all entity classes from entity manager
    Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

    List<Class> entityClass = new ArrayList<>();

    for (EntityType e : entities){
      entityClass.add(e.getJavaType());
    }

    // expose entity id's
    Class[] domainTypes = entityClass.toArray(new Class[0]);
    config.exposeIdsFor(domainTypes);
  }
}
