package br.com.minhasacoes.modulos.dataprovider.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minhasacoes.modulos.dataprovider.entity.AtivoData;

@Repository
public interface AtivoRepository extends JpaRepository<AtivoData, Long> {

	public Optional<AtivoData> findById(Long id);
	
	@SuppressWarnings("unchecked")
	public AtivoData save(AtivoData ativoData);
	
	public AtivoData findByCodigo(String codigo);
	
}
