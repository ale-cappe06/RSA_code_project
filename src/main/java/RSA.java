// Importazioni per il logging e le operazioni matematiche
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Classe che implementa l'algoritmo di crittografia RSA.
 */
public class RSA {
    // Logger per tenere traccia dei log
    private static final Logger logger = LogManager.getLogger(RSA.class);

    // Variabili per le chiavi RSA
    private BigInteger n; // Modulo (prodotto dei due numeri primi p e q)
    private BigInteger e; // Esponente pubblico
    private BigInteger d; // Esponente privato
    private final int bitLength = 3072; // Lunghezza delle chiavi in bit

    /**
     * Costruttore per generare le chiavi RSA.
     * Genera due numeri primi p e q, calcola il modulo n, l'esponente pubblico e e l'esponente privato d.
     */
    public RSA() {
        SecureRandom random = new SecureRandom(); // Generatore di numeri casuali sicuri
        // Generazione dei numeri primi p e q (dimensione metà di bitLength)
        BigInteger p = BigInteger.probablePrime(bitLength / 2, random);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, random);

        // Log dei numeri primi p e q
        logger.debug("[RSA] Numeri primi generati per la chiave RSA.");

        // Calcolo del modulo n
        n = p.multiply(q); 
        // Calcolo della funzione di Eulero phi(n) = (p-1) * (q-1)
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); 

        // Generazione dell'esponente pubblico e
        e = BigInteger.probablePrime(bitLength / 2, random); 
        // Assicurarsi che e sia coprimo con phi (cioè gcd(e, phi) == 1)
        while (!phi.gcd(e).equals(BigInteger.ONE)) {
            e = BigInteger.probablePrime(bitLength / 2, random); // Se non è coprimo, rigenera e
        }

        // Log dell'esponente pubblico e
        logger.debug("[RSA] Esponente pubblico generato.");

        // Calcolo dell'esponente privato d, che è l'inverso di e modulo phi(n)
        d = e.modInverse(phi); 
        // Log dell'esponente privato d
        logger.debug("[RSA] Esponente privato generato.");
    }

    /**
     * Metodo per criptare un messaggio (stringa).
     * 
     * @param message Il messaggio da criptare.
     * @return Il messaggio criptato come BigInteger.
     */
    public BigInteger encrypt(String message) {
        // Converte il messaggio in un array di byte
        byte[] messageBytes = message.getBytes();
        // Converte l'array di byte in un BigInteger
        BigInteger messageInt = new BigInteger(messageBytes); 
        // Log dell'intero rappresentante il messaggio
        logger.debug("[RSA] Messaggio convertito in intero per la crittografia.");

        // Crittografa il messaggio usando la formula: C = M^e mod n
        return messageInt.modPow(e, n); // Restituisce il messaggio criptato come BigInteger
    }

    /**
     * Metodo per decriptare un messaggio.
     * 
     * @param encryptedMessage Il messaggio criptato da decriptare.
     * @return Il messaggio decriptato come stringa.
     */
    public String decrypt(BigInteger encryptedMessage) {
        // Decripta il messaggio usando la formula: M = C^d mod n
        BigInteger decryptedInt = encryptedMessage.modPow(d, n); 
        // Log dell'intero decriptato
        logger.debug("[RSA] Messaggio decriptato con successo.");
        // Converte l'intero decriptato in un array di byte
        byte[] decryptedBytes = decryptedInt.toByteArray(); 
        // Restituisce il messaggio decriptato come stringa
        return new String(decryptedBytes); 
    }

    /**
     * Getter per ottenere la chiave pubblica.
     * 
     * @return L'esponente pubblico e.
     */
    public BigInteger getPublicKey() {
        return e; // Restituisce l'esponente pubblico
    }

    /**
     * Getter per ottenere la chiave privata.
     * 
     * @return L'esponente privato d.
     */
    public BigInteger getPrivateKey() {
        return d; // Restituisce l'esponente privato
    }

    /**
     * Getter per ottenere il modulo n.
     * 
     * @return Il modulo n.
     */
    public BigInteger getModulus() {
        return n; // Restituisce il modulo n
    }
}
