import lombok.Getter;

@Getter
public class SailingClub {
    private String name;
    private float actualDeposit;
    public SailingClub(String name) {
        this.name = name;
    }

}
