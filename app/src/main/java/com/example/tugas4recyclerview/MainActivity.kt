package com.example.tugas4recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration

class MainActivity : AppCompatActivity() {

    private val mahasiswaList = mutableListOf(
        Mahasiswa("225150407111086", "ACHMAD FIRDAUS ATTALEA YESSA"),
        Mahasiswa("225150400111050", "BANGKIT AGUNG LAKSONO"),
        Mahasiswa("225150400111049", "LAURENSIUS NATHAN SURYA RACHMANTO"),
        Mahasiswa("225150407111096", "SULTHAN MUHAMMAD RAFIF ILHAM")
    )

    private lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val etNim = findViewById<EditText>(R.id.etNim)
        val etNama = findViewById<EditText>(R.id.etNama)
        val btnSimpan = findViewById<Button>(R.id.btSimpan)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        adapter = MahasiswaAdapter(mahasiswaList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnSimpan.setOnClickListener {
            val nim = etNim.text.toString()
            val nama = etNama.text.toString()

            if (nim.isNotEmpty() && nama.isNotEmpty()) {
                val mahasiswa = Mahasiswa(nim, nama)
                mahasiswaList.add(mahasiswa)
                adapter.notifyItemInserted(mahasiswaList.size - 1)

                etNim.text.clear()
                etNama.text.clear()
            }
        }
    }
}
