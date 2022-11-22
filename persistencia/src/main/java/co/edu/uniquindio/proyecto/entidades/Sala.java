package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sala implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer numColumnas;

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer numFilas;

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer numAsientos;

    @ManyToOne
    private Teatro teatro;

    @OneToMany(mappedBy = "sala")
    private List<PeliculaSala> peliculaSalas;

    public Sala(Integer codigo, Integer numColumnas, Integer numFilas, Integer numAsientos, Teatro teatro) {
        this.codigo = codigo;
        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
        this.numAsientos = numAsientos;
        this.teatro = teatro;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "codigo=" + codigo +
                ", numColumnas=" + numColumnas +
                ", numFilas=" + numFilas +
                ", numAsientos=" + numAsientos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return Objects.equals(numColumnas, sala.numColumnas) && Objects.equals(numFilas, sala.numFilas) && Objects.equals(numAsientos, sala.numAsientos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, numColumnas, numFilas, numAsientos);
    }
}
