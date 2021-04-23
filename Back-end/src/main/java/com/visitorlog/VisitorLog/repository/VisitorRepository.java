package com.visitorlog.VisitorLog.repository;

import com.visitorlog.VisitorLog.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepository extends JpaRepository <Visitor, Long>{

    void deleteVisitorById(Long id);

    Optional<Visitor> findVisitorById(Long id);
}
