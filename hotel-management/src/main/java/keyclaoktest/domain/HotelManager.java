package keyclaoktest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import keyclaoktest.HotelManagementApplication;
import keyclaoktest.domain.RegisterHotel;
import lombok.Data;

@Entity
@Table(name = "HotelManager_table")
@Data
public class HotelManager {

    @Id
    private String name;

    private File image;

    private Money price;

    @PostPersist
    public void onPostPersist() {
        RegisterHotel registerHotel = new RegisterHotel(this);
        registerHotel.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static HotelManagerRepository repository() {
        HotelManagerRepository hotelManagerRepository = HotelManagementApplication.applicationContext.getBean(
            HotelManagerRepository.class
        );
        return hotelManagerRepository;
    }

    public void manageHotelInfo() {
        //implement business logic here:

        ManageHotelInfo manageHotelInfo = new ManageHotelInfo(this);
        manageHotelInfo.set(manageHotelInfoCommand.get());
        manageHotelInfo.publishAfterCommit();
    }
}
