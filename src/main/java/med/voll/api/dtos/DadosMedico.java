package med.voll.api.dtos;

public record DadosMedico(String nome,
                String email,
                String crm,
                Especialidade especialidade,
                DadosEndereco endereco) {
}
