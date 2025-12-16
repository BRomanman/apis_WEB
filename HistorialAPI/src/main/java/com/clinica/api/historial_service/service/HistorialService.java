package com.clinica.api.historial_service.service;

import com.clinica.api.historial_service.dto.ActualizarDiagnosticoRequest;
import com.clinica.api.historial_service.dto.HistorialRequest;
import com.clinica.api.historial_service.model.Historial;
import com.clinica.api.historial_service.repository.HistorialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HistorialService {

    private final HistorialRepository historialRepository;

    public HistorialService(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<Historial> findHistorialesByUsuarioId(Long usuarioId) {
        return historialRepository.findByIdUsuario(usuarioId);
    }

    public List<Historial> findHistorialesByDoctorId(Long doctorId) {
        return historialRepository.findByIdDoctor(doctorId);
    }

    public Historial crearHistorialDesdeCita(HistorialRequest request) {
        Historial historial = new Historial();
        historial.setFechaConsulta(request.getFechaHistorial());
        historial.setEstado(request.getEstado());
        historial.setIdUsuario(request.getIdUsuario());
        historial.setIdDoctor(request.getIdDoctor());
        historial.setPago(request.getPago());
        historial.setHoraInicio(request.getHoraInicio());
        historial.setHoraFin(request.getHoraFin());
        historial.setDuracionMinutos(request.getDuracionMinutos());
        historial.setDiagnostico(request.getDiagnostico());
        historial.setObservaciones(request.getObservaciones());
        historial.setIdConsulta(request.getIdConsulta());
        return historialRepository.save(historial);
    }

    public Historial actualizarDiagnosticoDesdeCita(Long idConsulta, ActualizarDiagnosticoRequest request) {
        Historial historial = historialRepository.findByIdConsulta(idConsulta)
            .orElseThrow(() -> new EntityNotFoundException("Historial no encontrado para la cita"));
        historial.setDiagnostico(request.getDiagnostico());
        historial.setObservaciones(request.getObservaciones());
        return historialRepository.save(historial);
    }

    @SuppressWarnings("null")
    public Historial findHistorialById(Long id) {
        return historialRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Historial no encontrado"));
    }
}
