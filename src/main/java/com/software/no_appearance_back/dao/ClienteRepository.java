package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {


    ClienteEntity findClienteEntityByCorreo(String correo);


}
