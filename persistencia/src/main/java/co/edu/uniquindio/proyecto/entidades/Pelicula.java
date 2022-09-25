package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Pelicula implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Length(min=1, max=10,message ="La cedula debe tener 10 caracteres.")
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=3, max=15,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;

    @Column(nullable = false,unique = true,length = 150)
    @Length(min=10,max = 150,message = "El email debe tener entre 10 y 150 caracteres.")
    @NotBlank
    @Email
    private String descripcion;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=150,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String sinopsis;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=15,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String genero;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=15,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String trailer;

    @ElementCollection
    @Column(nullable = false)
    private List<String> ruta;


    @OneToMany(mappedBy = "pelicula")
    private List<PeliculaSala> peliculaSalas;

    @ManyToMany
    private List<Actor> actores;

}
