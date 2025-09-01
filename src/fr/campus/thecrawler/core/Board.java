package fr.campus.thecrawler.core;


import java.util.List;
import java.util.ArrayList;
import fr.campus.thecrawler.equipment.DefensiveEquipment;
import fr.campus.thecrawler.Enemies.Goblin;
import fr.campus.thecrawler.Enemies.Sorcier;
import fr.campus.thecrawler.Enemies.Dragon;
import fr.campus.thecrawler.equipment.OffensiveEquipment;



public class Board {
    private final List<Cell> cells = new ArrayList<>();

    public Board() {

        cells.add(new EmptyCell());
        cells.add(new EnemyCell(new Goblin()));
        cells.add(new OffensiveCell(new OffensiveEquipment("Weapon", "Epée", 5)));
        cells.add(new DefensiveCell(new DefensiveEquipment("Potion de vie standard", "Potion standard", 2)));
    }
    public Board(int numCells) {
        if (numCells < 1) {
            throw new IllegalArgumentException("numCells doit être >= 1");
        }
        for (int i = 0; i < numCells; i++) {
            cells.add(new EmptyCell());
        }
    }

    public int getNumCells() {
        return cells.size();
    }
    public Cell getCellAt(int position1Based) {
        return cells.get(position1Based - 1);
    }



}






/*
        private int numCells;

        public Board(int numCells) {
            this.numCells = numCells;
        }

        public int getNumCells() {
            return numCells;
        }
    }

*/


/*
public class Board {
    private int numCells;

    public Board (int numCells) {
        this.numCells = numCells;

    }

    public int getNumCells() {
        return numCells;
    }

}
*/