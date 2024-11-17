// Importazioni per il logging e per la gestione dell'input utente
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Cappelletto Alessandro
 * @version 0.1.1
 */
public class RSATest {
    // Logger per tenere traccia dei log
    private static final Logger logger = LogManager.getLogger(RSATest.class);

    /**
     * Metodo principale per eseguire il test dell'algoritmo RSA.
     * Permette all'utente di inserire un messaggio da criptare e decriptare.
     */
    public static void main(String[] args) {
        // Crea un'istanza della classe RSA
        RSA rsa = new RSA();
        // Crea uno scanner per leggere l'input dell'utente
        Scanner scanner = new Scanner(System.in);

        // Chiede all'utente di inserire un messaggio da criptare
        System.out.print("Inserisci una frase da crittografare: ");
        String message = scanner.nextLine();
        // Logga il messaggio inserito dall'utente
        logger.info("[RSATest] Messaggio originale ricevuto dall'utente.");

        try {
        	// Cripta il messaggio usando il metodo encrypt della classe RSA
            BigInteger encryptedMessage = rsa.encrypt(message);
            // Logga il messaggio criptato
            logger.info("[RSATest] Messaggio criptato con successo.");
            // Mostra il messaggio criptato all'utente
            System.out.println("Messaggio criptato: " + encryptedMessage);

            // Decripta il messaggio usando il metodo decrypt della classe RSA
            String decryptedMessage = rsa.decrypt(encryptedMessage);
            // Logga il messaggio decriptato
            logger.info("[RSATest] Messaggio decriptato correttamente.");
            // Mostra il messaggio decriptato all'utente
            System.out.println("Messaggio decriptato: " + decryptedMessage);

            // Verifica che il messaggio decriptato corrisponda a quello originale
            if (message.equals(decryptedMessage)) {
                // Se il messaggio decriptato è uguale a quello originale, logga un messaggio di successo
            	logger.info("[RSATest] Verifica completata: il messaggio originale corrisponde al messaggio decriptato.");
                // Mostra un messaggio di conferma all'utente
                System.out.println("Il messaggio decriptato coincide con l'originale!");
            } else {
                // Se il messaggio decriptato non coincide con quello originale, logga un errore
            	logger.error("[RSATest] Verifica fallita: il messaggio originale NON corrisponde al messaggio decriptato.");
                // Mostra un messaggio di errore all'utente
                System.out.println("Errore: il messaggio decriptato NON coincide con l'originale!");
            }
        } catch (Exception e) {
        	logger.error("[RSATest] Si è verificato un errore durante il processo di crittografia o decrittografia: {}", e.getMessage(), e);
            System.out.println("Si è verificato un errore durante il processo di crittografia/decrittografia.");
        }        

        // Chiude lo scanner
        scanner.close();
    }
}
