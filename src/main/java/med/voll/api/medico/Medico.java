package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico { // dentro da classe Medico teremos os mesmo atributos do Record sendo que
    //o record é um DTO <Data Transfer Object> e a classe Medico é um JPA <Java Persistence API>

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //Não criaremos outra tabela no banco com relacionamento vamos usar o esquema Embeddable Attribute do JPA
    private Endereco endereco; //Embeddable Attribute > vai colocar o Endereco numa classe separada, mas no banco de
    // dados ele considera que os campos dessa classe fazem parte da mesma tabela no caso de medicos e la na
    // classe Endereco precisamos anotar o @Embeddable

    private Boolean ativo;


    public Medico(DadosCadastroMedico dados) {
      this.ativo = true;
      this.nome = dados.nome();
      this.email = dados.email();
      this.telefone = dados.telefone();
      this.crm = dados.crm();
      this.especialidade = dados.especialidade();
      //no endereco precisamos criar tambem um constructor alt+enter e cria.
      this.endereco = new Endereco(dados.endereco());
    }


    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}


// Codigos JPA que iremos adicionar na classe java acima
//@Table(name="medicos")
// @Entity(name="Medico")

//@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

//@Enumerated(EnumType.STRING)

//@Embedded

//Codigos Lombok
//@Getter // gerar getterrs e setters
//@NoArgsConstructor //criar construtor sem argumentos > exigencia da jpa em todas as entidades
//@AllArgsConstructor //para ter construtor que recebe todos os campos
//@ EqualsAndHashCode(of = "id") // para gerar equals e hashcode, atributo of="id" para gerar pelo id e não em cima de
// todos atributos