<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 4 - FRAMEWORKS .NET</h1>
<h2>Capítulo 06: Padrões e Práticas Avançadas.</h2>
</div>

<div align="center">
<h2>1. PADRÕES E PRÁTICAS AVANÇADAS</h2>
</div>

## 1.1 Injeção de Dependência

- a `inversão de controle (IoC)` em padrões e práticas avançadas em .NET é uma abordagem para projetar ***sistemas flexíveis, modulares e testáveis***. 
  - em vez de os componentes do sistema controlarem suas próprias dependências, a IoC transfere o controle da criação e gerenciamento de dependências para fora dos componentes individuais.
- é frequentemente implementada por meio da `injeção de dependência (DI)`. 
- com a DI, as dependências necessárias por um componente são fornecidas a ele por uma fonte externa, como um contêiner de injeção de dependência. 
- essa técnica promove um baixo acoplamento entre os componentes, pois eles não precisam conhecer detalhes de implementação de suas dependências. 
- em vez disso, eles apenas declaram as dependências que precisam e as recebem de fora.
- em .NET, a injeção de dependência é comumente realizada usando os contêineres de IoC fornecidos pelo framework, como o `IServiceCollection` no .NET, ou bibliotecas de terceiros, como o Autofac, Ninject, Unity etc. 
- esses contêineres gerenciam o ciclo de vida das dependências e resolvem automaticamente as dependências necessárias quando os componentes são instanciados.
- podemos considerar **flexibilidade, manutenção e escalabilidade como benefícios da IoC** sobre os seguintes aspectos:
  - ***Flexibilidade***: a IoC permite que os desenvolvedores alterem facilmente as implementações de dependência sem modificar o código do componente. Isso é particularmente útil em ambientes onde os requisitos podem mudar frequentemente.
  - ***Manutenção e Escalabilidade***: com componentes menos acoplados, o sistema torna-se mais fácil de entender, modificar e escalar. Isso é especialmente vantajoso em grandes bases de código.
- a IoC é **essencial para a testabilidade do código em .NET**: 
  - ao injetar dependências em vez de criar objetos dentro dos componentes, é mais fácil substituir as implementações reais por versões mockadas durante os testes.
  - permite testes unitários mais eficazes e confiáveis, pois as unidades de código podem ser isoladas e testadas de forma independente.
- além disso, **a IoC é fundamental em arquiteturas de microsserviços**:
  - em sistemas distribuídos, cada microsserviço pode ter suas próprias dependências injetadas por meio de técnicas de injeção de dependência. 
  - os contêineres de IoC, juntamente com práticas de configuração centralizada, como arquivos de configuração ou serviços de descoberta de configuração, são usados para facilitar a IoC em ambientes distribuídos.

## 1.2 Exemplo tradicional

- no exemplo tradicional, as dependências são criadas diretamente pela classe que as consome.

~~~csharp
class Program
{
    static void Main()
    {
        Mensageiro mensageiro = new Mensageiro();
        mensageiro.EnviarMensagem("Olá, mundo!");
    }
}
public class Mensageiro
{
    public void EnviarMensagem(string mensagem)
    {
        Console.WriteLine(mensagem);
    }
}
~~~

## 1.3 Exemplo com IoC e DI

- no exemplo utilizando IoC e DI, a dependência (Mensageiro) é injetada na classe consumidora, ao invés de ser diretamente instanciada por ela. 
- isso é frequentemente feito através de um contêiner IoC, mas para simplificar, faremos a injeção manualmente.

~~~csharp
class Program
{
    static void Main()
    {
        IMensageiro mensageiro = new Mensageiro();
        EnviadorDeMensagem enviador = new EnviadorDeMensagem(mensageiro);
        enviador.Enviar("Olá, mundo DI!");
    }
}
public interface IMensageiro
{
    void EnviarMensagem(string mensagem);
}
public class Mensageiro : IMensageiro
{
    public void EnviarMensagem(string mensagem)
    {
        Console.WriteLine(mensagem);
    }
}
public class EnviadorDeMensagem
{
    private readonly IMensageiro _mensageiro;
    public EnviadorDeMensagem(IMensageiro mensageiro)
    {
        _mensageiro = mensageiro;
    }
    public void Enviar(string mensagem)
    {
        _mensageiro.EnviarMensagem(mensagem);
    }
}
~~~

- neste segundo exemplo, EnviadorDeMensagem não precisa saber como Mensageiro é implementado, apenas que ele cumpre com o contrato definido pela interface IMensageiro.
- isso desacopla o código e facilita testes e manutenção, permitindo, por exemplo, substituir a classe Mensageiro por um mock durante os testes.

