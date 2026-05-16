
public abstract class AcaoSustentavel {

    protected int id;
    protected String tipo;
    protected double impacto;

    public AcaoSustentavel(int id, String tipo, double impacto) {

        this.id = id;
        this.tipo = tipo;
        this.impacto = impacto;

    }

    public int getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getImpacto() {
        return this.impacto;
    }

    public abstract int calcularPontos();

}
