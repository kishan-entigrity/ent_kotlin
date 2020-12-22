package com.mycpe.myappkot

import LoginResponseNew
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mycpe.myappkot.WebServices.RetrofitClient
//import com.mycpe.myappkot.model.LoginResponse
import com.mycpe.myappkot.utility.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivityKot : AppCompatActivity(), View.OnClickListener {

    private var edtEmail: EditText? = null
    private var edtPassword: EditText? = null
    private var strEmail: String? = null
    private var strPassword: String? = null
    private var btnGo: Button? = null
    private var txtResult: TextView? = null

    var email: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_kot)
        edtEmail = findViewById<View>(R.id.edtFName) as EditText
        edtPassword = findViewById<View>(R.id.edtLName) as EditText
        btnGo = findViewById<View>(R.id.btnGo) as Button
        txtResult = findViewById<View>(R.id.txtResult) as TextView

        btnGo!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
//        TODO("Not yet implemented")
        when (v.id) {
            R.id.btnGo -> {
                strEmail = edtEmail!!.text.toString()
                strPassword = edtPassword!!.text.toString()
//                txtResult!!.text = "$strEmail _ $strPassword"

                email = edtEmail!!.text.toString().trim()
                password = edtPassword!!.text.toString().trim()

                // Now we have to take an API call from here..
//                if (strEmail!!.equals("") || strEmail!!.length == 0) {
                if (email!!.equals("") || email!!.length == 0) {
                    Constant.showToast("Please enter email", this)
//                } else if (strPassword!!.equals("") || strPassword!!.length == 0) {
                } else if (password!!.equals("") || password!!.length == 0) {
                    Constant.showToast("Please enter password", this)
//                } else if (strPassword!!.length < 6) {
                } else if (password!!.length < 6) {
                    Constant.showToast("Password lenght must be 6 characters", this)
                } else {
                    if (Constant.isNetworkAvailable(this)) {
                        Constant.showToast("Internet is available", this)
                        Constant.showToast("Take API call for login", this)
//                        LoginUser(strEmail, strPassword)
                        LoginUser(email, password)
                    } else {
                        Constant.showToast("Please Check Internet Connection.", this)
                    }
                }
            }
        }
    }

    private fun LoginUser(strEmail: String?, strPassword: String?) {
//        Log.e("*+*+*", "Email : " + strEmail.toString() + " :: Pass : " + strPassword.toString())
        Log.e("*+*+*", "Email : " + email.toString() + " :: Pass : " + password.toString())
        RetrofitClient.instance.login("application/json", email.toString(), password.toString(),
                "android", "ddddddddddddddddd", "A")
                .enqueue(object : Callback<LoginResponseNew> {
                    override fun onFailure(call: Call<LoginResponseNew>, t: Throwable) {
                        Constant.showToast(t.message, applicationContext)
                        Log.e("*+*+*", "onFailure : " + t.message)
                    }

                    override fun onResponse(call: Call<LoginResponseNew>, response: Response<LoginResponseNew>) {
                        Log.e("*+*+*", "onResponse result is : " + response)
//                        Log.e("*+*+*", "onResponse result String is : " + response.toString())
                        Log.e("*+*+*", "onResponse result body is : " + response.body())
                        if(response.code() == 200) {
//                            txtResult!!.text = "$strEmail _ $strPassword"
                            txtResult!!.text = response.body()?.payload?.email+" || "+response.body()?.payload?.first_name+" || "+response.body()?.payload?.last_name
                            Log.e("*+*+*","200 Email : " + response.body()?.payload?.email)
                            Log.e("*+*+*","200 FName : " + response.body()?.payload?.first_name)
                            Log.e("*+*+*","200 LName : " + response.body()?.payload?.last_name)
                        } else {
                            Constant.showToast(""+response.body()?.message, applicationContext)
                            Log.e("*+*+*","Else part code: "+response.code())
                            Log.e("*+*+*","Else part success state: "+response.body()?.success)
                            Log.e("*+*+*","Else part body: "+response.body())
                            Log.e("*+*+*","Else part message: "+response.body()?.message)
                            Log.e("*+*+*","Else part message method : "+response.message())
                            Log.e("*+*+*","Else part response.row : "+response.raw())
                            Log.e("*+*+*","Else part response error body : "+response.errorBody())
                        }
                        /*if (!response.body()?.success!!) {
                            Log.e("*+*+*", "response on success : " + response.toString())
                        } else {
                            Constant.showToast(response.message(), applicationContext)
                            Log.e("*+*+*", "onResponse else : " + response.code())
                        }*/
                    }
                }
        )
    }
}