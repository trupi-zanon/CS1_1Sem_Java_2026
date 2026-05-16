public class Main {

    public static void main(String[] args) {

        // Testando usuários
        System.out.println("\n===============================================");
        Usuario usuario1 = new Usuario(1, "Kauan Mattos", "kauan@email.com");
        Usuario usuario2 = new Usuario(2, "Kauã Nunes", "kaua@email.com");
        Usuario usuario3 = new Usuario(3, "Diego Zanon", "diego@email.com");

        System.out.println("Usuário 1: " + usuario1.getNome() + " (ID: " + usuario1.getId() + ")");
        System.out.println("Usuário 2: " + usuario2.getNome() + " (ID: " + usuario2.getId() + ")");
        System.out.println("Usuário 3: " + usuario3.getNome() + " (ID: " + usuario3.getId() + ")");
        System.out.println("===============================================");

        // Testando ações simples
        System.out.println("\n===============================================");
        AcaoSustentavel acao1 = new AcaoSimples(1, "Reciclar garrafa PET", 3.0, 0.0);
        AcaoSustentavel acao2 = new AcaoSimples(2, "Plantar uma árvore", 8.0, 0.2);
        AcaoSustentavel acao3 = new AcaoSimples(3, "Economizar 1 hora de chuveiro", 5.0, 0.1);
        AcaoSustentavel acao4 = new AcaoSimples(4, "Usar transporte público", 7.0, 0.0);

        System.out.println("Ação: " + acao1.getTipo());
        System.out.println("Impacto: " + acao1.getImpacto());
        System.out.println("Pontos: " + acao1.calcularPontos() + "\n");

        System.out.println("Ação: " + acao2.getTipo());
        System.out.println("Impacto: " + acao2.getImpacto());
        System.out.println("Bônus: 0.2");
        System.out.println("Pontos: " + acao2.calcularPontos() + "\n");

        System.out.println("Ação: " + acao3.getTipo());
        System.out.println("Impacto: " + acao3.getImpacto());
        System.out.println("Bônus: 0.1");
        System.out.println("Pontos: " + acao3.calcularPontos() + "\n");
        System.out.println("===============================================");

        // Testando ações compostas
        System.out.println("\n===============================================");
        AcaoComposta acaoComposta = new AcaoComposta(5, "Dia sustentável completo", 6.0);
        acaoComposta.adicionarSubAcao(acao1);
        acaoComposta.adicionarSubAcao(acao3);
        acaoComposta.adicionarSubAcao(acao4);

        System.out.println("Ação composta: " + acaoComposta.getTipo());
        System.out.println("Impacto geral: " + acaoComposta.getImpacto());
        System.out.println("Sub-ações adicionadas: 3");
        System.out.println("Pontos totais: " + acaoComposta.calcularPontos() + "\n");
        System.out.println("===============================================");

        // Testando pontuações
        System.out.println("\n===============================================");
        Pontuacao pont1 = new Pontuacao(1, acao1.calcularPontos(), acao1);
        Pontuacao pont2 = new Pontuacao(2, acao2.calcularPontos(), acao2);
        Pontuacao pont3 = new Pontuacao(3, acao3.calcularPontos(), acao3);
        Pontuacao pont4 = new Pontuacao(4, acaoComposta.calcularPontos(), acaoComposta);

        usuario1.adicionarPontuacao(pont1);
        usuario1.adicionarPontuacao(pont2);

        usuario2.adicionarPontuacao(pont3);
        usuario2.adicionarPontuacao(pont4);

        usuario3.adicionarPontuacao(pont1);

        System.out.println("Usuário 1 (Kauan) ganhou " + usuario1.getPontuacaoTotal() + " pontos");
        System.out.println("Usuário 2 (Kauã) ganhou " + usuario2.getPontuacaoTotal() + " pontos");
        System.out.println("Usuário 3 (Diego) ganhou " + usuario3.getPontuacaoTotal() + " pontos");
        System.out.println("===============================================");

        // Testanto histórico dos usuários
        System.out.println("\n===============================================");
        usuario1.exibirHistorico();
        System.out.println();
        usuario2.exibirHistorico();
        System.out.println();
        usuario3.exibirHistorico();
        System.out.println();
        System.out.println("===============================================");

        // Testando ranking
        System.out.println("\n===============================================");
        Ranking ranking = new Ranking();
        ranking.adicionarUsuario(usuario1);
        ranking.adicionarUsuario(usuario2);
        ranking.adicionarUsuario(usuario3);

        Usuario[] rankingArray = ranking.calcularRanking();

        System.out.println("RANKING FINAL");
        for (int i = 0; i < rankingArray.length; i++) {
            System.out.println("  " + (i + 1) + "º lugar: " + rankingArray[i].getNome() + " - "
                    + rankingArray[i].getPontuacaoTotal() + " pontos");
        }

        Usuario encontrado = ranking.buscarUsuarioPorId(2);
        if (encontrado != null) {
            System.out.println("Usuário encontrado: " + encontrado.getNome());
        } else {
            System.out.println("Usuário não encontrado");
        }

        Usuario primeiro = ranking.getPrimeiroLugar();
        if (primeiro != null) {
            System.out.println("LÍDER: " + primeiro.getNome() + " com " + primeiro.getPontuacaoTotal() + " pontos!");
        }
        System.out.println("===============================================");

        // Testando recompensas
        System.out.println("\n===============================================");
        DescontoEnergia premioEnergia = new DescontoEnergia(1, "Conta de energia totalmente subsidiada pela EcoQuest",
                100.0, "conta123@energia.com");
        premioEnergia.aplicar(primeiro);

        BeneficioExperiencia premioExperiencia = new BeneficioExperiencia(2, "Ingresso VIP para o NEXT 2026",
                "Evento presencial de inovação da FIAP");
        premioExperiencia.aplicar(usuario2);
        System.out.println("===============================================");

    }

}
