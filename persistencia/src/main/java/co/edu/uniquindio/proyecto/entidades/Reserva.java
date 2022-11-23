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

    @Column(nullable = true)
    private double precio;

    @Column(nullable = true)
    private Date fecha;

    @Column(nullable = true)
    private Boolean diaEspecial;

    @OneToMany(mappedBy = "reserva")
    private List<Reserva_Confiteria> confiterias;

    @OneToMany(mappedBy = "reserva")
    private List<Entrada> entradas;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private Cupon cupon;

    @ManyToMany
    private List<Estacionamiento> estacionamientos;
}
