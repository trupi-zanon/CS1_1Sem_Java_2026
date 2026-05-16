public abstract class Recompensa {

    protected int id;
    protected String descricao;

    public Recompensa(int id, String descricao) {

        this.id = id;
        this.descricao = descricao;

    }

    public abstract void aplicar(Usuario usuario);

}
