package keyclaoktest.domain;

import keyclaoktest.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository
    extends PagingAndSortingRepository<Hotel, String> {}
