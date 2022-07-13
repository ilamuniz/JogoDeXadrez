package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMove(Position position) {
        ChessPiece peca = (ChessPiece)getBoard().piece(position);
        return peca == null || peca.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position peca = new Position(0, 0);

        peca.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        peca.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        peca.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        peca.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        peca.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        peca.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        peca.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        peca.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        return mat;
    }
}
