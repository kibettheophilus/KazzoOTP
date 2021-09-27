package dev.kibet.librarydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.kibet.kazzootp.KazzoOtp
import dev.kibet.librarydemo.databinding.ActivityVerifyBinding

class VerifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifyBinding
    private var kazzootp: KazzoOtp = KazzoOtp()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipient = intent.getStringExtra("recipient")

        binding.btnVerifyOtp.setOnClickListener {
            val otp = binding.otp.text.toString()

            kazzootp.verifyOtp(recipient!!, otp)

        }

    }
}