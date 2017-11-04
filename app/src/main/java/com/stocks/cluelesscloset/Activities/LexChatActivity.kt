package com.stocks.cluelesscloset.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.amazonaws.mobileconnectors.lex.interactionkit.Response
import com.amazonaws.mobileconnectors.lex.interactionkit.ui.InteractiveVoiceView
import com.stocks.cluelesscloset.R
import java.lang.Exception

class LexChatActivity : AppCompatActivity(), InteractiveVoiceView.InteractiveVoiceListener  {
    override fun dialogReadyForFulfillment(slots: MutableMap<String, String>?, intent: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(response: Response?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(responseText: String?, e: Exception?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lex_chat)

    }
}
