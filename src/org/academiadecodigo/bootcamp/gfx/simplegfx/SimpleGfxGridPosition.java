package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Picture pic;
    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){

        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid, 0);
    }

    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){

        super(col, row, grid,0);
        simpleGfxGrid = grid;

            pic = new Picture((col * grid.getCellSize()) + grid.getX(), (row * grid.getCellSize()) + grid.getY(), "D:\\projects\\amazing game versão hugo\\resources\\car.jpg");

        }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid, int type){

        super(col, row, grid,type);
        simpleGfxGrid = grid;
        if(type == 0) {
            pic = new Picture((col * grid.getCellSize()) + grid.getX(), (row * grid.getCellSize()) + grid.getY(), "/Users/codecadet/Desktop/amazing game project/amazing game 2 objectos/resources/goku small.jpg");
        }else if(type == 1) {
            pic = new Picture((col * grid.getCellSize()) + grid.getX(), (row * grid.getCellSize()) + grid.getY(), "/Users/codecadet/Desktop/amazing game project/amazing game 2 objectos/resources/rsz_frieza.bmp");

        }

        pic.draw();
        //rectangle = new Rectangle((col*grid.getCellSize()) + grid.getX(), (row*grid.getCellSize()) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        //rectangle.draw();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {

        //rectangle.fill();
        pic.draw();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        //rectangle.delete();
        pic.delete();

    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        super.moveInDirection(direction, distance);
        int x = simpleGfxGrid.columnToX(getCol()) - pic.getX();
        int y = simpleGfxGrid.rowToY(getRow()) - pic.getY();
        pic.translate(x, y);

    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        super.setColor(color);
      //  rectangle.setColor(SimpleGfxColorMapper.getColor(color));

    }
}
