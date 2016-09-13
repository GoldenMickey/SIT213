package transmetteurs;

import sources.*;
import destinations.*;
import information.*;

import java.util.*;

/** 
 * Classe Abstraite d'un composant transmetteur d'informations dont
 * les éléments sont de type R en entrée et de type E en sortie;
 * l'entrée du transmetteur implémente l'interface
 * DestinationInterface, la sortie du transmetteur implémente
 * l'interface SourceInterface
 * @author prou
 */
public class TransmetteurParfait extends Transmetteur<Boolean, Boolean> {

    public TransmetteurParfait() {
       destinationsConnectees = new LinkedList <DestinationInterface <Boolean>> ();
       informationRecue = null;
       informationEmise = null;
   }

    /**
     * reçoit une information.  Cette méthode, en fin d'exécution,
     * appelle la méthode émettre.
     * @param information  l'information  reçue
     */
    public void recevoir(Information <Boolean> information) throws InformationNonConforme {
        this.informationRecue = information;
        this.emettre();
    }

    /**
     * émet l'information construite par le transmetteur
     */
    public void emettre() throws InformationNonConforme {
        // émission vers les composants connectés
        for (DestinationInterface <Boolean> destinationConnectee : destinationsConnectees) {
            destinationConnectee.recevoir(informationRecue);
        }

        this.informationEmise = informationRecue;
    }  
}
