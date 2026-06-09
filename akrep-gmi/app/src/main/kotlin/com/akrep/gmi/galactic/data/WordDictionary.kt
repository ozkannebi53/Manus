package com.akrep.gmi.galactic.data

object WordDictionary {
    
    val turkishWords = mapOf(
        // Temel kelimeler
        "ALA" to "İyi, güzel, hoş",
        "AKREP" to "Zehirli böcek",
        "AYAK" to "Vücudun alt kısmı",
        "AYAR" to "Düzenleme, ayarlama",
        "ALAN" to "Geniş yer, saha",
        "AILE" to "Birlikte yaşayan insanlar",
        "AKIL" to "Zeka, anlayış",
        "AKAR" to "Akan su",
        "ALET" to "Araç, gereç",
        "ALEV" to "Ateş, yangın",
        "ALKOL" to "İçki",
        "ALMA" to "Meyve",
        "ALMAK" to "Ele geçirmek",
        "ALTAY" to "Dağ sistemi",
        "ALTIN" to "Değerli metal",
        
        // Uzay temalı kelimeler
        "UZAY" to "Yıldızlar ve gezegenler",
        "YILDIZ" to "Gökyüzündeki ışık noktası",
        "GEZEGEN" to "Güneş etrafında dönen cisim",
        "KOZMIK" to "Evrenle ilgili",
        "GALAKSI" to "Milyarlarca yıldızdan oluşan sistem",
        "NEBULA" to "Yıldız tozundan oluşan bulut",
        "KARA_DELIK" to "Işığı bile emen yer",
        "METEOR" to "Dünya atmosferine giren taş",
        "KUYRUKLU_YILDIZ" to "Kuyruğu olan yıldız",
        "SUPERNOVA" to "Patlayan yıldız",
        
        // Oyun temalı kelimeler
        "OYUN" to "Eğlence, spor",
        "PUAN" to "Kazanılan sayı",
        "SEVIYE" to "Derece, basamak",
        "KOLAY" to "Zor olmayan",
        "ZOR" to "Güç gerektiren",
        "SKOR" to "Oyunda kazanılan puan",
        "BAŞARI" to "Başarılı olma",
        "BAŞARISIZ" to "Başarısız olma",
        "KAZANMAK" to "Galip gelmek",
        "KAYBETMEK" to "Yenilmek",
        
        // Akrep temalı kelimeler
        "BÖCEK" to "Küçük hayvan",
        "ZEHİR" to "Zehirli madde",
        "KUYRUK" to "Hayvanın arka kısmı",
        "PENSE" to "Akrebin tutma aracı",
        "ÇÖĞÜR" to "Çöl hayvanı",
        "ÇÖĞÜR_AKREBI" to "Çölde yaşayan akrep",
        "BUZ_AKREBI" to "Buz ülkesinde yaşayan akrep",
        "ATES_AKREBI" to "Ateş gücüne sahip akrep",
        "ELEKTRİK_AKREBI" to "Elektrik gücüne sahip akrep",
        
        // Koleksiyon temalı
        "KOLEKSIYON" to "Bir araya getirilen şeyler",
        "SANDIK" to "Hazine kutusu",
        "ÖDÜL" to "Başarı için verilen şey",
        "ROZET" to "Başarı işareti",
        "ÇERÇEVE" to "Resim çerçevesi",
        "EFEKT" to "Görsel etki",
        
        // Ekonomi temalı
        "ALTIN_PARA" to "Oyunda para birimi",
        "ELMAS" to "Değerli taş",
        "KRISTAL" to "Parlak taş",
        "JETON" to "Oyun parası",
        "PARA" to "Ödeme aracı",
        "HARCAMAK" to "Para kullanmak",
        "KAZANMAK" to "Para kazanmak",
        
        // Sosyal temalı
        "ARKADAŞ" to "Dost",
        "KULÜP" to "Birleşme",
        "TAKIM" to "Grup",
        "LİDER" to "Başkan",
        "SAVAŞ" to "Çatışma",
        "YARIŞ" to "Rekabet",
        "TURNUVA" to "Spor müsabakası",
        
        // Etkinlik temalı
        "ETKİNLİK" to "Olay, faaliyet",
        "FIRTINA" to "Şiddetli rüzgar",
        "YAGMUR" to "Gökyüzünden düşen su",
        "HAFTA" to "Yedi günlük dönem",
        "AY" to "Otuz günlük dönem",
        "SEZON" to "Mevsim",
        
        // Diğer kelimeler
        "KARA" to "Siyah renk",
        "BEYAZ" to "Açık renk",
        "KIRMIZI" to "Ateş rengi",
        "MAVI" to "Gökyüzü rengi",
        "SARI" to "Güneş rengi",
        "YEŞİL" to "Ot rengi",
        "TURUNCU" to "Portakal rengi",
        "MOR" to "Mor renk",
        "PEMBE" to "Açık kırmızı",
        "GRİ" to "Gri renk",
        
        "GÜZEL" to "Hoş görünüşlü",
        "ÇIRKIN" to "Hoş olmayan",
        "BÜYÜK" to "Geniş",
        "KÜÇÜK" to "Dar",
        "UZUN" to "Geniş",
        "KISA" to "Az uzunlukta",
        "YÜKSEK" to "Tepede olan",
        "ALÇAK" to "Dibe yakın",
        
        "HIZLI" to "Çabuk",
        "YAVAS" to "Ağır",
        "GÜÇLÜ" to "Kuvvetli",
        "ZAYIF" to "Güçsüz",
        "SICAK" to "Yüksek sıcaklık",
        "SOĞUK" to "Düşük sıcaklık",
        "ISLAK" to "Su içeren",
        "KURU" to "Su olmayan"
    )
    
    fun getRandomWords(count: Int): List<String> {
        return turkishWords.keys.shuffled().take(count)
    }
    
    fun getWordMeaning(word: String): String? {
        return turkishWords[word.uppercase()]
    }
    
    fun searchWords(prefix: String): List<String> {
        return turkishWords.keys.filter { it.startsWith(prefix.uppercase()) }
    }
}
