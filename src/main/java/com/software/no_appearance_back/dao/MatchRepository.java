package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.ClienteEntity;
import com.software.no_appearance_back.domain.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity,Integer> {
    List<MatchEntity> findMatchEntityByEstadoAndIdCliente1OrIdCliente2(int estado, int idC1, int idC2);


}
