package boardgame;

public class Board {

	
	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Tabuleiro tem que ser maior que 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public int getRows() {
		return this.rows;
	}

	
	public int getColumns() {
		return this.columns;
	}

		
	public Piece piece(int row, int column) {
		if(!essaPosicaoExiste(row,column)) {
			throw new BoardException("Esta posição não existe no tabuleiro");
		}
		return pieces[row][column];
	} 
	
	public Piece piece(Position position) {
		if(!essaPosicaoExiste(position)) {
			throw new BoardException("Esta posição não existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void colocarPieceNumaPosicao(Piece piece, Position position) {
		if(temPecaNestaPosicao(position)) {
			throw new BoardException("Já existe uma peça nesta posição " +position);
		}
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removerPieceNumaPosicao(Position position) {
		if(!essaPosicaoExiste(position)) {
			throw new BoardException("Esta posição não existe no tabuleiro");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		this.pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	 
	private boolean essaPosicaoExiste(int row, int column) {
		return row >= 0 && row < this.rows && column >=0 && column < this.columns;
		
	}
	
	public boolean essaPosicaoExiste(Position position) {
		return essaPosicaoExiste(position.getRow(), position.getColumn()) ;
		
	}
	
	public boolean temPecaNestaPosicao(Position position) {
		if(!essaPosicaoExiste(position)) {
			throw new BoardException("Esta posição não existe no tabuleiro");
		}
		return piece(position) != null;
		
	}
}
