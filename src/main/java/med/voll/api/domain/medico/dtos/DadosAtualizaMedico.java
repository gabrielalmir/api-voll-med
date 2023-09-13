package med.voll.api.domain.medico.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.dtos.DadosEndereco;

public record DadosAtualizaMedico(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco
) {
}
