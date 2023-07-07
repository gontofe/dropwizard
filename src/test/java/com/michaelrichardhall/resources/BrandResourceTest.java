package com.michaelrichardhall.resources;

import com.michaelrichardhall.core.Brand;
import com.michaelrichardhall.repository.BrandRepository;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import javax.xml.transform.Result;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(DropwizardExtensionsSupport.class)
class BrandResourceTest {

    private static final BrandRepository repository = mock(BrandRepository.class);
    public static final int DEFAULT_SIZE = 5;

    private List<Brand> brandList;
    private static final ResourceExtension extension = ResourceExtension.builder()
            .addResource(new BrandResource(DEFAULT_SIZE, repository))
            .build();

    @BeforeEach
    void setUp() {
        brandList = List.of(new Brand(1L, "Brand 1"), new Brand(2L, "Brand 2"));
    }
    @AfterEach
    void tearDown() {
        reset(repository);
    }

    @Test
    void getBrands() {
        when(repository.findAll(DEFAULT_SIZE)).thenReturn(brandList);

        List<Brand> response = extension.target("/brands").request().get(new GenericType<List<Brand>>() {});

        assertEquals(brandList, response);
    }

    @Test
    void getBrandsLimit1() {
        when(repository.findAll(1)).thenReturn(List.of(brand1()));

        List<Brand> response = extension.target("/brands").queryParam("size", "1").request().get(new GenericType<List<Brand>>(){});

        assertEquals(List.of(brand1()), response);
    }

    @Test
    void getById() {
        when(repository.findById(1L)).thenReturn(Optional.of(brand1()));

        Brand response = extension.target("/brands/1").request().get(Brand.class);

        assertEquals(brand1(), response);
    }

    @Test
    void getByIdNotFound() {
        Response response = extension.target("/brands/1").request().get();

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    private Brand brand1() {
        return new Brand(1L, "Brand 1");
    }
}