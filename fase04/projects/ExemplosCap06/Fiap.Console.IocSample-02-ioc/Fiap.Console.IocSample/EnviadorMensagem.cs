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