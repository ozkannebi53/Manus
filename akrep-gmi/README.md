# AKREP GMİ - GALACTIC Akrep

Premium Yeni Nesil Kelime Bulmaca Evreni

## Proje Açıklaması

**AKREP GMİ - GALACTIC Akrep**, klasik kelime oyunlarının ötesine geçerek RPG, koleksiyon, evrim ve galaktik bir tema ile birleştirilmiş yenilikçi bir mobil oyundur.

## Özellikler

### Oyun Mekanikleri
- **Kelime Oyunu:** Harf tekerleği ile kelime bulma
- **Akrep Pet Sistemi:** 11 evrim aşaması ile yaşayan karakter
- **Evrim Sistemi:** Akrebin seviyesi attıkça evrim geçirmesi
- **Boss Bölümleri:** 5 farklı boss ile mücadele

### Ekonomi Sistemi
- **5 Para Birimi:** Altın, Elmas, Akrep Kristali, Sezon Jetonu, Kozmik Parça
- **Koleksiyon Sistemi:** 7 farklı koleksiyon türü
- **Mağaza:** Kozmetik ve özel ürünler

### Sosyal Özellikler
- **Çok Oyunculu Mod:** 2-8 oyuncu aynı anda
- **Lig Sistemi:** 8 farklı lig seviyesi
- **Liderlik Tabloları:** Global, Ülke, Şehir, Arkadaş, Kulüp
- **Kulüp Sistemi:** Oyuncuların birleşmesi

### Etkinlikler ve Görevler
- **Günlük Görevler:** Hergün yeni görevler
- **Haftalık Görevler:** Hafta içinde tamamlanacak görevler
- **Aylık Görevler:** Ay içinde tamamlanacak görevler
- **Canlı Etkinlikler:** Özel etkinlikler ve bonuslar

### Yapay Zeka
- **Dinamik Zorluk:** Oyuncunun seviyesine göre otomatik ayarlama
- **Kişiselleştirilmiş İçerik:** AI tarafından oluşturulan görevler
- **Akrep Rehberi:** Oyuncuyla etkileşime giren AI asistanı

## Teknoloji

### Geliştirme Araçları
- **Android Studio**
- **Kotlin**
- **Jetpack Compose**
- **MVVM Mimarisi**

### Kütüphaneler
- **Firebase:** Auth, Firestore, Cloud Messaging
- **Room Database:** Yerel veri depolama
- **Retrofit:** API çağrıları
- **Coroutines:** Asenkron işlemler

## Proje Yapısı

```
akrep-gmi-project/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── kotlin/com/akrep/gmi/galactic/
│   │       │   ├── MainActivity.kt
│   │       │   ├── firebase/
│   │       │   ├── game/
│   │       │   ├── models/
│   │       │   ├── data/
│   │       │   ├── services/
│   │       │   └── ui/
│   │       ├── res/
│   │       └── AndroidManifest.xml
│   ├── build.gradle.kts
│   ├── google-services.json
│   └── proguard-rules.pro
├── build.gradle.kts
└── settings.gradle.kts
```

## Kurulum

### Gereksinimler
- Android SDK 24+
- Java 11+
- Gradle 7.0+

### Adımlar

1. **Projeyi Klonla**
   ```bash
   git clone <repo-url>
   cd akrep-gmi-project
   ```

2. **Firebase Ayarları**
   - Firebase Console'de proje oluştur
   - `google-services.json` dosyasını indir
   - `app/` klasörüne koy

3. **Derle ve Çalıştır**
   ```bash
   ./gradlew build
   ./gradlew installDebug
   ```

## Oyun Sistemleri

### Kelime Oyunu Motoru
- Türkçe sözlük desteği
- Harf tekerleği sistemi
- Puan hesaplama
- Kombo sistemi

### Akrep Pet Sistemi
- 11 evrim aşaması
- Deneyim ve seviye sistemi
- Özel efektler
- Animasyonlar

### Ekonomi Sistemi
- Çok para birimi desteği
- Dinamik ödül sistemi
- Harcama ve kazanç yönetimi

### Lig Sistemi
- 8 lig seviyesi
- Puan tabanlı sıralama
- Sezon sistemi
- Ödüller

### Boss Sistemi
- 5 farklı boss
- Sağlık sistemi
- Hasar hesaplama
- Özel ödüller

### Koleksiyon Sistemi
- 7 koleksiyon türü
- Tamamlama ödülleri
- İlerleme takibi

### Çok Oyunculu Sistem
- Oda oluşturma
- Gerçek zamanlı senkronizasyon
- Skor tablosu
- Davet kodu

### Yapay Zeka Sistemi
- Oyuncu davranış analizi
- Dinamik zorluk ayarı
- Kişiselleştirilmiş görevler
- AI rehberi

## Geliştirme Aşamaları

- [x] Faz 1: Geliştirme Ortamı Kurulumu
- [x] Faz 2: Firebase Entegrasyonu
- [x] Faz 3: Kelime Oyunu Motoru
- [x] Faz 4: Akrep Pet Sistemi
- [x] Faz 5: Koleksiyon Sistemi
- [x] Faz 6: Lig Sistemi
- [x] Faz 7: Boss Sistemi
- [x] Faz 8: Çok Oyunculu Sistem
- [x] Faz 9: Yapay Zeka Sistemi
- [x] Faz 10: UI/UX Tasarımı
- [ ] Faz 11: Test ve Optimizasyon
- [ ] Faz 12: APK Oluşturma

## Lisans

Bu proje Nebi Özkan tarafından oluşturulmuştur.

## İletişim

Sorular ve öneriler için lütfen iletişime geçin.

---

**Sürüm:** 1.0.0  
**Son Güncelleme:** Haziran 2026
