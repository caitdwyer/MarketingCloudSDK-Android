package com.salesforce.marketingcloud.learningapp.screens

import android.widget.Button
import com.salesforce.marketingcloud.MarketingCloudSdk
import com.salesforce.marketingcloud.learningapp.R
import com.salesforce.marketingcloud.learningapp.SdkFragment
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdk
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager

class TrackingEvent : SdkFragment() {
    override val layoutId = R.layout.fragment_tracking_event

    private lateinit var marketingCloudSdk: MarketingCloudSdk

    override fun onSdkReady(sdk: MarketingCloudSdk) {
        marketingCloudSdk = sdk
        requireView().apply {
            findViewById<Button>(R.id.button_send_event).setOnClickListener {
                sendTrackingEvent()
            }
        }
    }

    private fun sendTrackingEvent() {
        val event = EventManager.customEvent(
            "wishlist",
            mapOf(
                "category" to "dial of destiny"
            )
        )
        SFMCSdk.track(event)
    }
}
