package org.sagebionetworks.research.researchstack;

import org.researchstack.backbone.ResourceManager;
import org.researchstack.backbone.ResourcePathManager;

import static org.researchstack.backbone.ResourcePathManager.Resource.TYPE_JSON;

public class MockResourceManager extends ResourceManager {

    private String onboardingJsonName;

    public MockResourceManager() {
        onboardingJsonName = "resource.json";
    }

    @Override
    public ResourcePathManager.Resource getResource(String resourceName) {

        return new ResourcePathManager.Resource(TYPE_JSON, "", "resource.json");
    }

    @Override
    public Resource getStudyOverview() {
        return null;
    }

    @Override
    public Resource getConsentHtml() {
        return null;
    }

    @Override
    public Resource getConsentPDF() {
        return null;
    }

    @Override
    public Resource getLicense() {
        return null;
    }

    @Override
    public Resource getConsentSections() {
        return null;
    }

    @Override
    public Resource getLearnSections() {
        return null;
    }

    @Override
    public Resource getPrivacyPolicy() {
        return null;
    }

    @Override
    public Resource getSoftwareNotices() {
        return null;
    }

    @Override
    public Resource getTasksAndSchedules() {
        return null;
    }

    @Override
    public Resource getTask(String taskFileName) {
        return null;
    }

    @Override
    public Resource getInclusionCriteria() {
        return null;
    }

    @Override
    public Resource getOnboardingManager() {
        return new Resource(Resource.TYPE_JSON, null, onboardingJsonName);
    }

    @Override
    public String generatePath(int type, String name) {
        return name;
    }

    @Override
    public String generateAbsolutePath(int type, String name) {
        return name;
    }

    public String getOnboardingJsonName() {
        return onboardingJsonName;
    }

    public void setOnboardingJsonName(String onboardingJsonName) {
        this.onboardingJsonName = onboardingJsonName;
    }
}
