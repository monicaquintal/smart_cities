package hook;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
public class Hook {
    @BeforeAll
    public static void setUpBeforeClass() {
        // Simulação de configuração global antes da execução de todos os testes
        System.out.println("Configuração global antes de todos os testes.");
        inicializarAmbiente();
    }
    @AfterAll
    public static void tearDownAfterClass() {
        // Simulação de limpeza global após a execução de todos os testes
        System.out.println("Limpeza global após todos os testes.");
        limparAmbiente();
    }
    @Before
    public void setUp() {
        // Simulação de configuração antes da execução de cada cenário
        System.out.println("Iniciando um novo cenário de teste...");
        prepararDadosParaTeste();
    }
    @After
    public void tearDown() {
        // Simulação de limpeza após a execução de cada cenário
        System.out.println("Finalizando o cenário de teste...");
        limparDadosDepoisDoTeste();
    }
    private static void inicializarAmbiente() {
        // Simulação de inicialização do ambiente
        System.out.println("Ambiente inicializado.");
    }
    private static void limparAmbiente() {
        // Simulação de limpeza do ambiente
        System.out.println("Ambiente limpo.");
    }
    private void prepararDadosParaTeste() {
        // Simulação de preparação de dados para o teste
        System.out.println("Dados preparados para o cenário de teste.");
    }
    private void limparDadosDepoisDoTeste() {
        // Simulação de limpeza de dados após o teste
        System.out.println("Dados limpos após o cenário de teste.");
    }
}