package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public ChessPiece movendoPecaTabuleiro(ChessPosition posicaoOrigem, ChessPosition posicaoDestino) {
		Position origem = posicaoOrigem.conversaoMatrizXADREZemMatrizNORMAL();
		Position destino = posicaoDestino.conversaoMatrizXADREZemMatrizNORMAL();
		validacaoPosicaoOrigem(origem);
		Piece pecaCapturada = movimentarPeca(origem,destino);
		return (ChessPiece) pecaCapturada;
		
	}
	
	private Piece movimentarPeca(Position posicaoOrigem, Position posicaoDestino) {
		Piece p = board.removerPieceNumaPosicao(posicaoOrigem);
		Piece pecaCapiturada = board.removerPieceNumaPosicao(posicaoDestino);
		board.colocarPieceNumaPosicao(p, posicaoDestino);
		return pecaCapiturada;
		
	}
	private void validacaoPosicaoOrigem(Position position) {
		if(!board.temPecaNestaPosicao(position)) {
			throw new ChessException("Não existe peça na posição de origem");
		}
	}

	public void novolugarDaPecaTabuleiroXadrez(char column, int row, ChessPiece chessPiece) {
		board.colocarPieceNumaPosicao(chessPiece, new ChessPosition(column, row).conversaoMatrizXADREZemMatrizNORMAL());
	}

	private void initialSetup() {
		
		novolugarDaPecaTabuleiroXadrez('c', 1, new Rook(board, Color.WHITE));
		novolugarDaPecaTabuleiroXadrez('c', 2, new Rook(board, Color.WHITE));
		novolugarDaPecaTabuleiroXadrez('d', 2, new Rook(board, Color.WHITE));
		novolugarDaPecaTabuleiroXadrez('e', 2, new Rook(board, Color.WHITE));
		novolugarDaPecaTabuleiroXadrez('e', 1, new Rook(board, Color.WHITE));
		novolugarDaPecaTabuleiroXadrez('d', 1, new King(board, Color.WHITE));
		
		novolugarDaPecaTabuleiroXadrez('c', 7, new Rook(board, Color.BLACK));
		novolugarDaPecaTabuleiroXadrez('c', 8, new Rook(board, Color.BLACK));
		novolugarDaPecaTabuleiroXadrez('d', 7, new Rook(board, Color.BLACK));
		novolugarDaPecaTabuleiroXadrez('e', 7, new Rook(board, Color.BLACK));
		novolugarDaPecaTabuleiroXadrez('e', 8, new Rook(board, Color.BLACK));
		novolugarDaPecaTabuleiroXadrez('d', 8, new King(board, Color.BLACK));
		
		
	
	
	}
}
