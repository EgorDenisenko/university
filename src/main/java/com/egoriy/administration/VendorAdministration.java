package com.egoriy.administration;

import com.egoriy.entity.Vendor;
import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;

public class VendorAdministration extends AdministrationConfiguration<Vendor> {

    @Override
    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder.nameField("name").singularName("Vendor").pluralName("Vendors").build();
    }
}
