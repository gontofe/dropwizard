package com.michaelrichardhall.resources;

import com.michaelrichardhall.core.Brand;
import com.michaelrichardhall.repository.BrandRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
public class BrandResource {

    private final int defaultSize;
    private final BrandRepository brandRepository;

    public BrandResource(int defaultSize, BrandRepository brandRepository) {
        this.defaultSize = defaultSize;
        this.brandRepository = brandRepository;
    }

    @GET
    public List<Brand> getBrands(@QueryParam("size") Optional<Integer> size) {
        return brandRepository.findAll(size.orElse())
    }
}
