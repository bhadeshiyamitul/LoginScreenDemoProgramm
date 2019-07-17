package com.ubrain.logindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/*
2 )Login Screen  ( email id TextField  with email id validation  , Password Text Field  with sequre input)
after click on Login Button check email and password validation  and give result/error in TOST
*/

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()

        var edEmail = findViewById<EditText>(R.id.ed_email)
        var edPwd: EditText = findViewById<EditText>(R.id.ed_pwd)
        var btnSignin = findViewById<Button>(R.id.btn_signin)


        fun isEmailValidate(): Boolean {
            var check: Boolean
            var email = edEmail.text.toString().trim()
            //var valid="^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" +
            //        "+ [A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,});"
            var validEmail = "[a-zA-Z0-9._-]+@[a-z]+(.[a-z]{2,})+"
            check = email.matches(Regex(validEmail))
            return check
        }

        fun isPasswordValidate(): Boolean {
            var check: Boolean
            var pwd = edPwd.text.toString()
            //((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,8})

            var validPwd = "[a-zA-Z0-9*&%\$#]{4,9}"
            check = pwd.matches(Regex(validPwd))
            return check
        }
        btnSignin.setOnClickListener {
            if (!isEmailValidate()) {
                Toast.makeText(applicationContext, "Invalid email", Toast.LENGTH_SHORT).show()
            } else if (!isPasswordValidate()) {
                Toast.makeText(applicationContext, "Invalid password", Toast.LENGTH_SHORT).show()
            } else if (isEmailValidate() && isPasswordValidate()) {

                Toast.makeText(applicationContext, "valid email address and password", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(applicationContext, "Invalid email address and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
