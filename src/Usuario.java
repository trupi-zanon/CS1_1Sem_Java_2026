public class Usuario {

    private int id;
    private String nome;
    private String email;
    private Pontuacao[] pontuacoes;
    private int quantidadePontuacoes;

    public Usuario(int id, String nome, String email) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pontuacoes = new Pontuacao[100];
        this.quantidadePontuacoes = 0;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void adicionarPontuacao(Pontuacao p) {
        if (quantidadePontuacoes < 100) {
            pontuacoes[quantidadePontuacoes] = p;
            quantidadePontuacoes++;
        }
    }

    public int getPontuacaoTotal() {
        int total = 0;
        for (int i = 0; i < quantidadePontuacoes; i++) {
            total = total + pontuacoes[i].getValor();
        }
        return total;
    }

    public void exibirHistorico() {
        System.out.println("\n====== Histórico de " + nome + " ======");
        if (quantidadePontuacoes == 0) {
            System.out.println("Nenhuma ação realizada ainda.");
        } else {
            for (int i = 0; i < quantidadePontuacoes; i++) {
                System.out
                        .println(" " + pontuacoes[i].getAcao().getTipo() + ": " + pontuacoes[i].getValor() + " pontos");
            }
            System.out.println("Total: " + getPontuacaoTotal() + " pontos");
        }
    }

}
