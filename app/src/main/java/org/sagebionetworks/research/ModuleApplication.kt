package org.sagebionetworks.research

import android.app.Application
import android.content.Context
import org.researchstack.backbone.ResearchStack
import org.researchstack.backbone.StorageAccess
import org.sagebionetworks.research.researchstack.MockResearchStack

class ModuleApplication : Application() {
    companion object {
        const val PIN_CODE = "1234"

        fun mockAuthenticate(context: Context) {
            if (StorageAccess.getInstance().hasPinCode(context)) {
                StorageAccess.getInstance().authenticate(context, PIN_CODE)
            } else {
                StorageAccess.getInstance().createPinCode(context, PIN_CODE)
            }
        }
    }

    lateinit var researchStack: MockResearchStack

    override fun onCreate() {
        super.onCreate()

        researchStack = MockResearchStack()
        ResearchStack.init(this, researchStack)
    }
}