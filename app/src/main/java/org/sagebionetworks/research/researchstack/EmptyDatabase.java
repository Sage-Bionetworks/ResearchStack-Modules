package org.sagebionetworks.research.researchstack;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.result.TaskResult;
import org.researchstack.backbone.storage.database.AppDatabase;

import java.util.List;

public class EmptyDatabase implements AppDatabase {

    public EmptyDatabase() {
        super();
    }

    @Override
    public void saveTaskResult(TaskResult result) {
        // no-op
    }

    @Override
    public TaskResult loadLatestTaskResult(String taskIdentifier) {
        // no-op
        return null;
    }

    @Override
    public List<TaskResult> loadTaskResults(String taskIdentifier) {
        // no-op
        return null;
    }

    @Override
    public List<StepResult> loadStepResults(String stepIdentifier) {
        // no-op
        return null;
    }

    @Override
    public void setEncryptionKey(String key) {
        // no-op
    }
}
