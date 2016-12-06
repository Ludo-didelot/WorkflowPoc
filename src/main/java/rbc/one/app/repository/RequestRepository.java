package rbc.one.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rbc.one.app.workflow.bean.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}