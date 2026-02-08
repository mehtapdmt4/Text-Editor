# Text Editor & Analyzer (Metin Düzenleyici ve Analiz Aracı)

Bu proje, Işık Üniversitesi Bilgisayar Mühendisliği eğitimi kapsamında Java kullanılarak geliştirilmiştir. Projenin temel amacı, hazır kütüphaneler yerine temel algoritma mantığı ve karakter dizileri (char arrays) kullanarak metin işleme (string manipulation) yeteneğini geliştirmektir.

## Projenin Amacı
Kullanıcıdan alınan metin verilerini bellekte bir karakter dizisi olarak tutarak; üzerinde istatistiksel analiz yapabilen, biçimlendirebilen ve düzenleyebilen interaktif bir konsol uygulaması tasarlanmıştır.

## Teknik Detaylar
* **Programlama Dili:** Java (SE)
* **Veri Yapısı:** char[] (Karakter Dizileri) - ArrayList kullanılmadan, raw array manipülasyonu ile geliştirilmiştir.
* **Kullanılan Konseptler:** String Manipulation, Loops, Conditional Statements, Input Validation.

## Temel Özellikler
Bu araç, girilen metin üzerinde aşağıdaki işlemleri gerçekleştirebilir:

### 1. İstatistiksel Analiz
Metni analiz ederek şunları raporlar:
* Rakam, harf (büyük/küçük) ve sembol sayıları.
* Kelime ve boşluk sayıları.

### 2. Metin Manipülasyonu
* **Case Conversion:** Tüm harfleri büyük veya küçük harfe çevirme.
* **Capitalization:** Her kelimenin baş harfini büyütme.
* **Reversing:**
    * Tüm karakterleri ters çevirme (örn: "Java" -> "avaJ").
    * Kelime sırasını ters çevirme (örn: "Hello World" -> "World Hello").

### 3. Düzenleme İşlemleri
* Belirtilen konuma yeni kelime ekleme (Insertion).
* İstenilen sıradaki kelimeyi silme (Deletion).
* Yapılan son 3 işlemi hafızada tutarak kullanıcıya gösterme (Operation Logging).

---
*Developed by Mehtap Demet*
