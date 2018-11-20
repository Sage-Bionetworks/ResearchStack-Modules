package org.sagebionetworks.research.researchstack_modules;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.ui.callbacks.StepCallbacks;
import org.researchstack.backbone.ui.step.layout.StepLayout;
import org.researchstack.backbone.ui.views.SubmitBar;
import rx.functions.Action1;

public class CustomStepLayout extends ConstraintLayout implements StepLayout {

    private CustomStep customStep;
    private StepResult stepResult;
    private StepCallbacks stepCallbacks;

    public CustomStepLayout(Context context) {
        super(context);
    }

    public CustomStepLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomStepLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void initialize(Step step, StepResult result) {
        if (!(step instanceof CustomStep)) {
            throw new IllegalStateException("Wrong step type");
        }
        customStep = (CustomStep) step;
        stepResult = result;
        if (stepResult == null) {
            stepResult = new StepResult(step);
        }

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_step_layout, this, true);
        ((SubmitBar) findViewById(R.id.submit_bar)).setPositiveAction(new Action1() {
            @Override
            public void call(Object o) {
                onComplete();
            }
        });
    }

    @Override
    public View getLayout() {
        return this;
    }

    @Override
    public boolean isBackEventConsumed() {
        return false;
    }

    @Override
    public void setCallbacks(StepCallbacks callbacks) {
        this.stepCallbacks = callbacks;
    }

    public void onComplete() {
        stepCallbacks.onSaveStep(StepCallbacks.ACTION_NEXT, customStep, stepResult);
    }
}
