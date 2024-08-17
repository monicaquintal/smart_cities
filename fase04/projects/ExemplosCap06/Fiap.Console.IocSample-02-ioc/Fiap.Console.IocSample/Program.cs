class Program
{
    static void Main()
    {
        IMensageiro mensageiro = new Mensageiro();
        EnviadorDeMensagem enviador = new EnviadorDeMensagem(mensageiro);
        enviador.Enviar("Olá, mundo DI!");
    }
}