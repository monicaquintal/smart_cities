<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 4 - FRAMEWORKS .NET</h1>
<h2>Capítulo 05: Persistência de Dados.</h2>
</div>

<div align="center">
<h2>1. PERSISTÊNCIA DE DADOS</h2>
</div>

## 1.1 O que é Entity Framework (EF)?

- ferramenta essencial no ecossistema .NET.
- desempenha um papel fundamental como um mapeador objeto-relacional (ORM) que permite aos desenvolvedores interagirem com bancos de dados usando uma abordagem orientada a objetos. 
- serve como uma ponte entre o código .NET e as bases de dados relacionais, eliminando a necessidade de escrever código SQL extenso e complexo para manipular os dados.
- através do EF, desenvolvedores podem definir classes .NET que mapeiam para as tabelas de um banco de dados. 
- operações CRUD (Criar, Ler, Atualizar, Deletar) são executadas sobre essas classes utilizando `LINQ (Language Integrated Query)`, que é integrado naturalmente na linguagem C#.
- uma das ***principais vantagens do EF é sua flexibilidade***, que permite escolher a melhor estratégia de acordo com as necessidades do projeto:
  - `abordagem Code-First`: possibilita aos desenvolvedores definir os modelos de dados diretamente no código C#; o esquema do banco de dados é gerado a partir dos modelos definidos no código.
  - `abordagem Model-First`: permite projetar o modelo de dados utilizando um designer visual, geralmente integrado ao Visual Studio. Após a definição do modelo, o EF gera o código C# correspondente aos modelos e o esquema do banco de dados a partir desse modelo. 
  - `abordagem Database-First`: ideal para casos em que o esquema do banco de dados já está estabelecido. Com essa abordagem, os modelos de dados são gerados a partir do esquema existente do banco de dados, permitindo aos desenvolvedores trabalharem com bancos de dados pré-existentes.
- a ferramenta também é equipada com um sistema de migrações sofisticado, e assegura que as bases de dados possam evoluir sem interrupções significativas ou perda de dados.
- o EF é altamente extensível, permitindo personalizar o comportamento padrão para atender a necessidades específicas, seja através da escrita de interceptadores de comandos SQL, customização de estratégias de carregamento de dados, ou otimização de desempenho. 

## 1.2 Breve histórico e versões (EF 6 e EF Core)

- ***EF 6***:
  - introduzido como parte do .NET Framework.
  - conhecido por sua estabilidade e recursos completos voltados para aplicações que não requerem a flexibilidade do .NET Core. 
  - não está sendo ativamente desenvolvido, mas continua recebendo suporte.
  - ideal para sistemas que já o utilizam e não precisam de atualizações significativas.
- ***EF Core***:
  - projetado como uma versão mais leve e modular.
  - compatível com o .NET Core.
  - adequado para ambientes multiplataforma e aplicações modernas que exigem alta performance e escalabilidade. 
  - tem sido aprimorado continuamente, com adições de novas funcionalidades e melhorias de desempenho que não estão presentes no EF 6.E

## 1.3 Vantagens de usar o Entity Framework 

- permite um desenvolvimento ágil com sua abordagem de mapeamento objeto-relacional (ORM), transformando operações de banco de dados complexas em simples manipulações de objetos em C#.
- suporta várias estratégias de modelagem de dados, como Code-First. As migrações automatizadas simplificam a evolução do esquema do banco de dados ao longo do tempo, mantendo a base de dados sincronizada com o modelo de dados sem esforço manual.
- a eficiência também é uma vantagem destacada, especialmente com o EF Core, que traz melhorias contínuas de desempenho.

<div align="center">
<h2>2. CONFIGURAÇÃO E SETUP</h2>
</div>

- para configurar a conexão com o banco de dados e utilizar o Entity Framework Core, instalar os pacotes necessários via `NuGet`, processo que assegura que todas as dependências requeridas estejam presentes e atualizadas para o correto funcionamento do nosso projeto.

## 2.1 Pacotes Necessários 

- Microsoft.EntityFrameworkCore.
- Microsoft.EntityFrameworkCore.Tools.
- Microsoft.EntityFrameworkCore.Design.
- Oracle.EntityFrameworkCore.

