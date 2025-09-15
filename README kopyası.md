# ☕ Akıllı Kahve Makinesi

Bu proje, kullanıcıların kendi zevklerine göre kahve siparişi verebildiği **konsol tabanlı bir kahve makinesi uygulamasıdır**.  
Amaç yalnızca kahve yapmak değil, aynı zamanda **Java OOP ilkelerini (Encapsulation, Inheritance, Polymorphism, Abstraction)** pekiştirmek ve **tasarım desenlerini** (Factory, Strategy, Template Method) uygulamalı olarak göstermektir.

---

## 📌 Özellikler

- **10 farklı kahve türü** (Americano, Espresso, Cappuccino, Latte, Mocha, vb.)
- **Sıcak / Soğuk kahve ayrımı**
  - Soğuk kahvede ekstra mesaj: *“Sıcak bir yaz gününde serinlemenin en iyi yolu… Mükemmel karar!”*
- **Boyut seçimi**: Small, Medium, Large, XLarge
- **Ekstralar**  
  ✅ Süt  
  ✅ Şeker (0–10 küp)  
  ✅ Şurup (Vanilya, Karamel, Fındık, Çikolata – pompa sayısı seçilebilir)  
  ✅ Krema
- **Fiyatlandırma**
  - Her kahvenin taban fiyatı vardır.
  - Boyuta göre çarpan uygulanır.
  - Süt, krema, şurup ve şeker ekstra ücretlidir.
- **İndirimler (Strategy Pattern)**
  - 🔖 **Kampanya kodları**: `%10`, `%15`, `%20` indirim (örn: `IND10`, `IND15`, `OGRENCI20`)
  - ⏰ **Happy Hour**: belirli saatler arası otomatik indirim (%20)
- **Sipariş Özeti**
  - Seçilen boyut, kahve türü, ekstra tercihler ve toplam fiyat ekrana yazdırılır.
- **Demleme Simülasyonu**
  - Su ısıtma / buz hazırlama  
  - Özüt alma veya karıştırma  
  - Süt, şurup, krema, şeker ekleme adımları

---

## 🏗 Kullanılan OOP Kavramları

- **Encapsulation (Kapsülleme):**  
  Kahve özellikleri (`sut`, `sekerKup`, `surup`, `krema`) private alanlar ile korunur.
- **Inheritance (Kalıtım):**  
  `Kahve` soyut sınıfından `SicakKahve` ve `SogukKahve` türetilmiştir.
- **Polymorphism (Çok Biçimlilik):**  
  `secildiMesaji()` ve `demle()` metotları alt sınıflarda farklı davranış gösterir.
- **Abstraction (Soyutlama):**  
  `Kahve` soyut sınıfı ve `Demlenebilir` arayüzü ile ortak davranışlar tanımlanır.

---

## 🎨 Tasarım Desenleri

- **Factory Pattern**  
  → `KahveFabrikasi`, seçilen kahve türüne göre uygun sınıfı (sıcak/soğuk) döndürür.

- **Strategy Pattern**  
  → Fiyatlandırma stratejileri (`VarsayilanFiyat`, `KampanyaYuzdeIndirim`, `HappyHourIndirimi`) siparişe dinamik olarak eklenir.

- **Template Method Pattern**  
  → `Kahve.demle()` metodu, sabit akışı tanımlar; alt adımlar alt sınıflarca özelleştirilir.

---

## 📂 Proje Yapısı

```
src/main/java/com/mersys/kahve/
│
├─ app/
│   └─ KahveMakinesi.java        # Main class (uygulama girişi)
│
├─ enums/
│   ├─ KahveTuru.java            # Kahve türleri
│   └─ Boyut.java                # Boyutlar
│
├─ models/
│   ├─ Kahve.java                # Soyut sınıf (abstract)
│   ├─ SicakKahve.java
│   ├─ SogukKahve.java
│   └─ Surup.java                # Şurup enum
│
├─ interfaces/
│   └─ Demlenebilir.java
│
├─ factory/
│   └─ KahveFabrikasi.java
│
├─ pricing/
│   ├─ FiyatlandirmaStratejisi.java
│   ├─ VarsayilanFiyat.java
│   ├─ KampanyaYuzdeIndirim.java
│   └─ HappyHourIndirimi.java
│
├─ order/
│   └─ Siparis.java
│
└─ util/
    └─ MetinGirisi.java
```

---

## 🚀 Çalıştırma

```bash
# Derleme
javac -d out $(find src -name "*.java")

# Çalıştırma
java -cp out com.mersys.kahve.app.KahveMakinesi
```

---

## 💡 Örnek Çalışma

```
# Kahve Makinesi

Lütfen aşağıdaki menüden kahvenizi seçiniz:
 1) Americano
 2) Espresso
 ...
Seçiminiz (1-10): 2
“Espresso”yi seçtiniz…

Lütfen aşağıdaki menüden kahvenizin boyutunu (size) seçiniz…
 1) Small
 2) Medium
 3) Large
 4) XLarge
Seçiminiz (1-4): 3

Large Espresso’niz hazırlanıyor…

Espresso’e süt eklemek ister misiniz? (Evet/Hayır): Hayır
Kahvenize şurup ister misiniz? (Evet/Hayır): Evet
Şurup seçiniz:
 1) Vanilya
 2) Karamel
 3) Fındık
 4) Çikolata
Seçiminiz: 2
Kaç pompa? (0-5): 2
Üzerine krema ister misiniz? (Evet/Hayır): Evet
Espresso’e şeker ister misiniz? (Evet/Hayır): Evet
Kaç şeker istersin? (küp): 1

--- SİPARİŞ ÖZETİ ---
Large Espresso sütsüz ve 1 küp şekerle hazırlanıyor. + Karamel şurubu (2 pompa) + krema
Ara toplam: ₺75.00
- Happy Hour (14:00-16:00, %20) uygulandı: -₺15.00
Toplam: ₺60.00

Demleme başlıyor...
Su ısıtılıyor…
Espresso için çekirdekten özüt alınıyor…
Espressoiniz sütsüz hazırlanıyor...
Karamel şurubundan 2 pompa ekleniyor…
Üzerine krema ekleniyor…
1 küp şeker ekleniyor…
Afiyet olsun! ☕
```

---

## 🔮 Geliştirme Fikirleri

- Çoklu şurup desteği (birden fazla şurup seçilebilmesi) → **Decorator Pattern**
- Kullanıcı tercihlerini dosyaya kaydetme → “Aynısını ister misiniz?” özelliği
- Grafik arayüz (JavaFX / Swing)
- Uluslararasılaştırma (`ResourceBundle` ile çok dillilik)

---

✍️ **Hazırlayan:** Mersys Dersleri – Java OOP Eğitim Projesi  
