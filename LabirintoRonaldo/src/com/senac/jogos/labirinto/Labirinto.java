package com.senac.jogos.labirinto;

import static java.lang.System.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

public class Labirinto {

	private static final Scanner teclado = new Scanner(System.in);

	private Sala[] salas;
	private int countSalas;
	private int salaAtual;
	private Jogador jogador;

	private void run() {
		inicializaLabirinto();
		popularizarLabirinto();

		do {
			out.println();
			exibeStatus();
			executaComando(teclado.nextLine());
		} while (!isGameOver());

		if (!jogador.isAlive()) {
			out.println("Voce Perdeu!");
		} else {
			out.println("Voce Ganhou");
		}

		teclado.close();
	}

<<<<<<< HEAD
=======

>>>>>>> LP2-T3-2
	@SuppressWarnings("resource")
	private void executaComando(String escolha) {
		try {
			Scanner linha = new Scanner(escolha.toLowerCase());
			int cmd = converterComando(linha.next());

			if (!linha.hasNext())
				throw new Exception(
						"COMANDO INCOMPLETO: esta faltando o segundo atributo");

			String s = linha.next();
			while (linha.hasNext())
				s += " " + linha.next();

			s = s.toLowerCase();

			switch (cmd) {
			case 1:
				cmdMover(s);
				break;
			case 2:
				cmdOlhar(s);
				break;
			case 3:
				cmdAtacar(s);
				break;
			case 4:
				cmdSoltarItem(s);
				break;
			case 5:
				cmdPegarItem(s);
				break;
			}

		} catch (Exception e) {
			err.println(e.getMessage());
			return;
		}
	}

