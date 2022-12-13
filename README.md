# Projekt Login-Registration

## Synchronisieren des Repositories in einen Ordner

Installiere die neueste Version von [git](https://git-scm.com/downloads) mit den Standardeinstellungen.
Gehe danach in die Windows Eingabeaufforderung (cmd) und führe in einem geeigneten Ordner den Befehl

```
git clone https://github.com/maz22374/loginregistration.git
```

Soll der neueste Stand vom Server geladen werden, führe die Datei _resetGit.cmd_ aus. Achtung:
alle lokalen Änderungen werden dabei zurückgesetzt.

## Aufsetzen der Datenbank

Installiere die neuste Version von [Docker](https://www.docker.com/).
Anschließend rufe folgenden Befehl in der Windows Eingabeaufforderung auf, um 
einen MariaDB-Container zu erstellen:
```
docker run --name mariadb -d -p 3306:3306 ^
	-e MARIADB_ROOT_PASSWORD=P@ssw0rd ^
	mariadb:latest
```
Anschließend läuft MariaDB auf dem Port _3306_ (Benutzername: _root_, Passwort: _P@ssw0rd_) und 
ist auf diesem auch erreichbar. Erstelle nun eine Datenbank mit dem Namen _registration_.
SQL-Befehl:
```
CREATE DATABASE registration;
```

## Aufsetzen des Mail-Servers

Rufe folgenden Befehl in der Windows Eingabeaufforderung auf, um [MailDev](https://github.com/maildev/maildev)
auf [Docker](https://www.docker.com/) laufen zu lassen:
```
docker run -p 1080:1080 -p 1025:1025 maildev/maildev
```
Anschließend ist das MailDev-Webinterface unter dem Port _1080_ erreichbar und der SMTP-Server unter dem Port _1025_.

## Starten des Servers

- **Backend:** Rufe im Ordner _login_ den Befehl _mvn spring-boot:run_. Das Backend
  läuft auf _http://localhost:8080_.
