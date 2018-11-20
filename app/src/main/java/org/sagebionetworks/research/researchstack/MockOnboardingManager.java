package org.sagebionetworks.research.researchstack;

import android.content.Context;
import org.researchstack.backbone.ResourcePathManager;
import org.researchstack.backbone.model.survey.SurveyItem;
import org.researchstack.backbone.model.survey.factory.SurveyFactory;
import org.researchstack.backbone.onboarding.OnboardingManager;
import org.researchstack.backbone.step.Step;

import static org.researchstack.backbone.ResourcePathManager.Resource.TYPE_JSON;

public class MockOnboardingManager extends OnboardingManager {
    private boolean isLoginVerified = false;
    private boolean isRegistered = false;
    private boolean hasPasscode = false;

    public MockOnboardingManager(Context context) {
        super(context);
    }


    /**
     * Create custom onboarding steps for Bridge.
     */
    @Override
    public Step createCustomStep(
            Context context, SurveyItem item, boolean isSubtaskStep, SurveyFactory factory) {
        throw new UnsupportedOperationException("Not implemented");
    }

    void setIsLoginVerified(boolean isLoginVerified) {
        this.isLoginVerified = isLoginVerified;
    }

    void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    void setHasPasscode(boolean hasPasscode) {
        this.hasPasscode = hasPasscode;
    }

    boolean isLoginVerified(Context context) {
        return isLoginVerified;
    }

    boolean isRegistered(Context context) {
        return isRegistered;
    }

    boolean hasPasscode(Context context) {
        return hasPasscode;
    }
}