package com.one.alura.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDate fechaDeCreacion;
        //LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico estatus;
            //StatusTopico.NO_RESPONDIDO;
    private String autor;
    private String curso;
            //private List<Respuesta> respuestas = new ArrayList<>();


    public Topico(DatosResgistoTopico datosResgistoTopico) {
        this.titulo = datosResgistoTopico.titulo();
        this.mensaje = datosResgistoTopico.mensaje();
        this.fechaDeCreacion = LocalDate.now();
        this.estatus = StatusTopico.NO_RESPONDIDO;
        this.autor = datosResgistoTopico.autor();
        this.curso = datosResgistoTopico.curso();

    }

    public void actualizarDatos(DatosAcutalizarTopico datosAcutalizarTopico) {
        if(datosAcutalizarTopico.titulo() != null){
            this.titulo = datosAcutalizarTopico.titulo();
        }
        if(datosAcutalizarTopico.mensaje() != null){
            this.mensaje = datosAcutalizarTopico.mensaje();
        }
        if (datosAcutalizarTopico.autor() != null){
            this.autor = datosAcutalizarTopico.autor();
        }
        if (datosAcutalizarTopico.curso() != null){
            this.curso = datosAcutalizarTopico.curso();
        }
    }
}
