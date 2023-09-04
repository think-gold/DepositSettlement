import lombok.Getter;

@Getter
public class SailingClub {
    private String name;
    private float actualEntryDeposit;
    public SailingClub(String name) {
        this.name = name;
    }

}
