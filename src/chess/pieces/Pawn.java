package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position inicial = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            inicial.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }
            inicial.setValues(position.getRow() - 2, position.getColumn());
            Position inicial2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial) && getBoard().positionExists(inicial2) && !getBoard().thereIsAPiece(inicial2) && getMoveCount() == 0) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }
            inicial.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }
            inicial.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }

            //specialmove - en passant white
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        }
        else {
            inicial.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }
            inicial.setValues(position.getRow() + 2, position.getColumn());
            Position inicial2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial) && getBoard().positionExists(inicial2) && !getBoard().thereIsAPiece(inicial2) && getMoveCount() == 0) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }
            inicial.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }
            inicial.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
                mat[inicial.getRow()][inicial.getColumn()] = true;
            }

            //specialmove - en passant black
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
