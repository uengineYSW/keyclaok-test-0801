package keyclaoktest.domain;

import java.util.*;
import keyclaoktest.domain.*;
import keyclaoktest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class ViewReservation extends AbstractEvent {

    public ViewReservation(Hotel aggregate) {
        super(aggregate);
    }

    public ViewReservation() {
        super();
    }
}
