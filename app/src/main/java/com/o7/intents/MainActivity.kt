package com.o7.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

var phoneNum :EditText? = null
var sendbtn : Button? = null

var email : EditText? = null
var subject : EditText? = null
var message : EditText? = null
var btnSend_email : Button? = null

var phoneNumSMS : EditText? = null
var messageSMS :EditText? = null
var sendSMS :Button? = null

var viewURL :Button? = null


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //To call
        phoneNum = findViewById(R.id.etPhoneNum)
        sendbtn = findViewById(R.id.btnCall)
        sendbtn?.setOnClickListener(){
        var getphoneNum =  phoneNum?.text.toString()
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$getphoneNum"))
            startActivity(dialIntent)
        }
        //To Send Email

        email = findViewById(R.id.etEmail)
        subject = findViewById(R.id.etEmail)
        message = findViewById(R.id.etMessagemail)
        btnSend_email = findViewById(R.id.btnSendEMAIL)

        var getemail = email?.text.toString()
        var getSubject = subject?.text.toString()
        var getMessage = message?.text.toString()

        btnSend_email?.setOnClickListener() {


            val sendEmailIntent = Intent(Intent.ACTION_SEND)
            sendEmailIntent.type = "plain/text"
            sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getemail))
            sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, getSubject)
            sendEmailIntent.putExtra(Intent.EXTRA_TEXT, getMessage)
            startActivity(Intent.createChooser(sendEmailIntent, "Send Email"))

        }

        //To Send SMS
        phoneNumSMS = findViewById(R.id.etPhoneNumSMS)
        messageSMS = findViewById(R.id.etMsgSMS)
        sendSMS = findViewById(R.id.btnSendSMS)

        sendSMS?.setOnClickListener(){
            var getMsg = messageSMS?.text.toString()
            var getNum = phoneNumSMS?.text.toString()
            val sendSmsIntent = Intent(Intent.ACTION_SENDTO)
            sendSmsIntent.data = Uri.parse("smsto:$getNum")
            sendSmsIntent.putExtra("sms_body", getMsg)
            startActivity(sendSmsIntent)
        }

        //View URL
        viewURL = findViewById(R.id.btnviewURL)
        viewURL?.setOnClickListener(){
            val viewUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"))
            startActivity(viewUrlIntent)
        }
    }
}