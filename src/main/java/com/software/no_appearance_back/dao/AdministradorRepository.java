package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorEntity,Integer> {

}
