# Opis projekta #

> Aplikacija FTN-IS oslikava uprošćeni informacioni sistem fakulteta koji poznaje tri tipa korisnika: administratora sistema, nastavnika i studenta. Obezbeđuje zaštitu od neautorizovanog pristupa podacima uz oslonac na mehanizam korisničke sesije. Podaci aplikacije se čuvaju u MySQL 5.5 bazi podataka, aplikacioni server i web container je Jboss AS 7.1. Aplikacija je rađena po arhitekturi sa slike1. i sa modelom podataka sa slike2.

## Arhitektura ##

> Slika 1. predstavlja troslojnu klijent-server arhitekturu, pri čemu je za čuvanje podataka zadužena MySQL baza podataka, serverski sloj čine JPA Entity-ji koji reprezentuju podatke iz baze u alikaciji i web servisi, realizovani po JAX-WS specifikaciji. Klijentska aplikacija koristi JSF framework za obavljanje svoje funkcije, a sa web servisima razmenjuje podatke preko SOAP protokola.
![http://ftn-is-project.googlecode.com/files/1.jpg](http://ftn-is-project.googlecode.com/files/1.jpg)


