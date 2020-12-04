package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity,Integer> {

    List<ChatEntity> findMatchEntityByEstadoAndIdCliente1OrIdCliente2(int i, int idCliente, int idCliente1);
}
