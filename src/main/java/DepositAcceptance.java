

import java.util.HashMap;
import java.util.Map;

public class DepositAcceptance {        //przyjęcie zgłoszenia
    private static final double ENTRY_DEPOSIT_VALUE = 15000d;       //Depozyt obowiązakowy przy zgłoszeniu
    private Map<SailingClub, Double> mapOfClubsAndDeposit = new HashMap<>();  //mapa zawierająca kluby i wysokość depozytu

    public void allocateDepositToClubs(SailingClub club, boolean isDepositPayed) {  //sprawdza, czy przy zgłoszeniu został opłacony depozyt i tworzy aktualną mapę
        if (isDepositPayed) mapOfClubsAndDeposit.put(club, ENTRY_DEPOSIT_VALUE);
        else mapOfClubsAndDeposit.put(club, 0d);
    }

    public Map<SailingClub, Double> getMapOfClubsAndDeposit() {
        return mapOfClubsAndDeposit;
    } //pobiera listę klubów i wysokości depozytu

    public void updateEntry(SailingClub club) {                                         //opcja, gdy klub najpierw się zgłasza, a pózniej opłaca depozyt
        for (Map.Entry<SailingClub, Double> set : mapOfClubsAndDeposit.entrySet()) {
            if (set.getKey().equals(club)) set.setValue(ENTRY_DEPOSIT_VALUE);
        }
    }
}

