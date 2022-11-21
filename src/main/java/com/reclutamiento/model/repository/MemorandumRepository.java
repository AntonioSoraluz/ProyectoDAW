package com.reclutamiento.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reclutamiento.model.Memorandum;

@Repository
public interface MemorandumRepository extends JpaRepository<Memorandum, Integer>{

}
