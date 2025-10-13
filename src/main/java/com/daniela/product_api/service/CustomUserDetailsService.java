package com.daniela.product_api.service;

import com.daniela.product_api.model.User;
import com.daniela.product_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;// Interfaz de Spring Security
import org.springframework.security.core.userdetails.UsernameNotFoundException;// Excepción lanzada cuando no se encuentra un usuario
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service// Indica que esta clase es un servicio de Spring
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired// Inyección de dependencia del repositorio de usuarios
    private UserRepository userRepository;// Repositorio para acceder a los datos de los usuarios

    @Override// Implementación del método de la interfaz UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));// Busca el usuario por nombre de usuario o lanza una excepción si no se encuentra

        return org.springframework.security.core.userdetails.User.builder()// Construye un objeto UserDetails a partir del usuario encontrado
                .username(user.getUsername())// Establece el nombre de usuario
                .password(user.getPassword())// Establece la contraseña
                .authorities(
                        user.getRoles().stream()
                                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                                .collect(Collectors.toList())
                )
                .build();// Construye y devuelve el objeto UserDetails
    }
}
