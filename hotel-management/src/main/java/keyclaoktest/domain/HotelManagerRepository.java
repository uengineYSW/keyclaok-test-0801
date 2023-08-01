package keyclaoktest.domain;

import keyclaoktest.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "hotelManagers",
    path = "hotelManagers"
)
public interface HotelManagerRepository
    extends PagingAndSortingRepository<HotelManager, String> {}
