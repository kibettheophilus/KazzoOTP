package dev.kibet.librarydemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import dev.kibet.kazzootp.KazzoOtp
import dev.kibet.librarydemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var channel: String
    private lateinit var recipient: String

    private var kazzootp: KazzoOtp = KazzoOtp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chooseChannel.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (radioGroup is RadioGroup) {
                channel = when (checkedId) {
                    R.id.sms -> {
                        "sms"
                    }
                    R.id.email -> {
                        "email"
                    }
                    else -> "voice"
                }
            }
        }

        binding.buttonRequestOtp.setOnClickListener {

            recipient = binding.recipient.text.toString()

            kazzootp.requestOtp(recipient, channel)

            val intent = Intent(this, VerifyActivity::class.java)
            intent.putExtra("recipient",recipient)
            startActivity(intent)
            //binding.progressbar.visibility = View.VISIBLE
            //kazzootp.verifyOtp()
        }
    }
}