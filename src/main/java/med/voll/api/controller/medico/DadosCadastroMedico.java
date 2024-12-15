package med.voll.api.controller.medico;

import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.controller.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //Expressao regular onde o d se refere a digito e entre chaves de quanto a quanto caracter ele pode receber no caso de 4 a 6 char
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid //Validar também no outro Record os dados com o BeamValidation
        DadosEndereco endereco
) {
}
