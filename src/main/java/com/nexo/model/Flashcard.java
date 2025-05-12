package com.nexo.model;

import com.nexo.dto.flashcard.FlashcardRequestDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity @Table
@Data
@NoArgsConstructor
public class Flashcard {

    public Flashcard(FlashcardRequestDto dto, Categoria categoria) {
        this.frente = dto.frente();
        this.verso = dto.verso();
        this.categoria = categoria;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String frente;
    private String verso;

    @ManyToOne
    private Categoria categoria;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

}
