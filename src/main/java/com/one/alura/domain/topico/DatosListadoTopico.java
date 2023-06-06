package com.one.alura.domain.topico;

import java.time.LocalDate;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDate fecha_de_creacion, StatusTopico estatus, String autor, String curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaDeCreacion(), topico.getEstatus(), topico.getAutor(), topico.getCurso());
    }

}