## 2.1.1. Instalando os pacotes

- `etapas`:
  - abra o Visual Studio e carregue seu projeto.
  - no menu principal, clique em Tools ou Clique com botão direito no nome do projeto na janela Solution Explorer.
  - no submenu que se abre, selecione NuGet Package Manager.
  - clique em Manage NuGet Packages for Solution.
- este caminho levará à janela do gerenciador de pacotes NuGet, onde é possível procurar, selecionar e instalar os pacotes necessários para o projeto, incluindo os relacionados ao Entity Framework Core.
- `para encontrar e instalar os pacotes necessários no NuGet Package Manager`: 
  - após abrir a janela do Manage NuGet Packages for Solution, clique na aba Browse.
  - use a barra de pesquisa para procurar o nome de cada pacote conforme listagem acima. Digite o nome do pacote e pressione Enter.
  - selecionar o pacote desejado da lista para ver mais detalhes e opções de instalação.
- `passos`:
  - selecione o pacote na listagem.
  - selecione o projeto que deseja instalar o pacote.
  - clique no botão “Install” ou “Instalar”.
- depois da instalação dos pacotes, é importante validar se tudo foi realizado corretamente: acessar o Solution Explorer e navegar até a pasta Dependencies\Packages, para vrerificar se os pacotes selecionados anteriormente estão listados no projeto. 

## 2.2 Conexão com diferentes tipos de Banco de Dados

- o EF oferece suporte a uma ampla variedade de sistemas de banco de dados através do uso de bibliotecas específicas, conhecidas como `provedores de banco de dados`. 
- os provedores funcionam como plug-ins para que o EF Core conecte-se a sistemas relacionais tradicionais como SQL Server e PostgreSQL ou bancos de dados não relacionais.
- podemos instalar vários packages para conectar com vários tipos de banco de dados.

<div align="center">

Pacote do NuGet | Mecanismos de banco de dados com suporte
----------------|-----------------------------
Microsoft.EntityFrameworkCore.SqlServer | SQL do Azure e SQL Server 2012 em diante
Microsoft.EntityFrameworkCore.Sqlite | SQLite 3.7 em diante
Microsoft.EntityFrameworkCore.InMemory | Banco de dados em memória do EF Core
Microsoft.EntityFrameworkCore.Cosmos | API de SQL do Azure Cosmos DB
Npgsql.EntityFrameworkCore.PostgreSQL | PostgreSQL
Pomelo.EntityFrameworkCore.MySql | MySQL, MariaDB
MySql.EntityFrameworkCore | MySQL
Oracle.EntityFrameworkCore | Oracle Database 11.2 em diante
MongoDB.EntityFrameworkCore | MongoDB
Devart.Data.MySql.EFCore | MySQL 5 em diante
Devart.Data.Oracle.EFCore | Oracle Database 9.2.0.4 em diante
Devart.Data.PostgreSql.EFCore | PostgreSQL 8.0 em diante
Devart.Data.SQLite.EFCore | SQLite 3 em diante
Devart.Data.DB2.EFCore | DB2
Devart.Data.Bigcommerce.EFCore | BigCommerce
Devart.Data.Dynamics.EFCore | Microsoft Dynamics 365
Devart.Data.FreshBooks.EFCore | FreshBooks
Devart.Data.Magento.EFCore | Magento
Devart.Data.MailChimp.EFCore | MailChimp
Devart.Data.QuickBooks.EFCore | QuickBooks
Devart.Data.Salesforce.EFCore | Salesforce
Devart.Data.ExactTarget.EFCore | Salesforce MC (ExactTarget)
Devart.Data.Sugar.EFCore | SugarCRM
Devart.Data.Zoho.EFCore | Zoho CRM
MASES.EntityFrameworkCore.KNet | Apache Kafka
Interbase | InterBase
FirebirdSql.EntityFrameworkCore.Firebird | Firebird 3.0 em diante
IBM.EntityFrameworkCore | Db2, Informix
IBM.EntityFrameworkCore-lnx | Db2, Informix
IBM.EntityFrameworkCore-osx | Db2, Informix
EntityFrameworkCore.Jet | Arquivos do Microsoft Access
Google.Cloud.EntityFrameworkCore.Spanner | Google Cloud Spanner
Teradata.EntityFrameworkCore | Banco de dados Teradata 16.10 em diante
FileContextCore | Armazena dados em arquivos
FileBaseContext | Armazenar tabelas em arquivos
EntityFrameworkCore.SqlServerCompact35 | SQL Server Compact 3.5
EntityFrameworkCore.SqlServerCompact40 | SQL Server Compact 4.0
EntityFrameworkCore.OpenEdge | Progress OpenEdge

