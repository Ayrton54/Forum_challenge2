package br.com.Forum_challenge2.domain.topico;

public record DadosretornoTopico(Long id, String titulo,
                                 String mensagem,String autor, String curso, StatusTopico status) {
    public DadosretornoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getAutor(), topico.getCurso(),topico.getStatus() );
    }

}



