package keyclaoktest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import keyclaoktest.HotelReservationApplication;
import keyclaoktest.domain.CancelReservation;
import keyclaoktest.domain.HotelSearch;
import keyclaoktest.domain.RoomReservation;
import keyclaoktest.domain.ViewHotelDetails;
import keyclaoktest.domain.ViewReservation;
import lombok.Data;

@Entity
@Table(name = "Hotel_table")
@Data
public class Hotel {

    @Id
    private String name;

    private String location;

    @ElementCollection
    private List<String> roomTypes;

    private roomTypesType roomTypesType;

    @ElementCollection
    private List<Date> availableDates;

    private Money price;

    @PostPersist
    public void onPostPersist() {
        HotelSearch hotelSearch = new HotelSearch(this);
        hotelSearch.publishAfterCommit();

        ViewHotelDetails viewHotelDetails = new ViewHotelDetails(this);
        viewHotelDetails.publishAfterCommit();

        RoomReservation roomReservation = new RoomReservation(this);
        roomReservation.publishAfterCommit();

        ViewReservation viewReservation = new ViewReservation(this);
        viewReservation.publishAfterCommit();

        CancelReservation cancelReservation = new CancelReservation(this);
        cancelReservation.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static HotelRepository repository() {
        HotelRepository hotelRepository = HotelReservationApplication.applicationContext.getBean(
            HotelRepository.class
        );
        return hotelRepository;
    }
}
