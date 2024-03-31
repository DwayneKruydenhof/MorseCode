package com.morsecodeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;


public class MorseController {

    private Stage stage;
    private Scene scene;

    @FXML
    public TextField inputTextArea;
    @FXML
    public TextArea morseCodeTextArea;
    @FXML
    public TextArea englishCodeTextArea;



    private final HashMap<Character, String> morseCodeMap;
    private final HashMap<String, Character> flippedMap = new HashMap<>();

    public MorseController(){
        morseCodeMap = new HashMap<>();

        // uppercase
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");

        // lowercase
        morseCodeMap.put('a', ".-");
        morseCodeMap.put('b', "-...");
        morseCodeMap.put('c', "-.-.");
        morseCodeMap.put('d', "-..");
        morseCodeMap.put('e', ".");
        morseCodeMap.put('f', "..-.");
        morseCodeMap.put('g', "--.");
        morseCodeMap.put('h', "....");
        morseCodeMap.put('i', "..");
        morseCodeMap.put('j', ".---");
        morseCodeMap.put('k', "-.-");
        morseCodeMap.put('l', ".-..");
        morseCodeMap.put('m', "--");
        morseCodeMap.put('n', "-.");
        morseCodeMap.put('o', "---");
        morseCodeMap.put('p', ".--.");
        morseCodeMap.put('q', "--.-");
        morseCodeMap.put('r', ".-.");
        morseCodeMap.put('s', "...");
        morseCodeMap.put('t', "-");
        morseCodeMap.put('u', "..-");
        morseCodeMap.put('v', "...-");
        morseCodeMap.put('w', ".--");
        morseCodeMap.put('x', "-..-");
        morseCodeMap.put('y', "-.--");
        morseCodeMap.put('z', "--..");

        // numbers
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");

        // special characters
        morseCodeMap.put(' ', "/");
        morseCodeMap.put(',', "--..--");
        morseCodeMap.put('.', ".-.-.-");
        morseCodeMap.put('?', "..--..");
        morseCodeMap.put(';', "-.-.-.");
        morseCodeMap.put(':', "---...");
        morseCodeMap.put('(', "-.--.");
        morseCodeMap.put(')', "-.--.-");
        morseCodeMap.put('[', "-.--.");
        morseCodeMap.put(']', "-.--.-");
        morseCodeMap.put('{', "-.--.");
        morseCodeMap.put('}', "-.--.-");
        morseCodeMap.put('+', ".-.-.");
        morseCodeMap.put('-', "-....-");
        morseCodeMap.put('_', "..--.-");
        morseCodeMap.put('"', ".-..-.");
        morseCodeMap.put('\'', ".----.");
        morseCodeMap.put('/', "-..-.");
        morseCodeMap.put('\\', "-..-.");
        morseCodeMap.put('@', ".--.-.");
        morseCodeMap.put('=', "-...-");
        morseCodeMap.put('!', "-.-.--");



// lowercase
        flippedMap.put(".-", 'a');
        flippedMap.put("-...", 'b');
        flippedMap.put("-.-.", 'c');
        flippedMap.put("-..", 'd');
        flippedMap.put(".", 'e');
        flippedMap.put("..-.", 'f');
        flippedMap.put("--.", 'g');
        flippedMap.put("....", 'h');
        flippedMap.put("..", 'i');
        flippedMap.put(".---", 'j');
        flippedMap.put("-.-", 'k');
        flippedMap.put(".-..", 'l');
        flippedMap.put("--", 'm');
        flippedMap.put("-.", 'n');
        flippedMap.put("---", 'o');
        flippedMap.put(".--.", 'p');
        flippedMap.put("--.-", 'q');
        flippedMap.put(".-.", 'r');
        flippedMap.put("...", 's');
        flippedMap.put("-", 't');
        flippedMap.put("..-", 'u');
        flippedMap.put("...-", 'v');
        flippedMap.put(".--", 'w');
        flippedMap.put("-..-", 'x');
        flippedMap.put("-.--", 'y');
        flippedMap.put("--..", 'z');

// numbers
        flippedMap.put("-----", '0');
        flippedMap.put(".----", '1');
        flippedMap.put("..---", '2');
        flippedMap.put("...--", '3');
        flippedMap.put("....-", '4');
        flippedMap.put(".....", '5');
        flippedMap.put("-....", '6');
        flippedMap.put("--...", '7');
        flippedMap.put("---..", '8');
        flippedMap.put("----.", '9');

// special characters
        flippedMap.put("/", ' ');
        flippedMap.put("--..--", ',');
        flippedMap.put(".-.-.-", '.');
        flippedMap.put("..--..", '?');
        flippedMap.put("-.-.-.", ';');
        flippedMap.put("---...", ':');
        flippedMap.put("-.--.", '(');
        flippedMap.put("-.--.-", ')');
        flippedMap.put("-.--.", '[');
        flippedMap.put("-.--.-", ']');
        flippedMap.put("-.--.", '{');
        flippedMap.put("-.--.-", '}');
        flippedMap.put(".-.-.", '+');
        flippedMap.put("-....-", '-');
        flippedMap.put("..--.-", '_');
        flippedMap.put(".-..-.", '"');
        flippedMap.put(".----.", '\'');
        flippedMap.put("-..-.", '/');
        flippedMap.put("-..-.", '\\');
        flippedMap.put(".--.-.", '@');
        flippedMap.put("-...-", '=');
        flippedMap.put("-.-.--", '!');

    }


