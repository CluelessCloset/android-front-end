package com.stocks.cluelesscloset.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.amazonaws.auth.CognitoCredentialsProvider
import com.amazonaws.mobileconnectors.lex.interactionkit.Response
import com.amazonaws.mobileconnectors.lex.interactionkit.ui.InteractiveVoiceView
import com.amazonaws.regions.Regions
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

    private void init() {
        appContext = getApplicationContext();
        voiceView = (InteractiveVoiceView) findViewById(R.id.voiceInterface);
        voiceView.setInteractiveVoiceListener(this);
        CognitoCredentialsProvider credentialsProvider = new CognitoCredentialsProvider(
                <your_conginto_identity_pool_id>,
        Regions.fromName(<your_aws_region>)));
        voiceView.getViewAdapter().setCredentialProvider(credentialsProvider);
        voiceView.getViewAdapter().setInteractionConfig(
                new InteractionConfig(<your_bot_name>),
        <your_bot_alias>));
        voiceView.getViewAdapter().setAwsRegion(<your_aws_region>));
    }
}
