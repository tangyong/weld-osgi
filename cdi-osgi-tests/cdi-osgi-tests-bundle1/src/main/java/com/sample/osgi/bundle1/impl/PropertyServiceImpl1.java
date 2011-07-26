package com.sample.osgi.bundle1.impl;

import com.sample.osgi.bundle1.api.PropertyService;
import org.osgi.cdi.api.extension.annotation.Publish;

@Publish
public class PropertyServiceImpl1 implements PropertyService {

    private String name;

    public PropertyServiceImpl1() {
        name = getClass().getName();
    }

    @Override
    public String whoAmI() {
        return name;
    }
}
