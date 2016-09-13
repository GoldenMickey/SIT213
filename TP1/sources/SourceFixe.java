package sources;

import information.*;
import destinations.DestinationInterface;
import java.util.*;

/** 
 * Classe Abstraite d'un composant source d'informations dont les
 * éléments sont de type T
 * @author prou
 */
public class SourceFixe <T> extends Source <T> {
   
    /** 
     * la liste des composants destination connectés
     */
    // protected LinkedList <DestinationInterface <T>> destinationsConnectees;
   
    /** 
     * l'information générée par la source
     */
    // protected Information <T>  informationGeneree;
   	
    /** 
     * l'information émise par la source
     */
    // protected Information <T>  informationEmise;
   	
    /** 
     * un constructeur factorisant les initialisations communes aux
     * réalisations de la classe abstraite Source
     */
    public SourceFixe (T [] mess) {
    	destinationsConnectees = new LinkedList <DestinationInterface <T>> ();
    	informationGeneree = new Information<T>(mess);
    	informationEmise = null;
    }
   
    /**
     * émet l'information générée
     */
    public void emettre() throws InformationNonConforme {
       	// émission vers les composants connectés
    	for (DestinationInterface <T> destinationConnectee : destinationsConnectees) {
                destinationConnectee.recevoir(informationGeneree);
    	}
    	this.informationEmise = informationGeneree;   			 			      
    }
}
