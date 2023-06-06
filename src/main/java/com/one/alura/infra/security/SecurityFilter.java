package com.one.alura.infra.security;

import com.one.alura.usuarios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Obtener lo tokens del header
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null){
            var token = authHeader.replace("Bearer ","");
            var nombreUsuario = tokenService.getSubject(token);// extract username
            if (nombreUsuario != null){
                //token valido
                var usuario = usuarioRepository.findByEmail(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());// forzamos un inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication); //setea la autenticacion
            }
        }
        filterChain.doFilter(request, response);
    }
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        var authHeader = request.getHeader("Authoritation");
//        if( authHeader != null){
//            var token = authHeader.replace("Bearer", "");
//            var nombreUsuario = tokenService.getSubject(token);// Extract username
//            if(nombreUsuario != null){
//                // token valido
//                var usuario = usuarioRepository.findByEmail(nombreUsuario);
//                var authentication = new UsernamePasswordAuthenticationToken(usuario,null,
//                        usuario.getAuthorities()); // forzamos un inicio de sesion
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        filterChain.doFilter(request,response);
//    }
}
