package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Actor implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @NotBlank
    @Length(min=1, max=10,message ="La cedula debe tener 10 caracteres.")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=3, max=20,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;

    @ManyToMany( mappedBy= "actores" )
    private List<Pelicula> peliculas;

}
