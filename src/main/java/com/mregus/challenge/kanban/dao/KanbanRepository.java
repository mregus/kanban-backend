package com.mregus.challenge.kanban.dao;

import com.mregus.challenge.kanban.entity.Kanban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource(path = "kanban")
public interface KanbanRepository extends JpaRepository<Kanban, Long> {

}
