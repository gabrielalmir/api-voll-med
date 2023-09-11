package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.DadosAtualizaMedico;
import med.voll.api.dtos.DadosListagemMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import med.voll.api.dtos.DadosCadastroMedico;
import med.voll.api.entities.Medico;
import med.voll.api.repositories.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);
    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
}
