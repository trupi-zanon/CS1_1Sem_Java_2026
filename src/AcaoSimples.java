public class AcaoSimples extends AcaoSustentavel {

    private double fatorBonus;

    public AcaoSimples(int id, String tipo, double impacto, double fatorBonus) {

        super(id, tipo, impacto);
        this.fatorBonus = fatorBonus;

    }

    public double getFatorBonus() {
        return this.fatorBonus;
    }

    public void setFatorBonus(double newFatorBonus) {
        this.fatorBonus = newFatorBonus;
    }

    @Override
    public int calcularPontos() {
        int pontos = (int) (impacto * 10);
        pontos = pontos + (int) (pontos * fatorBonus);

        if (pontos > 100) {
            pontos = 100;
        }
        if (pontos < 0) {
            pontos = 0;
        }

        return pontos;
    }

}
