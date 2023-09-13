package med.voll.api.domain.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.dtos.DadosAtualizaMedico;
import med.voll.api.domain.medico.dtos.DadosCadastroMedico;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.enums.Especialidade;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    public Medico(DadosCadastroMedico medico) {
        this.nome = medico.nome();
        this.email = medico.email();
        this.telefone = medico.telefone();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());
        this.ativo = true;
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizaMedico medico) {
        if (medico.nome() != null) {
            this.nome = medico.nome();
        }
        if (medico.telefone() != null) {
            this.telefone = medico.telefone();
        }
        if (medico.endereco() != null) {
            this.endereco.atualizaInformacoes(medico.endereco());
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;
    private String email;
    private String telefone;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
}
