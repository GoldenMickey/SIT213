package destinations;

import information.*;

/** 
 * Classe Abstraite d'un composant destination d'informations dont les
 * éléments sont de type T
 * @author prou
 */
public class DestinationFinale <T> extends Destination <T> {
    
    /** 
     * l'information reçue par la destination
     */
    protected Information <T>  informationRecue;
    
    /** 
     * un constructeur factorisant les initialisations communes aux
     * réalisations de la classe abstraite Destination
     */
    public DestinationFinale() {
	   informationRecue = null;
    }

    /**
     * retourne la dernière information reçue par la destination
     * @return une information   
     */
    public Information  <T>  getInformationRecue() {
	   return this.informationRecue;
    }
   	    
    /**
     * reçoit une information
     * @param information  l'information  à recevoir
     */
    public void recevoir(Information <T> information) throws InformationNonConforme {
        this.informationRecue = information;
    }  
}
