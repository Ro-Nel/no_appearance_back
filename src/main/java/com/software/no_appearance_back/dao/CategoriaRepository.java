package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Integer> {

}
