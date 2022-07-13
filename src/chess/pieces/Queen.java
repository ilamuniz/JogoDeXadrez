package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position inicial = new Position(0, 0);

        //acima
        inicial.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setRow(inicial.getRow() - 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        //abaixo
        inicial.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setRow(inicial.getRow() + 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        //esquerda
        inicial.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setColumn(inicial.getColumn() - 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        //direita
        inicial.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setColumn(inicial.getColumn() + 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        //noroeste
        inicial.setValues(position.getRow() - 1, position.getColumn() -1);
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setValues(inicial.getRow() -1, inicial.getColumn() - 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        //nordeste
        inicial.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setValues(inicial.getRow() - 1, inicial.getColumn() + 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        //sudeste
        inicial.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setValues(inicial.getRow() + 1, inicial.getColumn() + 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        //sudoeste
        inicial.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(inicial) && !getBoard().thereIsAPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
            inicial.setValues(inicial.getRow() + 1, inicial.getColumn() - 1);
        }
        if (getBoard().positionExists(inicial) && isThereOpponentPiece(inicial)) {
            mat[inicial.getRow()][inicial.getColumn()] = true;
        }

        return mat;
    }
}