package com.michaelrichardhall;

import com.michaelrichardhall.configuration.BasicConfiguration;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class IntroductionApplication extends Application<BasicConfiguration> {

    public static void main(String[] args) throws Exception {
        new IntroductionApplication().run("server", "introduction-config.yml");
    }
    @Override
    public void run(BasicConfiguration basicConfiguration, Environment environment) throws Exception {
        //register classes
    }

    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }
}
