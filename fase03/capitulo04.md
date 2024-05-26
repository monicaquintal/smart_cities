<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 3 - FRAMEWORKS JAVA</h1>
<h2>Capítulo 04: O Spring Data JPA.</h2>
</div>

<div align=”center”>
<h2>1. O SPRING DATA JPA</h2>
</div>

## 1.1 Definição

- `DTO`(Data Transfer Object) é um padrão de design de aplicações que é utilizado para representar os dados que serão trocados entre diferentes aplicações. 
- esse padrão permite que possamos enviar ou receber os dados do servidor Backend sem a necessidade de que o JSON possua exatamente os mesmos atributos da classe de domínio. 
- exemplo: talvez não seja interessante a API enviar ao cliente um JSON de usuário com o atributo senha. 
- com o padrão DTO podemos personalizar as respostas de modo a controlar o que queremos exibir aos clientes da API.

## 1.2 Implementação do padrão DTO nas consultas

- para implementar o padrão DTO, utilizar o `record`, disponível no Java desde a versão 16.
- o record é um tipo de classe utilizado para representação de dados,assim, não é necessário construir os métodos de acesso (getters e setters) e construtores. 
- implementar um DTO responsável por representar os dados do usuário que serão enviados aos clientes HTTP. 
- passos:
  - 1. No pacote dto do projeto Calorias, crie uma classe com nome UsuarioExibicaoDTO e selecione a opção “Record”.
  - 2. Insira o código fonte do record:

~~~java
package br.com.fiap.calorias.dto;

import br.com.fiap.calorias.model.Usuario;

public record UsuarioExibicaoDTO(
            Long usuarioId,
            String nome,
            String email) { 
    
    public UsuarioExibicaoDTO(Usuario usuario) { 
        this(
            usuario.getUsuarioId(), 
            usuario.getNome(), 
            usuario.getEmail()); 
    }
}
~~~

- implementações no record:
  - `Linha 5`: declaramos a classe UsuarioExibicaoDTO com o modificador “record”.
  - `Linhas 5 a 8`: fornecemos os atributos do record, que serão utilizadas para a criação do construtor, dos métodos de acesso (getters e setters) além dos métodos “toString()”, “hashcode()” e “equals()”, tudo de forma automática.
  - `Linhas 10 a 15`: criamos um construtor responsável por criar um objeto do tipo UsuarioExibicaoDTO com os dados de um usuário. A ***palavra reservada this*** está chamando o construtor da classe UsuarioExibicaoDTO e preenchendo os atributos com os dados do usuário que foi fornecido.

- com o DTO concluído, alterar a classe de serviço para que utilize o DTO:

~~~java
package br.com.fiap.calorias.service;

import br.com.fiap.calorias.dto.UsuarioExibicaoDTO;
import br.com.fiap.calorias.model.Usuario;
import br.com.fiap.calorias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public UsuarioExibicaoDTO listarPorId(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDTO(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não existe!");
        }
    }

    public List<UsuarioExibicaoDTO> listarTodos(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDTO::new)
                .toList();
    }

    . . . TRECHO DE CÓDIGO OMITIDO
}
~~~

- ***modificações efetuadas na classe UsuarioService***:
  - `Linha 22`: alteramos o retorno do método “listarPorId” para que retorne um objeto do tipo “UsuarioExibicaoDTO”.
  - `Linha 27`: instanciamos um objeto do tipo “UsuarioExibicaoDTO”, que será enviado ao cliente da API. Fornecemos ao construtor do objeto o usuário que foi obtido do banco de dados.
  - `Linha 33`: alteramos o retorno do método “listarTodos()” para que retorne uma lista de objetos do tipo “UsuarioExibicaoDTO”.
  - `Linhas 34 a 38`: iteramos na lista de usuários retornado pelo repositório através do método “stream”. A cada iteração utilizamos o método “map” para construir um objeto do tipo “UsuarioExibicaoDTO”, gerando, ao final, uma nova lista do tipo “UsuarioExibicaoDTO” através do método “toList()”.

- `Observação:`
  - o método findAll() do repositório retorna uma lista de elementos do tipo “Alimento”, mas queremos uma lista de “AlimentoDTO”, então, é necessário executarmos essa conversão. 
  - o método “stream()” retornaum objeto do tipo “Stream”, que é uma sequência (ou fluxo) de elementos da lista original. Neste objeto “Stream”, podemos realizar algumas operações em cada elemento que o compõe e obter uma segunda lista personalizada. 
  - no exemplo, utilizamos o “map”, que transforma cada elemento do fluxo em um elemento de outro tipo, assim, estamos transformando cada objeto “Alimento” do fluxo em um objeto “AlimentoDTO” e gerando uma nova lista!

