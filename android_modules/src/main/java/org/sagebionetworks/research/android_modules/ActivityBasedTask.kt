package org.sagebionetworks.research.android_modules

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.researchstack.backbone.result.TaskResult
import org.researchstack.backbone.ui.ViewTaskActivity.EXTRA_TASK_RESULT

class ActivityBasedTask : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, ActivityBasedTask::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_based_task)
    }

    fun saveAndFinish(view: View) {
        val taskResult = TaskResult("activity-based-task")
        val resultIntent = Intent()
        resultIntent.putExtra(EXTRA_TASK_RESULT, taskResult)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}
