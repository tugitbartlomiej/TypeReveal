@echo off
echo Uruchamianie prezentacji Lesson 05...
echo.

cd /d "%~dp0..\.."

echo Startuje serwer HTTP...
start /B python -m http.server 3000

echo Czekam 2 sekundy na uruchomienie serwera...
timeout /t 2 /nobreak >nul

echo Otwieram przegladarke...
start http://localhost:3000?lesson=05

echo.
echo Prezentacja uruchomiona!
echo Serwer dziala na http://localhost:3000?lesson=05
echo.
echo Aby zamknac serwer, zamknij to okno.
echo.
pause
