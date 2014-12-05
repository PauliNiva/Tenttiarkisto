package tenttiarkisto.tags;

import java.util.Collections;
import java.util.List;
import tenttiarkisto.domain.Tentti;

public final class TenttiSort {

    public static List<Tentti> sortByDate(List<Tentti> tenttiList) {
        Collections.sort(tenttiList);
        return tenttiList;
    }
}
