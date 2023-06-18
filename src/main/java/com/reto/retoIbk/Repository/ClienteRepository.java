package com.reto.retoIbk.Repository;

import com.reto.retoIbk.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
