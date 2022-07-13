package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
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
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
