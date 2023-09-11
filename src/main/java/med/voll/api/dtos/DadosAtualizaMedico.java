package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.Endereco;

public record DadosAtualizaMedico(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco
) {
}
