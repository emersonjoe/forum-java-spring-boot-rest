package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	//para tornar explícito que existe uma entidade chamada Curso dentro de Tópico e que queremos bustar a propriedade nome dentro de curso
	List<Topico> findByCurso_Nome(String nomeCurso);

	//para consultas aonde o padrão de nomenclatura esteja diferente do spring
	@Query("SELECT t FROM Topico t WHERE  t.curso.nome = :nomeCurso")
	List<Topico> carregarPorNomeCurso(@Param("nomeCurso") String nomeCurso);
	
	
}