    @FXML
    void onActionExample(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/fxmlfiles/example-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionExample2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/fxmlfiles/example-view-2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionGroepsLeden(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/fxmlfiles/credit-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionInstructions(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/fxmlfiles/instruction-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionTranslate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/fxmlfiles/translate-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionSwitchToMorse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/fxmlfiles/translate-view-morse.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/fxmlfiles/main-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void translateToMorse(ActionEvent e) {
        if (e.hashCode() != KeyEvent.VK_SHIFT) {
            morseCodeTextArea.setText(String.valueOf(translateToMorse(inputTextArea.getText())));
        }
    }

    @FXML
    void translateToLetters() {
            englishCodeTextArea.setText(String.valueOf(translateToChar(inputTextArea.getText())));
    }


    @FXML
    void onActionSoundOutMorse() throws InterruptedException {
        playSound(new String[]{morseCodeTextArea.getText()});
    }

    @FXML
    void onActionClear() {
        inputTextArea.clear();
        morseCodeTextArea.clear();
    }

    @FXML
    void onActionClearMorse() {
        inputTextArea.clear();
        englishCodeTextArea.clear();
    }

    public String translateToMorse(String textToTranslate){
        StringBuilder translatedText = new StringBuilder();
        for(Character letter : textToTranslate.toCharArray()){
            // translate the letter and then append to the returning value (to be displayed to the GUI)
            translatedText.append(morseCodeMap.get(letter) + " ");
        }
        return translatedText.toString();
    }

    @FXML
    public String translateToChar(String charToTranslate) {

        englishCodeTextArea.setText(String.valueOf(flippedMap.get(charToTranslate)));

        return charToTranslate;
    }

    // morseMessage - contains the morse message after being translated
    public void playSound(String[] morseMessage) throws InterruptedException {
            try {
                // audio format specifies the audio properties (i.e. the type of sound we want)
                AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);

                // create the data line (to play incoming audio data)
                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();

                // duration of the sound to be played (I just messed around with the values to get it close enough)
                int dotDuration = 200;
                int dashDuration = (int) (1.5 * dotDuration);
                int slashDuration = 2 * dashDuration;

                for (String pattern : morseMessage) {
                    System.out.println(pattern);

                    // play the letter sound
                    for (char c : pattern.toCharArray()) {

                        if (c == '.') {
                            playBeep(sourceDataLine, dotDuration);
                            Thread.sleep(dotDuration);
                        } else if (c == '-') {
                            playBeep(sourceDataLine, dashDuration);
                            Thread.sleep(dotDuration);
                        } else if (c == '/') {
                            Thread.sleep(slashDuration);
                        }
                    }

                    // waits a bit before playing the next sequence
                    Thread.sleep(dotDuration);
                }

                // close audio output line (cleans up resources)
                sourceDataLine.drain();
                sourceDataLine.stop();
                sourceDataLine.close();

        } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
    }

    // sends audio data to be played to the data line
    private void playBeep(SourceDataLine line, int duration){
        // create audio data
        byte[] data = new byte[duration * 44100 / 1000];

        for(int i = 0; i < data.length; i++){
            // calculates the angle of the sine wave for the current sample based on the sample rate and frequency
            double angle = i / (44100.0/440) * 2.0 * Math.PI;

            // calculates the amplitude of the sine wave at the current angle and scale it to fit within the range of
            // a signed byte (-128, 127)
            // also in the context of audio processing, a signed bytes is often used to represent audio data because it
            // can represent both positive and negative amplitudes of sound waves
            data[i] = (byte) (Math.sin(angle) * 127.0);
        }

        // write the audio dat in the data line to be played
        line.write(data, 0, data.length);
    }

}

