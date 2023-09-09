package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dtos.DadosMedico;
import med.voll.api.entities.Medico;
import med.voll.api.repositories.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosMedico dados) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);
    }
}
