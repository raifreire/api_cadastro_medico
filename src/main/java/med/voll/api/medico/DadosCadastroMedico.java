package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;


// classes record sao classes que são transformadas pelo java em imutaveis onde so precisamos criar o record com seus parametros
// e o resto fica por conta do java criar os construtores, getters e setters.
public record DadosCadastroMedico(
       @NotBlank
       String nome,
       @NotBlank
       @Email
        String email,
       @NotBlank
       String telefone,
       @NotBlank
       @Pattern(regexp = "\\d{4,6}") //para atender ao padrão do crm criamos um pattern com uma expressão regular
       String crm,
       @NotNull
       Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco) {
}
// OBS: @NotBlank -> não pode ser null nem vazio - String @NotNull campo obrigatorio a ser preenchido.
