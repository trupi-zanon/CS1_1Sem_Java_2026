public class Ranking {

    private Usuario[] usuarios;
    private int quantidadeUsuarios;

    public Ranking() {
        this.usuarios = new Usuario[100];
        this.quantidadeUsuarios = 0;
    }

    public int getQuantidadeUsuarios() {
        return quantidadeUsuarios;
    }

    public void adicionarUsuario(Usuario u) {
        if (quantidadeUsuarios < 100) {
            usuarios[quantidadeUsuarios] = u;
            quantidadeUsuarios++;
        }
    }

    public Usuario[] calcularRanking() {
        Usuario[] ranking = new Usuario[quantidadeUsuarios];

        for (int i = 0; i < quantidadeUsuarios; i++) {
            ranking[i] = usuarios[i];
        }

        for (int i = 0; i < quantidadeUsuarios - 1; i++) {
            for (int j = 0; j < quantidadeUsuarios - i - 1; j++) {
                if (ranking[j].getPontuacaoTotal() < ranking[j + 1].getPontuacaoTotal()) {
                    Usuario temp = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = temp;
                }
            }
        }

        return ranking;
    }

    public Usuario getPrimeiroLugar() {
        if (quantidadeUsuarios == 0) {
            return null;
        }
        Usuario[] ranking = calcularRanking();
        return ranking[0];
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (int i = 0; i < quantidadeUsuarios; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }

        return null;
    }

}
