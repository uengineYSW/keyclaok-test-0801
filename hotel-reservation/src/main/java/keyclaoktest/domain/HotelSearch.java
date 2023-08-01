package keyclaoktest.domain;

import java.util.*;
import keyclaoktest.domain.*;
import keyclaoktest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class HotelSearch extends AbstractEvent {

    public HotelSearch(Hotel aggregate) {
        super(aggregate);
    }

    public HotelSearch() {
        super();
    }
}
