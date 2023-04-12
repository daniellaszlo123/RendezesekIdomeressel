# RendezesekIdomeressel

## RendezesKollekcio osztály
- A tanult rendezések gyüjteménye.
- Minden metódusa egy-egy rendezést valósít meg, emellett minden metódusa statikus, hogy az osztály példányosítására ne legyen szükség.

## IdoTeszt osztály
- Ebben az osztályban történik meg a rendezések meghívása, és minden metódus futási idejét méri.
- Az osztály 5db statikus final értéket tartalmaz a kód olvashatósága és átláthatósága érdekében.
- Van egy rndTombGeneral nevű metódus ami a megadott hossz alapján fog egy int tömbböt visszaadni.
- Ezt a metódust az rndTombokGeneral nevű metódus fogja hívni, ami szintén egy megadott hossz alapján fog egy mátrix tömbböt létrehozni és visszaadni.
- Ez alapján 3 féle tömb fordul elő, kis/közepes/nagy tömb.
- Az **strEgyTombIdovel** metódus az ahol az összes rendezést meghívjuk és lemérjük futási idejüket.
- Ezt a metódust fogja hívni az strIdovelBuilder metódus, ami összeállítja az adott mátrix tömbre vonatkozó eredményeket egy string formájában és ezt adja vissza.
- A tombokIdore metódus fogja összeállítani a tényleges szöveget amit majd átadunk a fajlbaIr metódusnak és kiírjuk a fájlba a kapott eredményeket a statisztika.txt nevű fájlba.

### strEgyTombIdovel metódus
- Használja a kever metódus, hogy az adott tömb mindig véletlenszerű legyen és ne rendezett.
- Használja a vonal metódust annak érdekében, hogy az elkészült statisztika.txt-be kerülő szöveg ne folyjon egybe.

### Tapasztalat/Észrevétel
Többségében a buborékrendezés és a maximum kiválasztásos rendezés igérkezett a leggyorsabbnak.

### Jó tudni
- A MATRIX_TOMB_HOSSZ értékének megváltoztatásával tudjuk állítani, hogy *hány sora*[^1] legyen a mátrix tömbünknek.
- A NAGY_TOMB_HOSSZ vagy KOZEPES_TOMB_HOSSZ vagy KIS_TOMB_HOSSZ módosításával tudjuk elérni azt, hogy az adott tömbben hány darab érték tárolódjon.
[^1]: Hány sora alatt az értendő, hogy hány darab tömb legyen benne
