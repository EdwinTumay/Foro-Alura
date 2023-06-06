package com.one.alura.domain.topico;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DatosResgistoTopico(

        @Column(name = "titulo", unique = true, length = 150)
        @NotBlank(message = "no puede ser vacio  el titulo")
        String titulo,

        @Column(name = "mensaje", unique = true, length = 250)
        @NotBlank(message = "no puede ser vacio  el mensaje")
        String mensaje,

        LocalDate fechaDeCreacion,
        StatusTopico estatus,

        @NotBlank(message = "no puede ser vacio  el autor")
        String autor,

        @NotBlank(message = "no puede ser vacio  el curso")
        String curso ) {

}
