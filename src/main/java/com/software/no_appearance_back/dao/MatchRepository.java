package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.MatchiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchiEntity,Integer> {

    @Query(
            value = "SELECT * FROM matchi p WHERE " +
                    "p.estado = ?1 AND " +
                    "(p.id_cliente1 = ?2  OR p.id_cliente2 = ?2) ",
            nativeQuery = true)
    List<MatchiEntity> findMatchEntityByEstadoAndIdCliente1OrIdCliente2(int estado, int idC);

    @Query(
            value = "SELECT * FROM matchi p WHERE " +
                    "(p.id_cliente1 = ?1 AND p.id_cliente2 = ?2) OR " +
                    "(p.id_cliente1 = ?2 AND p.id_cliente2 = ?1) ",
            nativeQuery = true)
    MatchiEntity findMatchEntityByIdCliente1OrIdCliente2(int idC1, int idC2);

    @Query(
            value = "SELECT p.nombre FROM cliente p, matchi m WHERE" +
                    "(p.id_cliente = ?1 AND m.id_cliente1 = ?1 AND m.id_cliente2 = ?2 ) OR " +
                    "(p.id_cliente = ?1 AND m.id_cliente2 = ?1 AND m.id_cliente1 = ?2)",
            nativeQuery = true)
    String findNameByIdCliente(int idCExterno, int isCApp);

    MatchiEntity findByIdMatch(int idMatch);



}
