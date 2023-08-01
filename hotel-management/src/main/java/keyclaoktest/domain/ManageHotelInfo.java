package keyclaoktest.domain;

import java.util.*;
import keyclaoktest.domain.*;
import keyclaoktest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class ManageHotelInfo extends AbstractEvent {

    public ManageHotelInfo(HotelManager aggregate) {
        super(aggregate);
    }

    public ManageHotelInfo() {
        super();
    }
}
