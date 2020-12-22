package com.mycpe.myappkot

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mycpe.myappkot.R

class InputActivity : AppCompatActivity(), View.OnClickListener {
    private var edtFName: EditText? = null
    private var edtLName: EditText? = null
    private var strFName: String? = null
    private var strLName: String? = null
    private var btnGo: Button? = null
    private var txtResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        edtFName = findViewById<View>(R.id.edtFName) as EditText
        edtLName = findViewById<View>(R.id.edtLName) as EditText
        btnGo = findViewById<View>(R.id.btnGo) as Button
        btnGo!!.setOnClickListener(this)
        txtResult = findViewById<View>(R.id.txtResult) as TextView
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnGo -> {
                strFName = edtFName!!.text.toString()
                strLName = edtLName!!.text.toString()
                txtResult!!.text = "$strFName $strLName"
            }
        }
    }
}