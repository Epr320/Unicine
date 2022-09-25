package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Reserva implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=3, max=10,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private double precio;

    @Column(nullable = false)
    @Length(min=3, max=100,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private Date fecha;

    @Column(nullable = false)
    @Length(min=1, max=100,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private Boolean diaEspecial;

    @OneToMany(mappedBy = "reserva")
    private List<Reserva_Confiteria> confiterias;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Horario horario;

    @ManyToMany
    private List<Estacionamiento> estacionamientos;
}
