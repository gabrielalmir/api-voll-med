package med.voll.api.domain.paciente.dtos;

import med.voll.api.domain.endereco.dtos.DadosEndereco;

public record DadosPaciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}
