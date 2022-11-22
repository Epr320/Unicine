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
public class Horario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=1, max=15,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String horainicio;

    @Column(nullable = false)
    @Length(min=1, max=15,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String horaFin;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    private PeliculaSala peliculaSala = new PeliculaSala();

    @OneToMany(mappedBy = "horario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "horario")
    private List<Entrada> entradas;

}
