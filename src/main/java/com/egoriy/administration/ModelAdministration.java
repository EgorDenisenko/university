package com.egoriy.administration;

import com.egoriy.entity.Model;
import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;

public class ModelAdministration extends AdministrationConfiguration<Model> {

    @Override
    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder.nameField("name").singularName("Model").pluralName("Models").build();
    }
}
