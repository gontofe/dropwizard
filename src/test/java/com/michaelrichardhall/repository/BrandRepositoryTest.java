package com.michaelrichardhall.repository;

import com.michaelrichardhall.core.Brand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BrandRepositoryTest {

    private BrandRepository repository = new BrandRepository(brandList());

    @Test
    void findAll() {
        List<Brand> brands = repository.findAll(2);

        assertEquals(brandList(), brands);
    }

    @Test
    void findAllButActuallyFindOne() {
        List<Brand> brands = repository.findAll(1);

        assertEquals(List.of(new Brand(1L, "Brand 1")), brands);
    }

    @Test
    void findById() {
        Optional<Brand> brand = repository.findById(1L);

        assert(brand.isPresent());
        assertEquals(new Brand(1L, "Brand 1"), brand.get());
    }

    private List<Brand> brandList() {
        return List.of(new Brand(1L, "Brand 1"), new Brand(2L, "Brand 2"));
    }
}