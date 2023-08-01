package keyclaoktest.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import keyclaoktest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/hotelManagers")
@Transactional
public class HotelManagerController {

    @Autowired
    HotelManagerRepository hotelManagerRepository;

    @RequestMapping(
        value = "hotelManagers/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public HotelManager manageHotelInfo(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /hotelManager/manageHotelInfo  called #####");
        Optional<HotelManager> optionalHotelManager = hotelManagerRepository.findById(
            id
        );

        optionalHotelManager.orElseThrow(() -> new Exception("No Entity Found")
        );
        HotelManager hotelManager = optionalHotelManager.get();
        hotelManager.manageHotelInfo();

        hotelManagerRepository.save(hotelManager);
        return hotelManager;
    }
}
