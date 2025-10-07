package br.edu.fateccotia.shorten.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateccotia.shorten.entity.Code;

@Repository
public interface ShortenRepository extends CrudRepository<Code,Integer>{

	boolean existsByCode(String code);
	
	Optional<Code> findByCode(String code);
}
