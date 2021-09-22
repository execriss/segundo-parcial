package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Libro extends Base{
	@Column(name="titulo")
	private String titulo;
	@Column(name="fecha")
	private int fecha;
	@Column(name="genero")
	private String genero;
	@Column(name="paginas")
	private int paginas;
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	final private List<Autor> autores = new ArrayList<Autor>();
}
