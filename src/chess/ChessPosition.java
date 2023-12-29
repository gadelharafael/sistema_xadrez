package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	

	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro no construtor da ChessPosition!Os valores validos são de A1 até H8");
		}
		this.column = column;
		this.row = row;
	}
	
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	
	// linha da MATRIX = 8 - linha XADREZ
	// coluna da MATRIX = 'a' - coluna XADREZ                  *** BIZU de subtraçaode caracteres unicodes
	protected Position conversaoMatrizXADREZemMatrizNORMAL() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition conversaoMatrizNORMALemMatrizXADREZ(Position position) {
		return new ChessPosition((char)(position.getColumn() + 'a') , 8 + position.getRow() );
	}
	
	@Override
	public String toString() {
		return ""+ column+row; 
	}
}
