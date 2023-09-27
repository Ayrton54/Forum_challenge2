package br.com.Forum_challenge2.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
        @NotNull
        Long id,
        String autor,
        String titulo,
        String mensagem,
        String curso

) {
}
