
###Kiadott feladat:

A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat. <br>

A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar. A futár egy-egy fuvarját reprezentálja a `Ride` nevű osztály, adatagokkal, konstruktorra, getterekkel.<br>

Készítsd el a `Courier` osztályt, ez fogja a futárt reprezentálni. Legyen egy `rides` listája, ami fuvarokat tárol. Legyen egy `addRide(Ride ride)` metódus, ami csak sorrendben enged hozzáadni elemeket a listához.
Figyeljünk viszont arra, hogy nem feltétlenül minden nap dolgozott a futár, de ha már bekerült egy 3. napi fuvar, akkor ne kerülhessen be egy 2. napi. És arra is figyelj, hogy a napon belül is sorrendben kerüljenek be az adatok.
Ha a paraméterül kapott `Ride` nem felel meg a feltételeknek dobjunk `IllegalArgumentException`-t.<br>

Legyen egy `CourierFileManager`, amiben van egy `createCourierByFile(Path path)` nevű metódus, ami egy paraméterül kapott
file alapján elkészít egy futár objektumot és visszaadja azt! <br>

Egy minta file:
```
1 1 12
1 2 11
2 1 10
4 1 19
4 2 5
4 3 9
```
Itt látható, hogy a futár nem dolgozott a 3. 5. 6. és 7. napon.