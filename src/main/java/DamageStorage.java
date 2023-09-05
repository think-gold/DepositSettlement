import java.util.ArrayList;
import java.util.List;

public class DamageStorage {
    private List<Damage> listOfDamages = new ArrayList<>();

    public void addDamageToTheList(Damage newDamage){
        listOfDamages.add(newDamage);
    }
    public List<Damage> getListOfDamages(){
        return listOfDamages;
    }
}
