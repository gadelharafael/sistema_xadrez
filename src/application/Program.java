package application;

import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Posicao de Origem: ");
			ChessPosition posicaoOrigem = UI.lerPosicaoTabuleiro(sc);
			
			System.out.println();
			System.out.print("Posicao de Destino: ");
			ChessPosition posicaoDestino = UI.lerPosicaoTabuleiro(sc);
			
			ChessPiece pecaCapturada = chessMatch.movendoPecaTabuleiro(posicaoOrigem, posicaoDestino);
		}
		

	
	}

}
