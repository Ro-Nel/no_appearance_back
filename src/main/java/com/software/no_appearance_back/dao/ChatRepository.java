package com.software.no_appearance_back.dao;

import com.software.no_appearance_back.domain.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity,Integer> {


    @Query(
            value = "SELECT p.nombre FROM cliente p, chat m WHERE" +
                    "(p.id_cliente = ?1 AND m.id_cliente1 = ?1 AND m.id_cliente2 = ?2 ) OR " +
                    "(p.id_cliente = ?1 AND m.id_cliente2 = ?1 AND m.id_cliente1 = ?2)",
            nativeQuery = true)
    String findNameChatByIdCliente(int idCExterno, int isCApp);

    List<ChatEntity> findMatchEntityByEstadoAndIdCliente1OrIdCliente2(int i, int idCliente, int idCliente1);
}
