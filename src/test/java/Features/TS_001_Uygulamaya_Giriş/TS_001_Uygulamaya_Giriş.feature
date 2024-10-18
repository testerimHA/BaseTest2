@Login
Feature: Login

  @TC_001_001_Login_Başarılı
  Scenario: Geçerli Bilgiler İle Login
    Given Kullanıcı Login Sayfasındadır
    When  Kullanıcı "username" alanına "12345678901" metnini yazar
    And   Kullanıcı "password" alanına "46566600Ba." metnini yazar
    And  Kullanıcı "Giriş Yap" butonuna tıklar
    Then Başarılı giriş yapıldığı doğrulanır
    

  Scenario: Geçerli Bilgiler İle Login Kısa
    Given Kullanıcı Login Sayfasındadır
    And  Kullanıcı Başarılı Giriş Yapar
    Then Başarılı giriş yapıldığı doğrulanır


  @TC_0001_02_Aktif_Kullanici_Giriş_Bilgileri_Hatali
  Scenario: Geçerli Bilgiler İle Login
    Given Kullanıcı Login Sayfasındadır
    When  Kullanıcı "username" alanına "merve.webb" metnini yazar
    And   Kullanıcı "password" alanına "46566600Ba." metnini yazar
    And  Kullanıcı "Giriş Yap" butonuna tıklar
    Then Sistem "Kullanıcı adı veya şifre yanlış!" açıklamasını içeren bir bildirim gösterir


  @TC_0001_02_Aktif_Kullanici_Giriş_Bilgileri_Hatali
  Scenario: Geçerli Bilgiler İle Login
    Given Kullanıcı Login Sayfasındadır
    When  Kullanıcı "username" alanına "merve.web" metnini yazar
    And   Kullanıcı "password" alanına "46566600Ba.." metnini yazar
    And  Kullanıcı "Giriş Yap" butonuna tıklar
    Then Sistem "Kullanıcı adı veya şifre yanlış!" açıklamasını içeren bir bildirim gösterir