- ***também serão necessárias alterações na classe UsuarioController***:

~~~java
package br.com.fiap.calorias.controller;

import br.com.fiap.calorias.dto.UsuarioExibicaoDTO;
import br.com.fiap.calorias.model.Usuario;
import br.com.fiap.calorias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDTO> litarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioExibicaoDTO> buscarPorId(@PathVariable Long usuarioId){
        try {
            return ResponseEntity.ok(usuarioService.listarPorId(usuarioId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    . . . TRECHO DE CÓDIGO OMITIDO
}
~~~

- para testar se as alterações foram aplicadas com sucesso, executar novamente a aplicação e efetuar os testes de requisição nos endpoints de listagem de todos os usuários e de busca de usuário por identificador utilizando a aplicação “Insomnia”. 
- ao observar a resposta das requisições, notamos que os registros não mostram mais a senha dos usuários, confirmando que a resposta está utilizando a classe DTO!

## 1.3 Implementando o padrão DTO no cadastro

- para que a aplicação seja consistente em relação a utilização do padrão DTO, implementar também essa arquitetura no cadastro do usuário. 
- no cadastro, desejamos enviar os dados do usuário para a API, e neste caso precisamos de todos os atributos, inclusive a senha.
- criar a `classe record UsuarioCadastroDTO` no pacote dto do projeto Calorias.

~~~java
package br.com.fiap.calorias.dto;

public record UsuarioCadastroDTO(
        Long usuarioId,
        String nome,
        String email,
        String senha
) {
}
~~~

- após a criação da classe record UsuarioCadastroDTO, implementar as alterações necessárias no método salvarUsuario() da `classe UsuarioService`. 

~~~java
package br.com.fiap.calorias.service;

import br.com.fiap.calorias.dto.UsuarioCadastroDTO;
import br.com.fiap.calorias.dto.UsuarioExibicaoDTO;
import br.com.fiap.calorias.model.Usuario;
import br.com.fiap.calorias.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuarioDTO){

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDTO(usuarioSalvo);

    }

    . . . TRECHO DE CÓDIGO OMITIDO

}
~~~

- alterações implementadas no método salvarUsuario() da classe UsuarioService:
  - `Linha 20`: alteramos o retorno do método para UsuarioExibicaoDTO e o tipo do argumento do método para UsuarioCadastroDTO.
  - `Linha 22`: instanciamos um objeto do tipo Usuario.
  - `Linha 23`: utilizamos o método copyProperties da classe BeanUtilsdo Spring Framework, para copiar os atributos do objeto UsuarioDTO para o objeto Usuario. Isso foi necessário já que o repositório utiliza o objeto Usuario para a persistência de dados.
  - `Linha 25`: criamos uma variável do tipo Usuario que receberá o objeto criado no banco de dados.
  - `Linha 26`: retornamos o objeto criado no banco através de uma instância da classe record UsuarioExibicaoDTO.

- ajustar a `classe UsuarioController` para utilizar a nova arquitetura:

~~~java
package br.com.fiap.calorias.controller;

import br.com.fiap.calorias.dto.UsuarioCadastroDTO;
import br.com.fiap.calorias.dto.UsuarioExibicaoDTO;
import br.com.fiap.calorias.model.Usuario;
import br.com.fiap.calorias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO salvar(@RequestBody UsuarioCadastroDTO usuario){
        return usuarioService.salvarUsuario(usuario);  
    }

    . . . TRECHO DE CÓDIGO OMITIDO
}
~~~

- após ajustes, reinicie a aplicação para que as alterações sejam aplicadas.
- utilize a requisição Cadastrar usuário no Insomnia para cadastrar um usuário e verificar se tudo está funcionando corretamente.

