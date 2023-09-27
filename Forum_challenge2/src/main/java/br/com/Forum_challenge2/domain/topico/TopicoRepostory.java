package br.com.Forum_challenge2.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepostory extends JpaRepository <Topico,Long> {
    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
    @Query("""
            select t.ativo
            from Topico t 
            where
            t.id = :id
            """)
    Boolean findAtivoById(Long id);
}

