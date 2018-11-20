package org.sagebionetworks.research.researchstack;

import android.content.Context;
import org.researchstack.backbone.*;
import org.researchstack.backbone.notification.NotificationConfig;
import org.researchstack.backbone.onboarding.OnboardingManager;
import org.researchstack.backbone.storage.database.AppDatabase;
import org.researchstack.backbone.storage.file.EncryptionProvider;
import org.researchstack.backbone.storage.file.FileAccess;
import org.researchstack.backbone.storage.file.PinCodeConfig;
import org.researchstack.backbone.storage.file.SimpleFileAccess;
import org.researchstack.backbone.storage.file.aes.AesProvider;

public class MockResearchStack extends ResearchStack {
    @Override
    protected AppDatabase createAppDatabaseImplementation(Context context) {
        return new EmptyDatabase();
    }

    @Override
    protected PinCodeConfig getPinCodeConfig(Context context) {
        return new PinCodeConfig(30 * 60_000L);
    }

    @Override
    protected EncryptionProvider getEncryptionProvider(Context context) {
        return new AesProvider();
    }

    @Override
    public OnboardingManager getOnboardingManager() {
        return onboardingManager;
    }

    private OnboardingManager onboardingManager;

    @Override
    public void createOnboardingManager(Context context) {
        onboardingManager = new MockOnboardingManager(context);
    }

    @Override
    protected FileAccess createFileAccessImplementation(Context context) {
        return new SimpleFileAccess();
    }

    @Override
    protected ResourceManager createResourceManagerImplementation(Context context) {
        return new MockResourceManager();
    }

    @Override
    protected UiManager createUiManagerImplementation(Context context) {
        return null;
    }

    @Override
    protected DataProvider createDataProviderImplementation(Context context) {
        return null;
    }

    @Override
    protected TaskProvider createTaskProviderImplementation(Context context) {
        return null;
    }

    @Override
    protected NotificationConfig createNotificationConfigImplementation(Context context) {
        return null;
    }

    @Override
    protected PermissionRequestManager createPermissionRequestManagerImplementation(Context context) {
        return null;
    }
}
