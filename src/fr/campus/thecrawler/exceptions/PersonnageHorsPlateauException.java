package fr.campus.thecrawler.exceptions;


/**
 * This exception work when the character passes after cells n°64
 */

public class PersonnageHorsPlateauException extends Exception{

    public PersonnageHorsPlateauException(String message) {
        super (message);
    }
}
