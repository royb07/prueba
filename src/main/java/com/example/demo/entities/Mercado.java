package com.example.demo.entities;



import com.example.demo.entities.enums.Pais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "mercado")
@AllArgsConstructor
@NoArgsConstructor
public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String codigo;

    @Column
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Pais pais;

    @ManyToMany
    @JoinTable(name = "comitente_mercado",
            joinColumns = @JoinColumn(name = "mercado_id"),
            inverseJoinColumns = @JoinColumn(name = "comitente_id")
    )
    private Set<Comitente> comitentes = new HashSet<>();

}
