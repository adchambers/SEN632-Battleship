/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemoutgames;

import java.io.*;
import javax.sound.sampled.*;
/**
    The SoundPlayer encapsulates a sound that can be opened
    from the file system and later played.
*/
public class SoundPlayer  {
    public static void PlaySound (String audiofile) {
        // load a sound
        SoundPlayer sound =
            new SoundPlayer(audiofile);
        // create the stream to play
        InputStream stream =
            new ByteArrayInputStream(sound.getSamples());
        // play the sound
        sound.play(stream);
    }
    
        public void PlayMusic (String audiofile) {
        // load a sound
        SoundPlayer sound =
            new SoundPlayer(audiofile);
        // create the stream to play
        InputStream stream =
            new LoopingByteInputStream(sound.getSamples());
        // play the sound
        new Thread(() -> sound.play(stream)).start();

        }
    
    private AudioFormat format;
    private byte[] samples;
    /**
        Opens a sound from a file.
    */
    public SoundPlayer(String filename) {
        try {
            File file = new File(filename);
            // open the audio input stream
            AudioSystem.getAudioFileTypes();
            AudioInputStream stream =
                AudioSystem.getAudioInputStream(file.toURI().toURL());
                        format = stream.getFormat();
            // get the audio samples
            samples = getSamples(stream);
        }
        catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
        Gets the samples of this sound as a byte array.
    */
    public byte[] getSamples() {
        return samples;
    }
    /**
        Gets the samples from an AudioInputStream as an array
        of bytes.
    */
    private byte[] getSamples(AudioInputStream audioStream) {
        // get the number of bytes to read
        int length = (int)(audioStream.getFrameLength() *
            format.getFrameSize());
                // read the entire stream
        byte[] samples = new byte[length];
        DataInputStream is = new DataInputStream(audioStream);
        try {
            is.readFully(samples);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // return the samples
        return samples;
    }
    
    /**
    The LoopingByteInputStream is a ByteArrayInputStream that
    loops indefinitely. The looping stops when the close() method
    is called.
    <p>Possible ideas to extend this class:<ul>
    <li>Add an option to only loop a certain number of times.
    </ul>
*/
public class LoopingByteInputStream extends ByteArrayInputStream {
    private boolean closed;
    /**
        Creates a new LoopingByteInputStream with the specified
        byte array. The array is not copied.
    */
    public LoopingByteInputStream(byte[] buffer) {
        super(buffer);
        closed = false;
    }
    /**
        Reads <code>length</code> bytes from the array. If the
        end of the array is reached, the reading starts over from
        the beginning of the array. Returns -1 if the array has
        been closed.
    */
    public int read(byte[] buffer, int offset, int length) {
        if (closed) {
            return -1;
        }
        int totalBytesRead = 0;
                while (totalBytesRead < length) {
            int numBytesRead = super.read(buffer,
                offset + totalBytesRead,
                length - totalBytesRead);
            if (numBytesRead > 0) {
                totalBytesRead += numBytesRead;
            }
            else {
                reset();
            }
        }
        return totalBytesRead;
    }
    /**
        Closes the stream. Future calls to the read() methods
        will return 1.
    */
    public void close() throws IOException {
        super.close();
        closed = true;
    }
}
       
    /**
        Plays a stream. This method blocks (doesn't return) until
        the sound is finished playing.
    */
    public void play(InputStream source) {
        // use a short, 100ms (1/10th sec) buffer for real-time
        // change to the sound stream
        int bufferSize = format.getFrameSize() *
            Math.round(format.getSampleRate() / 10);
        byte[] buffer = new byte[bufferSize];
        // create a line to play to
        SourceDataLine line;
                try {
            DataLine.Info info =
                new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open(format, bufferSize);
        }
        catch (LineUnavailableException ex) {
            ex.printStackTrace();
            return;
        }
        // start the line
        line.start();
        // copy data to the line
        try {
            int numBytesRead = 0;
            while (numBytesRead != -1) {
                numBytesRead =
                    source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1) {
                   line.write(buffer, 0, numBytesRead);
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // wait until all data is played
        line.drain();        

        // close the line
        line.close();
    }
}