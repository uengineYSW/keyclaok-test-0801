package keyclaoktest.domain;

import java.util.*;
import keyclaoktest.domain.*;
import keyclaoktest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class RoomReservation extends AbstractEvent {

    public RoomReservation(Hotel aggregate) {
        super(aggregate);
    }

    public RoomReservation() {
        super();
    }
}
