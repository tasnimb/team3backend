package com.bbtutorials.users.repository;
import com.bbtutorials.users.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface ShowsRepository extends JpaRepository<Shows, Integer>, JpaSpecificationExecutor<Shows>, QuerydslPredicateExecutor<Shows> {}

