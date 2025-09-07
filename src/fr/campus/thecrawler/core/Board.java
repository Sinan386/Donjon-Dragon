package fr.campus.thecrawler.core;


import java.util.List;
import java.util.ArrayList;
import fr.campus.thecrawler.equipment.DefensiveEquipment;
import fr.campus.thecrawler.Enemies.Goblin;
import fr.campus.thecrawler.Enemies.Sorcier;
import fr.campus.thecrawler.Enemies.Dragon;
import fr.campus.thecrawler.equipment.OffensiveEquipment;
import fr.campus.thecrawler.equipment.DefensiveEquipment;
import fr.campus.thecrawler.equipment.*;




public class Board {
    private final List<Cell> cells = new ArrayList<>();


    public Board() {
        cells.add(new EmptyCell());                        // 1
        cells.add(new EnemyCell(new Goblin()));            // 2
        cells.add(new OffensiveCell(new Epee()));          // 3
        cells.add(new DefensiveCell(new PotionStandard())); // 4
        cells.add(new EnemyCell(new Sorcier()));           // 5
        cells.add(new OffensiveCell(new Massue()));        // 6
        cells.add(new DefensiveCell(new GrandePotion()));  // 7
        cells.add(new EnemyCell(new Dragon()));            // 8
        cells.add(new OffensiveCell(new Eclair()));        // 9
        cells.add(new OffensiveCell(new BouleDeFeu()));    // 10
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