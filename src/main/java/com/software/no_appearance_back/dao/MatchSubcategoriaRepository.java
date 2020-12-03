package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.MatchEntity;
import com.software.no_appearance_back.domain.MatchSubcategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchSubcategoriaRepository extends JpaRepository<MatchSubcategoriaEntity,Integer> {


    @Query(
            value = "SELECT * FROM match_subcategoria m WHERE " +
                    "m.id_match =    (SELECT p.idmatch  FROM 'match' p WHERE " +
                                    "(p.id_cliente1 = ?1 AND p.id_cliente2 = ?2) OR " +
                                    "(p.id_cliente1 = ?2 AND p.id_cliente2 = ?1) ",
            nativeQuery = true)
    MatchEntity findMatchSubcategoriaByIdClientes(int idC1, int idC2);
}
