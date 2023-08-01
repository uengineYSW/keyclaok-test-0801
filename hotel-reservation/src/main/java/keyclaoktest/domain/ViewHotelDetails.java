package keyclaoktest.domain;

import java.util.*;
import keyclaoktest.domain.*;
import keyclaoktest.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class ViewHotelDetails extends AbstractEvent {

    public ViewHotelDetails(Hotel aggregate) {
        super(aggregate);
    }

    public ViewHotelDetails() {
        super();
    }
}
