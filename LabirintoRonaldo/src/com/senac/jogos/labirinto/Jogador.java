package com.senac.jogos.labirinto;

public class Jogador extends Personagem {

	private Arma arma;
	private Armadura armadura;
	private Chave chave;

	public Jogador() {
		super(1, 1, 20);
		this.arma = null;
		this.armadura = null;
		this.chave = null;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) throws Exception {
<<<<<<< HEAD
		if (this.arma == null)
=======
		if (this.arma != null)
>>>>>>> LP2-T3-2
			throw new Exception("Seu player tem uma arma");
		this.arma = arma;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) throws Exception {
<<<<<<< HEAD
		if (this.armadura == null)
=======
		if (this.armadura != null)
>>>>>>> LP2-T3-2
			throw new Exception("Seu player tem uma armadura");
		this.armadura = armadura;
	}

	public Chave getChave() {
		return chave;
	}

<<<<<<< HEAD
	public void setChave(Chave chave) throws Exception {
		if (this.arma == null)
			throw new Exception("Seu player tem uma chave");
		this.chave = chave;
	}

=======
	public void setChave(Chave chave) throws Exception
	{
		if (this.arma != null)
			throw new Exception("Jogador ja possui uma chave.");
		this.chave = chave;
	}
	@Override
>>>>>>> LP2-T3-2
	public int getAtaque() {
		int bonus = 0;
		if (arma != null)
			bonus += arma.getDano();
		return ataque + bonus;
	}
<<<<<<< HEAD
	
=======
	@Override
>>>>>>> LP2-T3-2
	public void setDano(int value) {
		int total = value - resistencia;
		if (armadura != null)
			total -= armadura.getResistencia();
		vida -= total;
	}

	public void matarJogador() {
		this.vida = 0;
	}

<<<<<<< HEAD
	public void matarArmadura() {
		this.armadura = null;
	}

	public void matarArma() {
		this.arma = null;
	}

	public void matarChave() {
=======
	public void soltarArmadura() {
		this.armadura = null;
	}

	public void soltarArma() {
		this.arma = null;
	}

	public void soltarChave() {
>>>>>>> LP2-T3-2
		this.chave = null;
	}

	public String toString() {
		int ataq = 0;
		ataq = ataque;

		int defesa = 0;
		defesa = resistencia;

		if (armadura != null) {
			defesa += armadura.getResistencia();
		}

		if (arma != null) {
			ataq += arma.getDano();
		}

<<<<<<< HEAD
		return "Jogador" + "\nVida: " + vida + "\nAtaque: " + ataq
=======
		return "JOGADOR" + "\nVida: " + vida + "\nAtaque: " + ataq
>>>>>>> LP2-T3-2
				+ "\nDefesa: " + defesa;
	}
}
