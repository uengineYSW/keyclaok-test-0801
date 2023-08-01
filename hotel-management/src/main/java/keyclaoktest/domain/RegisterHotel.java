package keyclaoktest.domain;

import java.util.*;
import keyclaoktest.domain.*;
import keyclaoktest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class RegisterHotel extends AbstractEvent {

    public RegisterHotel(HotelManager aggregate) {
        super(aggregate);
    }

    public RegisterHotel() {
        super();
    }
}