</div>

<div align="center">
<h2>3. ARQUITETURA DO ENTITY FRAMEWORK</h2>
</div>

- os principais componentes do EF incluem:
  - provedor de dados, que se comunica com o banco de dados subjacente; 
  - modelo conceitual, que representa a estrutura lógica dos dados em termos de entidades e seus relacionamentos;
  - provedor LINQ, que permite consultar e manipular os dados usando a linguagem de consulta integrada à linguagem (LINQ). 

## 3.2 DbContext

- é uma classe central no EF e EF Core. 
- canal entre o código C# da aplicação e o banco de dados. 
- é parte do namespace Microsoft.EntityFrameworkCore.
- serve para configurar o modelo de dados, realizar consultas, e salvar alterações no banco de dados.
- o DbContext encapsula uma sessão com o banco de dados, oferecendo uma API simplificada para executar operações CRUD (Criar, Ler, Atualizar, Deletar) nas entidades mapeadas.
- `principais características e funcionalidades do DbContext`:
  - ***configuração de Modelo***: 
    - define como as classes de entidade são mapeadas para as tabelas do banco de dados, incluindo chaves primárias, relações, índices, e convenções de nomenclatura. 
    - essa configuração pode ser feita por meio de **DataAnnotations** diretamente nas classes de entidade ou através do **Fluent API** no próprio DbContext.
  - ***rastreamento de Mudanças***: 
    - DbContext rastreia as alterações feitas nas instâncias das entidades desde a última vez que foram carregadas ou desde a última chamada de SaveChanges().
    - permite que o EF Core envie comandos SQL eficientes para o banco de dados, atualizando apenas as partes que realmente mudaram.
  - ***execução de Consultas***: 
    - permite a execução de consultas LINQ para selecionar, filtrar, ordenar e agrupar dados de maneira eficiente. 
    - as consultas são traduzidas pelo EF Core em comandos SQL otimizados para o banco de dados em uso.
  - ***gerenciamento de Transações***: 
    - DbContext usa transações para garantir a consistência dos dados. 
    - pode gerenciar transações automaticamente ou permitir que você as controle manualmente para operações mais complexas.
  - ***caching de Primeiro Nível***: 
    - o EF Core armazena instâncias de entidades em cache no contexto, o que pode melhorar o desempenho ao reutilizar entidades já carregadas em operações subsequentes dentro do mesmo contexto.
  - ***migrações de Banco de Dados***:
    - o DbContext trabalha com o sistema de migrações do EF Core para aplicar mudanças incrementais no esquema do banco de dados, facilitando o controle de versão e a evolução do modelo de dados.

> Para ficar mais organizado, criaremos o namespace (pasta) no projeto com o nome de `Data\Contexts`, e dentro dessa pasta criaremos uma classe DatabaseContext que herda de System.Data.Entity.DbContext e incluiremos as definições das tabelas e relacionamentos, conforme necessário.

### 3.2.1 O construtor do DbContext
- é essencial ter um construtor específico para configurar a interação da aplicação com o banco de dados. 
- esse construtor é utilizado para passar configurações específicas para o DbContext por meio de uma instância de DbContextOptions. 
- assim é possível configurar detalhes importantes, como a string de conexão do banco de dados, o provedor de banco de dados (Oracle, SQL Server, PostgreSQL, SQLite etc.), comportamentos de logging e etc.
- permite à aplicação personalizar a conexão e o comportamento do DbContext com o banco de dados em tempo de execução. 
- normalmente, essas opções são configuradas no início da aplicação, por exemplo, no método ConfigureServices em uma aplicação ASP.NET Core. 

