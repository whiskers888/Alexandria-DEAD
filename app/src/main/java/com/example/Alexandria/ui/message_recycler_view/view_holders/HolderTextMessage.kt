package com.example.Alexandria.ui.message_recycler_view.view_holders

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import asTime
import com.example.Alexandria.database.CURRENT_UID
import com.example.Alexandria.ui.message_recycler_view.views.MessageView
import kotlinx.android.synthetic.main.message_item_text.view.*

class HolderTextMessage(view:View):RecyclerView.ViewHolder(view),MessageHolder {
    private val blockUserMessage: ConstraintLayout = view.bloc_user_message
    private val chatUserMessage: TextView = view.chat_user_message
    private val chatUserMessageTime: TextView = view.chat_user_message_time
    private val blockReceivedMessage: ConstraintLayout = view.bloc_received_message
    private val chatReceivedMessage: TextView = view.chat_received_message
    private val chatReceivedMessageTime: TextView = view.chat_received_message_time



    override fun drawMessage(view: MessageView) {
        if (view.from == CURRENT_UID) {
            blockUserMessage.visibility = View.VISIBLE
            blockReceivedMessage.visibility = View.GONE
            chatUserMessage.text = view.text
            chatUserMessageTime.text =
                view.timeStamp.asTime()
        } else {
            blockUserMessage.visibility = View.GONE
            blockReceivedMessage.visibility = View.VISIBLE
            chatReceivedMessage.text = view.text
            chatReceivedMessageTime.text =
                view.timeStamp.asTime()
        }
    }

    override fun onAttach(view: MessageView) {
    }

    override fun onDetach() {
    }
}