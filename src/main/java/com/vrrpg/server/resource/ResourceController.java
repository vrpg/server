package com.vrrpg.server.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
class ResourceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    private final ResourceManager resourceManager;

    ResourceController(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/resources/{resource_name}.{extension}")
    @ResponseBody
    Resource load(@PathVariable("resource_name") String resourceName, @PathVariable("extension") String extension) {
        LOGGER.trace("load - {}, {}", resourceName, extension);
        return resourceManager.getResource(resourceName + "." + extension);
    }
    }
}