>[Link do projeto desenvolvido até aqui.](https://github.com/FIAP/ON_TDS_JAVA_ADVANCED_SPRING_BOOT/tree/usuario-dto)

## 1.5 Configurando o Developer Tools (DevTools)

- a cada alteração que fazemos no código-fonte da aplicação é necessário a reinicialização do serviço para que as alterações sejam efetivadas e publicadas. 
- isso é uma atividade repetitiva que pode ser automatizada através de uma ferramenta chamada Developer Tools (Devtools). 
- o Devtools reinicia a aplicação sempre que alguma alteração no projeto for gravada.

## 1.6 Dependência do Devtools

- o suporte ao Devtools já foi adicionado ao projeto através da dependência adicionada no arquivo pom.xml, quando configuramos o projeto com o Spring Initializr.

## 1.7 Ativando o Devtools no IntelliJ

- o Devtools é configurado automaticamente no Eclipse, mas se estivermos utilizando o IntelliJ são necessárias algumas configurações adicionais. 
- passos para configurar o Devtools no IntelliJ:
  - 1. Clique no botão “Main Menu”, no canto superior esquerdo da tela para que a barra de menus do IntelliJ seja exibida.
  - 2. Clique no menu File e em seguida clique em Settings.
  - 3. Na janela Settings, expanda a opção “Build, Execution, Deployment”, clique na opção “Compiler”, marque a opção “Build project automatically”e clique no botão “Apply”.
  - 4. Clique na opção “Advanced Settings” e marque a opção “Allow auto-make to start even if developed applications is currently running”e clique no botão “OK”.

- para testar se a inicialização automática foi ativada, inicialize a aplicação e adicione uma instrução de “System.out.print(“Testando o Devtools”)”, em qualquer classe do projeto; observe se o IntelliJ reiniciará a aplicação automaticamente.

> Atenção! O IntelliJ salva as alterações automaticamente, então, você deve parar a aplicação quando for efetuar alguma alteração na estrutura do banco de dados utilizando o “Flyway”, pois ao digitar as instruções SQL o Devtools poderá reiniciar a aplicação e executar o script incompleto, causando problemas no banco de dados. 

<div align="center">
<h2>2. CLASSE DE DOMÍNIO ALIMENTO</h2>
</div>

## 2.1 Implementando a classe Alimento

- a classe “Alimento” será responsável por especificar os objetos que representam os alimentos em nossa aplicação.
- para a criação da `classe Alimento`, crie uma classe com o nome “Alimento” no pacote “model” do projeto. 

~~~java
package br.com.fiap.calorias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_alimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Alimento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ALIMENTOS"
    )
    @SequenceGenerator(
            name = "SEQ_ALIMENTOS",
            sequenceName = "SEQ_ALIMENTOS",
            allocationSize = 1
    )
    private Long alimentoId;

    private String nome;
    private String porcao;

    @Column(name = "qtde_proteina")
    private Double quantidadeProteina;

    @Column(name = "qtde_carboidrato")
    private Double quantidadeCarboidrato;

    @Column(name = "qtde_gorduras")
    private Double quantidadeGorduras;

    @Column(name = "total_calorias")
    private Double totalCalorias;
}
~~~

## 2.2 Criando a tabela TBL_ALIMENTOS com o Flyway

- implementar o script SQL responsável por criar a tabela TBL_ALIMENTOS e a sequência SEQ_ALIMENTOS no banco de dados Oracle. 
- crie um arquivo na pasta “db.migration” com o nome `V2__create-table-tbl_alimentos-seq-alimentos.sql`.

~~~sql
CREATE SEQUENCE SEQ_ALIMENTOS
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE TABLE TBL_ALIMENTOS (
    ALIMENTO_ID INTEGER DEFAULT SEQ_ALIMENTOS.NEXTVAL NOT NULL,
    NOME VARCHAR2(100) NOT NULL,
    PORCAO VARCHAR2(30) NOT NULL,
    QTDE_PROTEINA NUMBER(9,3) NOT NULL,
    QTDE_CARBOIDRATO NUMBER(9,3) NOT NULL,
    QTDE_GORDURAS NUMBER(9,3) NOT NULL,
    TOTAL_CALORIAS NUMBER(9,3) NOT NULL
);
~~~

## 2.3 Criando a interface AlimentoRepository

- criar a interface responsável por implementar a persistência de dados.
- crie uma interface no pacote repository com o nome AlimentoRepository. 
- implementar a herança da interface JpaRepository&lt;&gt;:

~~~java
package br.com.fiap.calorias.repository;

import br.com.fiap.calorias.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    

}
~~~

## 2.4 Implementação da classe de registro AlimentoExibicaoDTO

- implementar a classe responsável por representar o objeto Alimento através de uma classe do tipo record. 
- crie no pacote dto do projeto uma `classe record AlimentoExibicaoDTO`.

