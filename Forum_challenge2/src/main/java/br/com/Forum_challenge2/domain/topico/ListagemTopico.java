package br.com.Forum_challenge2.domain.topico;

import java.time.LocalDateTime;

public record ListagemTopico(Long id, String titulo, String mensagem, StatusTopico status, String autor, String curso,
                             LocalDateTime data) {
    public ListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getStatus(), topico.getAutor(), topico.getCurso(),topico.getData());
    }


}
