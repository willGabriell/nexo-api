package com.nexo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity @Table
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Categoria {

    public Categoria(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Usuario usuario;

    @CreatedDate
    private LocalDateTime dataCadastro;

}
