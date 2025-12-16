package com.clinica.api.historial_service.dto;

public class ActualizarDiagnosticoRequest {

    private String diagnostico;
    private String observaciones;

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
