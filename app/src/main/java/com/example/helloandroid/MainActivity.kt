package com.example.helloandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloandroid.ui.theme.HelloAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val namaToko: String = "Warung bu yannti"
        val hargaproduk: Double = 15000.0
        val stokbarang: Int = 25
        val tokotutup: Boolean = true






       cekstatusstok(namaToko,stokbarang)
        cekstatusstok("Kopi batusangkar",20)


        val totalbayar = hitungtotalharga(hargaproduk,3)
        Log.d("KatalogUMKM","Total bayar untuk 3 item : $totalbayar")


        val produk1 = produk("Keripik singkong",12000.0,3)
        val produk2 = produk("Kopi batusangkar",25000.0,20)

        Log.d("KatalogUMKM",produk1.infoproduk())
        Log.d("KatalogUMKM",produk2.infoproduk())

        produk1.tambahstok(10)
        Log.d("KatalogUMKM","Setelah restok: " +produk1.infoproduk())

        val daftarprodukobjek = listOf(produk1,produk2)
        for (p in daftarprodukobjek){
            cekstatusstok(p.nama,p.stok)
        }


        val kategoriproduk: String = "Makanan"
        when (kategoriproduk){
            "Makanan" -> Log.d("KatalogUMKM","Kategori: Makanan - Simpan Di Tempat Sejuk")
            "Minuman" -> Log.d("KatalogUMKM","Kategori:Minuman - Simpan DI Kulkas")
            "Kerajinan" -> Log.d("KatalogUMKM","Kategori: Kerajinan - Pajang Di Etalase")
            else -> Log.d("KatalogUMKM","Kategori Tidak Di Kenal")
        }
//perulangan
        val daftarProduk = listOf("Keripik Singkong", "Kopi Batusangkar", "kain Songket")
        for (produk in daftarProduk){
            Log.d("KatalogUMKM","Produk Tersedia: $produk")
        }
        var stokSimulasi: Int = 3
        while (stokSimulasi>0) {
            Log.d("KatalogUMKM","Simulasi:barang terjual, sisa stok $stokSimulasi")
            stokSimulasi = stokSimulasi - 1
        }
        Log.d("KatalogUMKM","Simulasi: Stok habis")




        Log.d("KatalogUmkm","Nama Toko: $namaToko")
        Log.d("KatalogUmkm","Harga Produk: $hargaproduk")
        Log.d("KatalogUmkm","Stok Barang: $stokbarang")
        Log.d("KatalogUmkm","Toko Buka: $tokotutup")

        Toast.makeText(this,"Selamat datang di $namaToko \n Stok barang:$stokbarang",
            Toast.LENGTH_LONG).show()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    fun cekstatusstok(nama: String,stok: Int){
        if (stok<5){
            Log.d("katalogUMKM","Peringatan: stok $nama menipis, sis $stok")
        }else {
            Log.d("KatalogUMKM","Stok $nama aman, sisa $stok")
        }
    }
    fun hitungtotalharga(harga: Double,jumlah: Int): Double{
        val total = harga * jumlah
        return total
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloAndroidTheme {
        Greeting("Android")
    }
}
class produk(val nama: String,val harga: Double,var stok: Int){
    fun infoproduk(): String{
        return "$nama - Rp$harga (stok: $stok)"
    }
    fun tambahstok(jumlah: Int){
        stok = stok + jumlah
    }
}

