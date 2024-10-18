@Logout
Feature: Uygulamadan Çıkış


  @TC_002_01_Uygulama_Arayüz_Üzerinden_Çıkış
  Scenario:TS_002 Uygulamadan Çıkış
    Given Kullanıcı Login Sayfasındadır
    When  Kullanıcı Başarılı Giriş Yapar
    And   Anasayfa Admin Panel Butonuna tıklar
    And   Oturumu Sonlandır Butonuna tıklar
    And Çıkış işlemini Onayla Butonuna Tıklar
    Then Login sayfasında olduğu doğrulanır


  @TC_002_02_Yönetim_Paneli_Üzerinden_Çıkış
  Scenario:Yönetim Paneli Üzerinden Uygulamadan Çıkış
    Given Kullanıcı Login Sayfasındadır
    When  Kullanıcı Başarılı Giriş Yapar
    And   Anasayfa Admin Panel Butonuna tıklar
    And   Anasayfa Yönetim Paneli Butonuna tıklar
    And Yönetim Panelindeki Çıkış Yap butonuna Tıklar
    Then Login sayfasında olduğu doğrulanır


  @TC_002_01_Uygulama_Arayüz_Üzerinden_Çıkış
  Scenario:Arayüz Üzerinden Uygulamadan Çıkış
    Given Kullanıcı Login Sayfasındadır
    When  Kullanıcı Başarılı Giriş Yapar
    And   Anasayfa Admin Panel Butonuna tıklar
    And   Oturumu Sonlandır Butonuna tıklar
    And Çıkış işlemini Onayla Butonuna Tıklar
    Then Login sayfasında olduğu doğrulanır


  @TC_002_03_Yönetim_Paneli_Uzerinden_Cikis_Yapildiginda_Tarayicidaki_Tum_Oturumlardan_Cikis
  Scenario: Tum_Oturumlardan_Cikis
    Given Kullanıcı Login Sayfasındadır
    When  Kullanıcı Başarılı Giriş Yapar
    And   Anasayfa Admin Panel Butonuna tıklar
    And   Anasayfa Yönetim Paneli Butonuna tıklar
    And Yönetim Panelindeki Çıkış Yap butonuna Tıklar
    And   Diğer Sekmedeki Oturum da Kapatılmış Olmalıdır


