@echo off
echo ========================================
echo  Budowanie Prezentacji
echo ========================================
echo.

python build_standalone.py

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo  Otwieranie index.html...
    echo ========================================
    start index.html
) else (
    echo.
    echo [BLAD] Budowanie nie powiodlo sie!
    pause
)
