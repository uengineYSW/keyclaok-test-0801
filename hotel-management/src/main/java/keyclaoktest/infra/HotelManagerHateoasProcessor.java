package keyclaoktest.infra;

import keyclaoktest.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class HotelManagerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<HotelManager>> {

    @Override
    public EntityModel<HotelManager> process(EntityModel<HotelManager> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
