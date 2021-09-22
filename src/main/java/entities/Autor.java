package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="autor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Builder
public class Autor extends Base {
	@Column(name="nombre")
	@NotNull String nombre;
	@Column(name="apellido")
	@NotNull String apellido;
	@Column(name="biografia", length = 1500)
	@NotNull String biografia;
}
