package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// Possibilidade de movimentacao ACIMA no tabuleiro
		p.setarValores(position.getRow() - 1, position.getColumn());
		while (getBoard().essaPosicaoExiste(p) && !getBoard().temPecaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().essaPosicaoExiste(p) && temPecaAdversariaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Possibilidade de movimentacao ABAIXO no tabuleiro
		p.setarValores(position.getRow() + 1, position.getColumn());
		while (getBoard().essaPosicaoExiste(p) && !getBoard().temPecaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}

		if (getBoard().essaPosicaoExiste(p) && temPecaAdversariaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Possibilidade de movimentacao ESQUERDA no tabuleiro
		p.setarValores(position.getRow(), position.getColumn() - 1);
		while (getBoard().essaPosicaoExiste(p) && !getBoard().temPecaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().essaPosicaoExiste(p) && temPecaAdversariaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Possibilidade de movimentacao DIREITA no tabuleiro
		p.setarValores(position.getRow(), position.getColumn() + 1);
		while (getBoard().essaPosicaoExiste(p) && !getBoard().temPecaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().essaPosicaoExiste(p) && temPecaAdversariaNestaPosicao(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}
}
