import lombok.Getter;

@Getter
public class SailingClub {
    private String name;
    private EntryDeposit actualEntryDeposit;
    public SailingClub(String name) {
        this.name = name;
    }

}
