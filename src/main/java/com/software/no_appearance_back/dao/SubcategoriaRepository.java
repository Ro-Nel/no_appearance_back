package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.CategoriaEntity;
import com.software.no_appearance_back.domain.SubcategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoriaRepository extends JpaRepository<SubcategoriaEntity,Integer> {
    List<SubcategoriaEntity> findByIdCategoria(int idCategoria);
    List<SubcategoriaEntity> findAll();


}
