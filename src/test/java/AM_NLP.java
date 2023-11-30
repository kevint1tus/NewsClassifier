import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import uob.oop.NLP;
import uob.oop.Toolkit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AM_NLP {
    public static double doubMarks = 0;

    @Test
    @Order(1)
    void textCleaning() {
        String strTest = "!\"$%&^%H).,e+ll~'/o/Wor.l,d! 9  0 .$%^&*^%][[]";
        assertEquals("helloworld 9  0", NLP.textCleaning(strTest));
        doubMarks += 1.5;
    }

    @Test
    @Order(1)
    void textCleaning_Foreign() {
        String strTest = "Hello 你好 Hola Bonjour Hallo Привет こんにちは 안녕하세요 مرحبا Olá Ciao";
        assertEquals("hello  hola bonjour hallo     ol ciao", NLP.textCleaning(strTest));
        doubMarks += 1.5;
    }

    @Test
    @Order(3)
    void textLemmatization() {
        String strTest = "bananas";
        assertEquals("banana", NLP.textLemmatization(strTest));
        doubMarks += 0.5;
    }

    @Test
    @Order(3)
    void textLemmatization_2() {
        String strTest = "wordseseding";
        assertEquals("wordsesed", strTest = NLP.textLemmatization(strTest));
        assertEquals("wordses", strTest = NLP.textLemmatization(strTest));
        assertEquals("words", strTest = NLP.textLemmatization(strTest));
        assertEquals("word", strTest = NLP.textLemmatization(strTest));
        doubMarks += 2.0;
    }

    @Test
    @Order(3)
    void textLemmatization_3() {
        String strTest = "wordsesedingword_'s";
        assertEquals("wordsesedingword_'", NLP.textLemmatization(strTest));
        doubMarks += 0.5;
    }

    @Test
    @Order(4)
    void removeStopWords() {
        Toolkit myTK = new Toolkit();
        String[] myStopWords = myTK.loadStopWords();
        String strTest = "He is fine.";
        assertEquals("He fine.", NLP.removeStopWords(strTest, myStopWords));
        doubMarks += 1;
    }

    @Test
    @Order(5)
    void removeStopWords_2() {
        Toolkit myTK = new Toolkit();
        String[] myStopWords = myTK.loadStopWords();
        String strTest = "he is fine.";
        assertEquals("fine.", NLP.removeStopWords(strTest, myStopWords));
        doubMarks += 1;
    }

    @Test
    @Order(6)
    void removeStopWords_3() {
        Toolkit myTK = new Toolkit();
        String[] myStopWords = myTK.loadStopWords();
        String strTest = "He is not fine.";
        assertEquals("He fine.", NLP.removeStopWords(strTest, myStopWords));
        doubMarks += 1;
    }

    @Test
    @Order(7)
    void Marks() {
        System.out.println("===============================");
        System.out.println("Task 2 Marks: " + doubMarks + "/9.0");
        System.out.println("===============================");
    }

}
