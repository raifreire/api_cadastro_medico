package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository; //injeção de dependecia.

    @Transactional
    @PostMapping/*Ao chegar uma requisição do tipo POST para a url '/medicos' chame o metodo cadastrar da classe MedicosController*/
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ /*recebendo os dados json do corpo da requisição do insomnia
        DadosCadastroMedico é um record que utilizamos para receber os dados da requisição e poder manipula-los
        Dessa forma estamos utilizando um padrão chamado DTO - Data Transfer Object
        Padrão muito utilizado em Apis para representar os dados que chegam para a api e também os dados retornados.
        utilizaremos esse padrão em todos os pontos de entrada de saída dos dados da api, criaremos sempre um DTO
        Que nada mais é que uma classe ou um record contendo apenas os campos que utilizamos.*/

        /*estamos aqui apenas pegando dados do nosso DTO e imprimindo no terminal
         vamos armazenar esses dados no nosso banco mysql vollmed_api atraves do jpa.*/

        repository.save(new Medico(dados)); /*utilizamos o alt + enter para a ide ajudar a criar o constructor na
         entidade correta*/
    }
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        //return repository.findAll(paginacao).map(DadosListagemMedico::new);
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    };
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        /*repository.deleteById(id);*/
        var medico = repository.getReferenceById(id);
        medico.excluir();

    }
}
