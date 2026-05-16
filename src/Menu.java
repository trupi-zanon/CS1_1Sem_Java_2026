import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ranking ranking = new Ranking();

        int nextId = 1;
        int nextAcaoId = 1;
        int nextPontuacaoId = 1;

        System.out.println("\n==============================");
        System.out.println("  BEM-VINDO À ECOQUEST!  ");
        System.out.println("==============================");
        System.out.println("Equipe: Kauan Mattos (571599), Kauã Nunes (572213),");
        System.out.println("        Diego Zanon (568945), Lucas Almeida (570546),");
        System.out.println("        Guilherme Costa (571689)");
        System.out.println("==============================\n");

        int opcao;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Realizar ação");
            System.out.println("3 - Ver Ranking");
            System.out.println("4 - Ver pontuação");
            System.out.println("5 - Dar recompensa ao líder");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("\nNome: ");
                String nome = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();

                Usuario u = new Usuario(nextId, nome, email);
                ranking.adicionarUsuario(u);
                System.out.println("\nUsuário cadastrado! ID: " + nextId);
                nextId++;
            }

            else if (opcao == 2) {
                if (ranking.getQuantidadeUsuarios() == 0) {
                    System.out.println("Nenhum usuário cadastrado!");
                } else {
                    System.out.print("ID do usuário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Usuario u = ranking.buscarUsuarioPorId(id);
                    if (u == null) {
                        System.out.println("Usuário não encontrado!");
                    } else {
                        System.out.print("Descrição da ação: ");
                        String tipo = scanner.nextLine();
                        System.out.print("Impacto (de 1 a 10): ");
                        double impacto = scanner.nextDouble();
                        System.out.print("Bônus (de 0 a 0,5): ");
                        double bonus = scanner.nextDouble();
                        scanner.nextLine();

                        AcaoSustentavel acao = new AcaoSimples(nextAcaoId, tipo, impacto, bonus);
                        int pontos = acao.calcularPontos();
                        Pontuacao p = new Pontuacao(nextPontuacaoId, pontos, acao);
                        u.adicionarPontuacao(p);

                        System.out.println("Ação realizada! Você ganhou " + pontos + " pontos!");
                        System.out.println("Total: " + u.getPontuacaoTotal());

                        nextAcaoId++;
                        nextPontuacaoId++;
                    }
                }
            }

            else if (opcao == 3) {

                if (ranking.getQuantidadeUsuarios() == 0) {
                    System.out.println("Nenhum usuário cadastrado!");
                } else {
                    Usuario[] rankingArray = ranking.calcularRanking();
                    System.out.println("\n=== RANKING ===");
                    for (int i = 0; i < rankingArray.length; i++) {
                        System.out.println((i + 1) + "º - " + rankingArray[i].getNome() + " - "
                                + rankingArray[i].getPontuacaoTotal() + " pontos");
                    }
                }

            }

            else if (opcao == 4) {

                if (ranking.getQuantidadeUsuarios() == 0) {
                    System.out.println("Nenhum usuário cadastrado!");
                } else {
                    System.out.print("ID do usuário: ");
                    int id = scanner.nextInt();

                    Usuario u = ranking.buscarUsuarioPorId(id);
                    if (u == null) {
                        System.out.println("Usuário não encontrado!");
                    } else {
                        u.exibirHistorico();
                    }
                }

            }

            else if (opcao == 5) {

                if (ranking.getQuantidadeUsuarios() == 0) {
                    System.out.println("Nenhum usuário cadastrado!");
                } else {
                    Usuario primeiro = ranking.getPrimeiroLugar();
                    DescontoEnergia premio = new DescontoEnergia(1, "Conta de energia totalmente subsidiada", 100,
                            "conta@energia.com");
                    premio.aplicar(primeiro);
                }

            }

            else if (opcao == 0) {
                System.out.println("\n Obrigado! Até logo!\n");

            } else {
                System.out.println("\nOpcão inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

}
