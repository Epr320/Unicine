package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Pelicula implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=3, max=25,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=250,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String descripcion;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=150,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String sinopsis;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=150,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String estado;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=15,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String genero;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=80,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String trailer;


    @Column(nullable = false)
    private String ruta;


    @OneToMany(mappedBy = "pelicula")
    private List<PeliculaSala> peliculaSalas;

    @ManyToMany
    private List<Actor> actores;


    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", estado='" + estado + '\'' +
                ", genero='" + genero + '\'' +
                ", trailer='" + trailer + '\'' +
                ", ruta='" + ruta + '\'' +
                '}';
    }

    public Pelicula(Integer codigo, String nombre, String descripcion, String sinopsis, String estado, String genero, String trailer, String ruta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sinopsis = sinopsis;
        this.estado = estado;
        this.genero = genero;
        this.trailer = trailer;
        this.ruta = ruta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return codigo.equals(pelicula.codigo) && nombre.equals(pelicula.nombre) && descripcion.equals(pelicula.descripcion) && sinopsis.equals(pelicula.sinopsis) && estado.equals(pelicula.estado) && genero.equals(pelicula.genero) && trailer.equals(pelicula.trailer) && Objects.equals(ruta, pelicula.ruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, descripcion, sinopsis, estado, genero, trailer, ruta);
    }
}
