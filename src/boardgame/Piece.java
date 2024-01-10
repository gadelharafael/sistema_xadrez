package boardgame;

import java.util.Iterator;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	// todos movimentos possiveis de uma dada peca
	public abstract boolean[][] possiveisMovimentos();

	public boolean possibilidadeMoverPeca(Position position) {
		return possiveisMovimentos()[position.getRow()][position.getColumn()];
	}

	public boolean existeMovimentoPossivelParaPeca() {
		boolean[][] mat = possiveisMovimentos();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
