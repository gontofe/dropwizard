package com.michaelrichardhall;

import com.michaelrichardhall.configuration.BasicConfiguration;
import com.michaelrichardhall.core.Brand;
import com.michaelrichardhall.repository.BrandRepository;
import com.michaelrichardhall.resources.BrandResource;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.util.ArrayList;
import java.util.List;

public class IntroductionApplication extends Application<BasicConfiguration> {

    public static void main(String[] args) throws Exception {
        new IntroductionApplication().run("server", "introduction-config.yml");
    }
    @Override
    public void run(BasicConfiguration basicConfiguration, Environment environment) throws Exception {
        int defaultSize = basicConfiguration.getDefaultSize();
        BrandRepository brandRepository = new BrandRepository(initBrands());
        BrandResource brandResource = new BrandResource(defaultSize, brandRepository);

        environment
                .jersey()
                .register(brandResource);
    }

    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }

    private List<Brand> initBrands() {
        final List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1L, "Brand1"));
        brands.add(new Brand(2L, "Brand2"));
        brands.add(new Brand(3L, "Brand3"));

        return brands;
    }
}
