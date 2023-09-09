package med.voll.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}