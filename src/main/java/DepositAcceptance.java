import java.util.HashMap;
import java.util.Map;

public class DepositAcceptance {
    private static final double ENTRY_DEPOSIT_VALUE = 15000d;
    private Map<SailingClub, Double> mapOfClubsAndDeposit = new HashMap<>();

    public void allocateDepositToClubs(SailingClub club, boolean isDepositPayed) {
        if (isDepositPayed) mapOfClubsAndDeposit.put(club, ENTRY_DEPOSIT_VALUE);
        else mapOfClubsAndDeposit.put(club, 0d);
    }
    public Map<SailingClub, Double> getMapOfClubsAndDeposit() {
        return mapOfClubsAndDeposit;
    }
}
