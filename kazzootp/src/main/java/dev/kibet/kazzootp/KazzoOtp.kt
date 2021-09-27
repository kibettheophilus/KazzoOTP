package dev.kibet.kazzootp

import android.util.Log
import dev.kibet.kazzootp.model.RequestOtp
import dev.kibet.kazzootp.model.RequestSuccess
import dev.kibet.kazzootp.model.ValidateOtp
import dev.kibet.kazzootp.model.ValidateSuccess
import dev.kibet.kazzootp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KazzoOtp {
    private lateinit var recipient: String
    private lateinit var channel: String
    private lateinit var otp: String


    private val apiInterface = ApiClient.buildApi()

    fun requestOtp(recipient: String,channel: String){
        this.recipient = recipient
        this.channel = channel

        val requestOtp = apiInterface.sendOtp(RequestOtp(recipient, channel))

        requestOtp.enqueue(object : Callback<RequestSuccess> {
            override fun onResponse(
                call: Call<RequestSuccess>,
                response: Response<RequestSuccess>
            ) {
                if (response.isSuccessful){
                    Log.d("ReqSuccess","${response.message()}")
                }
                else {
                    Log.d("ReqFailure","${response.message()}")
                }
            }

            override fun onFailure(call: Call<RequestSuccess>, t: Throwable) {

            }

        })

    }

    fun verifyOtp(recipient: String, otp: String ){
        this.recipient = recipient
        this.otp = otp

        val validateOtp = apiInterface.validateOtp(ValidateOtp(recipient, otp))
        validateOtp.enqueue(object :  Callback<ValidateSuccess>{
            override fun onResponse(
                call: Call<ValidateSuccess>,
                response: Response<ValidateSuccess>
            ) {
                if (response.isSuccessful){
                    Log.d("ValSuccess","${response.message()}")
                }
                else{
                    Log.d("ValFailure","${response.message()}")
                }
            }

            override fun onFailure(call: Call<ValidateSuccess>, t: Throwable) {

            }

        })
    }

}