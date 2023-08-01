package keyclaoktest.domain;

import java.util.*;
import keyclaoktest.domain.*;
import keyclaoktest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class CancelReservation extends AbstractEvent {

    public CancelReservation(Hotel aggregate) {
        super(aggregate);
    }

    public CancelReservation() {
        super();
    }
}
