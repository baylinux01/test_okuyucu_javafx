# test_okuyucu_javafx
Eğitim vermeden önce ön test eğitim verdikten sonra da 
son test uygulayan bir kurumun  
sınav kağıtlarını okumayı kolaylaştırmak amacıyla yazdığım 
ve xlsx formatında çıktı veren program.

Kurumun  verdiği eğitimlerde sınavları online olarak yapmak veya optik kağıt dağıtıp optik okuyucuda okutmak gibi bir altyapısı yok. 
Cevapların işaretlendiği kağıt genelde katılımcılara üzerinde bir tablo ile dağıtılıyor.
Katılımcılar kağıdın üzerine isimlerini el ile yazıp tablo olarak verilen cevap anahtarını çarpı veya tik gibi rastgele işaretlerle dolduruyorlar.
Bu program kağıtların düzgünce çekilmiş resimlerin bulunduğu klasörü seçiyor ve klasördeki resimleri tek seçimde toplu olarak okuyor.

Program bu resimlerden


-Başlıktan sınav ön test mi son test mi anlamaya çalışıyor ve sınıflandırıyor.

-Sınavın ön test veya son test olup olmadığını tesbit edemezse sadece test olarak farklı bir kategoride ele alıp kullanıcının düzenlemesine imkan tanıyor.
-Katılımcının A, B, C, D veya A, B, C, D, E olarak 4 veya 5 seçenekten cevaplarını algılayıp kaydediyor, cevapları değiştirmeye ve güncellemeye imkan tanıyor 
ve doğru cevaplarla karşılaştırıp 
doğru mu değil mi diye D veya Y şeklinde çktı veriyor.

-program ayrıca her kullanıcının doğru cevap sayısını 30 soru üzerinden puanını çıktı veriyor.

-program bunlara ek olarak bir de her soru için kullanıcıların verdiği toplam doğru sayısını tüm kullanıcıların ortalama doğru sayısını ve ortalama puanını da veriyor.

-program sınav cevap anahtarını güncellemeye veya katılımcının cevaplarını düzeltmeye de
imkan tanıyor.

-Yapılan herhangi bir değişiklik veritabanındaki tüm alakalı verileri de güncelliyor.

-program bu işlemleri hem ön test hem de son test için ayrı ayrı yapıyor.



Programın hem windows hem de linux ortamında çalışmak üzere tasarlanmış olup linux ortamında kısmen test edilmiştir.
Program amazon corretto jdk-21 ile geliştirilmiştir. Programın doğru bir şekilde çalışması için  jdk 21 yüklenmesi tavsiye edilir.
Ayrıca programın doğru bir şekilde çalışabilmesi için tesseract programının
(tercihen 5.3.0-2 sürümü) yüklü olması gerekir.
Ayrıca eğer programın kullanılacağı bilgisayar Windows ise 
Microsoft Visual C++ Redistributable for Visual Studio 2015-2022 yazılımının mutlaka yüklenmesi gerekir. Aksi takdirde program çalışmaz.
Bunlara ek olarak sqlite, mysql, mariadb veya postgresql databaselerinden en az birinin
bilgisayara yüklü olması gerekir.
Program ayrıca 4 çeşit database'den(sqlite,mysql,mariadb,postgresql) istenilen birisini kullanarak istenilen host ve port numarası ile 
başka bir bilgisayardaki veritabanına bağlanmayı da desteklemektedir.
Fakat bazı databaselerde mesela postgrede bazen database'i elle manuel olarak oluşturmak gerekebilir.

