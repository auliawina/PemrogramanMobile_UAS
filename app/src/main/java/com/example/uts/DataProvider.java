package com.example.uts;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.uts.model.makanan;
import com.example.uts.model.minuman;
import com.example.uts.model.produk;
import com.example.uts.model.tumblr;

public class DataProvider {
    private static List<produk> produks = new ArrayList<>();

    private static List<minuman> dataminuman (Context ctx){
        List<minuman> list_minuman = new ArrayList<>();
        list_minuman.add(new minuman("Caramel Java Chip Frappucino",ctx.getString(R.string.waktu_minuman_a),"4.1","100kal",
                ctx.getString(R.string.deskripsi_minuman_a),"Rp.55.000",R.drawable.es1));
        list_minuman.add(new minuman("Java Chip Frappucino",ctx.getString(R.string.waktu_minuman_b),"5.0","150kal",
                ctx.getString(R.string.deskripsi_minuman_b),"Rp.57.000",R.drawable.es2));
        list_minuman.add(new minuman("Chocolate Chip Frappucino",ctx.getString(R.string.waktu_minuman_c),"4.1","200kal",
                ctx.getString(R.string.deskripsi_minuman_c),"Rp.51.000",R.drawable.es3));
        return list_minuman;
    }

    private static List<makanan> datamakanan (Context ctx){
        List<makanan> list_makanans = new ArrayList<>();
        list_makanans.add(new makanan("Cheese Chip Waffel",ctx.getString(R.string.waktu_makanan_a),"5.0","500kal",ctx.getString(R.string.deskripsi_makanan_a),"Rp.12.000",R.drawable.makanan1));
        list_makanans.add(new makanan("Caramel Stroop Waffel",ctx.getString(R.string.waktu_makanan_b),"4.1","550kal",ctx.getString(R.string.deskripsi_makanan_b),"Rp.10.000",R.drawable.makanan2));
        list_makanans.add(new makanan("Chocolate Stroop Waffel",ctx.getString(R.string.waktu_makanan_c),"3.7","600kal",ctx.getString(R.string.deskripsi_makanan_c),"Rp.20.000",R.drawable.makanan3));
        return list_makanans;
    }

    private static List<tumblr> datatumblr (Context ctx){
        List<tumblr> list_tumblrs = new ArrayList<>();
        list_tumblrs.add(new tumblr("Reuseable WTR Bottle","-","5.0","-",ctx.getString(R.string.deskripsi_tumblr_a),"Rp.100.000",R.drawable.produk1));
        list_tumblrs.add(new tumblr("Cold Cup CPPER","-","4.1","-",ctx.getString(R.string.deskripsi_tumblr_b),"Rp.180.000",R.drawable.produk2));
        list_tumblrs.add(new tumblr("Tumbler Badge Siren Black","-","4.5","-",ctx.getString(R.string.deskripsi_tumblr_c),"Rp.170.000",R.drawable.produk3));
        return list_tumblrs;
    }
    private static void allproduk (Context ctx) {
        produks.addAll(dataminuman(ctx));
        produks.addAll(datamakanan(ctx));
        produks.addAll(datatumblr(ctx));
    }
    public static List<produk> getAllProduk(Context ctx) {
        if (produks.size() == 0) {
            allproduk(ctx);
        }
        return produks;
    }
    public static List<produk> getProduksByTipe (Context ctx, String jenis) {
        List<produk> produksByTipe = new ArrayList<>();
        if (produks.size() == 0) {
            allproduk(ctx);
        }
        for (produk p : produks) {
            if (p.getJenis().equals(jenis)) {
                produksByTipe.add(p);
            }
        }
        return produksByTipe;
    }

}