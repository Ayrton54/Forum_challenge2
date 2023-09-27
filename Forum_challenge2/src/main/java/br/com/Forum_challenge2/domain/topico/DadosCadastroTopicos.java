package br.com.Forum_challenge2.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public record DadosCadastroTopicos(
        @NotBlank
        String titulo,
        @NotBlank String mensagem,
        @NotBlank String autor,

        @NotBlank String curso,
        LocalDateTime data,
        @NotNull
        StatusTopico status

) {
}

