package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.MensajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<MensajeEntity,Integer> {
    List<MensajeEntity> findAllByIdChat(int idChat);


}
