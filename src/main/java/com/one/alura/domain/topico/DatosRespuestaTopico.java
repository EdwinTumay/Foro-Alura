package com.one.alura.domain.topico;

import java.time.LocalDate;

public record DatosRespuestaTopico(String titulo, String mensaje, LocalDate fecha_de_creacion, StatusTopico estatus, String autor, String curso) {

}
