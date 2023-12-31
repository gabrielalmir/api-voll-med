package med.voll.api.domain.medico.dtos;

import med.voll.api.domain.medico.enums.Especialidade;
import med.voll.api.domain.medico.Medico;

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