~~~java
package br.com.fiap.calorias.dto;

import br.com.fiap.calorias.model.Alimento;

public record AlimentoExibicaoDTO(
        Long alimentoId,
        String nome,
        String porcao,
        Double quantidadeProteina,
        Double quantidadeCarboidrato,
        Double quantidadeGorduras,
        Double totalCalorias
) {

    public AlimentoExibicaoDTO(Alimento alimento) {
        this(
                alimento.getAlimentoId(),
                alimento.getNome(),
                alimento.getPorcao(),
                alimento.getQuantidadeProteina(), 
                alimento.getQuantidadeCarboidrato(),
                alimento.getQuantidadeGorduras(), 
                alimento.getTotalCalorias()
        );
    }
}
~~~

- diferente da classe de registro UsuarioExibicaoDTO, queremos que todos os atributos da classe Alimento sejam retornados à aplicação cliente, então, todos os atributos estarão presentes no DTO.

## 2.5 Implementação da classe de registro AlimentoCadastroDTO

- a classe de registro AlimentoCadastroDTO será exatamente igual a classe de registro AlimentoExibicaoDTO, então faça uma cópia do arquivo AlimentoExibicaoDTO e cole no pacote dto alterando o nome para AlimentoCadastroDTO.
- o motivo de estarmos criando uma cópia ao invés de utilizar o mesmo DTO tanto para exibição quanto para cadastro é o fato de manter a flexibilidade da aplicação. Se houver a necessidade de alterar a exibição não haverá impacto na classe de DTO utilizada para representar os dados de cadastro.

~~~java
package br.com.fiap.calorias.dto;

public record AlimentoCadastroDTO(
  Long alimentoId,
  String nome,
  String porcao,
  Double quantidadeProteina,
  Double quantidadeCarboidrato,
  Double quantidadeGorduras
) {
}
~~~

## 2.6 Implementação da classe AlimentoService

- criar a classe de serviço, que proverá acesso a persistência de dados disponibilizada pelo repositório. 
- crie uma classe no pacote service com o nome `AlimentoService`, responsável por implementar os métodos de persistência de dados na tabela TBL_ALIMENTOS no banco de dados.

~~~java
package br.com.fiap.calorias.service;

import br.com.fiap.calorias.dto.AlimentoCadastroDTO;
import br.com.fiap.calorias.dto.AlimentoExibicaoDTO;
import br.com.fiap.calorias.model.Alimento;
import br.com.fiap.calorias.repository.AlimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public AlimentoExibicaoDTO salvarAlimento(AlimentoCadastroDTO alimentoDTO){

        Alimento alimento = new Alimento();
        BeanUtils.copyProperties(alimentoDTO, alimento);

        alimento.setTotalCalorias(
                calcularCalorias(
                    alimento.getQuantidadeProteina(),
                    alimento.getQuantidadeCarboidrato(),
                    alimento.getQuantidadeGorduras()
                )
        );

        Alimento alimentoSalvo = alimentoRepository.save(alimento);
        return new AlimentoExibicaoDTO(alimentoSalvo);

    }

    public AlimentoExibicaoDTO buscarPorId(Long id){
        Optional<Alimento> alimentoOptional =
                alimentoRepository.findById(id);

        if (alimentoOptional.isPresent()){
            return new AlimentoExibicaoDTO(alimentoOptional.get());
        } else {
            throw new RuntimeException("Alimento não existe!");
        }
    }

    public List<AlimentoExibicaoDTO> listarTodos(){
        return alimentoRepository
                .findAll()
                .stream()
                .map(AlimentoExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long id){
        Optional<Alimento> alimentoOptional =
                alimentoRepository.findById(id);

        if (alimentoOptional.isPresent()){
            alimentoRepository.delete(alimentoOptional.get());
        } else {
            throw new RuntimeException("Alimento não encontrado!");
        }
    }

    public AlimentoExibicaoDTO atualizar(AlimentoCadastroDTO alimentoDTO){
        Optional<Alimento> alimentoOptional =
                alimentoRepository.findById(alimentoDTO.alimentoId());

        if (alimentoOptional.isPresent()){
            Alimento alimento = new Alimento();
            BeanUtils.copyProperties(alimentoDTO, alimento);

            alimento.setTotalCalorias(
                    calcularCalorias(
                            alimento.getQuantidadeProteina(),
                            alimento.getQuantidadeCarboidrato(),
                            alimento.getQuantidadeGorduras()
                    )
            );
            
            return new AlimentoExibicaoDTO(alimentoRepository.save(alimento));
        } else {
            throw new RuntimeException("Alimento não encontrado!");
        }
    }

    public Double calcularCalorias(Double proteinas, Double carboidratos, Double gorduras){
        Double calorias = (proteinas * 4) + (carboidratos * 4) + (gorduras * 9);
        return calorias;
    }
}
~~~

