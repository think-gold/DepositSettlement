import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepositStorage {
    private Map<SailingClub, Double> mapOfClubsAndDeposit = new HashMap<>();  //mapa zawierająca kluby i wysokość depozytu

    public void allocateDepositToClub(Deposit deposit) {  //przypisuje do mapy klub i depozyt
    mapOfClubsAndDeposit.put(deposit.getSailingClub(), deposit.getCurrentDeposit());
    }

    public Map<SailingClub, Double> getMapOfClubsAndDeposit() {
        return mapOfClubsAndDeposit;
    } //zwraca listę klubów i wysokości depozytu


}
