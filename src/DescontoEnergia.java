public class DescontoEnergia extends Recompensa {

    private double percentual;
    private String contaEnergia;

    public DescontoEnergia(int id, String descricao, double percentual, String contaEnergia) {
        super(id, descricao);
        this.percentual = percentual;
        this.contaEnergia = contaEnergia;
    }

    @Override
    public void aplicar(Usuario usuario) {
        System.out.println("\n==============================");
        System.out.println("Parabéns " + usuario.getNome() + "!");
        System.out.println("Você ganhou " + percentual + "% de desconto na conta de energia!");
        System.out.println("==============================");
    }

}
