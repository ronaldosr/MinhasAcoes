package br.com.minhasacoes.modulos.dataprovider.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minhasacoes.modulos.dataprovider.entity.AtivoData;

@Repository
public interface AtivoRepository extends JpaRepository<AtivoData, Integer> {

	public Optional<AtivoData> findById(String id);
}
