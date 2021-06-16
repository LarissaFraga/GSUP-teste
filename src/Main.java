import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LinkedList<Integer> listaJogadores = new LinkedList<Integer>();

        int N;
        int k;
        int m;

        do {
            N = input.nextInt();
            k = input.nextInt();
            m = input.nextInt();

            if (N != 0 && k != 0 && m != 0) {
                if (N < 20 && N > 0) {
                    listaJogadores = montaLista(N);

                    while (!listaJogadores.isEmpty()) {
                        if (listaJogadores.size() == 2) {
                            System.out.println("Vocês são os ganhadores");
                            break;
                        }

                        if (listaJogadores.size() == 1) {
                            System.out.println("Você é o ganhador");
                            break;
                        }

                        int posicaoSentidoHorario = removeJogadorHorario(listaJogadores, k);
                        int posicaoSentidoAntiHorario = removeJogadorAntiHorario(listaJogadores, m);

                        System.out.print("\t" + listaJogadores.get(posicaoSentidoAntiHorario) + "\t" + listaJogadores.get(posicaoSentidoHorario));

                        if (listaJogadores.get(posicaoSentidoAntiHorario) == listaJogadores.get(posicaoSentidoHorario)) {
                            System.out.println("Jogador " + listaJogadores.get(posicaoSentidoHorario) + "ganhou o brinde");
                        } else if (!listaJogadores.isEmpty()) {
                            if (posicaoSentidoHorario != -1) {
                                listaJogadores.remove(posicaoSentidoHorario);
                            }
                            if (posicaoSentidoAntiHorario != -1) {
                                listaJogadores.remove(posicaoSentidoAntiHorario);
                            }

                        } else {
                            System.out.println("Não tiveram ganhadores");
                        }
                    }
                } else {
                    System.out.println("Valor de jogadores inválido!");
                    break;
                }
            }
        } while (N != 0 && k != 0 && m != 0);

        System.out.println(N + " " + " " + k + " " + m);
    }

    public static LinkedList<Integer> montaLista(int N) {
        LinkedList<Integer> lista = new LinkedList<Integer>();

        // metodo para escolher aleatorio a primeira posicao
        Random random = new Random();
        int primeiro = random.nextInt(N);

        for (int i = 1; i <= N; i++) {
            lista.add(i);
        }

        // laco para deixar a lista com a posicao correta de cada jogador
        for (int i = 1; i <= N; i++) {
            if (i != primeiro) {
                lista.addLast(i);
                lista.removeFirst();
            } else
                break;
        }

        System.out.println(lista);
        return lista;
    }

    public static int removeJogadorHorario(LinkedList lista, int k) {
        for (int i = 0; i < lista.size(); i++) {
            if (i == k - 1)
                return i;
        }
        return -1;
    }

    public static int removeJogadorAntiHorario(LinkedList lista, int m) {
        for (int i = lista.size(); i >= 0; i--) {
            if (i == m - 1)
                return i;
        }
        return -1;
    }
}