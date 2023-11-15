package com.utn.elbuensabor.entities.usuarios;

import com.utn.elbuensabor.entities.Base;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.facturacion.NotaCredito;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Builder
public class Persona extends Base implements UserDetails {

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name="rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "id_persona", nullable = false)
    @OneToMany (cascade = CascadeType.ALL)
    private List<Domicilio> domicilios = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Pedido> pedidos = new ArrayList<>();


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @Builder.Default
    private List<NotaCredito> notasCredito = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.name())));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
