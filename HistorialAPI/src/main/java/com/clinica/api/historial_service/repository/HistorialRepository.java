package com.clinica.api.historial_service.repository;

import com.clinica.api.historial_service.model.Historial;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {

    List<Historial> findByIdUsuario(Long idUsuario);

    List<Historial> findByIdDoctor(Long idDoctor);

    Optional<Historial> findByIdConsulta(Long idConsulta);
}
