package med.voll.api.dtos;

import med.voll.api.entities.Medico;

public record DadosListagemMedicos(
    Long id,
    String nome,
    String email,
    String crm,
    Especialidade especialidade
) {
    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}