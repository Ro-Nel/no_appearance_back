package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.AdministradorEntity;
import com.software.no_appearance_back.domain.ClienteSubcategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteSubcategoriaRepository extends JpaRepository<ClienteSubcategoriaEntity,Integer> {

    List<ClienteSubcategoriaEntity> findAllByIdCliente(int idCliente);



    @Query(
            value = "SELECT COUNT(*) FROM cliente_subcategoria p WHERE p.id_cliente = ? ",
            nativeQuery = true)
    int findCountByIdCliente(int idPaciente);
}
