package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece peca = (ChessPiece)getBoard().piece(position);
        return peca == null || peca.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position peca = new Position(0, 0);

        //acima
        peca.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        //abaixo
        peca.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        //esquerda
        peca.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        //direita
        peca.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        //noroeste
        peca.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        //nordeste
        peca.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        //sudoeste
        peca.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        //sudeste
        peca.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(peca) && canMove(peca)) {
            mat[peca.getRow()][peca.getColumn()] = true;
        }

        return mat;
    }
}
