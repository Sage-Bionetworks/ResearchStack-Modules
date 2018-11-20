package org.sagebionetworks.research.researchstack_modules;

import org.researchstack.backbone.step.Step;

public class CustomStep extends Step {
    public CustomStep(String id) {
        super(id);
        setStepLayoutClass(CustomStepLayout.class);
    }
}
