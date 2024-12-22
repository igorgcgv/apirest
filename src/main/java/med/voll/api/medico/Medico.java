package med.voll.api.medico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import med.voll.api.endereco.Endereco;


@Table(name="medicos")
@Entity(name="Medico")
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;


    //Construtor
    public Medico() {
    }


    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }

    // Getters manuais
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }


//Validação se os dados estão vindo nulo pra atualizar @Valid
    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {

        
    }

    public void excluir() {
        this.ativo=false;
    }
}

