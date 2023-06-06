package com.one.alura.domain.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

//    private Long id;
    private String nombreCurso;
//    private String categoria;


    public Curso(DatosCurso datosCurso) {
        this.nombreCurso = datosCurso.nombre();
//        this.categoria = datosCurso.categoria();
    }
}