	private void cmdPegarItem(String item) throws Exception {
		Sala sala = salas[salaAtual];
<<<<<<< HEAD

		List<Item> itens = sala.getItens();
		for (Item i : itens) {
			if (item.equalsIgnoreCase(i.getDescricao())) {
				if (i instanceof Chave)
					jogador.setChave((Chave) i);
				if (i instanceof Arma)
					jogador.setArma((Arma) i);
				if (i instanceof Armadura)
					jogador.setArmadura((Armadura) i);

=======
		
		List<Item> itens = sala.getItens();
		for(Item i : itens){
			if(item.equalsIgnoreCase(i.getDescricao())){
				if(i instanceof Chave)
					jogador.setChave((Chave) i);
				if(i instanceof Arma)
					jogador.setArma((Arma) i);
				if(i instanceof Armadura)
					jogador.setArmadura((Armadura) i);
				
>>>>>>> LP2-T3-2
				itens.remove(i);
				return;
			}
		}
<<<<<<< HEAD

=======
		
>>>>>>> LP2-T3-2
		throw new Exception("Item invalido");
	}

	private void cmdSoltarItem(String item) throws Exception {
		Sala sala = salas[salaAtual];
		List<Item> itens = sala.getItens();

		if (item.equals("chave")) {
			itens.add(jogador.getChave());
<<<<<<< HEAD
			jogador.matarChave();

		} else if (item.equals("arma")) {
			itens.add(jogador.getArma());
			jogador.matarArma();

		} else if (item.equals("armadura")) {
			itens.add(jogador.getArmadura());
			jogador.matarArmadura();
=======
			jogador.soltarChave();

		} else if (item.equals("arma")) {
			itens.add(jogador.getArma());
			jogador.soltarArma();

		} else if (item.equals("armadura")) {
			itens.add(jogador.getArmadura());
			jogador.soltarArmadura();
>>>>>>> LP2-T3-2

		} else
			throw new Exception("Item invalido");
	}

	private void cmdAtacar(String s) throws Exception {
		Conexao conexao = getConexao(s);
		Inimigo inimigo = conexao.getInimigo();

		if (inimigo == null)
			throw new Exception("Sem inimigos no ataque");

		if (inimigo instanceof Armadilha) {
			if (Range.getPercentual() >= 80) {
				conexao.setInimigo(null);
				out.println("Armadilha desfeita!");
			} else {
				jogador.setDano(2 + jogador.getArmadura().getResistencia());
				out.println("FALHOU: a armadilha nao pode ser desarmada - 2pts de danos sofreu o jogador");
			}
		} else {
			atacarInimigo(inimigo);
			atacarJogador(inimigo);
			if (!inimigo.isAlive()) {
				out.println("Voce derrotou o " + inimigo + "\n");
				conexao.setInimigo(null);
			}
		}
	}

	private void atacarInimigo(Inimigo inimigo) {
		if (Range.getPercentual() >= 20) {
			int ataque = jogador.getAtaque();
			inimigo.setDano(ataque);
			out.println("O " + inimigo + " recebeu " + ataque + " em danos.");
		} else {
			out.println("O " + inimigo + " conseguiu se defender.");
		}
	}

	private void atacarJogador(Inimigo inimigo) {
		if (Range.getPercentual() >= 40) {
			int ataque = inimigo.getAtaque();
			jogador.setDano(ataque);
			out.println("O jogador recebeu " + (ataque) + " em danos do "
					+ inimigo);
			out.println(jogador);
		} else {
			out.println("O jogador conseguiu se defender no ataque do "
					+ inimigo);
		}
	}


	private void cmdOlhar(String direcao) throws Exception {
		Conexao conexao = getConexao(direcao);

		out.println(conexao.getInfo());
<<<<<<< HEAD
=======
		out.println("\nSTATUS "+jogador);
>>>>>>> LP2-T3-2
	}

	private void cmdMover(String direcao) throws Exception {
		Conexao conexao = getConexao(direcao);

		Inimigo inimigo = conexao.getInimigo();
		if (inimigo != null) {
			if (inimigo instanceof Armadilha) {
				jogador.matarJogador();

				throw new Exception(
						"O jogador infelizmente caiu em uma armadilha e morreu.");
			} else {
				throw new Exception("O jogador tem que vencer o " + inimigo
						+ " para poder prosseguir no labirinto.");
			}
		}

		Cor porta = conexao.getCor();
		if (porta != Cor.MARROM) {
			Chave chave = jogador.getChave();
			if (chave == null || chave.getCor() != porta)
				throw new Exception("O jogador necessita da chave: " + porta
						+ " para poder prosseguir");
		}

		salaAtual = conexao.getSala();
	}

	private boolean isGameOver() {
		if (!jogador.isAlive())
			return true;

		if (salaAtual == 0)
			return true;

		return false;
	}

	private Conexao getConexao(String direc) throws Exception {
		Direcao direcao = Direcao.converte(direc);
		Sala sala = salas[salaAtual];
		Conexao conexao = sala.getConexao(direcao);
		if (conexao == null)
			throw new Exception("--- Direcao Invalida ---");

		return conexao;
	}

	private static int converterComando(String cmd) throws Exception {
		cmd = cmd.toLowerCase();
		if (cmd.equals("mover"))
			return 1;
		if (cmd.equals("olhar"))
			return 2;
		if (cmd.equals("atacar"))
			return 3;
		if (cmd.equals("largar"))
			return 4;
		if (cmd.equals("pegar"))
			return 5;
		throw new Exception("Comando " + cmd + " nao e valido");
	}

	private void exibeStatus() {

<<<<<<< HEAD
=======
		out.println("SALA ATUAL "+salaAtual);
>>>>>>> LP2-T3-2
		out.println(salas[salaAtual]);

	}

	private void inicializaLabirinto() {

		salas = new Sala[50];
		salas[0] = new Sala();
		countSalas = 0;
		jogador = new Jogador();

		try {
			leLabirinto(new Scanner(new FileInputStream("labirinto.txt")));
		} catch (Exception e) {
			err.println(e.getMessage());
			exit(1);
		}

		salaAtual = getRandomRoom();
	}

	private void leLabirinto(Scanner arquivo) throws Exception {
		String cmd = arquivo.next().toLowerCase();
		while (cmd.equals("room")) {
			int salaId = arquivo.nextInt();
			salas[salaId] = new Sala();
			Sala sala = salas[salaId];
			countSalas++;

			String direcao = arquivo.next();

			do {
				if (arquivo.hasNextInt()) {
					salaId = arquivo.nextInt();
				} else if (arquivo.next().equalsIgnoreCase("EXIT")) {
					salaId = 0;
				} else
					break;

				sala.addConexao(direcao, salaId);

				if (!arquivo.hasNext())
					return;
				cmd = arquivo.next().toLowerCase();
				if (cmd.equals("trap")) {
					sala.setArmadilha(direcao);
					if (!arquivo.hasNext())
						return;
					cmd = arquivo.next();
				}
				direcao = cmd;
			} while (!cmd.equals("room"));
		}
		throw new Exception("Arquivo de descricao do labirinto invalido.");
	}

	private void popularizarLabirinto() {
		Inimigo[] inimigos = Labirinto.criarInimigos();
		Chave[] chaves = Labirinto.criarChaves();
		Arma[] armas = Labirinto.criarArmas();
		Armadura[] armaduras = Labirinto.criarArmaduras();

		for (Armadura item : armaduras) {
			salas[getRandomRoom()].addItem(item);
		}
		for (Arma item : armas) {
			salas[getRandomRoom()].addItem(item);
		}
		for (Chave item : chaves) {
			salas[getRandomRoom()].addItem(item);
		}
		for (Inimigo inimigo : inimigos) {
			getRndConexaoSemInimigos().setInimigo(inimigo);
		}
	}

	
	private Conexao getRndConexaoSemInimigos() {
		do {
			Sala sala = salas[getRandomRoom()];
			for (Conexao c : sala.getConexoes()) {
				if (c == null)
					continue;

				if (c.getInimigo() == null) {
					return c;
				}
			}

		} while (true);
	}

	
	private int getRandomRoom() {
		return 1 + (int) (Math.random() * countSalas);
	}

	
	public static Inimigo[] criarInimigos() {
		Inimigo[] inimigos = new Inimigo[15 + 8 + 4];
		for (int i = 0; i < inimigos.length; i++) {
			if (i < 15)
				inimigos[i] = new Inimigo(TipoInimigo.GOBLIN);
			else if (i < 15 + 8)
				inimigos[i] = new Inimigo(TipoInimigo.ORC);
			else
				inimigos[i] = new Inimigo(TipoInimigo.TROLL);
		}
		return inimigos;
	}

	
	public static Chave[] criarChaves() {
		Chave[] chaves = new Chave[4 * 6];
		for (int i = 0; i < chaves.length; i++) {
			if (i < 6)
				chaves[i] = new Chave(Cor.AMARELA);
			else if (i < 12)
				chaves[i] = new Chave(Cor.AZUL);
			else if (i < 18)
				chaves[i] = new Chave(Cor.VERDE);
			else
				chaves[i] = new Chave(Cor.VERMELHA);
		}
		return chaves;
	}

	
	public static Armadura[] criarArmaduras() {
		Armadura[] armaduras = new Armadura[8 + 4 + 1];
		for (int i = 0; i < armaduras.length; i++) {
			if (i < 8)
				armaduras[i] = new Armadura("Armadura de Couro", 1);
			else if (i < 8 + 4)
				armaduras[i] = new Armadura("Armadura de Metal", 2);
			else
				armaduras[i] = new Armadura("Armadura de Mithrill", 3);
		}
		return armaduras;
	}

	
	public static Arma[] criarArmas() {
		Arma[] armas = new Arma[8 + 4 + 1];
		for (int i = 0; i < armas.length; i++) {
			if (i < 8)
				armas[i] = new Arma("Adaga", 1);
			else if (i < 8 + 4)
				armas[i] = new Arma("Faca", 2);
			else
				armas[i] = new Arma("Espada", 4);
		}
		return armas;
	}

	public static void main(String[] args) {
<<<<<<< HEAD
		(new Labirinto()).run();
	}
=======
		out.println(" --COMANDOS--                  --DIRECOES--\n" +
				"MOVER + DIRECAO               NORTE   SUL\n" +
				"ATACAR + DIRECAO              LESTE   OESTE\n" +
				"OLHAR + DIRECAO               ACIMA   ABAIXO\n" +                  
				"PEGAR + NOME DO ITEM\n"+              
				"LARGAR + TIPO DO ITEM");
		(new Labirinto()).run();
	}

	public int getCountSalas() {
		return countSalas;
	}
>>>>>>> LP2-T3-2
}