~~~csharp
using Microsoft.EntityFrameworkCore;
namespace Fiap.Web.Alunos.Data.Contexts
{
    public class DatabaseContext : DbContext
    {
        public DatabaseContext(DbContextOptions options) : base(options)
        {
        }
        protected DatabaseContext()
        {
        }
    }
}
~~~

### 3.2.2 E as configurações?
- com o ASP.NET Core, foi introduzida uma nova abordagem para lidar com configurações por meio de arquivos JSON, como `appsettings.json` e `appsettings.<Environment>.json`, onde &lt;Environment&gt; representa o ambiente específico em que a aplicação está sendo executada, como Development, Staging ou Production.
  - arquivo `appsettings.json`:
    - é o arquivo de configuração padrão utilizado por uma aplicação .NET Core. 
    - as configurações são armazenadas na forma de pares chave-valor e são carregadas automaticamente pelo framework no início da aplicação.
    - esse arquivo é destinado a definir configurações comuns a todos ambientes de execução da aplicação, como strings de conexão de banco de dados, configurações de log e outras preferências.
  - arquivo `appsettings<environment>.json`:
    - permite configurações específicas de cada ambiente, como Development, Staging ou Production.
    - o ASP.NET Core suporta arquivos de configuração nomeados como: appsettings.&lt;Environment>&gt;.json, appsettings.Development.json e appsettings.Production.json. 
    - esses arquivos substituem as configurações definidas em appsettings.json para o ambiente específico, possibilitando a personalização de configurações, como strings de conexão ou níveis de log, para diferentes ambientes sem a necessidade de alterar o código.
- uma das melhores formas de passar o ambiente para uma aplicação .NET Core é através de `variáveis de ambiente`. 
  - o ASP.NET Core fornece suporte nativo para a configuração do ambiente de execução por meio da variável de ambiente `ASPNETCORE_ENVIRONMENT`.

- ***para configurar a aplicação para usar o appsettings***, definir a variável de ambiente ASPNETCORE_ENVIRONMENT.
  - **Windows**: abra o prompt de comando e defina a variável de ambiente usando o comando (optando pelos ambientes Development ou Production):

~~~
set ASPNETCORE_ENVIRONMENT=Development
~~~

  - **Linux/macOS**: no aplicativo de terminal, usar o comando:

~~~
export ASPNETCORE_ENVIRONMENT=Development
~~~

> IMPORTANTE: Ao executar o projeto via Docker, a utilização da variável de configuração para o ambiente de produção depende de um serviço SSL (https) real. Essa dependência gera uma complexa configuração e exige um grande esforço da equipe de DevOps. Para simplificar o processo, optaremos por utilizar apenas o ambiente de desenvolvimento.

## 3.3 String de Conexão

- configuração essencial para estabelecer a conexão com o banco de dados, seja qual for. 
- cada banco de dados possui sua própria string de conexão, que contém informações como servidor de banco de dados, nome do banco de dados, credenciais de autenticação e outras configurações relevantes.
- no caso do `Oracle`, configurar uma string de conexão que seja compatível com este banco de dados.
  - o site [Connection Strings.com](https://www.connectionstrings.com/) oferece uma vasta lista de strings de conexão para uma variedade de bancos de dados e diferentes métodos de conexão.
- utilizar o código abaixo como base para modificar o arquivo appsettings.development.json e appsettings.json do projeto.

~~~json
{
  "Logging": {
    "LogLevel": {
      "Default": "Information",
      "Microsoft.AspNetCore": "Warning"
    }
  },
  "ConnectionStrings": {
    "DatabaseConnection": "Data Source=(DESCRIPTION = (ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = oracle.fiap.com.br)(PORT = 1521)))(CONNECT_DATA = (SID = orcl)));Persist Security Info=True;User ID=;Password=;Pooling=True;Connection Timeout=60;"
  },
  "AllowedHosts": "*"
}
~~~

> IMPORTANTE: Para utilizar o banco de dados Oracle da FIAP, certifique-se de alterar as propriedades User ID e Password, para outros bancos de dados Oracle lembre-se também de alterar as propriedades HOST, PORT e SID.














--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)