package com.informatika.databarang.service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.informatika.databarang.R
import com.informatika.databarang.model.ResponseBarang
import com.informatika.databarang.network.koneksi
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_username
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_update_data.*
import kotlinx.android.synthetic.main.activity_update_data.btn_submit
import java.util.prefs.AbstractPreferences
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionPreferences: SessionPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_login)
        btn_submit.setOnClickListener{
            val userName = et_username.text.toString()
            val password = et_password.text.toString()

            if (userName.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Form tidak boleh kosong!", Toast.LENGTH_LONG).show()
            }else{
                actionData((userName, password)
            }
        }
        btn_clean.setOnClickListener{
            formClear()
        }
       // tv_disini.setOnClickListener{
    }
}

    fun actionData(username: String, password : String){
  //  koneksi.service.logIn(username). enqueue(object  : Callback<ResponseAdmin>{
  //      override fun onFailure(call: Call<ResponseAdmin>, t:Throwable){
            Log.d("pesan1", t.localizedMessage)
        }

   //     override fun onResponse(call: Call<ResponseAdmin>, t. Throwble){
   //         if ((response.isSuccessful){
                   // val  resbody = response.body()
                   // val resStatus = resbody?.status
                 //   val resUserName = resbody?.data?get(0)?.username
                    Log.d("pesan", resUserName.toString())
                    if ((resStatus == true){
                          //  sessionPreferences = SessionPreferences(this@LoginActivity)
                          //  sessionPreferences.actionLogin(resUserName.toString())
                          //  startActivity(i)
                         //   finish()
                        }else if (resStatus == false){
                     //   Toast.makeText(this@LoginActivity, "Username atau Password Anda Salah", Toast.LENGTH_LONG).show()

                        }
                }
        }
    })
    }
}

    fun formClear(){
      //  et_username.text.clear()
      //  et_password.text.clear()
    }