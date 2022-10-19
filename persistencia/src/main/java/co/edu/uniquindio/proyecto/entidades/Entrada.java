package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Entrada implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=1, max=2,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private int fila;

    @Column(nullable = false)
    @Length(min=1, max=2,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private int columna;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private Reserva reserva;
}
