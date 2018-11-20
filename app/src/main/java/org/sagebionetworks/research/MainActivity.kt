package org.sagebionetworks.research

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.multidex.MultiDex
import android.util.Log
import android.view.View
import org.researchstack.backbone.answerformat.TextAnswerFormat
import org.researchstack.backbone.result.TaskResult
import org.researchstack.backbone.step.QuestionStep
import org.researchstack.backbone.step.Step
import org.researchstack.backbone.task.OrderedTask
import org.researchstack.backbone.ui.ActiveTaskActivity
import org.researchstack.backbone.ui.ViewTaskActivity
import org.sagebionetworks.research.android_modules.ActivityBasedTask
import org.sagebionetworks.research.researchstack_modules.CustomStep
import org.sagebionetworks.research.researchstackmodule.R

class MainActivity : Activity() {
    val REQUEST_TASK = 1245

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(base: Context) {
        // This is needed for android versions < 5.0 or you can extend MultiDexApplication
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onResume() {
        super.onResume()

        ModuleApplication.mockAuthenticate(this)
    }

    fun onResearchStackTaskClicked(view: View) {
        // Create a Task which includes a custom step from a ResearchStack module
        val task = OrderedTask(
            "researchstack-task", arrayListOf(
                QuestionStep("question1", "Question One", TextAnswerFormat()),
                CustomStep("custom-step1"),
                QuestionStep("question2", "Question Two", TextAnswerFormat())
                ) as List<Step>?
        )

        val intent = ActiveTaskActivity.newIntent(applicationContext, task)

        startActivityForResult(intent, REQUEST_TASK)
    }

    fun onActivityBasedTaskClicked(view: View) {
        // Create Task which is an arbitrary Activity
        val intent = ActivityBasedTask.createIntent(this)

        startActivityForResult(intent, REQUEST_TASK)
    }

    fun onFragmentBasedTaskClicked(view: View) {
        // TODO: Create wrapper for Fragment
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TASK) {
            if (resultCode == Activity.RESULT_OK) {
                val taskResult = data!!.getSerializableExtra(ViewTaskActivity.EXTRA_TASK_RESULT) as TaskResult

                handleTaskResult(taskResult)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun handleTaskResult(taskResult: TaskResult) {
        Log.i(
            "MainActivity",
            "Received task result: " + taskResult + ", step results: " + taskResult.results
        )

        // this is where My BP Lab will upload, mark task as complete, etc
    }
}
