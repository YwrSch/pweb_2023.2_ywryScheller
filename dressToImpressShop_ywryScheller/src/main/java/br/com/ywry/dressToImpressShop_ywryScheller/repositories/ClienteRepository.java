package br.com.ywry.dressToImpressShop_ywryScheller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ywry.dressToImpressShop_ywryScheller.model.Cliente;;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}