package br.com.Forum_challenge2.controller;

import br.com.Forum_challenge2.domain.usuario.Autentificacao;
import br.com.Forum_challenge2.infra.security.DadosToken;
import br.com.Forum_challenge2.domain.usuario.Usuario;
import br.com.Forum_challenge2.infra.security.Tokenservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class UsuarioController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private Tokenservice tokensevice;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid Autentificacao dados) {
        var autenticaToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autentica = manager.authenticate(autenticaToken);
        var tokenJWT = tokensevice.GerarToken((Usuario) autentica.getPrincipal());
        return ResponseEntity.ok(new DadosToken(tokenJWT));
    }

}
