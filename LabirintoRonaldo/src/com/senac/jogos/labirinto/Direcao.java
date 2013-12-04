package com.senac.jogos.labirinto;

public enum Direcao {
	NORTE("North", 0), 
	SUL("South", 1), 
	LESTE("East", 2), 
	OESTE("West", 3), 
	ACIMA("Up", 4), 
	ABAIXO("Down", 5);

	private String name;
	private int index;

	public static Direcao converte(String dir) throws Exception {
		if (dir.equalsIgnoreCase("north") || dir.equalsIgnoreCase("norte"))
			return NORTE;
		if (dir.equalsIgnoreCase("south") || dir.equalsIgnoreCase("sul"))
			return SUL;
		if (dir.equalsIgnoreCase("east") || dir.equalsIgnoreCase("leste"))
			return LESTE;
		if (dir.equalsIgnoreCase("west") || dir.equalsIgnoreCase("oeste"))
			return OESTE;
		if (dir.equalsIgnoreCase("up") || dir.equalsIgnoreCase("acima"))
			return ACIMA;
		if (dir.equalsIgnoreCase("down") || dir.equalsIgnoreCase("abaixo"))
			return ABAIXO;
		throw new Exception("Direcao invalida.");
	}

	private Direcao(String s, int i) {
		this.name = s;
		this.index = i;
	}

	public int getIndex() {
		return this.index;
	}

	public String toString() {
		return name;
	}

	public static Direcao converte(int direcao) throws Exception {
		switch (direcao) {
		case 0:
			return NORTE;
		case 1:
			return SUL;
		case 2:
			return LESTE;
		case 3:
			return OESTE;
		case 4:
			return ACIMA;
		case 5:
			return ABAIXO;
		}
		throw new Exception("Direcao invalida.");
	}
}
