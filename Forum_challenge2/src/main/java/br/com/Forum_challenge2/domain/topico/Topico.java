package br.com.Forum_challenge2.domain.topico;


import br.com.Forum_challenge2.domain.curso.Curso;
import br.com.Forum_challenge2.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status ;

    private String autor;
    private String curso;
    private Boolean ativo;


    public Topico(DadosCadastroTopicos dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.status = dados.status();
        this.data = dados.data();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.ativo =true;
    }

    public void Atualizacao(DadosAtualizarTopico dados) {
        if(dados.autor() != null){
            this.autor = dados.autor();
        }
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null){
            this.curso = dados.curso();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}