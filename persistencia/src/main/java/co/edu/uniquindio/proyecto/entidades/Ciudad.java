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
public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=3, max=100,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<AdministradorCiudad> adminsC;

    @OneToMany(mappedBy = "ciudad")
    private List<Teatro> teatros;

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
    public Ciudad(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
}
