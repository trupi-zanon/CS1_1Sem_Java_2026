public class BeneficioExperiencia extends Recompensa {

    private String tipoExperiencia;

    public BeneficioExperiencia(int id, String descricao, String tipoExperiencia) {
        super(id, descricao);
        this.tipoExperiencia = tipoExperiencia;
    }

    @Override
    public void aplicar(Usuario usuario) {
        System.out.println("\n==============================");
        System.out.println("Parabéns " + usuario.getNome() + "!");
        System.out.println(descricao);
        System.out.println("==============================");
    }

}
