public class AcaoComposta extends AcaoSustentavel {

    private AcaoSustentavel[] subAcoes;
    private int quantidadeSubAcoes;

    public AcaoComposta(int id, String tipo, double impacto) {

        super(id, tipo, impacto);
        this.subAcoes = new AcaoSustentavel[10];
        this.quantidadeSubAcoes = 0;

    }

    public AcaoSustentavel[] getSubAcoes() {
        return this.subAcoes;
    }

    public int getQuantidadeSubAcoes() {
        return this.quantidadeSubAcoes;
    }

    public void adicionarSubAcao(AcaoSustentavel acao) {

        if (quantidadeSubAcoes < 10) {
            subAcoes[quantidadeSubAcoes] = acao;
            quantidadeSubAcoes++;
        }

    }

    @Override
    public int calcularPontos() {
        int pontos = 0;

        if (quantidadeSubAcoes > 0) {
            for (int i = 0; i < quantidadeSubAcoes; i++) {
                pontos = pontos + subAcoes[i].calcularPontos();
            }
            pontos = pontos / quantidadeSubAcoes;
        }

        pontos = pontos + (int) (impacto * 5);

        if (pontos > 100) {
            pontos = 100;
        }
        if (pontos < 0) {
            pontos = 0;
        }

        return pontos;
    }

}
