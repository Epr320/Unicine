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
public class Confiteria implements Serializable {

    @Column(nullable = false)
    private String ruta;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=3, max=100,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;

    @Column(nullable = false)
    private double precio;


    @OneToMany(mappedBy = "confiteria")
    private List<Reserva_Confiteria> confiterias;

}