- implementações:
  - `Linhas 25 a 31 e Linhas 76 a 82`: método calcularCalorias() para efetuar o cálculo de calorias do alimento e atribuir ao atributo totalCalorias do alimento.
  - `Linhas 90 a 94`: método calcularCalorias() recebe como argumentos os valores referentes às quantidades de carboidratos, proteínas e gorduras totais do alimento, retornando o valor de calorias do alimento.

## 2.7 Implementação do controlador AlimentoController

- criação da classe que será responsável por receber as requisições HTTP dos clientes da API. 
- crie no pacote controller uma classe com o nome `AlimentoController`.
- criar os endpoints responsáveis por cada uma das operações CRUD do objeto Alimento.

~~~java
package br.com.fiap.calorias.controller;

import br.com.fiap.calorias.dto.AlimentoCadastroDTO;
import br.com.fiap.calorias.dto.AlimentoExibicaoDTO;
import br.com.fiap.calorias.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @PostMapping("/alimentos")
    @ResponseStatus(HttpStatus.CREATED)
    public AlimentoExibicaoDTO salvar(
            @RequestBody AlimentoCadastroDTO alimento){
        return alimentoService.salvarAlimento(alimento);
    }

    @GetMapping("/alimentos")
    @ResponseStatus(HttpStatus.OK)
    public List<AlimentoExibicaoDTO> litarTodos(){
        return alimentoService.listarTodos();
    }

    @GetMapping("/alimentos/{alimentoId}")
    public ResponseEntity<AlimentoExibicaoDTO> buscarPorId(
            @PathVariable Long alimentoId){
        try {
            return ResponseEntity
                    .ok(alimentoService.buscarPorId(alimentoId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/alimentos/{alimentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long alimentoId){
        alimentoService.excluir(alimentoId);
    }

    @PutMapping("/alimentos")
    public ResponseEntity<AlimentoExibicaoDTO> atualizar(
            @RequestBody AlimentoCadastroDTO alimentoDTO){
        try {
            AlimentoExibicaoDTO alimentoExibicaoDTO =
                    alimentoService.atualizar(alimentoDTO);
            return ResponseEntity.ok(alimentoExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
~~~

## 2.8 Efetuando requisições HTTP para o controlador de Alimentos

- para organizar as requisições HTTP no Insomnia, criar uma pasta para cada controlador. 
- passos:
  - 1. Clique no botão com o símbolo de adição e em seguida clique em New Folder.
  - 2. Na caixa de diálogo New Folder, digite o nome da pasta e em seguida clique no botão Create.
  - 3. Arraste as requisições HTTP para o controlador de usuários de modo que as requisições sejam movidas para a pasta Usuários que acabamos de criar.
  - 4. Repita os passos de 1 a 2 para criar a pasta Alimentos.

### 2.8.1 Cadastrando um alimento
- requisição "Cadastrar alimento".
- método `POST`, URL `http://localhost:8080/api/alimentos`.

~~~json
{
    "nome":"ABACATE",
    "porcao":"100g",
    "quantidadeProteina":"1.8",
    "quantidadeCarboidrato":"6.4",
    "quantidadeGorduras":"16"
}
~~~

- outros alimentos:

~~~json
[
  {
    "nome": "AÇAÍ",
    "porcao": "100g",
    "quantidadeProteina": "3.80",
    "quantidadeCarboidrato": "36.60",
    "quantidadeGorduras": "12.20"
  },
  {
    "nome": "BANANA",
    "porcao": "100g",
    "quantidadeProteina": "2.20",
    "quantidadeCarboidrato": "26.60",
    "quantidadeGorduras": "0.20"
  },
  {
    "nome": "BACON",
    "porcao": "100g",
    "quantidadeProteina": "9.50",
    "quantidadeCarboidrato": "0.00",
    "quantidadeGorduras": "59.40"
  },
  {
    "nome": "BOLO",
    "porcao": "100g",
    "quantidadeProteina": "5.10",
    "quantidadeCarboidrato": "54.30",
    "quantidadeGorduras": "6.70"
  },
  {
    "nome": "CARNE DE BOI",
    "porcao": "100g",
    "quantidadeProteina": "18.70",
    "quantidadeCarboidrato": "0.00",
    "quantidadeGorduras": "19.50"
  },
  {
    "nome": "COUVE-FLOR",
    "porcao": "100g",
    "quantidadeProteina": "2.50",
    "quantidadeCarboidrato": "4.30",
    "quantidadeGorduras": "0.22"
  },
  {
    "nome": "FEIJÃO PRETO",
    "porcao": "100g",
    "quantidadeProteina": "20.74",
    "quantidadeCarboidrato": "62.37",
    "quantidadeGorduras": "1.27"
  },
  {
    "nome": "IOGURTE NATURAL",
    "porcao": "100g",
    "quantidadeProteina": "3.50",
    "quantidadeCarboidrato": "15.50",
    "quantidadeGorduras": "0.10"
  },
  {
    "nome": "LARANJA",
    "porcao": "100g",
    "quantidadeProteina": "0.60",
    "quantidadeCarboidrato": "9.80",
    "quantidadeGorduras": "0.40"
  },
  {
    "nome": "ÓLEO DE MILHO",
    "porcao": "100g",
    "quantidadeProteina": "0.00",
    "quantidadeCarboidrato": "0.00",
    "quantidadeGorduras": "100.00"
  },
  {
    "nome": "ÓLEO DE SOJA",
    "porcao": "100g",
    "quantidadeProteina": "0.00",
    "quantidadeCarboidrato": "0.00",
    "quantidadeGorduras": "100.00"
  }
]
~~~

### 2.8.2 Listando todos os alimentos
- efetuar uma requisição para o endpoint responsável por listar todos os alimentos em nossa API.
- método `GET`, URL `http://localhost:8080/api/alimentos`.

### 2.8.3 Buscando um alimento pelo identificador
- utilizar o endpoint buscarPorId().
- método `GET`, URL `http://localhost:8080/api/alimentos/Id`.

### 2.9.4 Exclusão de um alimento
- requisição para o endpoint excluir().
- método `DELETE`, URL `http://localhost:8080/api/alimentos/Id`.

### 2.9.5 Modificando os dados de um alimento
- no cadastro, invertemos os valores de proteína e carboidrato do alimento “BANANA”, então vamos atualizar/modificar os dados desse alimento.
- executar uma requisição para o endpoint atualizar(). 
- método `PUT`, URL `http://localhost:8080/api/alimentos`.
- para efetuarmos uma atualização é necessário enviarmos o objeto com todos os atributos que se deseja alterar, incluindo-se o identificador.

~~~json
{
	"alimentoId": 3,
	"nome": "BANANA",
	"porcao": "100g",
	"quantidadeProteina": 2.2,
	"quantidadeCarboidrato": 26.6,
	"quantidadeGorduras": 0.2,
	"totalCalorias": 117.0
}
~~~

<div align="center">
<h2>3. VALIDAÇÃO DE DADOS COM BEAN VALIDATION</h2>
</div>

- quando uma aplicação cliente envia dados ao Backend, é necessário garantirmos que esses dados atendam um mínimo de requisitos, que garantirão a integridade, a consistência e a segurançados dados enviados.
- algumas das validações que podemos implementar são:
  - `Formato dos dados`: verificar se os dados estão no formato correto, como números, datas, endereços de e-mail etc.
  - `Tamanho do atributo`: verificar se os dados tenham um comprimento máximo e mínimo aceitável.
  - `Obrigatoriedade`: verificar se os atributos obrigatórios estão sendo preenchidos na requisição.
  - `Segurança`: garantir que os dados não contêm scripts perigosos que possam ser usados para ataques de injeção de código.

## 3.1 Bean Validation

- é uma especificação Java que faz parte da plataforma JEE (Jakarta Enterprise Edition).
- define um conjunto de anotações para validação de dados em objetos Java. 
- nos permite criar regras de validação diretamente nos atributos das classes de modelo, que são conhecidos também como `beans`.
- já foi adicionado ao nosso projeto através das dependências informadas no arquivo pom.xml.

## 3.2 Implementando a validação de dados

- também utiliza o recurso de anotações para validar os campos que compõe a requisição para a API. 
- implementar algumas validações para o `objeto Usuario`: as anotações deverão ser implementadas na `classe UsuarioCadastroDTO`, que é a classe utilizada para enviar os atributos dos usuários para a API.

~~~java
package br.com.fiap.calorias.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDTO(
        Long usuarioId,

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O e-mail do usuário é obrigatório!")
        @Email(message = "O e-mail do usuário não é válido!")
        String email,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres!")
        String senha
) {
}
~~~

- caso as regras de validação não sejam satisfeitas, a requisição não será aceita, retornando uma mensagem de erro com o status code "400 – Bad Request", que indica que o erro ocorreu na requisição por parte da aplicação cliente que está enviando dados inválidos.
- a tentativa de gravação do novo registro no banco de dados não será executada, já que avaliamos a condição dos dados antes de enviá-los ao banco de dados.
- anotações implementadas:
  - `Linha 10`: **anotação @NotBlank** determina que o atributo “nome” não pode estar vazio ou nulo. O argumento “message” da anotação define a mensagem de erro que deverá retornar ao cliente da requisição caso as regras de validação não sejam satisfeitas.
  - `Linha 14`: **anotação @Email** determina que o atributo “email” deverá ser um e-mail válido. O argumento “message” da anotação define a mensagem de erro que deverá retornar ao cliente da requisição caso as regras de validação não sejam satisfeitas.
  - `Linha 18`: **anotação “@Size”**, juntamente com os **argumentos “min” e “max”**, determina que a senha informada pelo usuário deverá conter no mínimo 6 caracteres e no máximo 20 caracteres.

### 3.2.1 Testando a validação dos atributos do usuário
- utilizar o Insomnia para cadastrar um novo usuário sem informarmos o valor do atributo nome. 
  - a requisição foi rejeitada, já que a regra de validação para o atributo nome não foi satisfeita. 
  - recebemos status code "400 – Bad Request", indicando que o erro partiu de uma requisição incompleta do cliente. 
  - além disso, a mensagem de erro retornada é a configurada no argumento “message” da anotação “@NotBlank”,

## 3.3 Customizando as mensagens de erro

- a mensagem que recebemos anteriormente como resposta é bastante verbosa. 
- o ideal é que a resposta de erro seja mais significativa e contenha somente as informações necessárias para informar a aplicação cliente sobre o erro ocorrido. 
- é possível customizar as mensagens de erro através da criação de classes personalizadas que estendem as classes de exceção do Java.
- exemplo: ***criar uma exceção personalizada para a consulta de usuário pelo ID***. 
  - lembre-se que esse método retorna o código de status “404 – Not Found” caso façamos a busca por um identificador de usuário que não existe.
  - o método buscarPorId() do UsuarioService lança uma exceção do tipo **Runtime Exception** caso o identificador do usuário não seja encontrado. No controlador, utilizamos o bloco try/catch para interceptar esse erro e devolver a resposta correta ao cliente da API.
- ***criar uma classe personalizada que irá tratar esse erro***. 
- passos:
  - 1. Crie um pacote no pacote br.com.fiap.calorias com o nome `exceptions`.
  - 2. No pacote “exceptions”, crie uma classe com o nome `UsuarioNaoEncontradoException`. 
  - 3. Implementar a classe UsuarioNaoEncontradoException para que estenda a classe Runtime Except.

~~~java
package br.com.fiap.calorias.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}
~~~

- implementações:
  - `Linha 3`: Adicionamos a **palavra-chave extends** na assinatura da classe de modo a indicar que ela deverá herdar a classe “Runtime Exception”.
  - `Linhas 5 a 7`: construtor que executa o construtor da classe mãe, através da **chamada “super”**. Assim, a mensagem de erro utilizada pela classe mãe será substituída pela mensagem fornecida pelo construtor da classe “UsuarioNaoEncontradoException”.

- ***passo 4.*** Na classe “UsuarioController”, alterar o método “buscarPorId()” removendo o bloco try/catch.

~~~java
. . . TRECHO DE CÓDIGO OMITIDO
@GetMapping("/usuarios/{usuarioId}")
public ResponseEntity<UsuarioExibicaoDTO> buscarPorId(@PathVariable Long usuarioId){
    return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
}
. . . TRECHO DE CÓDIGO OMITIDO
~~~

- ***passo 5.*** Na classe de serviço “UsuarioService”, substituir o lançamento da exceção pela exceção personalizada.

~~~java
. . . TRECHO DE CÓDIGO OMITIDO
public UsuarioExibicaoDTO buscarPorId(Long id){
    Optional<Usuario> usuarioOptional =
            usuarioRepository.findById(id);

    if (usuarioOptional.isPresent()){
        return new UsuarioExibicaoDTO(usuarioOptional.get());
    } else {
        throw new UsuarioNaoEncontradoException("Usuário não existe no banco de daos!");
    }
}
. . . TRECHO DE CÓDIGO OMITIDO
~~~

- **testar a implementação, executando uma busca de usuário pelo identificador fornecendo um identificador que não existe**.
- na resposta obtida na consulta, vemos que no corpo da resposta HTTP recebemos um objeto JSON com os detalhes do erro. Neste objeto temos diversas informações. São elas:
  - `timeStamp`: data e hora do evento de erro;
  - `status`: mostra o código de status do erro;
  - `error`: exibe a mensagem de erro relacionada ao código de status do erro;
  - `trace`: mostra toda a pilha de erros que foi gerada no servidor. Essa informação é importante para o desenvolvedor da API, mas não ao consumidor da API. Vamos removê-la mais adiante;
  - `message`: exibe a mensagem de erro personalizada que criamos na classe de serviço ao lançar a exceção.
  - `path`: nos mostra a URL do recurso que gerou o erro.

- para omitir o campo “trace”, vamos adicionar o `parâmetro server.error.include-stacktrace=never` no final do `arquivo application.properties`.

~~~
. . . TRECHO DE CÓDIGO OMITIDO
# QUEBRAR A EXIBIÇÃO DA INSTRUÇÃO SQL EM VÁRIAS LINHAS
spring.jpa.properties.hibernate.format_sql=true

# REMOVER O CAMPO "trace" DA RESPOSTA DE ERRO
server.error.include-stacktrace=never
~~~

> Agora o consumidor da API receberá apenas as informações que são importantes para ele!

## 3.4 Tratando as exceções com @ExceptionHandler e Bean Validation

- quando utilizamos o Bean Validation, o consumidor da API receberá uma resposta HTTP com o status code “400 – Bad Request”, informando que os requisitos para os dados enviados não foram atendidos. 
- essa resposta carrega uma série de informações que não são importantes para o consumidor da API, chegando até a confundir o desenvolvedor do Frontend.
- o ideal seria entregar um objeto JSON com as informações realmente importantes, facilitando a interpretação do problema. 

### 3.4.1 Personalizando a resposta HTTP com Bean Validation
- ao efetuar uma tentativa de inserir um usuário com o nome em branco, recebemos uma resposta HTTP informando que o nome é obrigatório, além de outras informações. 
- além disso, se analisarmos o log do IntelliJ, veremos mais algumas informações úteis, como a classe de exceção MethodArgumentNotValidException, que está tratando o erro de validação, o campo que causou a exceção e a mensagem de erro personalizada.
- ***criar uma classe de manipulação de exceções global***, de modo a centralizar o tratamento de exceções em um único lugar. Essa classe pode conter métodos anotados com “@ExceptionHandler” que poderão lidar com exceções específicas. 
- em nosso caso trataremos exceções de validação do tipo MethodArgumentNotValidException.
- passo-a-passo:
  - 1. Crie um pacote no pacote raiz da aplicação com o nome “advice”.
  - 2. Crie uma classe com o nome “ApplicationExceptionHandler” no pacote “advice”, que acabamos de criar.
  - 3. Implemente a classe ApplicationExceptionHandler.

~~~java
package br.com.fiap.calorias.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error) {

        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> campos = error.getBindingResult().getFieldErrors();

        for(FieldError campo : campos) {
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }
        return errorMap;
    }
}
~~~

- implementações:
  - `Linha 14`: adicionamos a **anotação @RestControllerAdvice**, que tem como função informar ao Spring Boot que esta classe será responsável pela manipulação global do tratamento de exceções da aplicação.
  - `Linha 17`: **anotação @ResponseStatus** está determinando que a resposta HTTP para o consumidor da API será do tipo “400 – Bad Request”, caso a validação esteja incorreta e a exceção seja interceptada por esse método.
  - `Linha 18`: **anotação @ExceptionHandler** configura o método para controlar um tipo de exceção específica. Em nosso exemplo, o método “handleInvalidArgument()” será responsável por tratar as exceções do tipo “MethodArgumentNotValidException”.






--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)