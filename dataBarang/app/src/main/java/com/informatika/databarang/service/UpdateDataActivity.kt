package com.informatika.databarang.service

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import com.informatika.databarang.R
import com.informatika.databarang.model.ResponseActionBarang
import com.informatika.databarang.network.koneksi
import kotlinx.android.synthetic.main.activity_insert_data.*
import kotlinx.android.synthetic.main.activity_update_data.btn_submit
import kotlinx.android.synthetic.main.activity_update_data.et_jumlah_barang
import kotlinx.android.synthetic.main.activity_update_data.toolbar
import retrofit2.Response
import javax.security.auth.callback.Callback

class UpdateDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)
        toolbar.title = "UPDATE DATA"
        toolbar.setTitleTextColor(Color.WHITE)

        val i = intent
        val idBarang = i.getStringExtra("IDBARANG")
        val namaBarang = i.getStringExtra("NAMABARANG")
        val jumlahBarang = i.getStringExtra("JMLBARANG")

        et_nama_barang.setText(namaBarang)
        et_jumlah_barang.setText(jumlahBarang)
        btn_submit.setOnClickListener{
            val etNamaBarang = et_nama_barang.text
            val etJmlBarang = et_jumlah_barang.text
            if(etJmlBarang.isEmpty()){
                Toast.makeText("this@UpdateDataActivity," "Jumlah Barang Tidak Boleh kosong", Toast.LENGTH_LONG).show()
            }else if (etNamaBarang.isEmpty()){
                Toast.makeText(this@UpdateDataActivity, "Nama Barang Tidak Boleh kosong," Toast.LENGTH_LONG).show()
            }else{
                actionData(
                    idBarang.toString(),
                    etNamaBarang.toString(),
                    etJmlBarang.toString()
                )
            }
        }

        btn_back.setOnClickListener(
            finish()
    }
    getData()
    }

fun actionData(id : String, namaBarang : String, jmlBarang : String){
    koneksi.service.updateBarang(id, namaBarang, jmlBarang).enqueue(object : Callback<ResponseActionBarang>{
        override fun onFailure(call:  Call<ResponseActionBarang>, t: Throwable) {
            Log.d("pesan1", t.localizedMessage)
        }

        override fun onResponse(
            call: Call<ResponseActionBarang>,
            response: Response<ResponseActionBarang>

        ) {
            if (response.isSuccessful){
                Toast.makeText(this@UpdateDataActivity, "data berhasil diupdate", Toast.LENGTH_LONG).show()
                getData()
            }
        }
    })
}
    





