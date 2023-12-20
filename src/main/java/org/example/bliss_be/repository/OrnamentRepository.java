package org.example.bliss_be.repository;

import org.example.bliss_be.entity.Ornament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrnamentRepository extends JpaRepository<Ornament, Long> {
    List<Ornament> findAllById(Long treeId);
}