> IMPORTANTE: [Link da solução implementada até o momento para download no GitHub - Exemplo tradicional](https://github.com/profflaviomoreni/Fiap.Console.IocSample/tree/01-tradicional) e [Exemplo IoC](https://github.com/profflaviomoreni/Fiap.Console.IocSample/tree/02-ioc).

## 1.4 Contêiner IoC 

- o `IServiceCollection` no ASP.NET Core é um componente essencial para o gerenciamento de dependências dentro da aplicação. 
- ele atua como um contêiner IoC (Inversion of Control), permitindo a configuração e resolução de dependências de forma flexível e controlada.
- é uma interface que define um contrato para uma coleção de serviços. 
  - no ASP.NET Core, os serviços são tipicamente componentes que fornecem funcionalidades específicas, como acesso a dados, operações de arquivo, ou serviços de rede.
  - o IServiceCollection permite que você adicione serviços ao contêiner de DI (Injeção de Dependência), configurá-los conforme necessário, e então consumi-los em toda a aplicação de forma segura e conveniente.

## 1.5 Métodos de Injeção de Dependência

- há várias maneiras de registrar serviços no IServiceCollection, cada uma correspondendo a diferentes necessidades de ciclo de vida dos objetos:
  - `Transient`:
    - AddTransient()
    - Cria uma nova instância toda vez que um serviço é solicitado.
  - `Scoped`:
    - AddScoped()
    - Cria uma instância única para cada requisição, compartilhada dentro de uma única requisição.
  - `Singleton`:
    - AddSingleton()
    - Cria uma instância única que é compartilhada entre todas as requisições e a vida útil da aplicação.

- para exemplificar o uso, imagine que você quer implementar um serviço simples de log. 
- exemplo de como poderia definir a interface e a implementação:

~~~csharp
namespace Fiap.Web.Alunos.Logging
{
    public interface ICustomLogger
    {
        void Log(string message);
    }
    public class MockLogger : ICustomLogger
    {
        public void Log(string message)
        {
            Console.WriteLine($"Log: {message}");
        }
    }
}
~~~

- e como registrá-la usando o IServiceCollection no `Program.cs`:

~~~csharp
#region IMPORTAÇÃO REFERENTE AO BANCO DE DADOS
using Fiap.Web.Alunos.Data.Contexts;
using Fiap.Web.Alunos.Logging;
using Microsoft.EntityFrameworkCore;
#endregion
var builder = WebApplication.CreateBuilder(args);
#region INICIALIZANDO O BANCO DE DADOS
var connectionString = builder.Configuration.GetConnectionString("DatabaseConnection");
builder.Services.AddDbContext<DatabaseContext>(
    opt => opt.UseOracle(connectionString).EnableSensitiveDataLogging(true)
);
#endregion
#region Registro IServiceCollection
builder.Services.AddSingleton<ICustomLogger, MockLogger>();
#endregion
// Add services to the container.
builder.Services.AddControllersWithViews();
// CODIGO SUPRIMIDO …
~~~

- uma vez registrado, o serviço pode ser injetado e utilizado em controladores, serviços, ou qualquer outro componente gerenciado pelo contêiner de DI do ASP.NET Core. 
- exemplo de como seria o possível uso desse mecanismo no Controller Home:

~~~csharp
public class HomeController : Controller
{
    private readonly ICustomLogger _logger;
    public HomeController(ICustomLogger logger)
    {
        _logger = logger;
    }
    public IActionResult Index()
    {
        _logger.Log("Acessando a página inicial."); // USO
        return View();
    }
}
~~~

- neste exemplo, MockLogger é registrado como um serviço singleton, o que significa que uma única instância será criada e compartilhada em toda a aplicação. 
- sempre que o HomeController for criado, o ASP.NET Core injetará a instância de MockLogger disponível no contêiner de DI.
- o IServiceCollection oferece um meio poderoso e flexível para gerenciar dependências em aplicações ASP.NET Core, facilitando a manutenção, testabilidade e escalabilidade do software. 
- ao abstrair a criação e gestão de dependências, ele permite um design de software mais limpo e desacoplado.

> IMPORTANTE: [Link da solução implementada até o momento para download no GitHub](https://github.com/FIAP/ON_TDS_DOTNET_ADVANCE/tree/13-injecao-dependencia).

## 1.6 Testes Unitários

- essenciais nos padrões e práticas avançadas de desenvolvimento de software, onde pequenas partes de código, como métodos ou classes, são isoladamente verificadas. 
- esses  testes  são  realizados  usando frameworks especializados como MSTest, NUnit, ou xUnit.net, que facilitam a escrita, organização e execução dos testes de forma eficiente.






--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)