package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Estacionamiento implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Length(min=1, max=10,message ="La cedula debe tener 10 caracteres.")
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=1, max=15,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private double precio;

    @ManyToMany( mappedBy= "estacionamientos" )
    private List<Reserva> reservas;
}
