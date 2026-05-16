public class Pontuacao {

    private int id;
    private int valor;
    private AcaoSustentavel acao;

    public Pontuacao(int id, int valor, AcaoSustentavel acao) {

        this.id = id;
        this.valor = valor;
        this.acao = acao;

    }

    public int getId() {
        return this.id;
    }

    public int getValor() {
        return this.valor;
    }

    public AcaoSustentavel getAcao() {
        return this.acao;
    }

    public void setValor(int newValor) {
        this.valor = newValor;
    }

}
