# CD application

## Wstępne założenia

- klasa płyta: tytuł płyty, wykonawca, lista gatunków - metoda, rok wydania, lista utworów, czas łączny - wyliczane przez metodę
- gatunek: typ wyliczeniowy
- klasa biblioteka - kolekcja płyt, metody dodawanie płyty, usuwanie płyty, wyszukiwanie na podstawie kryteriów: szukaj po tytule płyty, szukaj po tytule utworu, szukaj po gatunkach, szukaj po roku wydania, zapis danych na dysk, odczyt z dysku, pliki tekstowe
- klasa utwór: tytuł, długość w sekundach, gatunek, wykonawca, kompozytor, autor tekstu

## Format pliku z danymi

1. N - liczba płyt w bibliotece
2. tytuł 1
3. artysta 1
4. M1 - liczba utworów 1 płyty
5. tytuł 1 utworu
6. czas 1 utworu
7. 
8.
9.
10. 
11. tytuł 2 utworu
12. 
-- powtórzone M1 razy
...
XX. rok wydania 1
tytuł 2
artysta 2
M2 - liczba utworów 2 płyty


--- powtórzone N razy