
# **RSA_code_project**

Progetto sviluppato per implementare l'algoritmo RSA utilizzando Java e il framework Maven. Include funzionalità di crittografia e decrittografia dei messaggi, con un focus su sicurezza e gestione delle chiavi.

---

## **Descrizione**
Questo progetto dimostra l'implementazione di un sistema di crittografia basato sull'algoritmo RSA. È progettato per:

- **Generazione di chiavi sicure**: Calcolo delle chiavi pubbliche e private utilizzando numeri primi generati casualmente.
- **Crittografia e decrittografia**: Protezione dei messaggi tramite l'algoritmo RSA.
- **Gestione dei log**: Tracciamento delle operazioni tramite Apache Log4j.
- **Test interattivi**: Interfaccia a linea di comando per criptare e decriptare messaggi.

---

## **Funzionalità**
- Generazione di chiavi pubbliche e private.
- Criptazione dei messaggi tramite la formula:
  \[
  C = M^e \mod n
  \]
- Decriptazione dei messaggi tramite la formula:
  \[
  M = C^d \mod n
  \]
- Log dettagliati per monitorare il funzionamento interno.

---

## **Requisiti**
- **Java**: Versione 17 o superiore.
- **Maven**: Per la gestione delle dipendenze.
- **Apache Log4j**: Per il logging.

---

## **Setup**
Segui questi passaggi per configurare e avviare il progetto:

1. **Clona il repository**:
   ```bash
   git clone https://github.com/ale-cappe06/RSA_code_project.git
   ```

2. **Naviga nella directory del progetto**:
   ```bash
   cd RSA_code_project
   ```

3. **Compila ed esegui il progetto**:
   ```bash
   mvn clean install
   java -jar target/RSA_code_project.jar
   ```

---

## **Struttura del Progetto**

```
RSA_code_project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── RSA.java          # Classe principale RSA
│   │   │   ├── RSATest.java      # Classe di test
│   │   ├── resources/
│   │       ├── log4j2.xml        # Configurazione del logging
│   │
├── pom.xml                       # Configurazione Maven
├── .gitignore                    # File per ignorare file non necessari
├── README.md                     # Documentazione del progetto
```

---

## **Esempio di Utilizzo**
Esegui il file `RSATest` per provare la crittografia e la decrittografia. Inserisci un messaggio e osserva il risultato.

### **Output**
```plaintext
Inserisci una frase da crittografare: Test RSA
Messaggio criptato: 17283481239482103481034
Messaggio decriptato: Test RSA
Il messaggio decriptato coincide con l'originale!
```

---

## **Dipendenze**
Questo progetto utilizza le seguenti librerie:

- **Apache Log4j**:
  ```xml
  <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.20.0</version>
  </dependency>
  <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-api</artifactId>
      <version>2.20.0</version>
  </dependency>
  ```

---

## **Autori**
- **Cappelletto Alessandro**

---

## **Licenza**
Questo progetto è distribuito con licenza [MIT](https://opensource.org/licenses/MIT). Sentiti libero di contribuire o utilizzare il codice nel rispetto della licenza.
